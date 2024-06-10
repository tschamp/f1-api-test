<template>
    <div class="dashboard">
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
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </template>
  
  <script>
  import CircuitService from '@/router/CircuitService'; // Den richtigen Pfad zu AnalyzeService verwenden
  
  export default {
    data() {
      return {
        circuits: []
      };
    },
    created() {
      this.fetchCircuits();
    },
    methods: {
      fetchCircuits() {
        CircuitService.getCircuit()
          .then(response => {
            this.circuit = response.data.MRData.CircuitTable.Circuits;
          })
          .catch(error => {
            console.error("There was an error fetching the circuit!", error);
          });
      }
    }
  };
  </script>
  
  <style scoped>
  html {
    background-color: #000;
    font-size: 16px;
  }
  
  body {
    font-family: Arial, sans-serif;
    background-color: #000;
    color: #fff;
    overflow-x: hidden;
  }
  
  .section {
    margin: 2rem auto;
    background-color: #000;
    padding: 2rem;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
  
  .dashboard {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  
  .main-content {
    flex: 1;
    overflow-y: auto;
    padding: 2rem;
  }
  
  .section h1 {
    border-bottom: 2px solid #c30000;
    padding-bottom: 0.5rem;
    font-size: 4rem;
    font-weight: bold;
    margin-top: 0;
    color: white;
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
    background-color: #222;
    padding: 1rem;
    margin-right: auto;
    margin-left: auto;
    border-radius: 10px;
    width: 30%;
    transition: all 0.3s ease-in-out;
  }
  
  .circuit:hover {
    transform: scale(1.05);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    background-color: #c30000;
  }
  
  .circuit-info {
    color: #fff;
  }
  
  .circuit-info div {
    margin-bottom: 0.5rem;
  }
  
  .image-container {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
    margin: 1rem auto;
  }
  
  .image-container img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  </style>
  