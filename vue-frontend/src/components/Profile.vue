<template>
<ul>
  <li>사용자 등급 : {{userData.grade}}</li>
  <li>총 구매 가격 : {{userData.totalPriceForGrade}}</li>
</ul>
</template>

<script>
import {getProfile} from "@/api/auth";

export default {
  name: "Profile",
  props : ['userInfo'],
  data : function ()
  {
    return {
      userInfomation : this.userInfo,
      userData : ''
    }
  },
  async created() {
    const {data} = await getProfile(this.userInfomation)
    console.log(data)
    this.userData = data;
  }
}
</script>

<style scoped>

</style>