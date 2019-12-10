<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Agendamento</title>
</head>
<body>
	<form method="GET" action="http://localhost:8080/PetShopServer/agendamento/create"
		name="agendamentoForm">
		<div>
			<label for="lData">Data</label> <input type="date" id="lData"
				name="data">
		</div>
		<div>
			<label for="lAnimal">Nome do animal</label> <input type="text"
				id="lAnimal" name="animal">
		</div>
		<div>
			<label for="lServico">Serviço</label> <input type="text"
				id="lServico" name="servico">
		</div>
	</form>
</body>
</html>