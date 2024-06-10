import {createApp} from 'vue'
import App from './App.vue'


// Import Vue Router
import {createRouter, createWebHistory} from 'vue-router'
import DriversDashboard from './views/Drivers.vue'
import CircuitDashboard from './views/Circuits.vue'


// Create router instance
const router = createRouter({
    history: createWebHistory(),
    routes: [
        // Define routes
        {path: '/', component: App},
        {path: '/drivers', component: DriversDashboard},
        {path: '/circuits', component: CircuitDashboard},
    ]
})

// Mount the app with router
createApp(App).use(router).mount('#app')