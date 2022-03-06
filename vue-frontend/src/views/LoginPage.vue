<template>
  <div class="loginSector">
  <div class="loginForm">
<!--  <RouterLink to="/signup">회원가입</RouterLink>-->
  <LoginForm></LoginForm>
    <router-link to="/signup"><v-btn color="info" class="signup">아직 회원이 아니신가요?</v-btn></router-link>
  </div>
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

<style>
.loginSector{
  margin: auto;
  padding: 45px;
  background-color: #f1f3f5;
}
.loginForm {
   width: 400px;
   margin: auto;
   padding: 30px;
   background-color: white;
  box-shadow: 2px 5px 15px 1px  #ced4da;

}
.signup{
  margin-top: 10px;
}
</style>
