<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

.tt {
    width:100px;
    height:40px; 
    position: absolute;
    left:50%; 
    top:90%; 
    margin-left:-50px; 
    margin-top:-40px; 
    display: inline-block;
    background: #FFFFFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
div {
    width:400px;
    height:500px; 
    background-image:url('background.jpg');
    background-size:100%;
    position:absolute; 
    top:30%; 
    left:50%; 
    margin-left:-200px; 
    margin-top:-200px; 
}
 
</style>

</head>
<body>
<div></div>

   <form action="start">
      <p><input type="submit" value="log In" class="tt"/></p>
   </form>
</body>
</html>