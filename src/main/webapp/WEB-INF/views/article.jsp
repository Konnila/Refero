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
            <li><a href="/">Index</a></li>
        </ul>

        <h2>${article.title}</h2>
        
        <pre>
            Id: ${article.id}
            Author: ${article.author}
            Title: ${article.title}
            Journal: ${article.journal}
            Volume: ${article.volume}
            Number: ${article.number}
            Pages: ${article.pages}
            Year: ${article.releaseYear}
            Publisher: ${article.publisher}
            Address: ${article.address}
            ReferenceID: ${article.referenceID}
        </pre>
        
        <h2>BibTeX</h2>
        
        <textarea rows="10 "cols="40">${bibtex}</textarea>

    </body>
</html>