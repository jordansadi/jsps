package us.jordan.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public CreateDB() {
        try {
            final String DB_URL = "jdbc:derby:ProductsDB;create=true";

            Connection conn = DriverManager.getConnection(DB_URL);

            dropTables(conn);
            buildProductsTable(conn);
            buildCartTable(conn);

            conn.close();
        } catch (Exception e) {
            System.out.println("Error creating the table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            try {
                stmt.executeQuery("DROP TABLE Products");

                stmt.executeQuery("DROP TABLE Cart");
            } catch (SQLException ex) {
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void buildProductsTable(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Products (" +
                    "Description CHAR(25), " +
                    "ProdNum INT NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'MilwaukeeHome Shirt', " +
                    "1, " +
                    "30.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Wiskullsin Shirt', " +
                    "2, " +
                    "30.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Giltee Shirt', " +
                    "3, " +
                    "30.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Fern & Nettle Soap', " +
                    "4, " +
                    "8.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Tactile Craftworks Wallet', " +
                    "5, " +
                    "15.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Dear Darlington Jewelry', " +
                    "6, " +
                    "20.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Paper Pleasers Mug', " +
                    "7, " +
                    "12.99 )");

            stmt.execute("INSERT INTO Products VALUES ( " +
                    "'Indulgence Chocolate', " +
                    "8, " +
                    "6.99 )");

        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private static void buildCartTable(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Cart (" +
                    "CartPlace INT NOT NULL PRIMARY KEY," +
                    "Description CHAR(25), " +
                    "ProdNum INT, " +
                    "Price DOUBLE " +
                    ")");

        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}