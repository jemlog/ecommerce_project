<template>
  <form v-on:submit.prevent="signupUser">
    <div>
      <label for="username">Username</label>
      <input id="username" type="text" v-model="username">
    </div>
    <div>
    <label for="nickname">Nickname</label>
    <input id="nickname" type="text" v-model="nickname">
    </div>
    <div>
      <label for="email">Email</label>
      <input id="email" type="text" v-model="email">
    </div>
    <div>
      <label for="password">Password</label>
      <input id="password" type="password" v-model="password">
    </div>
    <div>
      <button type="submit">Signup</button>
    </div>
  </form>

</template>


<script>
import { registerUser } from '@/api/index';

export default {
  data : function ()
  {
    return {
      username : '',
      nickname : '',
      email : '',
      password : '',
    }
  },
      methods: {
  signupUser() {
    console.log('폼 제출');

    const userData = {
      username: this.username,
      nickname: this.nickname,
      email: this.email,
      password: this.password
    }
    registerUser(userData);
    this.initForm();
  },
        initForm() {
          this.username = '';
          this.password = '';
          this.nickname = '';
          this.email = '';
        }

},
}
</script>