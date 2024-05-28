<template>

<body>
    <div class="dashboard">
        <header class="header">
            <h1>Dashboard</h1>
        </header>
        <div class="sidebar">
            <nav>
                <ul>
                    <li><a href="#overview">Overview</a></li>
                    <li><a href="#drivers">Drivers</a></li>
                    <li><a href="#analytics">Analytics</a></li>
                    <li><a href="#settings">Settings</a></li>
                </ul>
            </nav>
        </div>
        <div class="main-content">
            <section id="overview" class="section">
                <h2>Overview</h2>
                <p>Summary of key metrics.</p>
            </section>
            <section id="drivers" class="section">
                <h2>Drivers</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Permanent Number</th>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Date of Birth</th>
                            <th>Nationality</th>
                            <th>Profile</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Data will be inserted here by JavaScript -->
                    </tbody>
                </table>
            </section>
            <section id="analytics" class="section">
                <h2>Analytics</h2>
                <p>Data analysis and insights.</p>
            </section>
            <section id="settings" class="section">
                <h2>Settings</h2>
                <p>Manage your settings.</p>
            </section>
        </div>
    </div>
  </body>

</template>

<script>
import analyzeService from '../services/AnalyzeService.js';

export default {
  name: 'analyzeResults',
  data() {
    return {
      drivers: [],
      inputParameter: '',
      email: ''
    };
  },
  methods: {
    async getResults() {
      if (this.inputParameter === '') {
        this.drivers = [];
        return;
      }
      try {
        const response = await analyzeService.getDrivers();
        this.drivers = response.data.MRData.DriverTable.Drivers;
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>

<style scoped>
.container {
  width: 80%;
  margin: 0 auto;
  font-family: Arial, sans-serif;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header h1 {
  margin: 0;
}

.nav-links a {
  margin: 0 10px;
  text-decoration: none;
  color: #42b983;
  font-weight: bold;
}

.nav-links a.active {
  color: #35495e;
}

.input-section {
  margin: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.input {
  margin: 10px 0;
  padding: 10px;
  width: 80%;
  max-width: 500px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.email-input {
  margin-top: 0;
}

.button {
  padding: 10px 20px;
  background-color: #42b983;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}

.button:hover {
  background-color: #35495e;
}

.results-section {
  margin-top: 30px;
}

.table {
  width: 100%;
  border-collapse: collapse;
  margin: 20px 0;
}

.table th, .table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.table th {
  background-color: #f4f4f4;
}

.table a {
  color: #42b983;
}

.table a:hover {
  color: #35495e;
}

.no-results {
  margin-top: 20px;
  text-align: center;
  color: #888;
}
</style>
