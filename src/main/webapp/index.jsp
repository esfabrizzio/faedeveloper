<html>
<head>
	<title>viewer by faedev</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
	.w3-btn {margin-bottom:10px;}
	</style>
</head>

<body>
	<br/><br/>
	<form action="mostrarInfoPromo" method="post">
		<input type="hidden" id="tipoB" name="tipoB" value=""/>
		Info promociones Banco Agrícola <input type="submit" class="w3-button w3-white w3-border w3-round-large" value="Click Aquí" onclick="document.getElementById('tipoB').value='A'" /> <br/><br/>
		Info promociones AFP Crecer <input type="submit" class="w3-button w3-white w3-border w3-round-large" value="Click Aquí" onclick="document.getElementById('tipoB').value='C'" /> <br/><br/>
		Info promociones AFP Confía <input type="submit" class="w3-button w3-white w3-border w3-round-large" value="Click Aquí" onclick="document.getElementById('tipoB').value='F'" /> <br/><br/>
	</form>
</body>
</html>
