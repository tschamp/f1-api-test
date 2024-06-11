<template>
  <body>
    <div class="dashboard">
      <div class="main-content">
        <section id="drivers" class="section">
          <h1>Drivers</h1>
          <div class="content-wrapper">
            <div class="drivers-box">
              <div v-for="driver in drivers" :key="driver.driverId" class="driver">
                <div class="driver-info">
                  <div><strong>Driver Name:</strong> {{ driver.givenName }} {{ driver.familyName }}</div>
                  <div><strong>Permanent Number:</strong> {{ driver.permanentNumber }}</div>
                  <div><strong>Code:</strong> {{ driver.code }}</div>
                  <div><strong>Date of Birth:</strong> {{ driver.dateOfBirth }}</div>
                  <div><strong>Nationality:</strong> {{ driver.nationality }}</div>
                  <div> <img :src="require(`@/Driverspicture/${driver.familyName}.png`)" alt="Driver Image"
                      class="image-container"> </div>
                </div>
              </div>
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
  overflow-x: hidden;
}

.section {
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

.drivers-box {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
}

.driver {
  background-color: #222;
  padding: 1rem;
  margin-right: auto;
  margin-left: auto;
  border-radius: 10px;
  width: 30%;
  transition: all 0.3s ease-in-out;
}

.driver:hover {
  transform: scale(1.05);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  background-color: #c30000;
}

.driver-info {
  color: #fff;
  font-size: 20px;
}

.driver-info div {
  margin-bottom: 0.5rem;
}

  .image-container {
    width: 150px;
    height: 150px; /* added height */
    border-radius: 50%; /* added border radius */
    overflow: hidden; /* added overflow hidden */
    margin: 1rem auto; /* added margin */
  }

  .image-container img {
    width: 100%;
    height: 100%;
    object-fit: cover; /* added object fit */
  }
</style>