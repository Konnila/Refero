<%-- 
    Document   : inproceedings
    Created on : Apr 19, 2012, 7:28:07 PM
    Author     : Stolichnaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <body>
        <h1>Refero</h1>

        <h2>Navigation</h2>
        
        <ul>
            <li><a href="/">Index</a></li>
        </ul>

        <h2>${inproceedings.title}</h2>
        
        <pre>
            Id: ${inproceedings.id}
            Author: ${inproceedings.author}
            Title: ${inproceedings.title}
            Book title: ${inproceedings.bookTitle}
            Year: ${inproceedings.releaseYear}
            Pages: ${inproceedings.pages}
            Publisher: ${inproceedings.publisher}
            ReferenceID: ${inproceedings.referenceID}
        </pre>
        
        <h2>BibTeX</h2>
        
        <textarea rows="10 "cols="40">${bibtex}</textarea>

    </body>
    </body>
</html>
