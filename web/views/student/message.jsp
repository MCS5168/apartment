<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>学生信息</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <style>
        body {
            margin: 10px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }

        .layui-table {
            text-align: center;
        }

        .layui-table th {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="demoTable">
    搜索学号：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
<%--    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        version: '1605453739808' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider;//滑块

        table.render({
            elem: '#demo'
            // ,height: 420
            , cellMinWidth: 120
            , url: 'http://localhost:8080/project3/TestServlet'
            , toolbar: 'default'
            , title: '学生表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'number', title: 'ID', width: 90, sort: true, totalRow: true}
                , {field: 'id', title: '学号', width: 200, sort: true, totalRow: true}
                , {field: 'name', title: '姓名', width: 80}
                , {field: 'sex', title: '性别', width: 150}
                , {field: 'age', title: '年龄', width: 150, sort: true, totalRow: true}
                , {field: 'phone', title: '电话', width: 200}
                , {field: 'apartmentId', title: '寝室编号', width: 200, sort: true, totalRow: true}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
            , id: 'testReload'
            /*            , limit: 10
                        , limits: [12, 30, 60, 80, 100]*/
            , response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });

        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        // id: demoReload.val()
                        'studentId': demoReload.val()
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 2
                        , title: '添加用户'
                        , content: '/project3/views/student/userform.jsp'
                        , maxmin: true
                        , area: ['500px', '450px']
                        , btn: ['确定', '取消']
                        , yes: function (index, layero) {
                            var iframeWindow = window['layui-layer-iframe' + index]
                                , submitID = 'LAY-user-front-submit'
                                , submit = layero.find('iframe').contents().find('#' + submitID);

                            //监听提交
                            iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                                var field = data.field; //获取提交的字段
                                //提交 Ajax 成功后，静态更新表格中的数据
                                $.ajax({
                                    url: 'http://localhost:8080/project3/StudentServlet/addStudent',
                                    type: 'POST',
                                    data: {
                                        "studentId": field.studentId,
                                        "name": field.name,
                                        "sex": field.sex,
                                        "age": field.age,
                                        "phone": field.phone,
                                        "apartmentId": field.apartmentId
                                    },
                                    async: true
                                });
                                layer.msg("添加成功");
                                table.reload('LAY-user-front-submit'); //数据刷新
                                layer.close(index); //关闭弹层
                            });
                            submit.trigger('click');
                        }
                    });
                    break;
            }
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除' + data.number + '么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url: 'http://localhost:8080/project3/StudentServlet/delStudent?ID=' + data.number,
                        type: 'POST',
                        async: true,
                        success: function (data) {
                            obj.del(); //删除对应行（tr）的DOM结构
                            layer.close(index);
                            layer.msg("删除成功", {time: 3000});
                        },
                        error: function () {
                            layer.msg("删除失败", {time: 3000});
                        }
                    });
                });
            } else if (layEvent === 'edit') {
                layer.open({
                    type: 2
                    ,
                    title: '编辑用户'
                    ,
                    content: '/project3/views/student/studentform.jsp?studentNumber=' + data.number + '&studentId=' + data.id +
                        '&name=' + data.name + '&sex=' + data.sex + '&age=' + data.age + '&aptId=' + data.apartmentId +
                        '&phone=' + data.phone
                    ,
                    maxmin: true
                    ,
                    area: ['500px', '450px']
                    ,
                    btn: ['确定', '取消']
                    ,
                    yes: function (index, layero) {
                        var iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'LAY-user-front-submit'
                            , submit = layero.find('iframe').contents().find('#' + submitID);
                        //监听提交
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                            var field = data.field; //获取提交的字段
                            //提交 Ajax 成功后，静态更新表格中的数据
                            $.ajax({
                                url: 'http://localhost:8080/project3/StudentServlet/editStudent',
                                type: 'POST',
                                data: {
                                    "studentId": field.studentId,
                                    "name": field.name,
                                    "sex": field.sex,
                                    "age": field.age,
                                    "phone": field.phone,
                                    "apartmentId": field.apartmentId,
                                    "studentNumber": field.studentNumber
                                },
                                async: true
                            });
                            layer.msg("编辑成功");
                            table.reload('LAY-user-front-submit'); //数据刷新
                            layer.close(index); //关闭弹层
                        });
                        submit.trigger('click');
                    }
                });
            }
        });

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            , count: 100 //总页数
            , skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            , jump: function (obj, first) {
                if (!first) {
                    layer.msg('第' + obj.curr + '页', {offset: 'b'});
                }
            }
        });


    });
</script>
</body>
</html>