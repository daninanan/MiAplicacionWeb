<%-- 
    Document   : index
    Created on : Feb 25, 2016, 3:03:34 AM
    Author     : Nanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuarios</title>
    </head>
    <body>
       <form action="ServletAplicacion" method="POST">
            Identificación: <input type="text" name="identificacion"/> <br />
            Nombre: <input type="text" name="nombre"/> <br />
            <input type="submit" value="Guardar Persona"/><br />
       </form>
        
        <form action="ServletAplicacion" method="GET">
            <input type="submit" value="Consultar"/>
            
        </form>
         <form>
        <a href="pruebajsp.jsp">Eliminar registros...</a>
        </form>
    </body>
</html>
