import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL } from '@nuxt/ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _14487f38 = () => interopDefault(import('..\\pages\\about.vue' /* webpackChunkName: "pages/about" */))
const _5bf7781a = () => interopDefault(import('..\\pages\\lend\\index.vue' /* webpackChunkName: "pages/lend/index" */))
const _5d769778 = () => interopDefault(import('..\\pages\\user.vue' /* webpackChunkName: "pages/user" */))
const _3029e884 = () => interopDefault(import('..\\pages\\user\\index.vue' /* webpackChunkName: "pages/user/index" */))
const _29b2d6b2 = () => interopDefault(import('..\\pages\\user\\user1.vue' /* webpackChunkName: "pages/user/user1" */))
const _29c0ee33 = () => interopDefault(import('..\\pages\\user\\user2.vue' /* webpackChunkName: "pages/user/user2" */))
const _c14e8dfc = () => interopDefault(import('..\\pages\\lend\\_id.vue' /* webpackChunkName: "pages/lend/_id" */))
const _15939b29 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

// TODO: remove in Nuxt 3
const emptyFn = () => {}
const originalPush = Router.prototype.push
Router.prototype.push = function push (location, onComplete = emptyFn, onAbort) {
  return originalPush.call(this, location, onComplete, onAbort)
}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/about",
    component: _14487f38,
    name: "about"
  }, {
    path: "/lend",
    component: _5bf7781a,
    name: "lend"
  }, {
    path: "/user",
    component: _5d769778,
    children: [{
      path: "",
      component: _3029e884,
      name: "user"
    }, {
      path: "user1",
      component: _29b2d6b2,
      name: "user-user1"
    }, {
      path: "user2",
      component: _29c0ee33,
      name: "user-user2"
    }]
  }, {
    path: "/lend/:id",
    component: _c14e8dfc,
    name: "lend-id"
  }, {
    path: "/",
    component: _15939b29,
    name: "index"
  }],

  fallback: false
}

function decodeObj(obj) {
  for (const key in obj) {
    if (typeof obj[key] === 'string') {
      obj[key] = decodeURIComponent(obj[key])
    }
  }
}

export function createRouter () {
  const router = new Router(routerOptions)

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    const r = resolve(to, current, append)
    if (r && r.resolved && r.resolved.query) {
      decodeObj(r.resolved.query)
    }
    return r
  }

  return router
}
