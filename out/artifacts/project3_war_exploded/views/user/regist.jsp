<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
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

        #PromptInformation {
            color: red;
        }
    </style>
    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
    <script type="text/javascript">
        $(function () {

            // 给验证码的图片，绑定单击事件
            $("#LAY-user-get-vercode").click(function () {
                // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
                // src属性表示验证码img标签的 图片路径。它可读，可写
                // alert(this.src);
                <%--this.src = "${basePath}kaptcha.jpg?d=" + new Date();--%>
                this.src = "http://localhost:8080/project3/kaptcha.jpg?d=" + new Date();
            });


            $("#registButton").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                var usernameText = $("#LAY-user-login-nickname").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#LAY-user-login-password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#LAY-user-login-repass").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#LAY-user-login-vercode").val();
                //去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

                $('#loginButton').click(function () {
                    $('.prompt_text').text('输入有误，请重新输入！');
                    $('.mask').removeClass('hide');
                })

            });


        });
    </script>
</head>
<body>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>注册</h2>
            <span class="errorMsg" id="PromptInformation">${requestScope.msg}</span>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body">
            <form action="http://localhost:8080/project3/UserServlet/regist" method="post">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                           for="LAY-user-login-nickname"></label>
                    <input type="text" name="userName" id="LAY-user-login-nickname" placeholder="昵称"
                           class="layui-input" value="${requestScope.username}">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                           for="LAY-user-login-password"></label>
                    <input type="password" name="userPassword" id="LAY-user-login-password" placeholder="密码"
                           class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                           for="LAY-user-login-repass"></label>
                    <input type="password" name="repass" id="LAY-user-login-repass" placeholder="确认密码"
                           class="layui-input">
                </div>

                <div class="layui-form-item">
                    <div class="layui-row">
                        <div class="layui-col-xs7">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode"
                                   for="LAY-user-login-vercode"></label>
                            <input type="text" name="vercode" id="LAY-user-login-vercode"
                                   placeholder="图形验证码" class="layui-input">
                        </div>
                        <div class="layui-col-xs5">
                            <div style="margin-left: 10px;">
                                <img src="http://localhost:8080/project3/kaptcha.jpg"
                                     class="layadmin-user-login-codeimg"
                                     id="LAY-user-get-vercode">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" type="submit" id="registButton">注 册</button>
                </div>
                <div class="layui-trans layui-form-item layadmin-user-login-other">
                    <button class="reset layadmin-link" type="reset">重置</button>
                    <a href="/project3/views/user/login.jsp"
                       class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>