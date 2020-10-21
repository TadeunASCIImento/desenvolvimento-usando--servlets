<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/api" var="linkApi" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul�rio de cadastro de empresas</title>
<link rel="stylesheet" href="static/css/formulario.css">
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header>
			<h1 class="titulo">Cadastro de Empresas</h1>
		</header>
		<form action="${linkApi}" method="POST">
			<input type="hidden" name="acao" value="create" />
			<div class="form-row">
				<div class="form-group col-md-3">
					<label>CNPJ da empresa</label> <input type="text" name="id"
						class="form-control" value="${empresa.id}" />
				</div>
				<div class="form-group col-md-4">
					<label>Nome da empresa</label> <input type="text" name="nome"
						class="form-control" value="${empresa.nome}" />
				</div>
				<div class="form-group col-md-4">
					<label>Data de abertura</label> <input type="date"
						name="dataAbertura" class="form-control" />
				</div>
			</div>
			<input type="submit" value="Cadastrar" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>