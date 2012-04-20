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
            <li><a href="/book">Add book</a></li>
            <li><a href="/inproceeding">Add inproceeding</a></li>
            <li><a href="/listbibtex">List all BiBTeXs</a></li>
        </ul>

        <h2>All articles</h2>

        <c:forEach var="article" items="${articles}">
            <pre>
                Author: ${article.author}
                Title: ${article.title}
                Year: ${article.releaseYear}
                <a href="/article/${article.id}">More details</a>
            </pre>
        </c:forEach>

        <h2>All inproceedings</h2>

        <c:forEach var="inpro" items="${inproceedings}">
            <pre>
                Author: ${inpro.author}
                Title: ${inpro.title}
                Year: ${inpro.releaseYear}
                <a href="/inproceeding/${inpro.id}">More details</a>
            </pre>
        </c:forEach>

        <h2>All books</h2>
        <c:forEach var="book" items="${books}">
            <pre>
                Author: ${book.author}
                Title: ${book.title}
                Year: ${book.releaseYear}
                <a href="/book/${book.id}">More details</a>
            </pre>
        </c:forEach>

    </body>
</html>