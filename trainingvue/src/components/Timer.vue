<template>
    <div>
        <div v-if="minutes <= '0' && seconds <= '0'">
            <p style="color:red;">
                00:00
            </p>
            <button @click="timer_loop">Start</button>
            <button @click="stop">Stop</button>
        </div>
        <div v-else>
            <p> {{ Math.trunc(minutes) }}:{{ Math.trunc(seconds) }}
            </p>
            <button @click="timer_loop">Start</button>
            <button @click="stop">Stop</button>
        </div>
<!--        <small class="tet-muted">Data: {{count}}</small>-->
    </div>
</template>

<script>
    export default {
        name: "CountdownTimer",
        props: {
            date: {
                type: String
            },
            dataTimeout: {
                type: String
            }
        },
        data() {
            return {
                now: 0,
                count: Number(this.date),
                countTimeout: Number(this.dataTimeout),
                timeStop: 0,
                currentTime: 0
            }
        },
        methods: {
            timer_loop() {
                this.count--
                this.now = Math.trunc(new Date().getTime() / 1000)
                //console.log(this.now);
                setTimeout(this.timer_loop, 1000)
                this.currentTime = this.count
                if (this.count < 0){
                    this.count = this.countTimeout
                    this.countTimeout = 0
                        if (this.countTimeout < 0){
                            this.count = this.timeStop
                        }
                }
            },
            start() {
                if (this.count === this.timeStop){
                    this.count = this.currentTime
                }
                this.timer_loop()
            },
            stop() {
                this.count = this.timeStop
            },
            reset() {
                this.stop()
                this.time = 0
                this.secondes = 0
                this.minutes = 0
            },
        },
        // mounted() {
        //     this.timer_loop()
        // },
        computed: {
            seconds() {
                return (this.count) % 60
            },
            minutes() {
                return ((this.count) / 60) % 60
            },
            // hours() {
            //     return ((this.modifiedDate - this.now) / 60 / 60) % 24
            // },
            // days() {
            //     return ((this.modifiedDate - this.now) / 60 / 60 / 24)
            // },
            // modifiedDate: function () {
            //     return Math.trunc(Date.parse(this.date) / 1000)
            // }
        }
    }
</script>

<style scoped>



</style>