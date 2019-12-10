<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Resumo dos dados</title>
</head>
<body>
	<div>
		<table id="clientTable">
			<c:forEach var="cliente" items="${listCliente}"/>
			<tr id="clientNome">
				<c:out value="${cliente.id}" />
			</tr>
			<tr id="clientEndereco">
				<c:out value="${cliente.endereco}" />
			</tr>
			<tr id="clientEmail">
				<c:out value="${cliente.email}" />
			</tr>
			<tr id="clientCPF">
				<c:out value="${cliente.cpf}" />
			</tr>
		</table>
	</div>
	<div>
		<table id="animalTable">
			<c:forEach var="animal" items="${getData}"/>
			<tr id="animalNome">
				<c:out value="${animal.nome}" />
			</tr>
			<tr id="animalRaca">
				<c:out value="${animal.raca}" />
			</tr>
			<tr id="animalSexo">
				<c:out value="${animal.sexo}" />
			</tr>
			<tr id="animalCor">
				<c:out value="${animal.cor}" />
			</tr>
			<tr id="animalIdade">
				<c:out value="${animal.idade}" />
			</tr>
			<tr id="animalAltura">
				<c:out value="${animal.altura}" />
			</tr>
			<tr id="animalPeso">
				<c:out value="${animal.peso}" />
			</tr>
		</table>
	</div>
	<div>
		<table id="agendamentoTable">
			<c:forEach var="agendamento" items="${getData}"/>
			<tr id="agendamentoData">
				<c:out value="${agendamento.data}" />
			</tr>
			<tr id="agendamentoAnimal">
				<c:out value="${agendamento.animal}" />
			</tr>
			<tr id="agendamentoServico">
				<c:out value="${agendamento.servico}" />
			</tr>
		</table>
	</div>
	<div>
		<form method="get" action="http://localhost:8080/TestePetShop1.0">
			<input type="submit" value="Retornar"/>
		</form>
	</div>
</body>
</html>