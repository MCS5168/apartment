<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加学生</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">

    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
     style="padding: 20px 0 0 0;">
        <input type="hidden" name="studentNumber" value="<%=request.getParameter("studentNumber")%>">
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text" name="studentId" value="<%=request.getParameter("studentId")%>"
                       lay-verify="studentId" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="name" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("name")%>">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">选择性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="age" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("age")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" lay-verify="phone" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("phone")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寝室编号</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentId" lay-verify="apartmentId" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("aptId")%>">
            </div>
        </div>
        <div class="layui-form-item layui-hide">
            <button type="submit" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认"></button>
        </div>
</div>

<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/project3/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'upload'], function () {
        var $ = layui.$
            , form = layui.form
            , upload = layui.upload;

        upload.render({
            elem: '#layuiadmin-upload-useradmin'
            , url: layui.setter.base + 'json/upload/demo.js'
            , accept: 'images'
            , method: 'get'
            , acceptMime: 'image/*'
            , done: function (res) {
                $(this.item).prev("div").children("input").val(res.data.src)
            }
        });
    })
</script>
</body>
</html>