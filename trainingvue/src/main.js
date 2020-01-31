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
import UserPage from "./components/UserPage";
import NewTraining from "./components/NewTraining";
import TrainingDisplay from "./components/TrainingDisplay";
import UserTrainingList from "./components/UserTrainingList";
import en from "element-ui/lib/locale/lang/en";
// import Timer3 from "./components/Timer3";

Vue.config.productionTip = false;
Vue.use(ElementUI, { locale: en });
Vue.use(VueResource);
Vue.use(VueRouter);


const routes = [
  {path: "/", component: Home},
  {path: "/users", component: UsersList},
  {path: "/registration", component: Registration},
  {path: "/login", component: Login},
  {path: "/user_page", component: UserPage},
  {path: "/new_train", component: NewTraining},
  {path: "/train_display", component: TrainingDisplay},
  {path: "/user_training_list", component: UserTrainingList}
  // {path: "/timer3", component: Timer3}
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