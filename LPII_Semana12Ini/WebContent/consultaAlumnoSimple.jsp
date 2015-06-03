

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="beans.CarreraBean"%>
<%@page import="dao.CarreraDao"%>
<%@page import="dao.Factory"%>
<%@page import="beans.AlumnoBean"%>
<%@page import="java.util.List"%>
<%@ taglib uri="misLibrerias" prefix="lp2" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Consulta Alumno</h1>

<form action="consultaAlumno">
	Carrera 
	 <lp2:TagSeleccionBd aliasSql="SQL_CARRERA" nombre="carrera"/>
		
	
	 	<input type="submit" value="enviar">
</form>

<table>
  <tr>
    <th>Id</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Carrera</th>
  </tr>
  <%
  	List<AlumnoBean> data =(List<AlumnoBean>)request.getAttribute("alumnos");
    	  if(data != null){
    		 for(AlumnoBean aux : data) {
  %>
  <tr>
    <td><%= aux.getIdAlumno() %></td>
    <td><%= aux.getNombre() %></td>
    <td><%= aux.getApellido() %></td>
    <td><%= aux.getDesCarrera() %></td>
  </tr>
  <%
  	  }}
  %>
</table>



</body>
</html>