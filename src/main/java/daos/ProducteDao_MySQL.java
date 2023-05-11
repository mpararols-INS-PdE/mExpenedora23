package daos;

import model.Producte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducteDao_MySQL implements Dao<Producte> {

    //Dades de connexió a la base de dades      //TODO: llegir les propietats de la BD d'un fitxer de configuració (Properties)
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_ROUTE = "jdbc:mysql://localhost:3306/expenedora";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "1234";

    private Connection conn = null;

    public ProducteDao_MySQL()
    {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_ROUTE, DB_USER, DB_PWD);
            System.out.println("Conexió establerta satisfactoriament");
        } catch (Exception e) {
            System.out.println("S'ha produit un error en intentar connectar amb la base de dades. Revisa els paràmetres");
            e.printStackTrace();
        }
    }

    @Override
    public Producte get(String primaryKey) {
        return null;
    }

    @Override
    public List<Producte> getAll() throws SQLException {

        List<Producte> productes = new ArrayList<>();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM producte");

        while (rs.next()) {
            Producte p = new Producte();
            p.setCodiProducte(rs.getString("codi_producte"));
            p.setNom(rs.getString("nom"));
            p.setDescripcio(rs.getString("descripcio"));
            p.setPreuCompra(rs.getFloat("preu_compra"));
            p.setPreuVenta(rs.getFloat("preu_venta"));
            productes.add(p);
        }
        return productes;
    }

    @Override
    public void save(Producte producte) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("INSERT INTO producte (codi_producte, nom, descripcio, preu_compra, preu_venta) VALUES (?,?,?,?,?)");

        ps.setString(1,producte.getCodiProducte());
        ps.setString(2,producte.getNom());
        ps.setString(3,producte.getDescripcio());
        ps.setFloat(4,producte.getPreuCompra());
        ps.setFloat(5,producte.getPreuVenta());

        int rowCount = ps.executeUpdate();      //TODO: necessitem recuperar el return?

    }

    @Override
    public void update(Producte producte) {

    }

    @Override
    public void delete(Producte producte) {

    }
}
