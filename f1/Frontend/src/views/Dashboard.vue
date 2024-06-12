<template>
    <div class="dashboard">
      <nav class="navbar">
        <router-link to="/circuits" class="nav-link">Circuits</router-link>
        <router-link to="/constructors" class="nav-link">Constructors</router-link>
        <router-link to="/drivers" class="nav-link">Drivers</router-link>
      </nav>
      <div class="info-section">
        <h2>Welcome to the F1 Dashboard</h2>
        <p>This dashboard provides detailed information about F1 circuits, constructors, and drivers. Use the links above to navigate to the respective sections.</p>
      </div>
      <router-view></router-view>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Dashboard'
  }
  </script>
  
  <style scoped>
  body {
    font-family: Arial, sans-serif;
    background-color: #000;
    color: #fff;
    overflow-x: hidden;
  }
  
  .dashboard {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
    background-color: #000;
  }
  
  .navbar {
    display: flex;
    justify-content: center;
    background-color: #222;
    width: 100%;
    padding: 1rem;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
  
  .nav-link {
    color: #fff;
    text-decoration: none;
    margin: 0 1rem;
    font-size: 1.5rem;
    transition: color 0.3s ease-in-out;
  }
  
  .nav-link:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    color: #c30000;
  }
  
  .info-section {
    background-color: #111;
    padding: 2rem;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    margin: 1rem 0;
    text-align: center;
    color: white;
  }
  
  .info-section h2 {
    font-size: 2rem;
    margin-bottom: 1rem;
  }
  
  .info-section p {
    font-size: 1.2rem;
    margin: 0;
  }
  </style>
  