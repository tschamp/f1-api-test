<template class="htmls">
    <div class="dashboard">
        <div class="main-content">
            <section id="constructors" class="section">
                <h1>Constructors</h1>
                <div class="content-wrapper">
                    <div class="constructors-box">
                        <div v-for="constructor in constructors" :key="constructor.constructorId" class="constructor">
                            <div class="constructor-info">
                                <div><strong>Constructor Name:</strong> {{ constructor.name }}</div>
                                <div><strong>Nationality:</strong> {{ constructor.nationality }}</div>
                                <div class="image-container">
                                    <img :src="require(`@/Constructorspicture/${constructor.name}.png`)" alt="Constructor Logo" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
import ConstructorService from '@/router/ConstructorService'; // Den richtigen Pfad zu AnalyzeService verwenden

export default {
    data() {
        return {
            constructors: []
        };
    },
    created() {
        this.fetchConstructors();
    },
    methods: {
        fetchConstructors() {
            ConstructorService.getConstructors()
                .then(response => {
                    this.constructors = response.data.MRData.ConstructorTable.Constructors;
                })
                .catch(error => {
                    console.error("There was an error fetching the constructors!", error);
                });
        }
    }
};
</script>

<style scoped>
.htmls {
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

.constructors-box {
    display: flex;
    flex-wrap: wrap;
    gap: 1rem;
    justify-content: center;
}

.constructor {
    background-color: #222;
    padding: 1rem;
    margin-right: auto;
    margin-left: auto;
    border-radius: 10px;
    width: 30%;
    transition: all 0.3s ease-in-out;
}

.constructor:hover {
    transform: scale(1.05);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    background-color: #c30000;
}

.constructor-info {
    color: #fff;
    font-size: 20px;
}

.constructor-info div {
    margin-bottom: 0.5rem;
}

.image-container {
    width: 150px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 1rem auto;
}

.image-container img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>
