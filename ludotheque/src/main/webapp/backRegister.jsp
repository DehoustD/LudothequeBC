bonjour <%= request.getParameter("prenom")%>
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
