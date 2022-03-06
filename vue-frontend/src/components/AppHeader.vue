<template><div>
  <template v-if="$store.getters.isLogin">
    <span>안녕하세요 {{ $store.state.username }}님</span>
    <v-btn color="warn" v-on:click="logoutUser">로그아웃</v-btn>
  </template>
</div>
</template>

<script>
import {deleteCookie} from "@/utils/cookie";

export default {
  name: "AppHeader",
  methods : {
    logoutUser(){
      this.$store.commit('clearUsername');
      this.$store.commit('clearToken');
      deleteCookie('auth');
      deleteCookie('user');
      this.$router.push('/login');
    },
    logoLink() {
      return this.$store.getters.isLogin ? '/main' : '/login';
    },
    isUserLogin()
    {
      return this.$store.getters.isLogin;
    }
  }
}
</script>

<style scoped>

</style>