<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="java.util.ArrayList"%>
<%@page language="java" import="modelo.Filme" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	ArrayList<Filme> listaFilmes = null; 

	if( request.getAttribute("filmes") == null){ %>
	
	<meta http-equiv="Refresh" content="1; url=http://localhost:8080/TEBD-Trab2/ListarFilmes">
	
	<% }
	else {
		 listaFilmes = (ArrayList<Filme>) request.getAttribute("filmes");
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de filmes</title>
</head>
<body>
	<h1>Filmes</h1>
	<ul>
		<%
		if(request.getAttribute("filmes") != null){
			ArrayList<String> generos;
			ArrayList<String> premios;
			ArrayList<String> atores;
			
			for (Filme filme : listaFilmes){
				generos = filme.getGenero();
				premios = filme.getPremios();
				atores = filme.getAtores();
		%>
		<li>
			<table>
				<tr>
					<td>
						<div> <%=filme.getTitulo()%> </div>
						<div> <%=filme.getAno()%></div>
						<div> <%=filme.getNomeDiretor()%></div>
						<div> <%=filme.getLocalFilmagem()%></div>
						<div>
				<%		
				if(!generos.isEmpty()){
					for (String genero : generos){
				%>
						<%=genero%>; 
				<%
					}
				}
				%>
						</div>
						<div>
				<%						
				if(!premios.isEmpty()){
					for (String premio : premios){
				%>
						<%=premio%>; 
				<%
					}
				}
				%>
						</div>
						
					</td>
				</tr>
				<tr>
					<td>
						<div> 
				<%
				if(!atores.isEmpty()){
					for (String ator : atores){
				%>
						<a href="InfoAtor?nome=<%=ator%>"> <%=ator%> </a>; 
				<%
					}
				}
				%>
						</div>
						
					</td>
				</tr>
			</table>
		</li>
		<%
			}
		}
		%>
	</ul>

</body>
</html>