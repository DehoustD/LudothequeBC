import java.sql.*;

public class Livre {
    // propriétés

    private Integer id, anneePublication;
    private String titre, langue;

    // constructeur
    public Livre(Integer id, Integer anneePublication, String titre, String langue) {
        this.id = id;
        this.anneePublication = anneePublication;
        this.titre = titre;
        this.langue = langue;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    // méthodes
    // ajout d'un livre
    public static void InsertLivre(Livre _livre) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO livre (anneePublication, langue, titre) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setInteger(1, _livre.getAnneePublication());
            pstmt.setString(2, _livre.getTitre());
            pstmt.setString(3, _livre.getLangue());

            int _nbEnregistrement = pstmt.executeUpdate();

            if (_nbEnregistrement == 1) {
                System.out.println("Le livre a bien été ajouté.");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    Integer id = rs.getInt("insert_id");
                    _livre.id = id;
                }
            } else {
                System.out.println("Aucun livre n'a été ajouté.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

// affichage d'un livre en fonction de son ID

public static void DisplayLivre(Integer _id) {
    try (ClassDb db = new ClassDb()) {
        Connection con = db.getConnection();
        PreparedStatement pstmt = con
                .prepareStatement("SELECT id, anneePublication, titre, langue FROM livre WHERE id = ?");
        pstmt.setInt(1, _id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println(
                    rs.getInt("id") + "\t\t" + rs.getInt("anneePublication") + "\t\t" + rs.getString("titre") + "\t\t"
                            + rs.getString("langue"));
        } else {
            System.out.println("Livre non trouvé");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

    


    // affichage d'un livre
    public static void DisplayLivre(Livre _Livre) {
        System.out.println(_Livre.toString());
    }

    // mise à jour d'un livre
    public static void UpdateLivre(Livre _livre) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con
                    .prepareStatement("UPDATE _livre SET anneePublication=?, titre=?, langue=? WHERE id=?");
                    pstmt.setInt(1, _livre.getAnneePublication());
            pstmt.setString(2, _livre.getTitre());
            pstmt.setString(3, _livre.getLangue());
            pstmt.setInt(4, _livre.getId());
            int _nbEnregistrement = pstmt.executeUpdate();
            if (_nbEnregistrement == 1) {
                System.out.println("Le livre a été modifié.");
            } else {
                System.out.println("Aucun enregistrement n'a été modifié.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // suppression d'un livre en utilisant son ID

    public static void DeleteLivre(Integer _id) {
        if (_id != null) {
            try (ClassDb db = new ClassDb()) {
                Connection con = db.getConnection();
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM livre WHERE id =?");
                pstmt.setInt(1, _id);
                int _rowsDeleted = pstmt.executeUpdate();
                if (_rowsDeleted == 1) {
                    System.out.println("Le livre a bien été supprimé.");

                } else {
                    System.out.println("Aucun livre n'a été trouvé avec cet identifiant.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Impossible de supprimer ce livre.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livre other = (Livre) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (anneePublication == null) {
            if (other.anneePublication != null)
                return false;
        } else if (!anneePublication.equals(other.anneePublication))
            return false;
        if (titre == null) {
            if (other.titre != null)
                return false;
        } else if (!titre.equals(other.titre))
            return false;
        if (langue == null) {
            if (other.langue != null)
                return false;
        } else if (!langue.equals(other.langue))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Livre [id=" + id + ", anneePublication=" + anneePublication + ", titre=" + titre + ", langue=" + langue
                + "]";
    }

}