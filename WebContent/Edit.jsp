<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Book</title>
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
            top:90%; 
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
    <s:form action="Update" >
        <table cellspacing="0">
            <tbody>
                <tr><td>&nbsp;</td></tr>
                <tr><s:textfield name="book.isbn" label="ISBN" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><s:textfield name="book.title" label="Title" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><s:textfield name="book.authorID" label="AuthorID" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><s:textfield name="book.publisher" label="Publisher" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><s:textfield name="book.publishdate" label="Publishdate" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><s:textfield name="book.price" label="Price" cssStyle="width:140px;height:22px;border: 1px solid #828282;border-radius: 2px;"/></tr>
                <tr><td><input type="submit" value="Update" class="tt"/></td></tr>
                <tr><td>&nbsp;</td></tr>
            </tbody>
        </table>
    </s:form>
</body>
</html>