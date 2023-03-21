<%
String prenom = request.getParameter("prenom");

String nom = request.getParameter("nom");

String mPasse = request.getParameter("mp");

String mPConfirm = request.getParameter("mp1");

if (mPasse.equals(mPConfirm)) {

out.println("Bonjour " + prenom + " " + nom);
}
else {

	out.println("Vos mots de passe sont différents ! Veuillez recommencer !\n Cliquer sur ce lien pour recommencer");
%>

<a href="register.jsp">Changer le mot de passe</a>
<%
}
%>
<p> bienvenue sur notre site !</p>

<%

if (request.getParameter("vue").equals("oui")) {
%>

	<p>
		<label for="ci">Veuillez choisir le fichier ou se trouve la copie de la carte(UNIQUEMENT Word ou pdf)</label>
		<input type="file" name="ci" id="ci" required accept=".doc, .docx, .pdf">
	</p>


<%
}
%>
