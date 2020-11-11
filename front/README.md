<!--
 * @Date: 2020-11-11 09:49:16
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-11 10:01:44
-->
# Frontend Project Description

需要先配置好node环境、npm， 安装好cnpm之后才能进行下面的操作

## Configuration
1. 安装webpack
`cnpm install webpack webpack-cli -g`
> 验证安装:
> `webpack -v`
> ```
> PS E:\Programs\software03\front> webpack -v
> 
> webpack-cli 4.2.0
> 
> webpack 5.4.0   
> ```
2. 安装vue-cli
`cnpm install vue-cli -g`
> 验证安装(注意大写)
> `vue -V`
> ```
> PS E:\Programs\software03\front> vue -V
> 2.9.6
> ```
3. 项目构建过程:
`vue init webpack ${your_project_name}`

```
PS E:\Programs\software03\front> vue init webpack webapp

? Project name webapp
? Project description Frontend of Main Project
? Author JecosineMoc <mj_ol@outlook.com>
? Vue build standalone      
? Install vue-router? Yes
? Use ESLint to lint your code? Yes
? Pick an ESLint preset Standard
? Set up unit tests No
? Setup e2e tests with Nightwatch? No
? Should we run `npm install` for you after the project has been created? (recommended) no

   vue-cli · Generated "webapp".

# Project initialization finished!
# ========================

To get started:

  cd webapp
  npm install (or if using yarn: yarn)
  npm run lint -- --fix (or for yarn: yarn run lint --fix)
  npm run dev

Documentation can be found at https://vuejs-templates.github.io/webpack
```
执行
`cnpm install`
`cnpm run lint -- --fix`
## Structure
```
├─.vscode
└─webapp
    ├─build
    ├─config
    ├─src
    │  ├─assets
    │  ├─components
    │  └─router
    └─static
```