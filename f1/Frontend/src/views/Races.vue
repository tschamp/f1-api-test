<template class="htmls">
  <div class="dashboard">
    <nav class="navbar">
      <div class="dropdown">
        <button @click="toggleDropdown" class="dropbtn">
          <i class="fas fa-bars"></i>
        </button>
        <div v-show="dropdownVisible" class="dropdown-content">
          <router-link to="/circuits" class="dropdown-link">Circuits</router-link>
          <router-link to="/constructors" class="dropdown-link">Constructors</router-link>
          <router-link to="/drivers" class="dropdown-link">Drivers</router-link>
          <router-link to="/races" class="dropdown-link">Races</router-link>
          <router-link to="/about" class="dropdown-link">About</router-link>
        </div>
      </div>
      <router-link to="/" class="homelink"><img src="../assets/f1_logo.png" alt="Logo"></router-link>
    </nav>
    <div class="main-content">
      <section id="races" class="section">
        <h1>Races</h1>
        <div class="content-wrapper">
          <div class="races-box">
            <div v-for="race in races" :key="race.raceId" class="race">
              <div class="race-info">
                <div><strong>Race Name:</strong> {{ race.raceName }}</div>
                <div><strong>Circuit Name:</strong> {{ race.Circuit.circuitName }}</div>
                <div><strong>Date:</strong> {{ race.date }}</div>
                <div><strong>Time:</strong> {{ race.time }}</div>
                <div class="practice-block">
                  <div><strong>First Practice:</strong></div>
                  <div>{{ race.FirstPractice.date }} at {{ race.FirstPractice.time }}</div>
                  <div>{{ calculateTimeRemaining(race.FirstPractice.date, race.FirstPractice.time) }}</div>
                </div>
                <div class="practice-block">
                  <div><strong>Second Practice:</strong></div>
                  <div>{{ race.SecondPractice.date }} at {{ race.SecondPractice.time }}</div>
                  <div>{{ calculateTimeRemaining(race.SecondPractice.date, race.SecondPractice.time) }}</div>
                </div>
                <div class="practice-block">
                  <div><strong>Third Practice:</strong></div>
                  <div>{{ race.ThirdPractice?.date }} at {{ race.ThirdPractice?.time }}</div>
                  <div>{{ calculateTimeRemaining(race.ThirdPractice?.date, race.ThirdPractice?.time) }}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import RaceService from '@/router/RaceService'; // Importiere RaceService aus dem richtigen Pfad

export default {
  data() {
    return {
      races: [], // Initialisiere das races Array für die Renninformationen
      dropdownVisible: false // Variable für die Sichtbarkeit des Dropdown-Menüs
    };
  },
  created() {
    this.fetchRaces(); // Beim Erstellen der Komponente werden die Rennen geladen
  },
  methods: {
    fetchRaces() {
      // Funktion zum Abrufen der Rennen über RaceService
      RaceService.getRaces()
        .then(response => {
          const currentTime = new Date(); // Aktuelle Zeit
          // Sortiere die Rennen nach Datum und Zeit, um vergangene Rennen nach oben zu bringen
          this.races = response.data.MRData.RaceTable.Races.sort((a, b) => {
            const raceADate = new Date(`${a.date}T${a.time}`); // Datum und Zeit des Rennens A
            const raceBDate = new Date(`${b.date}T${b.time}`); // Datum und Zeit des Rennens B
            if (raceADate < currentTime) return 1; // Sortierung für vergangene Rennen
            if (raceBDate < currentTime) return -1;
            return 0;
          });
        })
        .catch(error => {
          console.error("Beim Abrufen des Rennens ist ein Fehler aufgetreten!", error); // Fehlerbehandlung
        });
    },
    toggleDropdown() {
      this.dropdownVisible = !this.dropdownVisible; // Funktion zum Umschalten der Dropdown-Sichtbarkeit
    },
    calculateTimeRemaining(date, time) {
      // Funktion zur Berechnung der verbleibenden Zeit bis zum Rennen
      const raceDateTime = new Date(`${date}T${time}`); // Datum und Zeit des Rennens
      const currentTime = new Date(); // Aktuelle Zeit
      const timeDiff = raceDateTime.getTime() - currentTime.getTime(); // Differenz in Millisekunden
      if (timeDiff < 0) {
        return "Rennen ist bereits vorbei"; // Fall für vergangene Rennen
      }
      // Berechnung von Tagen, Stunden und Minuten bis zum Rennen
      const days = Math.floor(timeDiff / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeDiff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeDiff % (1000 * 60 * 60)) / (1000 * 60));
      let remainingTime = "";
      if (days > 0) {
        remainingTime += `${days}d `;
      }
      if (hours > 0) {
        remainingTime += `${hours}h `;
      }
      if (minutes > 0) {
        remainingTime += `${minutes}m `;
      }
      return remainingTime.trim(); // Rückgabe der verbleibenden Zeit im formatierten String
    }
  },
};
</script>


<style scoped>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css');

template {
  margin: 0px;
  padding: 0px;
}

body {
  font-family: Arial, sans-serif;
  background-color: white;
  color: #000;
  overflow-x: hidden;
  padding: 0px;
  margin: 0px;
}

.section {
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

.dashboard {
  display: flex;
  flex-direction: column;
  height: 99vh;
  width: 99vw;
}

.main-content {
  flex: 1;
  overflow-y: auto;
  background-color: #fff;
}

.section h1 {
  border-bottom: 4px solid #e10600;
  padding-bottom: 0.5rem;
  font-size: 4rem;
  font-weight: bold;
  margin-top: 0;
  color: black;
}

.content-wrapper {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.drivers-box,
.races-box {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
}

.driver,
.race {
  background-color: #fff;
  padding: 1rem;
  padding-bottom: 0;
  margin-right: auto;
  margin-left: auto;
  border-radius: 10px;
  border-top-left-radius: 0%;
  border-bottom-right-radius: 0%;
  width: 30%;
  color: #000;
  transition: all 0.3s ease-in-out;
  border-top: 3px solid black;
  border-right: 3px solid black;
}

.driver-info,
.race-info {
  color: #000;
}

.driver-info div,
.race-info div {
  margin-bottom: 0.5rem;
}

.driver-info-data {
  text-align: start;
  font-size: 30px;
  line-height: 50%;
}

.driver-info-mid {
  text-align: start;
  font-size: 15px;
}

.driver-info-small {
  text-align: start;
  font-size: 13px;
}

.image-container {
  width: 200px;
  height: 200px;
  border-radius: 30%;
  overflow: hidden;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
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

.navbar-left {
  display: flex;
  align-items: center;
}

.dropbtn {
  background-color: #e10600;
  color: white;
  padding: 0.5rem;
  font-size: 1.5rem;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

.dropbtn i {
  font-size: 3rem;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #222;
  min-width: 160px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  z-index: 1;
}

.dropdown-content .dropdown-link {
  color: white;
  padding: 1rem;
  text-decoration: none;
  display: block;
  font-size: 1.5rem;
  border-radius: 10px;
  transition: background-color 0.3s ease-in-out;
}

.dropdown-content .dropdown-link:hover {
  background-color: #e10600;
}

.dropdown:hover .dropdown-content {
  display: block;
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

.practice-block {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-top: 10px;
}

.practice-block>div {
  margin-bottom: 5px;
}
</style>
