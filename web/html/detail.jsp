<%-- 
    Document   : detail
    Created on : Oct 12, 2020, 10:47:10 AM
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
                        <div class="section3">
                            <table>
                                <tr>
                                    <td><img src="${detail.getIcon()}" class="icon"></td>
                                    <td>
                                        <p class="small-title">${detail.getTitle()}<span class="date">${detail.getDateFormat()}</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <img src="${detail.getImage()}" class="${detail.getType() == "picture" ? 'img1' : 'img2'}">
                                        <p class="${detail.getType() == "picture" ? 'description' : ''}">${detail.getContent()}</p>
                                    </td>
                                </tr>
                            </table>
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
