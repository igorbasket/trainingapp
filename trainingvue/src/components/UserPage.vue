<template>
    <div>
        <i style="font-size: large">Greetings!!!</i>
        <h1></h1>
        <el-button type="primary" v-on:click.prevent="pushToUserTrainingList">My trainings</el-button>
        <h1></h1>
        <el-button type="primary" v-on:click.prevent="pushToNewTrain">Create a new workout</el-button>
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: "UserPage",
        methods: {
            pushToNewTrain: function () {
                this.$router.push('/new_train')
            },
            pushToUserTrainingList: function () {
                this.$router.push('/user_training_list')
            },
        }
    }
</script>

<style scoped>
</style>