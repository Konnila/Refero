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

        <h2>All articles</h2>
        
        <c:forEach var="object" items="${list}">
            <pre>
                Author: ${object.author}
                Title: ${object.title}
                Journal: ${object.journal}
                Volume: ${object.volume}
                Number: ${object.number}
                Year: ${object.releaseYear}
            </pre>
        </c:forEach>

    </body>
</html>