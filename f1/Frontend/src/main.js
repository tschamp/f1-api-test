import {createApp} from 'vue'
import App from './App.vue'


// Import Vue Router
import {createRouter, createWebHistory} from 'vue-router'
import DriversDashboard from './views/Drivers.vue'
import CircuitDashboard from './views/Circuits.vue'
import ConstructorsDashboard from './views/Constructors.vue'
import Dashboard from './views/Dashboard.vue'
import Race from './views/Race.vue'


// Create router instance
const router = createRouter({
    history: createWebHistory(),
    routes: [
        // Define routes
        {path: '/', component: Dashboard},
        {path: '/drivers', component: DriversDashboard},
        {path: '/circuits', component: CircuitDashboard},
        {path: '/constructors', component: ConstructorsDashboard},
        {path: '/race', component: RaceDashboard},
    ]
})

// Mount the app with router
createApp(App).use(router).mount('#app')