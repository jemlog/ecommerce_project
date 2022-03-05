<template>
  <div class="about">
    <h1>i will test axios!</h1>
    <v-btn outlined @click="button">Click</v-btn>
    <p>{{a}}</p>
  </div>
</template>
<script>
export default {
  name: 'App',
  data: () => ({
    a: ''
  }),
  methods: {
    button () {
      this.$http.get('/items').then(result => {
        console.log(result.data)
        this.a = result.data
      })
    }
  }
}
</script>