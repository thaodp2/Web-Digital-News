<%-- 
    Document   : HomePage
    Created on : May 12, 2021, 9:45:08 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="asset/css/header.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
        <link href="asset/css/right.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="components/Header.jsp"/>
            <div class="main">
                <%--<c:forEach items="${requestScope.top1News}" var="news">--%>
                    <div class="leftMain">
                        <div class="titleLeft">
                            ${requestScope.top1New.getTitle()}
                        </div>
                        <div class="image">
                            <img src="asset/img/${requestScope.top1New.getImage()}" alt=""/>
                        </div>
                        <div class="detailsContent">
                            ${requestScope.top1New.getDescription()}
                        </div>
                        <div class="infomation">
                            ${requestScope.top1New.getAuthor()} | ${requestScope.top1New.getDate()}  
                        </div>
                    <%--</c:forEach>--%>
                </div>
                <jsp:include page="RightPage.jsp"/>
            </div>
            <jsp:include page="components/Footer.jsp"/>
        </div>
    </body>
</html>
