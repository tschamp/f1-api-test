<template>
  <div>
    <h1>Drivers</h1>
    <ul>
      <li v-for="driver in drivers" :key="driver.id">
        {{ driver.name }} ({{ driver.team }})
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      drivers: [],
    };
  },
  mounted() {
    // Fetch the drivers from the server
    fetch('http://localhost:8080/drivers')
     .then(response => response.json())
     .then(data => {
        this.drivers = data;
      });
  },
};
</script>