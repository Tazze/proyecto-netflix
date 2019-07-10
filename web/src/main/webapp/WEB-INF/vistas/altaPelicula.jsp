<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Home de Spring MVC</title>
    </head>
    <body>
        <marquee><h1>Formulario</h1></marquee>
        <form action="insertMovie">
            Titulo <input type="text" name="titulo">
            Director <input type="text" name="director">
            Sinopsis <input type="text" name="sinopsis">
            <input type="submit" value="alta">
        </form>
    </body>
</html>