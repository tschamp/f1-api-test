<template>
    <div class="dashboard">
      <nav class="navbar">
        <div class="dropdown">
          <button @click="toggleDropdown" class="dropbtn">
            <i class="fas fa-bars"></i>
          </button>
          <div v-show="dropdownVisible" class="dropdown-content">
            <router-link to="/races" class="dropdown-link">Races</router-link>
            <router-link to="/circuits" class="dropdown-link">Circuits</router-link>
            <router-link to="/constructors" class="dropdown-link">Constructors</router-link>
            <router-link to="/drivers" class="dropdown-link">Drivers</router-link>
          </div>
        </div>
      </nav>
      <div class="main-content">
        <section id="races" class="section">
          <h1>Races</h1>
          <div class="content-wrapper">
            <div class="races-box">
              <div v-for="race in races" :key="race.round" class="race">
                <div class="race-info">
                  <div><strong>Race Name:</strong> {{ race.raceName }}</div>
                  <div><strong>Date:</strong> {{ race.date }}</div>
                  <div><strong>Time:</strong> {{ race.time }}</div>
                  <div><strong>Location:</strong> {{ race.Circuit.Location.locality }}, {{ race.Circuit.Location.country }}</div>
                  <div><strong>Circuit:</strong> {{ race.Circuit.circuitName }}</div>
                  <div><strong>Latitude:</strong> {{ race.Circuit.Location.lat }}</div>
                  <div><strong>Longitude:</strong> {{ race.Circuit.Location.long }}</div>
                  <div>
                    <img :src="require(`@/Countrypicture/${race.Circuit.Location.country}.png`)" alt="Country Image of Circuit" class="image-container">
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
  import RaceService from '@/router/RaceService'; // Den richtigen Pfad zu RaceService verwenden
  
  export default {
    data() {
      return {
        races: [],
        dropdownVisible: false
      };
    },
    created() {
      this.fetchRaces();
    },
    methods: {
      fetchRaces() {
        RaceService.getRaces()
          .then(response => {
            this.races = response.data.MRData.RaceTable.Races;
          })
          .catch(error => {
            console.error('Error fetching races:', error);
          });
      },
      toggleDropdown() {
        this.dropdownVisible = !this.dropdownVisible;
      }
    }
  };
  </script>
  
  <style scoped>
  .dashboard {
    display: flex;
    flex-direction: column;
  }
  .navbar {
    display: flex;
    justify-content: space-between;
  }
  .dropbtn {
    background-color: #333;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
  }
  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
  }
  .dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
  }
  .dropdown-content a:hover {
    background-color: #f1f1f1;
  }
  .dropdown:hover .dropdown-content {
    display: block;
  }
  .main-content {
    padding: 20px;
  }
  .content-wrapper {
    display: flex;
    flex-wrap: wrap;
  }
  .races-box {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  .race {
    background-color: #f9f9f9;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
  .image-container {
    max-width: 100px;
    max-height: 100px;
  }
  </style>
  