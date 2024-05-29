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
import analyzeService from '../router/AnalyzeService.js';

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
  body {
    font-family: Arial, sans-serif;
  }
  .dashboard {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  .header {
    background-color: #333;
    color: #fff;
    padding: 1rem;
    text-align: center;
  }
  .sidebar {
    background-color: #f4f4f4;
    padding: 1rem;
    width: 200px;
  }
  .sidebar nav ul {
    list-style: none;
    padding: 0;
  }
  .sidebar nav ul li {
    margin: 1rem 0;
  }
  .sidebar nav ul li a {
    color: #333;
    text-decoration: none;
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
    border-bottom: 2px solid #333;
    padding-bottom: 0.5rem;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 2rem;
  }
  table th, table td {
    border: 1px solid #ccc;
    padding: 0.5rem;
    text-align: left;
  }
  table th {
    background-color: #f9f9f9;
  }
</style>