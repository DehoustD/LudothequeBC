<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<!DOCTYPE html>

<!-- login.jsp réalisé par Bru. -->
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>S'enregistrer</title>
</head>
<body>

	<jsp:include page="header.html"/>

    <jsp:include page="navBar.html"/>

	<!-- la balise h1 est à inclure dans la navBar -->

	<h1>Travail de fin d'etude BlindCode Mons 2023</h1>

	<h2>S'enregistrer</h2>

	<form action="backRegister.jsp" id="inscription" name="inscription">

		<fieldset>

			<legend>Formulaire d'inscription :</legend>

			<p>

				<label for="prenom">Prénom :</label>

				<input type="text" name="prenom" id="prenom" autofocus required>
			</p>

			<p>

				<label for="nom">Nom :</label>

				<input type="text" name="nom" id="nom" required>
			</p>

			<p>

				<label for="email">e-Mail :</label>

				<input type="email" name="email" id="email">

				<br aria-hidden="true"><small>Exemple : jean.dupont@mail.com</small>
			</p>

			<p>

				<label for="mp">Tapez votre mot de passe :</label>

				<input type="password" name="mp" id="mp" required>
			</p>

			<p>

				<label for="mp">Retapez votre mot de passe :</label>

				<input type="password" name="mp" id="mp" required>
			</p>
		</fieldset>

		<fieldset>

			<h2>Pour le téléchargement possible des livres audio, êtes-vous déficients visuels ? Si oui, préparez dans vos fichiers la copie de votre carte qui le prouve !!</h2>

		<p>

			Oui<input type="radio" name="vue" value="oui">

			Non<input type="radio" name="vue" value="non">
		</p>


	</fieldset>

		<fieldset>

			<input type="submit" name="valid" id="valid" value="Je m'inscris">
		</fieldset>

	</form>

	<jsp:include page="footer.html"/>

</body>
</html>