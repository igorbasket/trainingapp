<template>
    <div id="table">
        <h1>Таблица пользователей</h1>
        <el-table :data="usersList" align="center" style="width: 100%">
            <el-table-column
                    prop="name"
                    label="Name"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="Email"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="age"
                    label="Age"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="weight"
                    label="Weight"
                    width="180">
            </el-table-column>
        </el-table>
    </div>
</template>


<script>

//import axios from 'axios'

    export default {
        name: 'usersList',
          el: '#table',
        data() {
            return {
                usersList: []
        }
        },
          mounted() {
                this.$http.get('api/user')
                        .then(response => {
                              this.usersList = response.data
                        })
                        .catch(response => {
                              //debugger
                              alert(response.status)
                        })
          }
    }


</script>

<style scoped>


</style>