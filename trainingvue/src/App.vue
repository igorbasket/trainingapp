<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/man.png" width="200px" height="200px">
    <!--    <img alt="Vue logo" src="./assets/logo.png">-->
    <!--    <UsersList msg="My Training APP"/>-->
    <h1>My-TrainingAPP</h1>
    <hr>
<!--    <router-link to="/">Home</router-link> <router-link to="/users">UsersList</router-link> -->
    <h1></h1>
    <router-view></router-view>
  </div>
</template>

<!--<script>-->
<!--  import UsersList from './components/UsersList.vue'-->
<!--  export default {-->
<!--    name: 'app',-->
<!--    components: {-->
<!--      UsersList-->
<!--    }-->
<!--  }-->
<!--</script>-->

<script>
  export default {
    data() {
      return {}
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  html,
  body{
    background: lightcyan;
  }
</style>