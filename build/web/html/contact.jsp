<%-- 
    Document   : contact
    Created on : Oct 12, 2020, 11:55:49 PM
    Author     : ThangCoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p class="page-title">Contact Me</p>
                        <div class="section2">
                            <p class="send">Send your message</p>
                            <c:if test="${alert!=null}">
                                <input placeholder="${alert}" class="${status == true ? 'success' : 'error'}" id="notice" readonly>
                            </c:if>
                        </div>
                        <p>Write your message here. Fill out the form:</p>

                        <form action="contact">
                            <input type="text" name="name" placeholder="Write your name here" 
                                   id="name" value="${name}" required 
                                   class="${status == true ? 'sent' : ''}">
                            <input type="email" name="email" placeholder="Write your email here"
                                   id="email" value="${email}" required
                                   class="${status == true ? 'sent': ''}">
                            <textarea name="message" placeholder="Write your message here"
                                      id="textarea" required 
                                      class="${status == true ? 'sent-mess' : ''}">${mess}</textarea>
                            <button type="submmit" id="button"          
                                    class="${status == true ? 'clicked' : ''}">
                                ${status == true ? 'Sent' : 'Sent - Click here'}
                            </button>
                        </form>
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
