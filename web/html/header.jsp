<%-- 
    Document   : header
    Created on : Oct 11, 2020, 6:45:52 PM
    Author     : ThangCoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/header.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="title-wrap">
            <p class="title">My Fashion Blog</p>
            <p class="subtitle">Welcome to my website</p>
        </div>
        <div class="menu">
            <a href="home" class="${page == "Home" ? 'active' : ''}">My Fashion Blog</a>
            <a href="about" class="${page == "About" ? 'active' : ''}">About Me</a>
            <a href="contact" class="${page == "Contact" ? 'active' : ''}">Contact</a>
        </div>
    </body>
</html>
