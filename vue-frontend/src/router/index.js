import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login',
  }
    ,
  {
    path: '/login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginPage.vue')
  },
  {
    path: '/signup',
    component: () => import(/* webpackChunkName: "about" */ '../views/SignupPage.vue')
  }
  ,
  {
    path: '*',
    component: () => import(/* webpackChunkName: "about" */ '../views/NotFoundPage.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(function (to,from,next){

  if(to.matched.some(function (routeInfo){
    return routeInfo.meta.authRequired;
  })){
    alert('login Please!');
  }else
  {
    console.log("routing success : '" + to.path + "'");
    next();
  }

});

export default router
