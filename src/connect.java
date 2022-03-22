import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 * @author hector.barrio@universidadeuropea.es
 * 
 * Descargar sqlite-jdvc:
 * https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
 * 
 */
public class connect {
     /**
     * Conectarse a base de datos de ejemplo:
     */
    public static void connect() {
        Connection conn = null;
        try {
            // Parametros de la base de datos:
        	// SQLite string de conexion
        	// desde el directorio de trabajo.
        	String dir = System.getProperty("user.dir");
        	System.out.println(dir);
        	String dir_bdd = dir + "\\src\\database\\chinook.db";
        	String url = "jdbc:sqlite:" + dir_bdd;
            // Crear una conexion a la base de datos
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexion con SQLite establecida.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }    
    
    /**
     * @param args argumentos para linea de comandos:
     */
    public static void main(String[] args) {
        connect();
    }
}