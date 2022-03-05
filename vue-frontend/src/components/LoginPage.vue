<template>
  <div class="login">
    <h2 class="comm__title">LOGIN</h2>
    <div class="ipt__box">
      <input type="text" class="ipt" placeholder="EMAIL" v-model="user.email">
    </div>
    <div class="ipt__box">
      <input type="password" class="ipt" placeholder="Password" v-model="user.password" @keyup.enter="login()">
    </div>
    <div class="ipt__btn">
      <a href="#" class="btn btn--confirm btn--large" v-on:click="login()">LOGIN</a>
    </div>
  </div>
</template>

<script>
export default  {
  data() {
    return {
      user : {
        email : '',
        password : ''
      }
    }
  },
  methods : {
    login : function () {
      if (this.user.email == '') {alert('아이디를 입력해주세요.');return;}
      if (this.user.password == '') {alert('비밀번호를 입력해주세요.');return;}
      this.$http.post('/auth/login', {email: this.user.email, password: this.user.password}).then((response) => {
          console.log(response);
          this.$router.push('/about'); //로그인 성공시 list 페이지로 이동
      });
    }
  },
  created () {
  }
}
</script>