import Vue from 'vue'
import Router from 'vue-router'
// import Home from './views/Home.vue'
import UsersList from './src/components/UsersList'
// import Register from "./views/Register"
// import Login from "./views/Login";


Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path:'/login',
      name:'Login',
      component: Login,
      meta:{
        quest: true
      }
    },
    {
      path:'/register',
      name:'Register',
      component: Register,
      meta:{
        quest: true
      }
    },
    {
      path: '/ListPayments',
      name: 'ListPayments',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.

      component:UsersList,
      meta:{
        requiresAuth: true
      }
    }
  ]
})
