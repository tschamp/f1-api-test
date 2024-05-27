import {createApp} from 'vue'
import App from './App.vue'

// Import Vue Router
import {createRouter, createWebHistory} from 'vue-router'
import DriversDashboard from './views/Drivers.vue'


// Create router instance
const router = createRouter({
    history: createWebHistory(),
    routes: [
        // Define routes
        {path: '/', component: App},
        {path: '/drivers', component: DriversDashboard},
    ]
})

// Mount the app with router
createApp(App).use(router).mount('#app')