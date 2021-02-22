<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <link rel="stylesheet" href="/project3/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/project3/layuiadmin/style/admin.css" media="all">
</head>

<style type="text/css">
    #test-n1 {
        margin-left: 50px;
    }
</style>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">

        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    入住人数
                    <span class="layui-badge layui-bg-blue layuiadmin-badge">人</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">
                    <p class="layuiadmin-big-font">${requestScope.studentCount}</p>
                    <p>
                        学生总数
                        <span class="layuiadmin-span-color">1000 <i class="layui-inline layui-icon layui-icon-user"></i></span>
                    </p>
                </div>
            </div>
        </div>
        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    公寓数量
                    <span class="layui-badge layui-bg-cyan layuiadmin-badge">间</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">
                    <p class="layuiadmin-big-font">${requestScope.apartmentCount}</p>
                    <p>
                        尚未入住
                        <span class="layuiadmin-span-color">61 <i
                                class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                    </p>
                </div>
            </div>
        </div>
        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    维修上报
                    <span class="layui-badge layui-bg-green layuiadmin-badge">件</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">

                    <p class="layuiadmin-big-font">${requestScope.apartmentCount}</p>
                    <p>
                        尚未处理
                        <span class="layuiadmin-span-color">10 <i
                                class="layui-inline layui-icon layui-icon-flag"></i></span>
                    </p>
                </div>
            </div>
        </div>
        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    应缴费用
                    <span class="layui-badge layui-bg-orange layuiadmin-badge">元</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">

                    <p class="layuiadmin-big-font">66,666</p>
                    <p>
                        未缴用户
                        <span class="layuiadmin-span-color">61 <i
                                class="layui-inline layui-icon layui-icon-dollar"></i></span>
                    </p>
                </div>
            </div>
        </div>
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-header">
                    访问量
                </div>
                <div class="layui-card-body">
                    <div class="layui-row">
                        <div class="layui-col-sm8">
                            <div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade"
                                 lay-filter="LAY-index-pagetwo">
                                <div carousel-item id="LAY-index-pagetwo">
                                    <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="site-demo-laydate">
                            <div class="layui-inline" id="test-n1"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/project3/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/project3/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'sample']);

    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //直接嵌套显示
        laydate.render({
            elem: '#test-n1'
            , position: 'static'
        });
    });
</script>
</body>
</html>