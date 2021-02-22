<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的密码</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/project3/layuiadmin/style/admin.css" media="all">
    <%--<script src="/project3/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '/project3/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'set']);
    </script>--%>
    <style type="text/css">
        #PromptInformation {
            color: red;
        }
    </style>
    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#modifyButton").click(function () {
                var usernameText = $("#oldPassword").val();
                var usernamePatt = ${sessionScope.user.userPassword};
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("旧密码不合法！");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#LAY_password").val();
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
                var repwdText = $("#repassword").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

                /*$('#loginButton').click(function () {
                    $('.prompt_text').text('输入有误，请重新输入！');
                    $('.mask').removeClass('hide');
                })*/

            });
        });
    </script>

</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改密码</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form">
                        <form action="http://localhost:8080/project3/UserServlet/modifyPassword?username=${sessionScope.user.userName}&password=${sessionScope.user.userPassword}"
                              method="post">
                            <div>
                                <span class="errorMsg" id="PromptInformation">${requestScope.msg}</span>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">当前密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="oldPassword"
                                           class="layui-input" id="oldPassword">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="newpassword"
                                           autocomplete="off" id="LAY_password" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">确认新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="repassword"
                                           autocomplete="off" class="layui-input" id="repassword">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" type="submit" id="modifyButton">确认修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>