<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<h2>Hello World!</h2></br>
<button type = "button" onclick = "one()">注册</button>
<script type="text/javascript">
    function one(){
        //location对象跳转
        location.href = "html/register.html";
    }
</script>

<button type = "button" onclick = "one()">登录</button>
<script type="text/javascript">
    function one(){
        //location对象跳转
        location.href = "html/login.html";
    }
</script>


</body>
</html>
