<%-- 
    Document   : book
    Created on : Apr 19, 2012, 7:57:49 PM
    Author     : Stolichnaya
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Refero</h1>

        <h2>Navigation</h2>

        <ul>
            <li><a href="/">Index</a></li>
        </ul>

        <h2>${book.title}</h2>

        <pre>
            Id: ${book.id}
            Author: ${book.author}
            Title: ${book.title}
            Publisher: ${book.publisher}
            Year: ${book.releaseYear}
            Address: ${book.address}


            
            
            
        </pre>

        <h2>BibTeX</h2>

        <textarea rows="10 "cols="40">${bibtex}</textarea>

    </body>
</html>