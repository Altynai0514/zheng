<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is my first JSP!</title>

<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript">

$(function(){
	$.post('userController/getAllUsers.htm',{},function(data){
		alert(data);
	},'html'); 
	
});
	
</script>

</head>
<body>
	This is my first JSP!
</body>
</html>