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
    搜索员工名：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>

<table class="layui-hide" id="test-table-demoEvent" lay-filter="test-table-demoEvent"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        version: '1605453739808',//为了更新 js 缓存，可忽略
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
            elem: '#test-table-demoEvent'
            // ,height: 420
            , cellMinWidth: 120
            , url: 'http://localhost:8080/project3/DisciplineServlet/disciplineMessage'
            , toolbar: 'default'
            , title: '学生表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'disciplineId', title: 'ID', width: 70, sort: true, totalRow: true}
                , {field: 'studentId', title: '值日生学号', width: 150, sort: true, totalRow: true}
                , {field: 'studentName', title: '值日生姓名', width: 100}
                , {
                    field: 'disciplineDate',
                    title: '日期',
                    // templet: '<div>{{ layui.util.toDateString(d.createDate, "yyyy-MM-dd") }}</div>',
                    width: 180
                }
                , {field: 'disciplineDetail', title: '详情', width: 250}
                , {field: 'disciplineAgent', title: '经办人', width: 150}
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
            , id: 'testReload'
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
                        'disciplineId': demoReload.val()
                    }
                }, 'data');
            }
        };
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听头工具栏事件
        table.on('toolbar(test-table-demoEvent)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 2
                        , title: '添加寝室'
                        , content: '/project3/views/discipline/disciplineform.jsp'
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
                                    url: 'http://localhost:8080/project3/DisciplineServlet/addDiscipline',
                                    type: 'POST',
                                    data: {
                                        "disciplineId": field.disciplineId,
                                        "studentId": field.studentId,
                                        "studentName": field.studentName,
                                        "disciplineDate": field.disciplineDate,
                                        "disciplineDetail": field.disciplineDetail,
                                        "disciplineAgent": field.disciplineAgent
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
        table.on('tool(test-table-demoEvent)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除' + data.personnelName + '么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url: 'http://localhost:8080/project3/DisciplineServlet/delDiscipline?ID=' + data.disciplineId,
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
                    content: '/project3/views/discipline/disciplineedit.jsp?disciplineId=' + data.disciplineId + '&studentId=' + data.studentId +
                        '&studentName=' + data.studentName + '&disciplineDate=' + data.disciplineDate + '&disciplineDetail=' + data.disciplineDetail +
                        '&disciplineAgent=' + data.disciplineAgent
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
                                url: 'http://localhost:8080/project3/DisciplineServlet/editDiscipline',
                                type: 'POST',
                                data: {
                                    "disciplineId": field.disciplineId,
                                    "studentId": field.studentId,
                                    "studentName": field.studentName,
                                    "disciplineDate": field.disciplineDate,
                                    "disciplineDetail": field.disciplineDetail,
                                    "disciplineAgent": field.disciplineAgent
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