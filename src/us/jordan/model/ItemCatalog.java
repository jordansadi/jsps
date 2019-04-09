package us.jordan.model;

import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ItemCatalog extends HttpServlet {
    private static List<Item> itemList = new ArrayList<>();

    public ItemCatalog() {
        addItems();
    }

    public static void addItems() {
        final String DB_URL = "jdbc:derby:ProductsDB";
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Products";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Item toAdd = new Item(0, "", 0);

                String pn  = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String name = rs.getString("Description");

                toAdd.setProductNumber(Integer.parseInt(pn));
                toAdd.setName(name);
                toAdd.setPrice(price);

                itemList.add(toAdd);
             }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static Item getItem(int i) {
        Item theItem = null;

        for (Item itemName : itemList) {
            if (itemName.getProductNumber() == i) {
                theItem = itemName;
            }
        }
        return theItem;
    }

    public List<Item> getAllItems() { return itemList; }
}
