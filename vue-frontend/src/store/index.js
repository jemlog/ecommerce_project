import Vue from 'vue'
import Vuex from 'vuex'
import {getAuthFromCookie, getUserFromCookie, saveAuthToCookie, saveUserToCookie} from "@/utils/cookie";
import {loginUser} from "@/api/auth";

Vue.use(Vuex); // vue의 플러그인 가능
               // 전역에서 기능을 사용하고 싶을때

export default new Vuex.Store({
    state : {
        username : getUserFromCookie() || '',
        token : getAuthFromCookie() || ''
    },
    getters : {
      isLogin(state)
      {
          return state.username != '';
      }
    },
    mutations : {
        setUsername(state,username)
        {
            state.username = username;
        },
        setToken(state,token)
        {
            state.token = token;
        }
    },
    actions : {
        async LOGIN({commit},userData)
        {
            const {data} = await loginUser(userData);
            commit('setToken',data.token);
            commit('setUsername',data.username);
            saveAuthToCookie(data.token);
            saveUserToCookie(data.username);
            return data;
        }
    }
});