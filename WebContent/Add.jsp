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
    <script>
    function checkform(){
        if(document.getElementById('ii').value == null ||
        document.getElementById('ii').value == "") {
           alert("NO isbn !");
           return false;
        }
        if(document.getElementById('tt').value == null ||
        document.getElementById('tt').value == "") {
           alert("NO title !");
           return false;
        }
        if(document.getElementById('aa').value == null ||
        document.getElementById('aa').value == "") {
           alert("NO author_id !");
           return false;
        }
        if(document.getElementById('pp').value == null ||
        document.getElementById('pp').value == "") {
           alert("NO publisher !");
           return false;
        }
        if(document.getElementById('dd').value == null ||
        document.getElementById('dd').value == "") {
           alert("NO publish_date !");
           return false;
        }
        if(document.getElementById('rr').value == null ||
        document.getElementById('rr').value == "") {
           alert("NO price !");
           return false;
        }
    return true;
    }
    </script>
</head>
<body>    
    <s:form action="Store"  onsubmit="return checkform()">
    <table cellspacing="0">
            <tbody>
                <tr><td>ADD BOOK</td></tr>
        <tr><s:textfield name="book.isbn" label="ISBN" id="ii"/></tr>
        <tr><s:textfield name="book.title" label="Title" id="tt"/></tr>
        <tr><s:textfield name="book.authorID" label="AuthorID" id="aa"/></tr>
        <tr><s:textfield name="book.publisher" label="Publisher" id="pp"/></tr>
        <tr><s:textfield name="book.publishdate" label="Publishdate" id="dd"/></tr>
        <tr><s:textfield name="book.price" label="Price" id="rr"/></tr>
        <tr><td><input type="submit" value="Add" class="tt"/></td></tr>
        </tbody>
        </table>
    </s:form>
   
</body>
</html>