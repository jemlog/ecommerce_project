(function(e){function n(n){for(var r,u,a=n[0],i=n[1],s=n[2],f=0,d=[];f<a.length;f++)u=a[f],Object.prototype.hasOwnProperty.call(c,u)&&c[u]&&d.push(c[u][0]),c[u]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);l&&l(n);while(d.length)d.shift()();return o.push.apply(o,s||[]),t()}function t(){for(var e,n=0;n<o.length;n++){for(var t=o[n],r=!0,u=1;u<t.length;u++){var a=t[u];0!==c[a]&&(r=!1)}r&&(o.splice(n--,1),e=i(i.s=t[0]))}return e}var r={},u={app:0},c={app:0},o=[];function a(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-279fc9e2":"34367c86","chunk-58519cab":"6653aa65","chunk-77345aea":"095282cd","chunk-1e4964d6":"5d4d5efe","chunk-29737965":"0da44209","chunk-dbe730cc":"d34514a8","chunk-2d0aed93":"313df53e","chunk-2d222708":"e66ecd52"}[e]+".js"}function i(n){if(r[n])return r[n].exports;var t=r[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,i),t.l=!0,t.exports}i.e=function(e){var n=[],t={"chunk-279fc9e2":1,"chunk-58519cab":1,"chunk-77345aea":1,"chunk-1e4964d6":1,"chunk-29737965":1,"chunk-dbe730cc":1};u[e]?n.push(u[e]):0!==u[e]&&t[e]&&n.push(u[e]=new Promise((function(n,t){for(var r="css/"+({}[e]||e)+"."+{"chunk-279fc9e2":"d2eb8f6f","chunk-58519cab":"92895adc","chunk-77345aea":"37df9b61","chunk-1e4964d6":"3ca66f8d","chunk-29737965":"37f48d41","chunk-dbe730cc":"91b2ee86","chunk-2d0aed93":"31d6cfe0","chunk-2d222708":"31d6cfe0"}[e]+".css",c=i.p+r,o=document.getElementsByTagName("link"),a=0;a<o.length;a++){var s=o[a],f=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(f===r||f===c))return n()}var d=document.getElementsByTagName("style");for(a=0;a<d.length;a++){s=d[a],f=s.getAttribute("data-href");if(f===r||f===c)return n()}var l=document.createElement("link");l.rel="stylesheet",l.type="text/css",l.onload=n,l.onerror=function(n){var r=n&&n.target&&n.target.src||c,o=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=r,delete u[e],l.parentNode.removeChild(l),t(o)},l.href=c;var h=document.getElementsByTagName("head")[0];h.appendChild(l)})).then((function(){u[e]=0})));var r=c[e];if(0!==r)if(r)n.push(r[2]);else{var o=new Promise((function(n,t){r=c[e]=[n,t]}));n.push(r[2]=o);var s,f=document.createElement("script");f.charset="utf-8",f.timeout=120,i.nc&&f.setAttribute("nonce",i.nc),f.src=a(e);var d=new Error;s=function(n){f.onerror=f.onload=null,clearTimeout(l);var t=c[e];if(0!==t){if(t){var r=n&&("load"===n.type?"missing":n.type),u=n&&n.target&&n.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+u+")",d.name="ChunkLoadError",d.type=r,d.request=u,t[1](d)}c[e]=void 0}};var l=setTimeout((function(){s({type:"timeout",target:f})}),12e4);f.onerror=f.onload=s,document.head.appendChild(f)}return Promise.all(n)},i.m=e,i.c=r,i.d=function(e,n,t){i.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,n){if(1&n&&(e=i(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(i.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var r in e)i.d(t,r,function(n){return e[n]}.bind(null,r));return t},i.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(n,"a",n),n},i.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],f=s.push.bind(s);s.push=n,s=s.slice();for(var d=0;d<s.length;d++)n(s[d]);var l=f;o.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("56d7")},"365c":function(e,n,t){"use strict";t.d(n,"a",(function(){return s})),t.d(n,"b",(function(){return f}));var r=t("bc3a"),u=t.n(r),c=(t("d3b7"),t("4360"));function o(e){return e.interceptors.request.use((function(e){return e.headers.Authorization=c["a"].state.token,e}),(function(e){return Promise.reject(e)})),e.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),e}function a(){return u.a.create({})}function i(e){var n=u.a.create({baseURL:"".concat(e)});return o(n)}var s=a(),f=i("items")},3786:function(e,n,t){"use strict";t.d(n,"b",(function(){return u})),t.d(n,"a",(function(){return c}));var r=t("365c");function u(e){return r["a"].post("api/signup",e)}function c(e){return r["a"].post("api/authenticate",e)}},4360:function(e,n,t){"use strict";var r=t("1da1"),u=(t("96cf"),t("2b0e")),c=t("2f62"),o=t("f3e4"),a=t("3786"),i=t("5892");u["a"].use(c["a"]),n["a"]=new c["a"].Store({state:{username:Object(o["c"])()||"",token:Object(o["b"])()||"",itemData:[]},getters:{isLogin:function(e){return""!=e.username}},mutations:{setUsername:function(e,n){e.username=n},setToken:function(e,n){e.token=n},clearUsername:function(e){e.username=""},clearToken:function(e){e.token=""},setItemData:function(e,n){e.itemData=n}},actions:{LOGIN:function(e,n){return Object(r["a"])(regeneratorRuntime.mark((function t(){var r,u,c;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=e.commit,t.next=3,Object(a["a"])(n);case 3:return u=t.sent,c=u.data,r("setToken","Bearer "+c.token),r("setUsername",c.username),Object(o["d"])("Bearer "+c.token),Object(o["e"])(c.username),t.abrupt("return",c);case 10:case"end":return t.stop()}}),t)})))()},GETDATA:function(e){return Object(r["a"])(regeneratorRuntime.mark((function n(){var t,r,u;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return t=e.commit,n.next=3,Object(i["c"])();case 3:return r=n.sent,u=r.data,t("setItemData",u),n.abrupt("return",u);case 7:case"end":return n.stop()}}),n)})))()}}})},"56d7":function(e,n,t){"use strict";t.r(n);t("e260"),t("e6cf"),t("cca6"),t("a79d");var r=t("2b0e"),u=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("v-app",[t("router-view")],1)},c=[],o={},a=o,i=t("2877"),s=t("6544"),f=t.n(s),d=t("7496"),l=Object(i["a"])(a,u,c,!1,null,null,null),h=l.exports;f()(l,{VApp:d["a"]});t("d3b7"),t("3ca3"),t("ddb0");var p=t("8c4f"),m=t("4360");r["a"].use(p["a"]);var b=new p["a"]({routes:[{path:"/",redirect:"/login"},{path:"/order/:id",component:function(){return t.e("chunk-2d222708").then(t.bind(null,"cf2a"))}},{path:"/login",component:function(){return Promise.all([t.e("chunk-279fc9e2"),t.e("chunk-77345aea"),t.e("chunk-1e4964d6")]).then(t.bind(null,"48ca"))}},{path:"/addItems",component:function(){return Promise.all([t.e("chunk-279fc9e2"),t.e("chunk-77345aea"),t.e("chunk-dbe730cc")]).then(t.bind(null,"15d2"))}},{path:"/signup",component:function(){return Promise.all([t.e("chunk-279fc9e2"),t.e("chunk-77345aea"),t.e("chunk-29737965")]).then(t.bind(null,"560f"))}},{path:"/main",component:function(){return Promise.all([t.e("chunk-279fc9e2"),t.e("chunk-58519cab")]).then(t.bind(null,"4385"))},meta:{auth:!0}},{path:"*",component:function(){return t.e("chunk-2d0aed93").then(t.bind(null,"0c8b"))}}]});b.beforeEach((function(e,n,t){if(e.meta.auth&&!m["a"].getters.isLogin)return console.log("인증이 필요합니다"),void t("/login");t()}));var k=b,v=t("f309");r["a"].use(v["a"]);var g=new v["a"]({});r["a"].config.productionTip=!1,new r["a"]({router:k,store:m["a"],vuetify:g,render:function(e){return e(h)}}).$mount("#app")},5892:function(e,n,t){"use strict";t.d(n,"c",(function(){return u})),t.d(n,"a",(function(){return c})),t.d(n,"b",(function(){return o}));var r=t("365c");function u(){return r["b"].get("/")}function c(e){return r["b"].post("/",e)}function o(e){return r["b"].delete("/".concat(e))}},f3e4:function(e,n,t){"use strict";t.d(n,"d",(function(){return r})),t.d(n,"e",(function(){return u})),t.d(n,"b",(function(){return c})),t.d(n,"c",(function(){return o})),t.d(n,"a",(function(){return a}));t("ac1f"),t("5319");function r(e){document.cookie="auth=".concat(e)}function u(e){document.cookie="user=".concat(e)}function c(){return document.cookie.replace(/(?:(?:^|.*;\s*)auth\s*=\s*([^;]*).*$)|^.*$/,"$1")}function o(){return document.cookie.replace(/(?:(?:^|.*;\s*)user\s*=\s*([^;]*).*$)|^.*$/,"$1")}function a(e){document.cookie="".concat(e,"=; expires=Thu, 01 Jan 1970 00:00:01 GMT;")}}});
//# sourceMappingURL=app.6bcde865.js.map