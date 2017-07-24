# js 目录结构说明

本目录用于存储项目的 JavaScript 执行文件

注意文件顺序，所有的 js 文件都依赖 `jquery.js`

* base/app.js 项目主要基础公共脚本
* change-password.js 修改密码页面脚本
* pages/index.js 首页脚本
* pages/reporting-tasks.js 上报任务脚本
* pages/role-management.js 角色管理脚本
* pages/tasks-processing.js 任务处理脚本
* pages/user-management.js 用户管理脚本
* lib/bootstrap.min.js 基础组件脚本
* lib/datepicker-zh-CN.js
* lib/icheck.min.js 复选框&单选框脚本
* lib/jquery.flot.categories.js 绘图脚本
* lib/jquery.flot.js 绘图脚本
* lib/jquery.flot.resize.js 绘图脚本
* lib/jquery.js 基础脚本
* lib/jquery.slimscroll.js 滚动条脚本
* lib/jquery-ui.min.js 基础开源脚本
* lib/nprogress.js 进度条脚本
* lib/require.js 管理、加载脚本

**`change-password.js`，`index.js`，`login.js` 全部依赖 `app.js` **