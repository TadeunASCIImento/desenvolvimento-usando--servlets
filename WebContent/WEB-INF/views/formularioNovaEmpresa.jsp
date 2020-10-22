<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/empresa" var="linkEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de cadastro de empresas</title>
<link rel="stylesheet" href="static/css/formulario.css">
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		Olá ${usuario.login} bem vindo ao cadastro de empresas.
		<header>
			<c:import url="templateLogout.html" />
			<h1 class="titulo">Cadastro</h1>
		</header>
		<form action="${linkEmpresa}" method="POST">
			<input type="hidden" name="acao" value="NovaEmpresa" />
			<div class="form-row">
				<div class="form-group col-md-3">
					<label>CNPJ da empresa</label> <input type="text" name="id"
						class="form-control" value="${empresa.id}" />
				</div>
				<div class="form-group col-md-4">
					<label>Nome da empresa</label> <input type="text" name="nome"
						class="form-control" value="${empresa.nome}" />
				</div>
				<div class="form-group col-md-3">
					<label>Data de abertura</label> <input type="date"
						name="dataAbertura" class="form-control"
						style="text-align: center;" />
				</div>
			</div>
			<input type="submit" value="Cadastrar" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>