<template>
  <div>
  <h1>loginform</h1>
  <form v-on:submit="submitForm">
    <div>
      <label for="email">Email</label>
      <input id="email" type="text" v-model="email">
    </div>
    <div>
      <label for="password">Password</label>
      <input id="password" type="password" v-model="password">
    </div>
    <div>
      <button type="submit">Login</button>
    </div>
  </form>
  </div>
</template>
<script>


export default {

  name: "LoginForm",
  data : function (){
    return {
      email : '',
      password : ''
    }
  },
  methods : {
    async submitForm(event){
      event.preventDefault();
      const userData = {
        email : this.email,
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

