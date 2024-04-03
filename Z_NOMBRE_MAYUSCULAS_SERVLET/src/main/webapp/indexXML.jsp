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
				background-color:aqua;
				border:3px dotted green;
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

			<h1> CONVERSOR NOMBRE A MAYUSCULAS - MODO XML </h1>
	
	
			<br/><br/><br/>
			
			
			<!--  <form action="ConversorMayusculasServlet" method="GET" -->
			
			<form action="ConversorMayusculasServletXML" method="GET"			
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
					<pre class="rojo"> ${param.nombre} </pre>
				</div>
	
				<div>
					ATRIBUTO NOMBRE - XML: 
					<pre id="nombreXML" class="azul"></pre>
				</div>

			</fieldset>
			
			
			
			
			<script type="text/javascript">
			
				// SCRIPT PARA OBTENER Y TRANSFORMAR LA RESPUESTA DEL SERVLET:
			
				let xml = "${requestScope.nombre}";	// LA RESPUESTA DEBE IR ENTRE "" ... "${xxx}";				
				
				console.log("\nXML TEXTO = \t" + xml);
				
				//alert("XML TEXTO ... " + xml);
				
				
				//	CONVERTIR LA RESPUESTA (TEXTO) A UN OBJETO XML JAVASCRIPT PARA PODER 
				//		MANEJARLO CON EL API DOM:
				
				// https://es.stackoverflow.com/questions/550497/convertir-objeto-string-en-un-objeto-xml-en-javascript
				xml = new DOMParser().parseFromString(xml, 'application/xml');
					
				// EN LA PROPIEDAD responseXML DE UN NEGOCIADOR AJAX DISPONEMOS DE UN OBJETO XML DADO QUE HACE
				//		LA CON)				
				
				console.log("\nXML PURO = " + xml);
				
				//alert("XML PURO ... " + xml);

				
				// xml.getElementsByTagName("nombre")[0] 	...		<nombre>JUAN</nombre>	
				// 		.firstChild							...		JUAN
				// 			.data							...		"JUAN"
				
				
				// MÉTODO DOM:
				let nombreXML = xml.getElementsByTagName("nombre")[0].firstChild.data;

				console.log("\nEL NOMBRE OBTENIDO DE XML ... " + nombreXML);
				
				//alert("EL NOMBRE OBTENIDO DE XML ... " + elNombre);
				
				document.getElementById("nombreXML").innerText = nombreXML;
				
				/*
				
					VALOR DEL CAMPO nombre =  pepe
					
					SIN BLANCOS EN EXTREMOS = pepe
					
					XML TEXTO = 	<?xml version='1.0'?><datos><nombre>PEPE</nombre></datos>
					
					XML PURO = [object XMLDocument]
					
					EL NOMBRE OBTENIDO DE XML ... PEPE		
				
				*/
				
				
			</script>

		</div>

	</body>
	
</html>