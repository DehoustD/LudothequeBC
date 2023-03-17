import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.*;
public class Pendu {
    private static List<String> mots = new ArrayList<>();

    static {
        mots.add("batman");
        mots.add("superman");
        mots.add("spiderman");
        mots.add("ironman");
        mots.add("sandman");
        mots.add("flash");
    }
    public static void main(String[] args) {
        System.out.println("Bonjour, et bienvenue dans ce jeu du pendu.\nPetit indice, ce jeu concerne des personnages des comics marvel et DC.");
        String motADeviner = choisirMot();
        String motActuel = initialiserMotActuel(motADeviner);

        System.out.println("Le mot à deviner contient " + motADeviner.length() + " lettres");

        int nbErreurs = 0;
        Scanner scanner = new Scanner(System.in);

        while (nbErreurs < 7 && !motADeviner.equals(motActuel)) {
            System.out.println("Le mot actuel est : " + motActuel);
            System.out.println("Entrez une lettre : ");

            String lettre = scanner.nextLine().toLowerCase();

            if (lettre.length() != 1) {
                System.out.println("Entrez une seule lettre.");
                continue;
            }

            if (motADeviner.contains(lettre)) {
                System.out.println("Bonne réponse !");
                motActuel = mettreAJourMotActuel(motADeviner, motActuel, lettre);
        trueAnswer();
            }
            else {
                System.out.println("Mauvaise réponse...");
                nbErreurs++;
                jouerSonErreur(nbErreurs);
            }
        }

        if (nbErreurs == 7) {
            System.out.println("Dommage, vous avez perdu. Le mot était : " + motADeviner);
        } else {
            System.out.println("Bravo, vous avez gagné !");
        }
    }
    public static void trueAnswer() {
        try {
            // Créer un File object représentant le fichier audio à lire
    File audioFile = new File("**/true.wav");
   
            // Obtenir un AudioInputStream à partir du fichier audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
   
            // Obtenir un Clip à partir de l'AudioInputStream
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
   
            // Jouer le son
            clip.start();
   
        // Attendre que le son soit terminé
       Thread.sleep(clip.getMicrosecondLength() / 1000);
   
         }
         catch (Exception ex) {
            System.out.println("Erreur lors de la lecture du fichier audio: " + ex.getMessage());
     }    
    }

    public static void falseAnswer() {
        try {
            // Créer un File object représentant le fichier audio à lire
            File audioFile = new File("**/false.wav");
   
            // Obtenir un AudioInputStream à partir du fichier audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
   
            // Obtenir un Clip à partir de l'AudioInputStream
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
   
            // Jouer le son
            clip.start();
   
        // Attendre que le son soit terminé
       Thread.sleep(clip.getMicrosecondLength() / 1000);
   
         }
         catch (Exception ex) {
            System.out.println("Erreur lors de la lecture du fichier audio: " + ex.getMessage());
     }       
    }
    public static String choisirMot() {
        return mots.get((int) (Math.random() * mots.size()));
    }

    public static String initialiserMotActuel(String mot) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static String mettreAJourMotActuel(String motADeviner, String motActuel, String lettre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre.charAt(0)) {
                sb.append(lettre);
            } else {
                sb.append(motActuel.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void jouerSonErreur(int nbErreurs) {
        // jouer un son différent en fonction du nombre d'erreurs
    }
}