
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Envoi de fichier</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<body>
	<form action="<c:url value="/upload" />" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Envoi de fichier</legend>

			<label for="description">Description du fichier</label> <input
				type="text" id="description" name="description" value="" /> <br />

			<label for="fichier">Emplacement du fichier <span
				class="requis">*</span></label> <input type="file" id="fichier"
				name="fichier" /> <br /> <input type="submit" value="Envoyer"
				class="sansLabel" /> <br />
		</fieldset>
	</form>
</body>
</html>