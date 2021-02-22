<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑信息</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">

    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
     style="padding: 20px 0 0 0;">
    <input type="hidden" name="disciplineId" value="<%=request.getParameter("disciplineId")%>">
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
            <input type="text" name="studentName" lay-verify="studentName" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("studentName")%>">
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">日期</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDate" lay-verify="disciplineDate" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("disciplineDate")%>">
        </div>
    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">请选择时间</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDate" lay-verify="disciplineDate" autocomplete="off"
                   class="layui-input" id="test-laydate-type-datetime"
                   value="<%=request.getParameter("disciplineDate")%>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">详细信息</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDetail" lay-verify="disciplineDetail" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("disciplineDetail")%>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">经办人</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineAgent" lay-verify="disciplineAgent" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("disciplineAgent")%>">
        </div>
    </div>

    <div class="layui-form-item layui-hide">
        <button type="submit" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit"
                value="确认"></button>
    </div>
</div>

<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/project3/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'upload', 'laydate'], function () {
        var $ = layui.$
            , form = layui.form
            , upload = layui.upload;
        var laydate = layui.laydate;

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

        //日期时间选择器
        laydate.render({
            elem: '#test-laydate-type-datetime'
            , trigger:'click'
            , type: 'date'
        });
    })
</script>
</body>
</html>