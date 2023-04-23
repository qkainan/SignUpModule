<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作成功</title>
</head>
<body>
    <h2>操作成功</h2>

    <button type = "button" onclick = "one()">返回主页</button>
    <script type="text/javascript">
        function one(){
            //location对象跳转
            location.href = "index.jsp";
        }
    </script>
</body>
</html>
