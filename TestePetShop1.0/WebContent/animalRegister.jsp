<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro do animal</title>
</head>
<body>
	<form name="animalForm" method="post" action="http://localhost:8080/TestePetShop1.0/animal/create">
		<div>
			<label for="lNome">Nome</label> <input id="lNome" name="nome"
				type="text">
		</div>
		<div>
			<label for="lRaca">Raça</label> <input type="text" id="lRaca"
				name="raca">
		</div>
		<div>
			<label for="lSexo">Sexo</label> <input type="text" id="lSexo"
				name="sexo">
		</div>
		<div>
			<label for="lCor">Cor</label> <input type="text" id="lCor" name="cor">
		</div>
		<div>
			<label for="lIdade">Idade</label> <input type="text" id="lIdade"
				name="idade">
		</div>
		<div>
			<label for="lAltura">Altura</label> <input type="text" id="lAltura"
				name="altura">
		</div>
		<div>
			<label for="lPeso">Peso</label> <input type="text" id="lPeso"
				name="peso">
		</div>
		<div>
			<input type="submit" value="Cadastrar"/>
			<input type="submit" value="Editar" formaction="http://localhost:8080/TestePetShop1.0/animal/update"/>
		</div>
	</form>
</body>
</html>