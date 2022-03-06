<template>
  <div>
<!--  <RouterLink to="/signup">회원가입</RouterLink>-->
  <LoginForm></LoginForm>
    <router-link to="/signup"><button>아직 회원이 아니신가요?</button></router-link>
  </div>
</template>

<script>
import LoginForm from "@/components/LoginForm";
export default {
  name: "LoginPage",
  components : {
    LoginForm
  }
}
</script>

