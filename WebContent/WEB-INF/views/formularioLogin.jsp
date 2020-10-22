<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/empresa" var="linkEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login de Usuário</title>
<link rel="stylesheet" href="static/css/formulario.css">
<link rel="stylesheet" href="static/css/empresas.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header>
			<h1 class="titulo">Informe os dados de acesso</h1>
		</header>
		<p>${mensagem}</p>
		<form action="${linkEmpresa}" method="POST">
			<input type="hidden" name="acao" value="LoginUsuario" />
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Login</label><input type="text" name="login"
						class="form-control" />
				</div>
				<div class="form-group col-md-4">
					<label>Senha</label> <input type="password" name="senha"
						class="form-control" />
				</div>
			</div>
			<input type="submit" value="ENTRAR" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>