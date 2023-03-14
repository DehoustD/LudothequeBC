    

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassDb implements AutoCloseable{
    private  String DB_URL = "jdbc:mariadb://localhost:3306/";
    private  String USER = "new_user";
    private  String PASS = "password1";

    private Connection con;
// Connection à la base de données Livreaudio
    public ClassDb() {
        this("livreaudio");
    }

    // Constructeur
    public ClassDb(String db_name) {
        try {
            this.DB_URL += db_name;
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Impossible de se connecter à la base de données:" + e.getMessage());
        }
    }
// getters

public String getDB_URL() {
        return this.DB_URL;
    }

    public String getUSER() {
        return this.USER;
    }

    public String getPASS() {
        return this.PASS;
    }

    public Connection getConnection() {
        return con;
    }

    @Override
    public void close() throws Exception {
        if (this.con != null) {
            this.con.close();
        }
    }
}