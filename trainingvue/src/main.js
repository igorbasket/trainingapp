import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import UsersList from "./components/UsersList"
import Home from "./components/Home"
import Registration from "./components/Registration";
import Login from "./components/Login";

Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(VueResource);
Vue.use(VueRouter);

const routes = [
  {path: "/", component: Home},
  {path: "/users", component: UsersList},
  {path: "/registration", component: Registration},
  {path: "/login", component: Login}
];

const router = new VueRouter({
  routes,
  mode: "history" //remove "#" from URL
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});



// new Vue({
// //  router,
//   render: h => h(App),
// }).$mount('#app');