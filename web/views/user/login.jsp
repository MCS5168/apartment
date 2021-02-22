<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/project3/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="/project3/layuiadmin/style/login.css" media="all">
    <style type="text/css">
        body {
            background: url(/project3/views/images/395265.jpg) no-repeat center center fixed;
            /*兼容浏览器版本*/
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>登录</h2>
            <span class="errorMsg">
                ${ empty requestScope.msg ? "请输入用户名和密码":requestScope.msg }
            </span>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <form action="http://localhost:8080/project3/UserServlet/login" method="post">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                           for="LAY-user-login-username"></label>
                    <input type="text" name="userName" id="LAY-user-login-username" placeholder="用户名"
                           class="layui-input" value="${requestScope.username}">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                           for="LAY-user-login-password"></label>
                    <input type="password" name="userPassword" id="LAY-user-login-password"
                           placeholder="密码" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" id="loginButton" type="submit">登 入</button>
                </div>
                <div class="layui-trans layui-form-item layadmin-user-login-other">
                    <button class="reset layadmin-link" type="reset">重置</button>
                    <a href="/project3/views/user/regist.jsp" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>