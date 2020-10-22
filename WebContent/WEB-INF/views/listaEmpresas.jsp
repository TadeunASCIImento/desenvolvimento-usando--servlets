<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.tadeu.gerenciador.models.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/empresa" var="linkEmpresa" />
<!DOCTYPE html>
<html>
<head>
<title>Lista de Empresas cadastradas</title>
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">

		Usuario Logado:${usuario.login}
		<header>
			<h1 class="titulo">Empresas Cadastradas</h1>
		</header>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>CÓDIGO</th>
					<th>NOME DA EMPRESA</th>
					<th>DATA DE ABERTURA</th>
					<th>EXCLUÍR</th>
					<th>ATUALIZAR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empresas}" var="empresa">
					<tr>
						<td>${empresa.id}</td>
						<td>${empresa.nome}</td>
						<td><fmt:formatDate value="${empresa.dataAbertura}"
								pattern="dd/MM/yyyy" /></td>
						<td><a
							href="${linkEmpresa}?id=${empresa.id}&acao=RemoveEmpresa"><img
								src="static/imagens/icones/icone-delete.png"></a></td>
						<td><a
							href="${linkEmpresa}?id=${empresa.id}&acao=EditaEmpresa"><img
								src="static/imagens/icones/icone-update.png"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
