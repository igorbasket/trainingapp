<template>
    <div align="center">
        <i style="font-size: large">Creating a training:</i>
        <h1/>
        <el-form :model="newTrainingForm" ref="newTrainingForm" class="demo-dynamic" style="width: 400px" >
            <el-form-item label="Training name"
                          :rules="{required: true, message: 'Exercise can not be null', trigger: 'blur'}">
                <el-input v-model="newTrainingForm.nameTrain"/>
            </el-form-item>

            <!--        <el-form-item label="Rest duration">-->
            <strong>Rest duration</strong>
            <el-select v-model="valueMinutesRest" clearable placeholder="Select minutes" style="width: 400px">
                <el-option
                        v-for="item in optionsMinutes"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
<!--            <span class="mid" id="middlee">:</span>-->
            <el-select v-model="valueSecondsRest"  clearable placeholder="Select seconds" style="width: 400px">
                <el-option
                        v-for="item in optionsSeconds"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
            <!--        </el-form-item>-->


            <el-form-item
                    v-for="(domain, index) in newTrainingForm.exercise"
                    :key="domain.key"
                    :rules="{
      required: true, message: 'Exercise can not be empty', trigger: 'blur'
    }"
            >
                <strong>Exercise {{index + 1}}</strong>
                <el-input placeholder="Input exercise name" v-model="domain.nameEx"/>

                <!--            <el-time-picker placeholder="Pick exercise duration" v-model="domain.timeEx" style="width: 100%;"/>-->

                <el-select v-model="domain.valueMinutes" clearable placeholder="Select minutes" style="width: 198px">
                    <el-option
                            v-for="item in optionsMinutes"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
                <span class="mid" id="middle">:</span>
                <el-select v-model="domain.valueSeconds" clearable placeholder="Select seconds" style="width: 197px">
                    <el-option
                            v-for="item in optionsSeconds"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>

                <!--            <el-input type="time" v-model="domain.timeEx"></el-input>-->
                <el-button class="del" type="danger" @click.prevent="removeDomain(domain)">Delete</el-button>
            </el-form-item>

            <el-form-item>
                <el-button type="success" @click="submitForm('newTrainingForm')">Creat</el-button>
                <el-button type="primary" @click="addDomain">New exercise</el-button>
                <el-button @click="resetForm('newTrainingForm')">Reset</el-button>
            </el-form-item>
            <small class="tet-muted">Data: {{newTrainingForm}}</small>
        </el-form>


    </div>
</template>


<script>
    export default {
        name: "NewTraining",
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        alert('error submit!!');
                        return false;
                    }
                });
            },
            // resetForm() {
            //     this.newTrainingForm.exercise.timeEx = 0;
            //     this.newTrainingForm.exercise.nameEx = '';
            //     this.newTrainingForm.nameTrain = '';
            // },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            removeDomain(item) {
                let index = this.newTrainingForm.exercise.indexOf(item);
                if (index !== -1) {
                    this.newTrainingForm.exercise.splice(index, 1);
                }
            },
            addDomain() {
                this.newTrainingForm.exercise.push({
                    timeEx: 0,
                    nameEx: '',
                });
                // this.valueMinutes = '';
            },
            exerciseCount () {
                this.counterEx = 1
            }
        },
        data() {
            return {
                newTrainingForm: {
                    exercise: [{
                        timeEx: 0,
                        nameEx: '',
                    }],
                    nameTrain: ''
                },
                valueMinutes: 0,
                valueSeconds: 0,
                valueMinutesRest: '',
                valueSecondsRest: '',
                optionsMinutes: [{
                    value: 0,
                    label: '0'
                }, {
                    value: 1,
                    label: '1'
                }, {
                    value: 2,
                    label: '2'
                }, {
                    value: 3,
                    label: '3'
                }, {
                    value: 4,
                    label: '4'
                }, {
                    value: 5,
                    label: '5'
                },{
                    value: 6,
                    label: '6'
                }, {
                    value: 7,
                    label: '7'
                }, {
                    value: 8,
                    label: '8'
                }, {
                    value: 9,
                    label: '9'
                }, {
                    value: 10,
                    label: '10'
                },{
                    value: 11,
                    label: '11'
                }, {
                    value: 12,
                    label: '12'
                }, {
                    value: 13,
                    label: '13'
                }, {
                    value: 14,
                    label: '14'
                }, {
                    value: 15,
                    label: '15'
                },{
                    value: 16,
                    label: '16'
                }, {
                    value: 17,
                    label: '17'
                }, {
                    value: 18,
                    label: '18'
                }, {
                    value: 19,
                    label: '19'
                }, {
                    value: 20,
                    label: '20'
                },{
                    value: 21,
                    label: '21'
                }, {
                    value: 22,
                    label: '22'
                }, {
                    value: 23,
                    label: '23'
                }, {
                    value: 24,
                    label: '24'
                }, {
                    value: 25,
                    label: '25'
                },{
                    value: 26,
                    label: '26'
                }, {
                    value: 27,
                    label: '27'
                }, {
                    value: 28,
                    label: '28'
                }, {
                    value: 29,
                    label: '29'
                }, {
                    value: 30,
                    label: '30'
                },{
                    value: 31,
                    label: '31'
                }, {
                    value: 32,
                    label: '32'
                }, {
                    value: 33,
                    label: '33'
                }, {
                    value: 34,
                    label: '34'
                }, {
                    value: 35,
                    label: '35'
                },{
                    value: 36,
                    label: '36'
                }, {
                    value: 37,
                    label: '37'
                }, {
                    value: 38,
                    label: '38'
                }, {
                    value: 39,
                    label: '39'
                }, {
                    value: 40,
                    label: '40'
                },{
                    value: 41,
                    label: '41'
                }, {
                    value: 42,
                    label: '42'
                }, {
                    value: 43,
                    label: '43'
                }, {
                    value: 44,
                    label: '44'
                }, {
                    value: 45,
                    label: '45'
                },{
                    value: 46,
                    label: '46'
                }, {
                    value: 47,
                    label: '47'
                }, {
                    value: 48,
                    label: '48'
                }, {
                    value: 49,
                    label: '49'
                }, {
                    value: 50,
                    label: '50'
                },{
                    value: 51,
                    label: '51'
                }, {
                    value: 52,
                    label: '52'
                }, {
                    value: 53,
                    label: '53'
                }, {
                    value: 54,
                    label: '54'
                }, {
                    value: 55,
                    label: '55'
                },{
                    value: 56,
                    label: '56'
                }, {
                    value: 57,
                    label: '57'
                }, {
                    value: 58,
                    label: '58'
                }, {
                    value: 59,
                    label: '59'
                }],
                optionsSeconds: [{
                    value: 0,
                    label: '0'
                },{
                    value: 1,
                    label: '1'
                }, {
                    value: 2,
                    label: '2'
                }, {
                    value: 3,
                    label: '3'
                }, {
                    value: 4,
                    label: '4'
                }, {
                    value: 5,
                    label: '5'
                },{
                    value: 6,
                    label: '6'
                }, {
                    value: 7,
                    label: '7'
                }, {
                    value: 8,
                    label: '8'
                }, {
                    value: 9,
                    label: '9'
                }, {
                    value: 10,
                    label: '10'
                },{
                    value: 11,
                    label: '11'
                }, {
                    value: 12,
                    label: '12'
                }, {
                    value: 13,
                    label: '13'
                }, {
                    value: 14,
                    label: '14'
                }, {
                    value: 15,
                    label: '15'
                },{
                    value: 16,
                    label: '16'
                }, {
                    value: 17,
                    label: '17'
                }, {
                    value: 18,
                    label: '18'
                }, {
                    value: 19,
                    label: '19'
                }, {
                    value: 20,
                    label: '20'
                },{
                    value: 21,
                    label: '21'
                }, {
                    value: 22,
                    label: '22'
                }, {
                    value: 23,
                    label: '23'
                }, {
                    value: 24,
                    label: '24'
                }, {
                    value: 25,
                    label: '25'
                },{
                    value: 26,
                    label: '26'
                }, {
                    value: 27,
                    label: '27'
                }, {
                    value: 28,
                    label: '28'
                }, {
                    value: 29,
                    label: '29'
                }, {
                    value: 30,
                    label: '30'
                },{
                    value: 31,
                    label: '31'
                }, {
                    value: 32,
                    label: '32'
                }, {
                    value: 33,
                    label: '33'
                }, {
                    value: 34,
                    label: '34'
                }, {
                    value: 35,
                    label: '35'
                },{
                    value: 36,
                    label: '36'
                }, {
                    value: 37,
                    label: '37'
                }, {
                    value: 38,
                    label: '38'
                }, {
                    value: 39,
                    label: '39'
                }, {
                    value: 40,
                    label: '40'
                },{
                    value: 41,
                    label: '41'
                }, {
                    value: 42,
                    label: '42'
                }, {
                    value: 43,
                    label: '43'
                }, {
                    value: 44,
                    label: '44'
                }, {
                    value: 45,
                    label: '45'
                },{
                    value: 46,
                    label: '46'
                }, {
                    value: 47,
                    label: '47'
                }, {
                    value: 48,
                    label: '48'
                }, {
                    value: 49,
                    label: '49'
                }, {
                    value: 50,
                    label: '50'
                },{
                    value: 51,
                    label: '51'
                }, {
                    value: 52,
                    label: '52'
                }, {
                    value: 53,
                    label: '53'
                }, {
                    value: 54,
                    label: '54'
                }, {
                    value: 55,
                    label: '55'
                },{
                    value: 56,
                    label: '56'
                }, {
                    value: 57,
                    label: '57'
                }, {
                    value: 58,
                    label: '58'
                }, {
                    value: 59,
                    label: '59'
                }],
            };
        },
    }
</script>

<style scoped>
    .del{
        margin-top: 1rem;
    }
    .mid{
        font-weight: bolder;
    }
    strong{
        color: rgba(12,12,12,0.68);
        float: left
    }
</style>