import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 * @author hector.barrio@universidadeuropea.es
 */
public class SelectApp {

    /**
     * Conectarse a una base de datos de prueba en dir_bdd.
     * @return el objeto Connection, una conexion a la base de datos.
     */
    private Connection connect() {
        // SQLite string de conexion
    	// desde el directorio de trabajo.
    	String dir = System.getProperty("user.dir");
    	System.out.println(dir);
    	String dir_bdd = dir + "\\src\\database\\chinook.db";
    	String url = "jdbc:sqlite:" + dir_bdd;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * Seleccionar todos los atributos de la tabla albums:
     */
    public void selectAll(){
        String sql = "SELECT AlbumID, Title, ArtistID FROM albums";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // Iterar sobre los resultados e imprimir por consola:
            while (rs.next()) {
                System.out.println(rs.getInt("AlbumID") +  "\t" + 
                                   rs.getString("Title") + "\t" +
                                   rs.getInt("ArtistID"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args argumentos para linea de comando:
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}