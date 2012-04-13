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
            <li><a href="/">All articles</a></li>
        </ul>
        
        <h2>Let's add an article!</h2>
        <form method="post" action="article">
            
            <label>Author:</label>
            <input type="text" name="author"><br>    
            
            <label>Title:</label>
            <input type="text" name="title"><br>
            
            <label>Journal:</label>
            <input type="text" name="journal"><br>
            
            <label>Volume:</label>
            <input type="text" name="volume"><br>
            
            <label>Number:</label>
            <input type="text" name="number"><br>
            
            <label>Year:</label>
            <input type="text" name="releaseYear"><br>
            
            <input type="submit" name="Add article"><br>
        </form>
    </body>
</html>