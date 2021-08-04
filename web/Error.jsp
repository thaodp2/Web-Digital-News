<%-- 
    Document   : Error
    Created on : May 12, 2021, 3:08:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link href="asset/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/right.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/search.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="components/Header.jsp"/>
            <div class="main">
                <div class="leftMain" style="font-weight: bold; font-size: 30px; ">
                    This page does not exist: 
                    <div>Error: ${error}</div>
                </div>
                <div class="rightMain">
                    <div class="titleRight">
                        Digital news
                    </div>
                    <div class="shortDes">
                        IN today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report.
                    </div>
                    <div class="titleRight">
                        Search
                    </div>
                    <div class="search">
                        <form action="SearchController">
                            <input class="inputTxt" type="text" name="txtSearch" value=""  
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
                    <div class="list">
                        <a href="http://localhost:8080/J3.L.P0004_Digital_news_/DetailController?id=1">Making security feeds smarter via machine learning</a> <br>
                        <br>
                        <a href="http://localhost:8080/J3.L.P0004_Digital_news_/DetailController?id=2">Elevenia tawarkan layanan Mokado</a> <br>
                        <br>
                        <a href="http://localhost:8080/J3.L.P0004_Digital_news_/DetailController?id=3">Digi offers iPhone SE, promises lowest per month all-in payment</a> <br>
                        <br>
                        <a href="http://localhost:8080/J3.L.P0004_Digital_news_/DetailController?id=4">Digi offers iPhone SE, promises lowest per month all-in payment</a> <br>
                        <br>
                        <a href="http://localhost:8080/J3.L.P0004_Digital_news_/DetailController?id=5">Midlife Enterpriser: Reengineering mindsets of mid-aged professionals</a> <br>
                        <br>
                        <br>
                        <br>
                    </div>
                </div>
                <%--<jsp:include page="RightPage.jsp"/>--%>
            </div>
            <jsp:include page="components/Footer.jsp"/>
        </div>
    </body>
</html>
