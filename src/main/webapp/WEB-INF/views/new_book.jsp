<%-- 
    Document   : new_book
    Created on : Apr 19, 2012, 8:22:48 PM
    Author     : Stolichnaya
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

        <h2>Let's add a book!</h2>
        
        <ul>
            <li>Bolded fields are required to fill!</li>
        </ul>
        
        <form:form method="POST" commandName="bookForm" action="book">
            <label><b>Author:</b></label>
            <input type="text" name="author"><br>

            <form:label path="title"><b>Title:</b></form:label>
            <form:input path="title" />
            <form:errors path ="title"/><br>

            <form:label path="publisher"><b>Publisher:</b></form:label>
            <form:input path="publisher" />
            <form:errors path ="publisher"/><br>

            <form:label path="releaseYear"><b>Year:</b></form:label>
            <form:input path="releaseYear" />
            <form:errors path ="releaseYear"/><br>

            <form:label path="address">Address:</form:label>
            <form:input path="address" />
            <form:errors path ="address"/><br>

            <input type="submit" value="Add book"><br>
        </form:form>
    </body>
</html>
