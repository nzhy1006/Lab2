<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Book List</title>
    <style type="text/css">
        body {
            background-image:url('b2.png');
            background-size:100%;
            background-repeat:no-repeat;
        }

        table {
            position: absolute;
            top: 140px;
            botton:50px;
            left:50%;
            width:650px;
            margin-left:-325px;
            background-color: #FCFCFC;
            box-shadow: 2px 2px 5px #888888;
        }
        
        table thead tr th {
            height: 50px;
            text-align: center;
        }
        
        table tbody tr td {
            height: 50px;
            text-align: center;
            font-family:Georgia;
            
        }
        
        a:link {
            text-decoration:none;
            color:black;
        }
        a:hover {
            text-decoration:none;
            color:red;
        }
        a:active {
            text-decoration:none;
            color:yellow;
        }
        a:visited {
            text-decoration:none;
            color:gray;
        }
        .tt {
            width:27px;
            height:27px; 
            display: inline-block;
            background: #FFFFFF;
            border: 2px solid #99D3F5;
            border-radius: 5px;
            overflow: hidden;
            color: #1E88EF;
            text-decoration: none;
            font-weight:normal;
            font-size: 12pt;
         }
         
         div {
             top: 30px;
             width:650px;
             height:60px;
             line-height:60px;   
             overflow:hidden;
             position:absolute; 
             
             left:50%;
             background-color: #FCFCFC;
             margin-left:-325px;
             text-align: center;
             font-size:24pt;
             font-family:Georgia;
             box-shadow: 2px 2px 5px #888888;
         }
         

    </style>
</head>
<body>    
    <s:form action="Search" theme="simple">
        <div>BOOK LIST</div>
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>
                        <a href="Add.jsp"  ><img src="addsign.png" height="28px" width="28px" alt="left"/></a>
                    </th>
                    <th>&nbsp;</th>
                    <th>
                        <s:textfield name="name" label="ISBN" cssStyle="width:100px;height:22px;border: 1px solid #828282;border-radius: 2px;"/>
                        <input type="submit" value="S" class="tt"/>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>ISBN</td>
                    <td>Title</td>
                    <td>Operation</td>
                </tr>
                <tr><th>&nbsp;</th></tr>
                <s:iterator value="books">
                    <tr>
                        <td><s:property value="isbn" /></td>
                        <td>
                            <a href='<s:url action="Show"><s:param name="isbn" value="isbn" /></s:url>'>
                                <s:property value="title" />
                            </a>
                        </td>
                        <td>
                            
                            &nbsp;
                            <a href='<s:url action="Remove"><s:param name="isbn" value="isbn" /></s:url>'>
                                Delete
                            </a>
                        </td>
                    </tr>
                </s:iterator>
                <tr><th>&nbsp;</th></tr>
                <tr><th>&nbsp;</th></tr>
            </tbody>
        </table>
    </s:form>    
</body>
</html>