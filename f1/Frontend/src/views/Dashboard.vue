<template>
  <div class="dashboard">
    <nav class="navbar">
      <div class="nav-links">
        <router-link to="/circuits" class="nav-link">Circuits</router-link>
        <router-link to="/constructors" class="nav-link">Constructors</router-link>
        <router-link to="/drivers" class="nav-link">Drivers</router-link>
        <router-link to="/races" class="nav-link">Races</router-link>
        <router-link to="/about" class="nav-link">About</router-link>
      </div>
      <router-link to="/" class="homelink"><img src="../assets/f1_logo.png" alt="Logo"></router-link>
    </nav>
    <div class="content-wrapper">
      <div v-if="nextRace" class="next-race-section">
        <div class="race">
          <div class="race-info">
            <h2>Next Race</h2>
            <div><strong>{{ nextRace.raceName }}</strong> </div>
            <div><strong></strong> {{ nextRace.Circuit.circuitName }}</div>
            <div><strong></strong> {{ nextRace.date }}</div>
            <div><strong></strong> {{ nextRace.time }}</div>

              <div><strong>Race Start:</strong></div>
            <div class="countdown">
              <div class="countdown-item">
                <span class="count">{{ days }}</span>
                <span class="label">Days</span>
              </div>
              <div class="countdown-item">
                <span class="count">{{ hours }}</span>
                <span class="label">Hours</span>
              </div>
              <div class="countdown-item">
                <span class="count">{{ minutes }}</span>
                <span class="label">Minutes</span>
              </div>
              <div class="countdown-item">
                <span class="count">{{ seconds }}</span>
                <span class="label">Seconds</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import RaceService from '@/router/DashboardService';

export default {
  name: 'Dashboard',
  data() {
    return {
      nextRace: null,
      dropdownVisible: false,
      days: 0,
      hours: 0,
      minutes: 0,
      seconds: 0
    };
  },
  created() {
    this.fetchRaces();
    this.startTimer();
  },
  beforeDestroy() {
    clearInterval(this.timer);
  },
  methods: {
    fetchRaces() {
      RaceService.getRaces()
        .then(response => {
          const currentTime = new Date();

          const upcomingRaces = response.data.MRData.RaceTable.Races
            .map(race => {
              return {
                ...race,
                raceDateTime: new Date(`${race.date}T${race.time}`)
              };
            })
            .filter(race => race.raceDateTime > currentTime)
            .sort((a, b) => a.raceDateTime - b.raceDateTime);

          this.nextRace = upcomingRaces.length > 0 ? upcomingRaces[0] : null;
          this.updateRemainingTime();
        })
        .catch(error => {
          console.error("There was an error fetching the race!", error);
        });
    },
    toggleDropdown() {
      this.dropdownVisible = !this.dropdownVisible;
    },
    startTimer() {
      this.timer = setInterval(this.updateRemainingTime, 1000);
    },
    updateRemainingTime() {
      if (this.nextRace) {
        const raceDateTime = new Date(`${this.nextRace.date}T${this.nextRace.time}`);
        const currentTime = new Date();
        const timeDiff = raceDateTime.getTime() - currentTime.getTime();

        if (timeDiff < 0) {
          clearInterval(this.timer);
          return;
        }

        this.days = Math.floor(timeDiff / (1000 * 60 * 60 * 24));
        this.hours = Math.floor((timeDiff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        this.minutes = Math.floor((timeDiff % (1000 * 60 * 60)) / (1000 * 60));
        this.seconds = Math.floor((timeDiff % (1000 * 60)) / 1000);
      }
    }
  }
};
</script>


<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #fff;
  color: #000;
  overflow-x: hidden;
}

.dashboard {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  background-color: #fff;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #e10600;
  width: 100%;
  padding: 1rem;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

.nav-link {
  color: #fff;
  text-decoration: none;
  margin: 0 1rem;
  font-size: 30px;
  transition: color 0.3s ease-in-out;
}

.nav-links {
  margin-left: 20%;
}

.next-race-section {
  background-color: #fff;
  padding: 2rem;
  text-align: left;
  margin: 2rem 0;
}

.content-wrapper {
  display: flex;
  width: 100%;
  justify-content: center;
}

.race {
  background-color: #fff;
  border-radius: 10px;
  transition: all 0.3s ease-in-out;
}

.race-info {
  color: #000;
  font-size: 20px;
  text-align: center;
}

.race-info div {
  margin-bottom: 0.5rem;
}

.homelink {
  display: flex;
  align-items: center;
  background-color: #e10600;
  color: white;
  padding: 1rem;
  font-size: 2rem;
  border: none;
  cursor: pointer;
  transition: background-color 0.5s ease-in-out;
  margin-right: 100px;
}

.homelink img {
  height: 50px;
  /* Adjust size as needed */
}

.homelink:hover {
  background-color: #e10600;
}

.countdown {
  display: flex;
  justify-content: center;
  margin-top: 2rem;
}

.countdown-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 1rem;
  background-color: #e10600;
  color: #fff;
  padding: 1rem;
  border-radius: 10px;
}

.count {
  font-size: 2rem;
  font-weight: bold;
}

.label {
  font-size: 1rem;
  margin-top: 0.5rem;
}
</style>
