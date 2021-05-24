import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router'
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
  mode: 'hash',
  // history: createWebHistory(process.env.BASE_URL),
  history: createWebHashHistory(),
  routes
})
// const router = new VueRouter({
//   // mode: 'hash',
//   routes
// })

export default router
