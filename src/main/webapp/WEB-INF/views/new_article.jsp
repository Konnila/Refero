<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Let's add an article!
        <form method="post" action="newArticle">
            Author:<input type="text" name="author"/><br>    
            Title:<input type="text" name="title"/><br>
            Journal:<input type="text" name="journal"/><br>  
            Volume:<input type="text" name="volume"/>  <br>
            Number:<input type="text" name="number"/>  <br>
            Year:<input type="text" name="ReleaseYear"/><br>
            <input type="submit" name="submit"/><br>
        </form>
    </body>
</html>