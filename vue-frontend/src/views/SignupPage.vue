<template>
  <div class="signupSector">
    <p class="signupletter">Signup</p>
    <div class="signupForm">
      <SignupForm></SignupForm>
    </div>
  </div>

</template>

<script>
import SignupForm from "@/components/SignupForm";
export default {
  name: "SignupPage",
  components : {
    SignupForm
  }
}
</script>

<style>
.signupSector{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: auto;
  padding: 20px 35px 20px 35px;
  background-color: #f1f3f5;
}
.signupForm {
  width: 400px;
  margin: auto;
  padding: 40px;
  background-color: white;
  box-shadow: 2px 5px 15px 1px  #ced4da;

}
.signupletter{
  text-align: center;
  font-size: 2rem;
  font-family: 'Heebo', sans-serif;
}
</style>