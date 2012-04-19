<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Refero - Add article</title>
    </head>
    <body>
        <h1>Refero</h1>

        <h2>Navigation</h2>

        <ul>
            <li><a href="/">Index</a></li>
        </ul>

        <h2>Let's add an article!</h2>

        <form:form method="POST" commandName="articleForm" action="article">

            <form:label path="author">Author:</form:label>
            <form:input path="author" />
            <form:errors path ="author"/> <br>    

            <form:label path="title">Title:</form:label>
            <form:input path="title" />
            <form:errors path ="title"/><br>

            <form:label path="journal">Journal:</form:label>
            <form:input path="journal" />
            <form:errors path ="journal"/><br>

            <form:label path="volume">Volume:</form:label>
            <form:input path="volume" />
            <form:errors path ="volume"/><br>

            <form:label path="number">Number:</form:label>
            <form:input path="number" />
            <form:errors path ="number"/><br>
            
            <form:label path="pages">Pages:</form:label>
            <form:input path="pages" />
            <form:errors path ="pages"/><br>

            <form:label path="releaseYear">Year:</form:label>
            <form:input path="releaseYear" />
            <form:errors path ="releaseYear"/><br>

            <form:label path="publisher">Publisher:</form:label>
            <form:input path="publisher" />
            <form:errors path ="publisher"/><br>

            <form:label path="address">Address:</form:label>
            <form:input path="address" />
            <form:errors path ="address"/><br>

            <input type="submit" value="Add article"><br>
        </form:form>
    </body>
</html>