<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <li><a href="/article">Add article</a></li>
        </ul>

        <h2>All article</h2>
        
        <c:forEach var="article" items="${articles}">
            <pre>
                Author: ${article.author}
                Title: ${article.title}
                Year: ${article.releaseYear}
                <a href="/article/${article.id}">More details</a>
            </pre>
        </c:forEach>

    </body>
</html>