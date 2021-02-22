<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑寝室</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">

    <script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
     style="padding: 20px 0 0 0;">
        <input type="hidden" name="apartmentId" value="<%=request.getParameter("apartmentId")%>">
        <div class="layui-form-item">
            <label class="layui-form-label">寝室名</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentName" value="<%=request.getParameter("apartmentName")%>"
                       lay-verify="apartmentName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寝室规格</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentSize" lay-verify="apartmentSize" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("apartmentSize")%>">
            </div>
        </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收费标准</label>
        <div class="layui-input-inline">
            <input type="text" name="apartmentCharge" lay-verify="apartmentCharge" autocomplete="off"
                   class="layui-input" value="<%=request.getParameter("apartmentCharge")%>">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">管理员</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentManager" lay-verify="apartmentManager" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("apartmentManager")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentNote" lay-verify="apartmentNote" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("apartmentNote")%>">
            </div>
        </div>
        <%--<div class="layui-form-item">
            <label class="layui-form-label">寝室编号</label>
            <div class="layui-input-inline">
                <input type="text" name="apartmentId" lay-verify="apartmentId" autocomplete="off"
                       class="layui-input" value="<%=request.getParameter("aptId")%>">
            </div>
        </div>--%>
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