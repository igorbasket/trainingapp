<template>
    <div align="center">
        <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="120px"  class="demo-dynamic" style="width: 30%">
            <el-form-item
                    prop="email"
                    label="Email"
                    :rules="[
      { required: true, message: 'Please input email address', trigger: 'blur' },
      { type: 'email', message: 'Please input correct email address', trigger: ['blur', 'change'] }
    ]"
            >
                <el-input v-model="dynamicValidateForm.email"></el-input>
            </el-form-item>
            <el-form-item
                    prop="password"
                    label="Password"
                    :rules="[
      { required: true, trigger: 'blur' }
    ]"
            >
                <el-input v-model="dynamicValidateForm.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('dynamicValidateForm')">Submit</el-button>
                <el-button @click="resetForm('dynamicValidateForm')">Reset</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                dynamicValidateForm: {
                    password: '',
                    email: ''
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$http.post('/api/user/login'), {
                            email: this.dynamicValidateForm.password,
                            password: this.dynamicValidateForm.email,
                        },
                        alert('submit!');
                    } else {
                        alert('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
        }
        }
</script>

<style scoped>

</style>