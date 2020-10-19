<%-- 
    Document   : home
    Created on : Oct 11, 2020, 9:25:42 PM
    Author     : ThangCoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/style.css" rel="stylesheet" type="text/css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p class="page-title">Blog</p>
                        <c:forEach var="a" items="${article}">
                            <div class="section1">
                                <table>
                                    <tr>
                                        <td><img src="${a.getIcon()}" class="icon"></td>
                                        <td>
                                            <a href="detail?id=${a.getId()}" class="small-title">${a.getTitle()}</a>
                                            <p class="date">${a.getDateFormat()}</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <a href="detail?id=${a.getId()}">
                                                <img src="${a.getImage()}" class="${a.getType() == "picture" ? 'img1' : 'img2'}">
                                            </a>
                                            <p class="${a.getType() == "picture" ? 'description' : ''}">${a.getContent()}</p>

                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                        <br><a href="overview" class="overview">Overview</a>
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
