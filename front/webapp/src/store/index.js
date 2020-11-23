import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    ws: {}
  },
  mutations: {
    openWebSocket (state, config) {
      state.ws = new WebSocket(config.url)
      state.ws.onopen = config.onOpenHandler
      state.ws.onclose = config.onCloseHandler
      state.ws.onerror = config.onErrorHandler
      state.ws.onmessage = config.onMessageHandler
    },
    setWebSocketHandler (state, onOpenHandler, onCloseHandler, onMessageHandler, onErrorHandler) {
      state.ws.onopen = onOpenHandler
      state.ws.onclose = onCloseHandler
      state.ws.onerror = onErrorHandler
      state.ws.onmessage = onMessageHandler
    }
  },
  actions: {
    openWebSocketFunction (context, config) {
      context.commit('openWebSocket', config)
    },
    setWebSocketHandlerFunction (context, onOpenHandler, onCloseHandler, onMessageHandler, onErrorHandler) {
      context.commit('setWebSocketHandler', onOpenHandler, onCloseHandler, onMessageHandler, onErrorHandler)
    }
  }
})

export default store
