/*
 * @Author: your name
 * @Date: 2020-11-23 13:30:50
 * @LastEditTime: 2020-11-26 04:59:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \webapp\src\store\index.js
 */
import Vue from 'vue'
import Vuex from 'vuex'
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'
// import { ContextExclusionPlugin } from 'webpack'

Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    stompClient: null,
    ws: null,
    subscribes: {},
    outerCount: 0,
    messageData: {
      chats: [
        {
          type: 'build-in',
          name: '待处理提醒',
          icon: 'bell',
          background: '#f56a00',
          avatar: '',
          preview: '',
          lastest: '',
          unRead: 0,
          id: '1',
          data: [
            {'id': '192f01199d0c499', 'userId': '1606060960', 'receiverList': ['1606016550', '1606060960'], 'isToGroup': null, 'content': 'dada 结束了', 'url': '41d145f2941846c', 'time': '2020-11-26 01:34:10'}
          ]
        },
        {
          type: 'build-in',
          name: '通知公告',
          icon: 'user',
          background: '#1890ff',
          avatar: '',
          preview: '',
          lastest: '',
          unRead: 0,
          id: '0',
          data: [

          ]
        }
      ]
    }
  },
  mutations: {
    /**
     * @description:
     * @param {*} state
     * @param {*} config
      {
        'userId': '',
        'subscibes': [],
        'onmessage': f,
        'connectCallBack': f,
        'errorCallBack': f
      }
     * @return {*}
     */
    connect (state, config) {
      state.ws = new SockJS('/api/pigeon/sjs', null, {timeout: 15000})
      state.stompClient = Stomp.over(state.ws)
      state.stompClient.connect({}, (res) => {
        config.subscribes.forEach((item, i) => {
          console.log('in store:', item)
          state.subscribes[item] = state.stompClient.subscribe(item, config.onmessage)
        })
      }, config.errorCallBack)
    },
    addCount (state, amount) {
      state.outerCount += amount || 1
    },
    disconnect (state) {
      if (state.stompClient) {
        state.stompClient.disconnect()
        console.log('Disconnected')
      }
    },
    addMessage (state, msg) {
      state.messageData.chats[0].data.push(msg)
    },
    resetCount(state) {
      state.outerCount = 0
    },
    send (state) {

    }
  },
  actions: {
    connectFunc (context, config) {
      context.commit('connect', config)
    },
    disconnectFunc (context) {
      context.commit('disconnect')
    },
    addCountFunc (context, amount) {
      context.commit('addCount')
    },
    addMessageFunc (context, msg) {
      context.commit('addMessage', msg)
    },
    resetCountFunc(context) {
      context.commit('resetCount')
    }

  }
})

export default store
