mimport java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice = 0;

        System.out.println("Entrez 1 pour auteur, 2 pour livre ou 3 pour thème.");
        choice = input.nextInt();
        if (choice == 1) {
            System.out.println(
                    "Que souhaitez-vous faire ? Entrez 1 pour ajouter un auteur, 2 pour modifié un auteur ou 3 pour supprimer un auteur.");

            int choiceAuteur = input.nextInt();
            input.nextLine();
            if (choiceAuteur == 1) {
                System.out.println("Saisissez les informations de l'auteur en commençant par son nom");
                String nomAuteur = input.nextLine();
                System.out.println("Son prénom");
                String prenomAuteur = input.nextLine();
                System.out.println("sa nationalité");
                String nationaliteAuteur = input.nextLine();
                System.out.println("sa date de naissance.");
                String dateNaissanceAuteur = input.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date newDateNaissance = format.parse(dateNaissanceAuteur);
                Auteur ajoutAuteur = new Auteur(null, nomAuteur, prenomAuteur, nationaliteAuteur, newDateNaissance);
                Auteur.insertAuteur(ajoutAuteur);
                Auteur.DisplayAuteur(ajoutAuteur);
            } else if (choiceAuteur == 2) {
                System.out.println("Saisissez l'ID de l'auteur a modifié.");
                Auteur.DisplayAuteur(input.nextInt());
                input.nextLine();
                System.out.println("Saisissez les nouvelles informations de lauteur en commançant par son nom,");
                String newNomAuteur = input.nextLine();
                System.out.println("Son prénom,");
                String newPrenomAuteur = input.nextLine();
                System.out.println("sa nationalité,");
                String newNationaliteAuteur = input.nextLine();
                System.out.println("son identifiant uniquement constitué de chiffre,");
                Integer newId = input.nextInt();
                System.out.println("sa date de naissance.");
                String newDateNaissanceAuteur = input.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date newDateNaissance = format.parse(newDateNaissanceAuteur);
                Auteur updateAuteur = new Auteur(newId, newNomAuteur, newPrenomAuteur, newNationaliteAuteur,
                        newDateNaissance);
                Auteur.UpdateAuteur(updateAuteur);

            } else if (choiceAuteur == 3) {
                System.out.println("Saisissez l'id de l'auteur a supprimer.");
                Auteur.DisplayAuteur(input.nextInt());
                input.nextLine();
                System.out.println("Saisissez les informations de l'auteur, en commençant par le nom.");
                String nom = input.nextLine();
                System.out.println("le prénom,");
                String prenom = input.nextLine();
                System.out.println("la nationalité,");
                String nationalite = input.nextLine();
                System.out.println("l'identifiant, constitué uniquement de chiffre,");
                Integer id = input.nextInt();
                input.nextLine();
                System.out.println("sa date de naissance.");
                String dateNaissance = input.nextLine();

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date newDatenaissance = format.parse(dateNaissance);
                Auteur delete = new Auteur(id, nom, prenom, nationalite, newDatenaissance);
                Auteur.DisplayAuteur(delete);
                Auteur.DeleteAuteur(id);
                Auteur.DisplayAuteur(id);

            }
        } else if (choice == 2) {
            System.out.println(
                    "Que souhaitez-vous faire ? entrez 1 pour ajouté un livre, 2 pour modifié un livre ou 3 pour supprimer un livre.");
            int choiceLivre = input.nextInt();
            if (choiceLivre == 1) {
                System.out.println(
                        "Saisissez les informations du livre à ajouter en commençant par l'année de publication,");
                Integer anneePublicationLivre = input.nextInt();
                input.nextLine();
                System.out.println("le titre,");
                String titrelivre = input.nextLine();
                System.out.println("la langue.");
                String langueLivre = input.nextLine();
                Livre newLivre = new Livre(null, anneePublicationLivre, titrelivre, langueLivre);
                Livre.InsertLivre(newLivre);
                Livre.DisplayLivre(newLivre);

            } else if (choiceLivre == 2) {
                System.out.println("Saisissez l'id du livre a modifié.");
                Livre.DisplayLivre(input.nextInt());
                System.out.println(
                        "Saisissez les nouvelles informations du livre en commençant par l'id uniquement constitué de chiffre,");
                Integer newId = input.nextInt();
                System.out.println("l'année de publication,");
                Integer newAnneePublication = input.nextInt();
                input.nextLine();
                System.out.println("le titre,");
                String newTitreLivre = input.nextLine();
                System.out.println("la langue.");
                String newLangueLivre = input.nextLine();
                Livre updateLivre = new Livre(newId, newAnneePublication, newTitreLivre, newLangueLivre);
                Livre.UpdateLivre(updateLivre);
                Livre.DisplayLivre(updateLivre);

            } else if (choiceLivre == 3) {
                System.out.println("Saisissez l'id du livre a supprimer.");
                Livre.DisplayLivre(input.nextInt());
                System.out.println("Saisissez les informations du livre en commençant par l'id,");
                Integer id = input.nextInt();
                System.out.println("l'année de publication");
                Integer anneePublication = input.nextInt();
                input.nextLine();
                System.out.println("le titre,");
                String titre = input.nextLine();
                String langue = input.nextLine();
                Livre deleteLivre = new Livre(id, anneePublication, titre, langue);
                Livre.DisplayLivre(deleteLivre);
                Livre.DeleteLivre(id);
                Livre.DisplayLivre(id);

            }

        }

        else if (choice == 3) {
            System.out
                    .println("Entrez 1 pour ajouter un thème, 2 pour modifier un thème ou 3 pour supprimer un thème.");
            int choiceTheme = input.nextInt();
            input.nextLine();
            if (choiceTheme == 1) {
                System.out.println("Saisissez le libellé du thème que vous souhaitez ajouter.");
                String libelleTheme = input.nextLine();
                Theme newTheme = new Theme(null, libelleTheme);
                Theme.InsertTheme(newTheme);
                Theme.DisplayTheme(newTheme);

            } else if (choiceTheme == 2) {
                System.out.println("Saisissez l'id du thème que vous souhaitez modifier.");
                Theme.DisplayTheme(input.nextInt());
                System.out.println("Saisissez l'id.");
                Integer newId = input.nextInt();
                input.nextLine();
                System.out.println("saisissez le libellé");
                String newLibelleTheme = input.nextLine();
                Theme updateTheme = new Theme(newId, newLibelleTheme);
                Theme.UpdateTheme(updateTheme);
                Theme.DisplayTheme(updateTheme);
            } else if (choiceTheme == 3) {
                System.out.println("Saisissez l'id du thème à supprimer.");
                Theme.DisplayTheme(input.nextInt());
                System.out.println("Saisissez l'id.");
                Integer themeId = input.nextInt();
                input.nextLine();
                System.out.println("Saisissez le libellé.");
                String libelleTheme = input.nextLine();
                Theme deleteTheme = new Theme(themeId, libelleTheme);
                Theme.DisplayTheme(deleteTheme);
                Theme.DeleteTheme(themeId);
                Theme.DisplayTheme(themeId);

            }

        }
    }
}
