<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Agendamento</title>
</head>
<body>
	<form method="post" name="agendamentoForm" action="http://localhost:8080/TestePetShop1.0/agendamento/create">
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
		<div>
			<input type="submit" value="Cadastrar"/>
			<input type="submit" value="Editar" formaction="http://localhost:8080/TestePetShop1.0/agendamento/update"/>
		</div>
	</form>
</body>
</html>