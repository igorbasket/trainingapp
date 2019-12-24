<template>
    <div>
        <el-row>
            <el-button @click="goToLogin" style="width: 150px" type="primary">Login</el-button>
        </el-row>
        <h1></h1>
        <el-row>
            <el-button @click="goToRegistr" style="width: 150px" type="success">Registration</el-button>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Home",
        methods: {
            goToLogin() {
                this.$router.push('/login')
            },
            goToRegistr() {
                this.$router.push('/registration')
            }
        }
    }
</script>

<style scoped>

</style>