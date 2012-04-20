<%-- 
    Document   : listbibtex
    Created on : 20.4.2012, 14:41:17
    Author     : laurpulk
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
        <h1>Refero</h1>

        <h2>Navigation</h2>
        
        <ul>
            <li><a href="/">Index</a></li>
        </ul>
        
        <textarea rows="100"cols="100">${bibtex}</textarea>
    </body>
</html>
