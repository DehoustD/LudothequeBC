import java.sql.*;

public class Theme {

    // propriétés

    private Integer id;
    private String libelle;

    // Constructeur

    public Theme(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Methodes
    // ajout d'un thème
    public static void InsertTheme(Theme _Theme) {
        try (ClassDb db = new ClassDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO theme(libelle) VALUES(?) ",
                    statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, _Theme.getLibelle());

            int _nbEnregistrement = pstmt.executeUpdate();
            if (_nbEnregistrement == 1) {
                System.out.println("Le thème a bien été ajouté.");
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    Integer id = rs.getInt("insert_id");
                    _Theme.id = id;
                }

            } else {
                System.out.println("Aucun thème n'a été ajouté;");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // affichage du thème
    public static void DisplayTheme(Theme _Theme) {
        System.out.println(_Theme.toString());

    }

    // mise à jour du thème
    public static void UpdateTheme(Theme _Theme) {
        try (ClassDb db = new classDb()) {
            Connection con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("UPDATE theme SET libelle =? WHERE id=?");
            pstmt.setString(1, _Theme.getLibelle());
            pstmt.setInteger(2, _Theme.getId());
            int _nbEnregistrement = pstmt.executeUpdate();
            if (_nbEnregistrement == 1) {
                System.out.println("Le thème a bien été modifié.");

            } else {
                System.out.println("Aucun thème n'a été modifié.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // suppression d'un thème en utilisant son ID
    public static void DeleteTheme(Integer _id) {
        if (_id != null) {
            try (ClassDb db = new ClassDb()) {
                Connection con = db.getConnection();
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM theme WHERE id =?");
                pstmt.setInteger(1, _id);
                int _rowsDeleted = pstmt.executeUpdate();
                if (_rowsDeleted == 1) {
                    System.out.println("Le thème a bien été supprimé.");

                } else {
                    System.out.println("Aucun thème n'a été supprimé.");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("Impossible de supprimer ce thème.");
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
        Theme other = (Theme) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Theme [id=" + id + ", libelle=" + libelle + "]";
    }

}
