import java.sql.*;
import java.util.Date;;
public class Auteur {

    // propriétés

    private Integer id;
    private String nom, prenom, nationalite;
    private Date date_naissance;

    // constructeur

    public Auteur(Integer id, String nom, String prenom, String nationalite, Date date_naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.date_naissance = date_naissance;
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    // méthodes

    // ajout d'un auteur
    public static void insertAuteur(Auteur _auteur) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO auteur (nom, prenom, date_naissance, nationalite) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, _auteur.getNom());
            pstmt.setString(2, _auteur.getPrenom());
            java.sql.Date dateSql = new java.sql.Date(_auteur.date_naissance.getTime());
            pstmt.setDate(3, dateSql);
            pstmt.setString(4, _auteur.getNationalite());

            int _nbEnregistrement = pstmt.executeUpdate();

            if (_nbEnregistrement == 1) {
                System.out.println("L'auteur a bien été ajouté.");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    Integer id = rs.getInt("insert_id");
                    _auteur.id = id;
                }

            } else {
                System.out.println("Aucun auteur n'a été ajouté;");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // affichage de l'auteur en fonction de son ID
    public static void DisplayAuteur(Integer _id) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con
                    .prepareStatement("SELECT id, nom, prenom, date_naissance, nationalite FROM auteur WHERE id = ?");
            pstmt.setInt(1, _id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t\t" + rs.getString("nom") + "\t\t" + rs.getString("prenom") + "\t\t"
                                + rs.getDate("date_naissance") + "\t\t" + rs.getString("nationalite"));
            } else {
                System.out.println("Auteur non trouvé");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Affichage d'un auteur
    public static void DisplayAuteur(Auteur _Auteur) {
        System.out.println(_Auteur.toString());
    }

    // mise à jour d'un auteur
    public static void UpdateAuteur(Auteur _Auteur) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
                    "UPDATE auteurSEt nom =?, prenom =?, nationalite =?, date_naissance =? WHERE id =?");
            pstmt.setString(1, _Auteur.getNom());
            pstmt.setString(2, _Auteur.getPrenom());
            pstmt.setString(3, _Auteur.getNationalite());
            java.sql.Date dateSql = new java.sql.Date(_Auteur.date_naissance.getTime());
            pstmt.setDate(4, dateSql);
            pstmt.setInt(5, _Auteur.getId());
            int _nbEnregistrement = pstmt.executeUpdate();
            if (_nbEnregistrement == 1) {
                System.out.println("L'auteur a été modifié.");
            } else {
                System.out.println("Aucun auteur n'a été modifié.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // suppression d'un auteur en utilisant son ID
    public static void DeleteAuteur(Integer _id) {
        if (_id != null) {

            try (ClassDb db = new ClassDb()) {
                Connection con = db.getConnection();
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM auteur WHERE id =?");
                pstmt.setInt(1, _id);

                int _rowsDeleted = pstmt.executeUpdate();

                if (_rowsDeleted == 1) {
                    System.out.println("L'auteur a été supprimé avec succès.");

                } else {
                    System.out.println("Aucun auteur n'a été trouvé avec cet identifiant.");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Impossible de supprimer cet auteur.");
        }
    }

    @Override
    public String toString() {
        return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite
                + ", date_naissance=" + date_naissance + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auteur other = (Auteur) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (nationalite == null) {
            if (other.nationalite != null)
                return false;
        } else if (!nationalite.equals(other.nationalite))
            return false;
        if (date_naissance == null) {
            if (other.date_naissance != null)
                return false;
        } else if (!date_naissance.equals(other.date_naissance))
            return false;
        return true;
    }

}
