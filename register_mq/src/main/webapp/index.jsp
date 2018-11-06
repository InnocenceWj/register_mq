<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
</head>
<style>
    input, button {
        width: 380px;
        height: 45px;
        margin-left: 65px;
        margin-right: 8px;
        margin-top: 20px;
        border-radius: 10px; /*圆角矩形*/
        text-indent: 10px; /*里面隐形的字体首行缩进*/
    }

    body {
        margin: 0px;
        padding: 0px;
        height: 180px;
        background-image: url("/static/img/login.jpg"); /*背景图片*/
        background-size: 100% 100%; /*图片自由伸缩*/
    }

    form {
        border-radius: 5px; /*圆角矩形*/
        margin: 200px 600px;
        width: 550px;
        height: 480px;
        background-color: azure;
        opacity: 0.7;
    }

    a {
        margin: 15px 30px;
        text-decoration: none; /*去掉下划线*/
        color: #808080;
        font-family: '黑体';
        font-size: 14px;
    }

    .errorInfo {
        padding: 5px 6px;
        color: #fff;
        background: red;
        font-size: 6px;
        opacity: 0.8;
    }
</style>
<body>
<form action="register/registerUser" onsubmit="return check1()" method="post">
    <input type="text" placeholder="请输入用户名" maxlength="12" name="uName" id="uName"><label id="uName-label"
                                                                                          class="errorInfo"
                                                                                          style="display: none"></label><br/>
    <input type="password" placeholder="请输入密码" maxlength="16" name="uPwd" id="uPwd"><label id="uPwd-label"
                                                                                           class="errorInfo"
                                                                                           style="display: none"></label><br/>
    <input type="password" placeholder="请确认密码" maxlength="16" name="confirmPwd" id="confirmPwd"><label id="confirmPwd-label"
                                                                                            class="errorInfo"
                                                                                                       style="display: none"></label><br/>
    <input type="text" placeholder="请输入电话号码" maxlength="11" name="uPhone" id="uPhone"><label id="uPhone-label"
                                                                                             class="errorInfo"
                                                                                             style="display: none"></label><br/>
    <input type="text" placeholder="请输入邮箱" name="uMail" id="uMail"><label id="uMail-label"
                                                                          class="errorInfo"
                                                                          style="display: none"></label><br/>
    <input type="submit" value="注册"/>
</form>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<%--注意：<script src="/resources/script/seckill.js" type="text/javascript"></script>
不能写成
<script src="/resources/script/seckill.js" type="text/javascript"/>,否则js加载不出来，至于为什么还没查到
/resources/script/seckill.js 在webapp下
--%>
<script src="static/js/check.js"></script>
<script>
    $(function () {
        $("input").click(function () {
            $(".errorInfo").hide();
        })
    });

    function check1() {
        var uName = $("#uName").val();
        var uPwd = $("#uPwd").val();
        var confirmPwd = $("#confirmPwd").val();
        var uPhone = $("#uPhone").val();
        var uMail = $("#uMail").val();
        return check.verify(uName, uPwd, confirmPwd, uPhone, uMail);
    }
</script>
</html>
