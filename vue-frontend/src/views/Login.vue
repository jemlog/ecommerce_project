<template>
  <div class="login">
    <LoginPage msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import LoginPage from '@/components/LoginPage.vue'

export default {
  name: 'App',
  components: {
    LoginPage
  }
}
</script>
