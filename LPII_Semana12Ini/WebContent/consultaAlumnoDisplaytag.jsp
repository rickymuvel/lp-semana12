

<%@ taglib uri="misLibrerias" prefix="lp2" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/displaytag.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1>Consulta Alumno</h1>

<form action="consultaAlumnoDisplayTag">
	Carrera 
	 <lp2:TagSeleccionBd aliasSql="SQL_CARRERA" nombre="carrera"/>
		
	
	 	<input type="submit" value="enviar">
</form>
    
<!-- 
	pagesize: Tamaño de la página
	requestURI: El alias del servlet
	id: Es el nombre de la variable que permite acceder a los datos, es como el i de un for.
 -->
    
<display:table name="alumnos" pagesize="3" 
			   requestURI="consultaAlumnoDisplayTag"
			   export="true"
			   id="bean">
	<display:column property="idAlumno" title="ID" sortable="true"></display:column>
	<display:column property="nombre" title="Nombre" sortable="true"></display:column>
	<display:column property="apellido" title="APELLIDO" sortable="true"></display:column>
	<display:column property="desCarrera" title="CARRERA" sortable="true"></display:column>
	<display:column style="text-align:center">
		<a href="eliminaAlumno?id=${bean.idAlumno}">
			<img alt="Elimina" src="img/elimina.png">
		</a>
	</display:column>
</display:table>


</body>
</html>