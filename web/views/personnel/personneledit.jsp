<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑宿管</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">

    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
     style="padding: 20px 0 0 0;">
        <input type="hidden" name="personnelId" value="<%=request.getParameter("personnelId")%>">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="personnelName" value="<%=request.getParameter("personnelName")%>"
                       lay-verify="personnelName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="personnelAge" lay-verify="personnelAge" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("personnelAge")%>">
            </div>
        </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-inline">
            <input type="text" name="personnelPhone" lay-verify="personnelPhone" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("personnelPhone")%>">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-inline">
                <input type="text" name="personnelIdCard" lay-verify="personnelIdCard" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("personnelIdCard")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">家庭住址</label>
            <div class="layui-input-inline">
                <input type="text" name="personnelAddress" lay-verify="personnelAddress" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("personnelAddress")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责区域</label>
            <div class="layui-input-inline">
                <input type="text" name="personnelArea" lay-verify="personnelArea" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("personnelArea")%>">
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