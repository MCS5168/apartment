<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加记录</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
    <script src="/project3/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '/project3/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'form', 'upload', 'laydate'], function () {
            var $ = layui.$
                , form = layui.form
                , upload = layui.upload
                , laydate = layui.laydate;

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
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
     style="padding: 20px 0 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <div class="layui-input-inline">
            <input type="text" name="studentId" lay-verify="studentId" placeholder="请输入学号" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="studentName" lay-verify="studentName" placeholder="请输入姓名"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <%--<div class="layui-form-item">
        <label class="layui-form-label">日期</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDate" lay-verify="disciplineDate" placeholder="请选择日期"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">选择日期</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDate" lay-verify="disciplineDate" class="layui-input" id="test-laydate-type-datetime" >
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">详情</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineDetail" lay-verify="disciplineDetail" placeholder="请输入详情"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">经办人</label>
        <div class="layui-input-inline">
            <input type="text" name="disciplineAgent" lay-verify="disciplineAgent" placeholder="请选择经办人"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
</div>
</body>
</html>