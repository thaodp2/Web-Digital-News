<%-- 
    Document   : RightPage
    Created on : May 12, 2021, 3:18:19 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="asset/css/right.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Right Page</title>
    </head>
    <body> 
        <div class="rightMain">
            <div class="titleRight">
                Digital news
            </div>
            <div class="shortDes">
                <%--<c:forEach items="${requestScope.top1News}" var="new">--%>
                ${requestScope.top1New.getShortDes()}
                <%--</c:forEach>--%>
            </div>
            <div class="titleRight">
                Search
            </div>
            <div class="search">
                <form action="SearchController">
                    <input class="inputTxt" type="text" name="txtSearch" value="${requestScope.txt}"  
                           placeholder="Search"
                           required pattern=".*\S+.*"
                           title="Search should only contain lowercase letters."
                           />                           
                    <input class="submitBtn" type="submit" value="Go" name="btnSearch" />  
                </form>
            </div>
            <div class="titleRight">
                Last Articles
            </div>
            <c:forEach items="${requestScope.digitals}" begin="1" var="new">
                <div class="list">
                    <a href="DetailController?id=${new.getId()}">${new.getTitle()}</a>
                    <br>
                    <br>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
