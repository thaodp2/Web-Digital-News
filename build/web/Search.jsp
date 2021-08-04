<%-- 
    Document   : search
    Created on : May 12, 2021, 3:08:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="Error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/right.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/footer.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link href="asset/css/search.css" rel="stylesheet" type="text/css"/>
        <style>
            .paging
            {
                float: left;
                /*margin-top: 100px;*/
                text-align: center;
                margin-bottom: 100px;
                margin-left:  400px;
            }
            .paging a{
                text-decoration: none;
                border-radius: 5px;
                padding: 2px;
                border: 1px solid;
                width: 50px;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="components/Header.jsp"/>
            <div class="main">
                <div class="leftMain">
                    <c:forEach items="${requestScope.digitalsSearch}" var="new">
                        <div class="titleLeft">
                            <a href="DetailController?id=${new.getId()}">
                                ${new.getTitle()}
                            </a>
                        </div>
                        <div class="image_search">
                            <img src="asset/img/${new.getImage()}" alt=""/>
                        </div>
                        <div class="detailsContent_search">
                            ${new.getShortDes()}
                        </div>
                        <div class="infomation">
                            ${new.getAuthor()}|${new.getDate()}
                        </div>
                        <br>
                        <div>__</div>
                        <br>
                    </c:forEach>
                </div>
                <jsp:include page="RightPage.jsp"/>
            </div>
            <div class="paging">
                <c:forEach begin="1" end="${requestScope.countNumberPage}" var="i">
                    <a class="${i==requestScope.index?"active":""}" href="SearchController?index=${i}&txtSearch=${txt}">${i}</a>
                </c:forEach>
                <br>
            </div>
            <jsp:include page="components/Footer.jsp"/>
        </div>
    </body>
</html>
