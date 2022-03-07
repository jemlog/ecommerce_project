<!--<template>-->
<!--  <div>-->
<!--  <h1>loginform</h1>-->
<!--  <form v-on:submit="submitForm">-->
<!--    <div>-->
<!--      <label for="email">Email</label>-->
<!--      <input id="email" type="text" v-model="email">-->
<!--    </div>-->
<!--    <div>-->
<!--      <label for="password">Password</label>-->
<!--      <input id="password" type="password" v-model="password">-->
<!--    </div>-->
<!--    <div>-->
<!--      <v-btn color="success" type="submit">로그인</v-btn>-->
<!--    </div>-->
<!--  </form>-->
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
        v-model="password"
        label="Password"
        required
    ></v-text-field>

    <v-btn
        color="success"
        class="mr-4"
        type="submit"
    >
      Login
    </v-btn>

  </v-form>
</template>
<script>


export default {

  name: "LoginForm",
  data : function (){
    return {
      username : '',
      password : ''
    }
  },
  methods : {
    async submitForm(event){
      event.preventDefault();
      const userData = {
        username : this.username,
        password : this.password
      }
     // const {data} = await loginUser(userData);
     // this.$store.commit('setToken',data.token);
     // this.$store.commit('setUsername',data.user.username);
     // saveAuthToCookie(data.token);
     // saveUserToCookie(data.user.username);
      await this.$store.dispatch('LOGIN',userData);
      this.$router.push('/main');
    }
  }
}
</script>

<style>

</style>

