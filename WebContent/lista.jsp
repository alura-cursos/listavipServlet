<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListaVIP</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<div id="listaDeConvidados">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Nome</th>
					</tr>
				</thead>
				<c:forEach var="convidado" items="${convidados}">
					<tr>
						<td>${convidado.nome}</td>
						<td>${convidado.email}</td>
						<td>${convidado.telefone}</td>
				</c:forEach>

			</table>
		</div>

		<hr>

		<form action="convidado">
			<div class="form-group">
				<label for="nome">Nome</label> <input type="text"
					class="form-control" id="nome" name="nome" placeholder="Nome">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" placeholder="Email">
			</div>
			<div class="form-group">
				<label for="telefone">Telefone</label> <input
					type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone">
			</div>
			<button type="submit" class="btn btn-success">Convidar</button>
		</form>

	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>