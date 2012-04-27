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

        <h2>All books from this author</h2>

        <c:forEach var="book" items="${author.bookReferenceList}">
            <pre>
                Author(s):
                <c:forEach var="author" items="${book.authors}">${author}
                </c:forEach>
                Title: ${book.title}
                Year: ${book.releaseYear}
                <a href="/book/${book.id}">More details</a>
            </pre>
        </c:forEach>

        <h2>All inproceedings from this author</h2>

        <c:forEach var="inproceedings" items="${author.inproceedingsReferenceList}">
            <pre>
                Author(s):
                <c:forEach var="author" items="${inproceedings.authors}">${author}
                </c:forEach>
                Title: ${inproceedings.title}
                Year: ${inproceedings.releaseYear}
                <a href="/inproceedings/${inproceedings.id}">More details</a>
            </pre>
        </c:forEach>
    </body>
</html>
