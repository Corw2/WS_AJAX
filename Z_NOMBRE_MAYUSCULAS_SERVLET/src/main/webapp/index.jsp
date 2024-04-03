<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html lang="es">

	<head>
		<meta charset="UTF-8">
		<title>DESARROLLO WEB</title>

		
		<style type="text/css">
		
			fieldset {
				width:90%;
				color:blueviolet;
				font-size:20px;
				background-color:yellow;
				border:3px solid green;
				border-radius:25px;
				padding:5px;
			}		

			button {
				width:200px;
				height:50px;
				border-radius:30px;
				font-size:25px;
			}

			pre {
				display:inline-block;
			}
		
			.rojo {
				color:red;
			}
		
			.azul {
				color:blue;
			}

			.rojo, .azul {
				font-size:50px;
				font-weight:bolder;
				font-style:italic;
			}

		</style>

		
		<script type="text/javascript">
			
			function f_quitarBlancos() {
				
				//alert("QUITAR BLANCOS");
					
				const cajaNombre = document.getElementById("nombre"); // EL CONTROL GRÁFICO.
				
				const valorNombre = cajaNombre.value; // SU VALOR.
				
				//alert("CON BLANCOS ..." + cajaNombre.value);
				
				// TRAZA POR LA CONSOLA DE DEPURACIÓN DEL NAVEGADOR.
				console.log("\nVALOR DEL CAMPO nombre = " + cajaNombre.value);
				
				
				const valorNombreSinBlancos = valorNombre.trim(); // SU VALOR SIN BLANCOS A IZQ. NI DER.
				
				cajaNombre.value = valorNombreSinBlancos; // REASIGNAR VALOR YA LIMPIO A LA CAJA.

				//alert("SIN BLANCOS ..." + cajaNombre.value);
				
				console.log("\nSIN BLANCOS EN EXTREMOS = " + cajaNombre.value); // TRAZA SIN BLANCOS.
				
				
				/*
				document.getElementById("nombre").value = 
					trim(document.getElementById("nombre").value);
				*/
				
			} 
		
		</script>
		
	</head>
	
	
	<body>
	
		<div align="center">

			<h1> CONVERSOR NOMBRE A MAYUSCULAS - MODO TEXTO </h1>
	
	
			<br/><br/><br/>
			
			
			<form action="ConversorMayusculasServlet" method="GET"			
							onsubmit="f_quitarBlancos();">
	
				<label for="nombre"> TU NOMBRE </label>
				
				<input type="text" name="nombre" id="nombre" 
						size="22" maxlength="20" 
						placeholder="escribe ..."
						required
						autofocus/>
	
	
				<br/><br/><br/>
				<br/><br/><br/>
			
							
				<button> ENVIAR </button>
			
			</form>
			
			
			<br/><br/><br/>
			

			<fieldset>
							
				<div>
					PARAMETRO NOMBRE: 
					<pre class="rojo">${param.nombre}</pre>
				</div>

				<div>
					ATRIBUTO NOMBRE: 
					<pre class="azul">${requestScope.nombre}</pre>
				</div>

			</fieldset>

		</div>

	</body>
	
</html>