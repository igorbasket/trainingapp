<template>
    <div align="center">
        <i style="font-size: large">Registration</i>
        <h1></h1>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" class="demo-ruleForm" style="width: 300px" align="center">
        <el-form-item label="Name" prop="name">
            <el-input type="name" v-model="ruleForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
            <el-input type="email" v-model="ruleForm.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Confirm password" prop="checkPass">
            <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Age" prop="age">
            <el-input v-model.number="ruleForm.age"></el-input>
        </el-form-item>
        <el-form-item label="Weight" prop="weight">
            <el-input type="weight" v-model="ruleForm.weight" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" v-on:click.prevent="post">Submit</el-button>
            <el-button @click="resetForm('ruleForm')">Reset</el-button>
        </el-form-item>
    </el-form>
    </div>
</template>

<script>
    export default {
        name: "Registration",
        data() {

            let checkAge = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('Please input the age'));
                }
                setTimeout(() => {
                    if (!Number.isInteger(value)) {
                        callback(new Error('Please input digits'));
                    } else {
                        if (value < 10) {
                            callback(new Error('Age must be greater than 10'));
                        } else {
                            callback();
                        }
                    }
                }, 1000);
            };
            let validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Please input the password'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            let validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Please input the password again'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('Two inputs don\'t match!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    password: '',
                    age: '',
                    name: '',
                    email: '',
                    weight: ''
                },
                rules: {
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    age: [
                        { validator: checkAge, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            post: function () {
                this.$http.post('/api/user/registration',{
                    name: this.ruleForm.name,
                    email: this.ruleForm.email,
                    password: this.ruleForm.password,
                    age: this.ruleForm.age,
                    weight: this.ruleForm.weight
                }).then(response => {
                    let a = response.data;
                    alert(a);
                    this.$router.push('/')
                })
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>