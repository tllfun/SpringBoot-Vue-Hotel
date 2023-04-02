import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import * as ELIcons from '@element-plus/icons-vue'

const app = createApp(App);
app.use(store).use(router).use(ElementPlus).mount('#app')

//全局使用图标
for (let iconName in ELIcons) {
    app.component(iconName, ELIcons[iconName])
}
