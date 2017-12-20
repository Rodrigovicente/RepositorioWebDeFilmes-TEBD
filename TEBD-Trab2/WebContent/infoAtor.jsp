<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page language="java" import="modelo.Ator" %>


	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	Ator ator = null;
	
	if( request.getAttribute("infoAtor") == null){ %>
	
	<!-- <meta http-equiv="Refresh" content="1; url=http://localhost:8080/TEDB-Trab2/ListaFilmes"> -->
	
	<% }
	else {
		ator = (Ator) request.getAttribute("infoAtor");
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informações do ator</title>
</head>
<body>

	<h1>Informações do ator</h1>
	<%
	if(request.getAttribute("infoAtor") != null){
		//ArrayList<String> premios = ator.getPremios();
		
	%>
	<ul>
		<li>Nome: <%= ator.getNome() %></li>
		<li>Data de nascimento: <%= ator.getDataNasc() %></li>
		<li>País de origem: <%= ator.getPaisOrigem() %></li>
		<li>Endereço: <%= ator.getEndereco() %></li>
		<li>Premio(s): <%= ator.getPremios() %></li>
		<%						
		/* if(premios != null){
			out.println("<li>Premios: <ul>");
			for (String premio : premios){
				out.println("<li>" + premio + "</li>");
			}
			out.println("</ul></li>");
		} */
		%>
	</ul>
	<%
	}
	%>

</body>
</html>