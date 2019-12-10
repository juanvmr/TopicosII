<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro do cliente</title>
</head>
<body>
	<form name="clientForm" method="post" action="http://localhost:8080/PetShopServer/cliente/create">
		<div>
			<label for="lNome">Nome</label> <input type="text" id="lNome"
				name="nome">
		</div>
		<div>
			<label for="lEndereco">Endereço</label> <input type="text"
				id="lEndereco" name="nome">
		</div>
		<div>
			<label for="lEmail">Email</label> <input type="text" id="lEmail"
				name="email">
		</div>
		<div>
			<label for="lCPF">CPF</label> <input type="text" id="lCPF" name="cpf">
		</div>
	</form>
</body>
</html>