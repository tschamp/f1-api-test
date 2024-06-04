<template>
    <body>
      <div class="dashboard">
        <div class="main-content">
          <section id="drivers" class="section">
            <h2>Drivers</h2>
            <div class="content-wrapper">
              <div class="drivers-box">
                <div v-for="driver in drivers" :key="driver.driverId" class="driver">
                  <div class="driver-info">
                    <div><strong>Driver Name:</strong> {{ driver.givenName }} {{ driver.familyName }}</div>
                    <div><strong>Permanent Number:</strong> {{ driver.permanentNumber }}</div>
                    <div><strong>Code:</strong> {{ driver.code }}</div>
                    <div><strong>Date of Birth:</strong> {{ driver.dateOfBirth }}</div>
                    <div><strong>Nationality:</strong> {{ driver.nationality }}</div>
                    <div id="app"><img :src="'C:/Users/timo.schreiber/OneDrive - ICT Berufsfachschulen Kanton Thurgau/Dokumente/f1-api-test/f1/Frontend/src/picture/' +  driver.familyName  + '.png'" alt="Driver Image"></div>

                  </div>
                </div>
              </div>
              <div class="image-container">
                
              </div>
            </div>
          </section>
        </div>
      </div>
    </body>
  </template>
  
  <script>
  import AnalyzeService from '@/router/DriverService'; // Den richtigen Pfad zu AnalyzeService verwenden
  
  export default {
    data() {
      return {
        drivers: []
      };
    },
    created() {
      this.fetchDrivers();
    },
    methods: {
      fetchDrivers() {
        AnalyzeService.getDrivers()
          .then(response => {
            this.drivers = response.data.MRData.DriverTable.Drivers;
          })
          .catch(error => {
            console.error("There was an error fetching the drivers!", error);
          });
      }
    }
  };
  </script>
  
  <style scoped>
  body {
    font-family: Arial, sans-serif;
    background-color: #000;
    color: #fff;
  }
  
  .dashboard {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  
  .main-content {
    flex: 1;
    padding: 1rem;
    overflow-y: auto;
  }
  
  .section {
    margin-bottom: 2rem;
  }
  
  .section h2 {
    border-bottom: 2px solid #c30000;
    padding-bottom: 0.5rem;
  }
  
  .content-wrapper {
    display: flex;
  }
  
  .drivers-box {
    display: flex;
    flex-wrap: wrap;
    gap: 1rem;
    flex: 1;
  }
  
  .driver {
    background-color: #222;
    padding: 1rem;
    border-radius: 8px;
    width: calc(50% - 1rem);
  }
  
  .driver-info {
    color: #fff;
  }
  
  .driver-info div {
    margin-bottom: 0.5rem;
  }
  
  .image-container {
    width: 100px; /* Adjust width as needed */
    margin-left: -40px; /* Add margin to create space */
  }
  </style>
  