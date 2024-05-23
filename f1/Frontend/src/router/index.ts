import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Drivers from "../views/Drivers.vue"

const routes: Array<RouteRecordRaw> = [
    { path: '/drivers', component: Drivers },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL), // uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
    routes
});

export default router;