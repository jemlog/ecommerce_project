<template>
  <div>
  <RouterLink to="/signup">회원가입</RouterLink>
  <LoginForm></LoginForm>
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

