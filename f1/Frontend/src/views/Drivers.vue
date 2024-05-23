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

<style scoped>
p {
  margin-bottom: 20px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
