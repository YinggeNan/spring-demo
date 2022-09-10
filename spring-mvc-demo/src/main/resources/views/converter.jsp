<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html" http-equiv="Content-Type; charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="application/x-wisely请求"/>
<input type="button" onclick="req_other();" value="其他请求"/>
<script type="text/javascript" src="assets/js/jquery-3.6.1.js"></script>
<script>
    function req(){
        $.ajax({
            url: "convert",
            data: "1-wangyunfei", // 1.注意这的数据格式用 "-"隔开,因为后台处理要求按照 "-"分割
            type: "POST",
            contentType: "application/x-wisely", // 2. contentType 设置为自定义的 "application/x-wisely"
            success: function (data){
                $("#resp").html(data);
            }
        });
    }
    function req_other(){
        $.ajax({
            url: "convert",
            data: "1-wangyunfei", // 1.注意这的数据格式用 "-"隔开,因为后台处理要求按照 "-"分割
            type: "POST",
            contentType: "application/json", // 2. contentType设置为自定义的 "application/x-wisely"
            success: function (data){
                $("#resp").html(data);
            }
        });
    }
</script>
</div>
</body>
</html>