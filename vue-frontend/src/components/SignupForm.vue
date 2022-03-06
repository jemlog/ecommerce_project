<!--<template>-->
<!--  <div>-->
<!--  <h1>signup page</h1>-->
<!--  <form v-on:submit="submitForm">-->
<!--    <div>-->
<!--      <label for="username">Username</label>-->
<!--      <input id="username" type="text" v-model="username">-->
<!--    </div>-->
<!--    <div>-->
<!--      <label for="nickname">Nickname</label>-->
<!--      <input id="nickname" type="text" v-model="nickname">-->
<!--    </div>-->
<!--    <div>-->
<!--      <label for="email">Email</label>-->
<!--      <input id="email" type="text" v-model="email">-->
<!--    </div>-->
<!--    <div>-->
<!--      <label for="password">Password</label>-->
<!--      <input id="password" type="password" v-model="password">-->
<!--    </div>-->
<!--    <div>-->
<!--      <button type="submit">입력 완료</button>-->
<!--    </div>-->
<!--  </form>-->
<!--    <router-link to="/login"><button>로그인 화면으로 이동</button></router-link>-->
<!--  </div>-->
<!--</template>-->
<template>
  <v-form v-on:submit="submitForm">

    <v-text-field
        v-model="username"
        label="Username"
        required
    ></v-text-field>
    <v-text-field
        v-model="nickname"
        label="Nickname"
        required
    ></v-text-field>
    <v-text-field
        v-model="email"
        label="E-mail"
        required
    ></v-text-field>
    <v-text-field
        v-model="password"
        label="Password"
        required
    ></v-text-field>

    <v-btn
        color="success"
        class="mr-4"
        type="submit"
    >
      제출
    </v-btn>

  </v-form>
</template>

<script>
import {registerUser} from "@/api/auth";

export default {
  name: "SignupForm",
  data : function ()
  {
    return {
      username : '',
      password : '',
      nickname : '',
      email : '',
    }
  },
  methods : {
    submitForm(event)
    {
      event.preventDefault();
      console.log('폼 제출');
      const userData = {
         username : this.username,
         password : this.password,
         nickname : this.nickname,
         email : this.email
      }
      registerUser(userData);
      this.initForm();
      this.$router.push('/login');
    },
    initForm(){
      this.username = '';
      this.password = '';
      this.nickname = '';
      this.email = '';
    }

  }
}
</script>

