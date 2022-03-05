<template>
  <div class="about">
    <h1>물품 목록 가져오기</h1>
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