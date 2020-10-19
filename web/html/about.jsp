<%-- 
    Document   : about
    Created on : Oct 12, 2020, 10:34:22 AM
    Author     : ThangCoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/style.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <table>
                    <td class="left">
                        <p class="page-title">About Me</p>
                        <div class="section2">
                            <img src="${info.getImage()}" class="img3">
                            <p><strong>Name:</strong> ${info.getName()}</p>
                            <p><strong>Age:</strong>${info.getAge()}</p>
                            <p>${info.getDescription()}</p>
                        </div>
                    </td>
                    <td class="right">
                        <%@include file="box.jsp" %>
                    </td>
                </table>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
