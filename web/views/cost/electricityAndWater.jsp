<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>水电费</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <%--    <link rel="stylesheet" href="/project3/layuiadmin/style/admin.css" media="all">--%>
    <style type="text/css">
        body {
            margin: 10px;
        }

        .layui-elem-quote {
            font-size: 20px;
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
<blockquote class="layui-elem-quote">本月水电费汇总</blockquote>

<div id="main" style="width: 1320px;height:500px;"></div>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="test-table-switchTpl">
    <input type="checkbox" name="sex" lay-skin="switch" lay-text="是|否" lay-filter="test-table-sexDemo"
           value="{{ d.id }}" data-json="{{ encodeURIComponent(JSON.stringify(d)) }}" {{ d.id== 10003
           ? 'checked' : '' }}>
</script>

<script type="text/javascript" src="/project3/layuiadmin/json/jquery.js"></script>
<script src="/project3/layuiadmin/json/echarts.min.js"></script>
<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/project3/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'element', 'echarts', 'table', 'form', 'laydate', 'laypage'], function () {


        var element = layui.element
            , $ = layui.jquery
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , laydate = layui.laydate
            , echarts = layui.echarts;

        var myChart = echarts.init(document.getElementById('main'));

        var list1 = [];
        var list2 = [];
        var list3 = [];

        // 同步执行
        $.ajaxSettings.async = false;

        // 加载数据
        $.getJSON('http://localhost:8080/project3/CostServlet/disciplineMessage2', function (json) {
            list1 = json.xAxisArr;
            list2 = json.waterRateArr;
            list3 = json.electricChargeArr;
        });

        myChart.setOption({
            title: {
                text: ''
            },
            tooltip: {},

            legend: {
                data: ['水费', '电费']
            },
            xAxis: {
                data: list1,
            },
            yAxis: {type: 'value'},
            series: [{
                name: '水费',
                type: 'bar',
                data: list2,
                itemStyle: {
                    normal: {
                        color: '#6c6dff'
                    }
                },
            },
                {
                    name: '电费',
                    type: 'bar',
                    data: list3,
                    itemStyle: {
                        normal: {
                            color: '#ff755f'
                        }
                    }
                }]
        });

        table.render({
            elem: '#demo'
            // ,height: 420
            , cellMinWidth: 120
            , url: 'http://localhost:8080/project3/CostServlet/costMessage'
            , title: '水电费'
            , cols: [[
                {
                    fixed: 'paymentTime',
                    title: '缴费时间',
                    width: 180,
                    templet: '<div>{{ layui.util.toDateString(d.createDate, "yyyy-MM-dd") }}</div>'
                }
                , {field: 'apartmentId', title: 'ID', width: 100, sort: true, totalRow: true}
                , {field: 'apartmentName', title: '寝室名', width: 150, sort: true, totalRow: true}
                , {field: 'waterRate', title: '水费', width: 100}
                , {field: 'electricCharge', title: '电费', width: 100}
                , {field: 'agent', title: '经办人', width: 150}

                , {field: 'whetherPay', title: '是否缴纳', width: 150, templet: '#test-table-switchTpl', unresize: true}
            ]]
            , page: true
            , response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });

        //监听操作
        form.on('switch(test-table-sexDemo)', function (obj) {
            var json = JSON.parse(decodeURIComponent($(this).data('json')));
            layer.tips(this.value + ' ' + this.name + '：' + obj.elem.checked, obj.othis);

            json = table.clearCacheKey(json);
            console.log(json); //当前行数据
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