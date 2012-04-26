<%-- 
    Document   : author
    Created on : Apr 27, 2012, 1:07:07 AM
    Author     : Stolichnaya
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Refero</title>
    </head>
    <body>
        <h1>Refero</h1>
        
        <h2>Navigation</h2>
        
        <ul>
            <li><a href="/">Index</a></li>
        </ul>
        
        <h2>${author.firstName} ${author.surName}</h2>
        
                <h2>All articles from this author</h2>

        <c:forEach var="article" items="${author.articleReferenceList}">
            <pre>
                Author(s):
                <c:forEach var="author" items="${article.authors}">${author}
                </c:forEach>
                Title: ${article.title}
                Year: ${article.releaseYear}
                <a href="/article/${article.id}">More details</a>
            </pre>
        </c:forEach>
        
    </body>
</html>
