import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import booking from "@/views/booking.vue";
import AdminWelcome from "@/views/admin/welcome.vue"
import Housekeeping from "@/views/admin/housekeeping.vue";


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/booking',
    name: 'booking',
    component: booking
  },
  {
    path: '/admin/',
    name: 'AdminWelcome',
    component: AdminWelcome,
    children:[
      {
        path:'/admin/housekeeping',
        component:()=>import('../views/admin/housekeeping.vue'),
      },
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
