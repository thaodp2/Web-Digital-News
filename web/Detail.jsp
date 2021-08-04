<%-- 
    Document   : Detail
    Created on : May 16, 2021, 5:28:22 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="asset/css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div class="container">
            <jsp:include page="components/Header.jsp"/>
            <div class="main">
                <div class="leftMain">
                    <div class="titleLeft">
                        ${requestScope.digitalById.getTitle()}
                    </div>
                    <div class="image">
                        <img src="asset/img/${requestScope.digitalById.getImage()}" alt=""/>
                    </div>
                    <div class="detailsContent">
                        ${requestScope.digitalById.getDescription()}
                    </div>
                    <div class="infomation">
                        ${requestScope.digitalById.getAuthor()}|${requestScope.dateConvert}
                    </div>
                </div>
                <jsp:include page="RightPage.jsp"/>
            </div>
            <jsp:include page="components/Footer.jsp"/>
        </div>
    </body>
</html>
