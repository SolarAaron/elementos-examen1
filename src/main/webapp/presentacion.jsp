<%-- 
    Document   : presentacion
    Created on : 4/07/2014, 08:24:43 PM
    Author     : Aaron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <link href="jscript/libs/jquery-mobile/jquery.mobile.css" rel="stylesheet" />
        <script src="jscript/libs/jquery/jquery.js"></script>
        <script src="jscript/libs/jquery-mobile/jquery.mobile.js"></script>
        <script>
            $(document).ready(function(e){
                $.ajax({
                    url: '/examen1/resultados',
                    type: 'GET',
                    success: function (data) {
                        $("#resServ").html("Calificacion: " + data.object.nombre + " " + data.object.calificacion);
                    }
                });
                $.ajax({
                    url: '/examen1/servicios/calificaciones/servicio-calificaciones',
                    type: 'GET',
                    success: function (data) {
                        for(i = 0; i < data.object.length; i++){
                            $("#resCont").html($("#resCont").html() + "<br>Calificacion: " + data.object[i].nombre + " " + data.object[i].calificacion);
                        }
                    }
                });
            });
        </script>
    </head>
    <body>
        <h1>Resultados de calificaciones</h1>
        <div id="resServ"></div>
        <div id="resCont"></div>
    </body>
</html>
