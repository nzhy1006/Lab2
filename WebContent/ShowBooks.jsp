<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
        body {
            background-image:url('b2.png');
            background-size:100%;
            background-repeat:no-repeat;
        }

        table {
            position: absolute;
            top: 80px;
            botton:50px;
            left:50%;
            width:450px;
            margin-left:-225px;
            background-color: #FCFCFC;
            box-shadow: 2px 2px 5px #888888;
        }
        
        table thead tr th {
            height: 50px;
            text-align: center;
            font-family:Georgia;
        }
        
        table tbody tr td {
            height: 50px;
            text-align: center;
            font-family:Georgia;
        }
        
        .tt {
            width:100px;
            height:30px; 
            position: absolute;
            left:50%; 
            top:94%; 
            margin-left:-50px; 
            margin-top:-20px;  
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
    </style>
</head>
<body>
<s:form action="Ret" >
<table cellspacing="0">
            <tbody>
                <tr><td>This author's book:</td></tr>
<s:iterator value="books">
<tr><td><s:property value="title" /></td></tr>

</s:iterator>
<tr><td>&nbsp;</td></tr>
<tr><td><input type="submit" value="Return" class="tt"/></td></tr>
</tbody>
</table>
</s:form>

</body>
</html>