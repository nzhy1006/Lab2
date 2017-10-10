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
            top: 40px;
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
        
        tbody tr td {
            width:350px;
            height: 50px;
            text-align: center;
            font-family:Georgia;
        }
        
        a:link {
            text-decoration:none;
            color:#99D3F5;
        }
        a:hover {
            text-decoration:none;
            color:#1E88C7;
        }
        a:visited {
            text-decoration:none;
            color:#99D3F5;
        }
        
        .tt {
            width:100px;
            height:30px; 
            position: absolute;
            left:50%; 
            top:95%; 
            margin-left:50px; 
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
        <tr><td>ISBN:</td>
        <td><s:property value="book.isbn"/></td>
        </tr>
        <tr><td>Title:</td>
        <td><s:property value="book.title"/></td></tr>
        <tr><td>Author_ID:</td>
        <td><s:property value="book.authorID"/></td></tr>
        <tr><td>Publisher:</td>
        <td><s:property value="book.publisher"/></td></tr>
        <tr><td>PublishDate:</td>
        <td><s:property value="book.publishdate"/></td></tr>
        <tr><td>Price:</td>
        <td><s:property value="book.price"/></td></tr>
        <tr><td>Name:</td>
        <td><s:property value="author.name"/></td></tr>
        <tr><td>Age:</td>
        <td><s:property value="author.age"/></td></tr>
        <tr><td>Country:</td>
        <td><s:property value="author.country"/></td></tr>
        <tr>
        <td><a href='<s:url action="Edit"><s:param name="isbn" value="book.isbn" /></s:url>'>
             Update
        </a></td><td><input type="submit" value="Return" class="tt"/></td></tr>
        </tbody>
        </table>
    </s:form>

</body>
</html>