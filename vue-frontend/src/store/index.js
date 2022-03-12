import Vue from 'vue'
import Vuex from 'vuex'
import {
    getAuthFromCookie,
    getUserFromCookie,
    getUserIdFromCookie,
    saveAuthToCookie,
    saveUserToCookie
} from "@/utils/cookie";
import {loginUser} from "@/api/auth";
import {fetchPosts} from "@/api/posts";

Vue.use(Vuex); // vue의 플러그인 가능
               // 전역에서 기능을 사용하고 싶을때

export default new Vuex.Store({
    state : {
        username : getUserFromCookie() || '',
        userId : getUserIdFromCookie() || '',
        token : getAuthFromCookie() || '',
        itemData : []
    },
    getters : {
      isLogin(state)
      {
          return state.username != '';
      }
    },
    mutations : {
        setUsername(state, username) {
            state.username = username;
        },
        setUserId(state,userId)
        {
            state.userId = userId;
        },
        setToken(state, token) {
            state.token = token;
        },
        clearUsername(state) {
            state.username = '';
        },
        clearToken(state) {
            state.token = '';
        },
        clearUserId(state)
        {
            state.userId = '';
        }
        ,
        setItemData(state, data) {
            state.itemData = data;
        }

    }
    ,
    actions : {
        async LOGIN({commit},userData)
        {
            const {data} = await loginUser(userData);
            commit('setToken',"Bearer " + data.token);
            commit('setUsername',data.username);
            saveAuthToCookie("Bearer "+ data.token);
            saveUserToCookie(data.username,data.userId);
            return data;
        },

        async GETDATA({commit})
        {
            const {data} = await fetchPosts();
            commit("setItemData",data);
            return data;

        }
    }
});