import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '@/store/index';
Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    {
      path: '/',
      redirect : '/login'
    },
    {
      path: '/orderList',
      component : () => import('@/views/OrderListPage.vue'),
      meta: { auth: true },
    },
    {
      path : '/order/:id',
      name : 'Order',
      component : () => import('@/views/OrderPage.vue'),
      props : true,
      meta: { auth: true },
    },
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/addItems',
      component : () => import('@/views/AddItems')
    },
    {
      path: '/signup',
      component: () => import('@/views/SignupPage.vue'),
    },
    {
      path: '/main',
      component: () => import('@/views/MainPage.vue'),
      meta: { auth: true },
    },
    {
      path: '*',
      component: () => import('@/views/NotFoundPage.vue'),
    },
  ],
});

router.beforeEach((to, from, next) => {
  if (to.meta.auth && !store.getters.isLogin) {
    console.log('인증이 필요합니다');
    next('/login');
    return;
  }
  next();
});

export default router;