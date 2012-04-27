<%-- 
    Document   : new_inproceeding
    Created on : Apr 19, 2012, 7:13:05 PM
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

        <h2>Let's add an inproceeding!</h2>
        
        <ul>
            <li>Bolded fields are required to fill!</li>
        </ul>
        
        <form:form method="POST" commandName="inproceedingForm" action="inproceeding">

            <label><b>Author:</b></label>
            <input type="text" name="author"><br>  

            <form:label path="title"><b>Title:</b></form:label>
            <form:input path="title" />
            <form:errors path ="title"/><br>

            <form:label path="bookTitle">Book title:</form:label>
            <form:input path="bookTitle" />
            <form:errors path ="bookTitle"/><br>

            <form:label path="releaseYear">Year:</form:label>
            <form:input path="releaseYear" />
            <form:errors path ="releaseYear"/><br>

            <form:label path="pages">Pages:</form:label>
            <form:input path="pages" />
            <form:errors path ="pages"/><br>

            <form:label path="publisher"><b>Publisher:</b></form:label>
            <form:input path="publisher" />
            <form:errors path ="publisher"/><br>

            <input type="submit" value="Add inproceeding"><br>
        </form:form>



    </body>
</html>
