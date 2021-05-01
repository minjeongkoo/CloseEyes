import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Writing from '../views/Writing.vue'
import Mylist from '../views/Mylist.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/writing',
    name: 'Writing',
    component: Writing
  },
  {
    path: '/mylist',
    name: 'Mylist',
    component: Mylist
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
