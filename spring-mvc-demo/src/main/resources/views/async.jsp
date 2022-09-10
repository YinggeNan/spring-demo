<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html" http-equiv="Content-Type; charset=UTF-8">
    <title>servlet async support</title>
</head>
<body>
<div id="msgFromPush"></div>
<script type="text/javascript" src="assets/js/jquery-3.6.1.js"> </script>
<script type="text/javascript">
// 此处代码时使用jQuery的ajax请求,所以没有浏览器兼容性问题
deferred(); // 1.页面打开就向后台发送请求
function deferred(){
    $.get('defer', function (data){
        console.log(data); // 2.控制台输出服务器推送的数据
        deferred(); // 3.一次请求完成后再向后台发送请求
    })
}
</script>
</body>
</html>