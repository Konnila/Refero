<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        If you wish to add an article, go <a href="/article">HERE</a> 

        <pre>
            <c:forEach var="object" items="${list}">
                Author: ${object.author}
                Title: ${object.title}
                Journal: ${object.journal}
                Volume: ${object.volume}
                Number: ${object.number}
                Year: ${object.releaseYear}
            </c:forEach>
        </pre>

    </body>
</html>