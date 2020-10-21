<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/controller" var="linkController" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de alteração de dados</title>
<link rel="stylesheet" href="static/css/formulario.css">
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header>
			<h1 class="titulo">Atualização de dados da Empresa</h1>
		</header>
		<form action="${linkController}" method="POST">
			<input type="hidden" name="acao" value="update" />
			<div class="form-row">
				<div class="form-group col-md-4">
					<input type="hidden" name="acao" value="alterar" /> <label>CNPJ
						da empresa</label> ${empresa.id} <input type="hidden" name="id"
						class="form-control" value="${empresa.id}" />
				</div>
				<div class="form-group col-md-4">
					<label>Nome da empresa</label> <input type="text" name="nome"
						class="form-control" value="${empresa.nome}" />
				</div>
				<div class="form-group col-md-4">
					<label>Data de abertura</label> <input type="text"
						name="dataAbertura" class="form-control"
						value="<fmt:formatDate value="${empresa.dataAbertura}"
								pattern="yyyy/MM/dd" />" />
				</div>
			</div>
			<input type="submit" value="Salvar Alterações"
				class="btn btn-primary" />
		</form>
	</div>
</body>
</html>