<template>
    <div class="about-page">
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
            <section id="about" class="section">
                <h1>About</h1>
                <div class="content-wrapper">
                    <p>Willkommen auf meiner Formel-1-Informationsseite.</p>
                    <p>Hier finden Sie detaillierte Informationen über Strecken, Konstrukteure, Fahrer und Rennen.</p>
                    <p>Bleiben Sie dran für die neuesten Updates und spannende Inhalte.</p>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            dropdownVisible: false
        };
    },
    methods: {
        toggleDropdown() {
            this.dropdownVisible = !this.dropdownVisible;
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
    padding: 2rem;
    margin: 2rem;
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
    margin-top: 2rem;
    font-size: 1.2rem;
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