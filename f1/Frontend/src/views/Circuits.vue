<template>
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
      <section id="circuits" class="section">
        <h1>Circuits</h1>
        <div class="content-wrapper">
          <div class="circuits-box">
            <div v-for="circuit in circuits" :key="circuit.circuitId" class="circuit">
              <div class="circuit-info">
                <div><strong>Circuit Name:</strong> {{ circuit.circuitName }}</div>
                <div><strong>Location:</strong> {{ circuit.Location.locality }}, {{ circuit.Location.country }}</div>
                <div><strong>Latitude:</strong> {{ circuit.Location.lat }}</div>
                <div><strong>Longitude:</strong> {{ circuit.Location.long }}</div>
                <div><img :src="require(`@/Countrypicture/${circuit.Location.country}.png`)"
                    alt="Country Image of Circuit" class="image-container"></div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import CircuitService from '@/router/CircuitService'; // Import der CircuitService-Klasse

export default {
  data() {
    return {
      circuits: [], // Array zur Speicherung der Streckendaten
      dropdownVisible: false // Variable zur Steuerung der Dropdown-Sichtbarkeit
    };
  },
  created() {
    this.fetchCircuits(); // Beim Erstellen der Komponente werden die Streckendaten abgerufen
  },
  methods: {
    fetchCircuits() {
      CircuitService.getCircuit() // Aufruf der Methode getCircuit aus CircuitService
        .then(response => {
          this.circuits = response.data.MRData.CircuitTable.Circuits; // Zuweisen der abgerufenen Streckendaten zur Datenvariable circuits
        })
        .catch(error => {
          console.error("There was an error fetching the circuits!", error); // Fehlerbehandlung bei Fehler beim Abrufen der Streckendaten
        });
    },
    toggleDropdown() {
      this.dropdownVisible = !this.dropdownVisible; // Methode zum Umschalten der Dropdown-Sichtbarkeit
    }
  }
};
</script>

<style scoped>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css');

body {
  font-family: Arial, sans-serif;
  background-color: white;
  color: #000;
  overflow-x: hidden;
  padding: 0;
  margin: 0;
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

.circuits-box {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
}

.circuit {
  background-color: #fff;
  padding: 1rem;
  padding-bottom: 0;
  margin-right: auto;
  margin-left: auto;
  border-radius: 10px;
  border-top-left-radius: 0;
  border-bottom-right-radius: 0;
  width: 30%;
  color: #000;
  transition: all 0.3s ease-in-out;
  border-top: 1px solid black;
  border-right: 1px solid black;
}

.circuit-info {
  color: #000;
}

.circuit-info div {
  margin-bottom: 0.5rem;
}

.image-container {
  border: 1px solid black;
  height: 200px;
  width: 300px;
  overflow: hidden;
  margin: 1rem auto;
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
}

.homelink:hover {
  background-color: #e10600;
}
</style>
