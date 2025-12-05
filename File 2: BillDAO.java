import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDAO {

    public void saveBill(String name, int units, double amount) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bills(consumer_name, units, amount) VALUES (?, ?, ?)"
            );

            ps.setString(1, name);
            ps.setInt(2, units);
            ps.setDouble(3, amount);

            ps.executeUpdate();
            System.out.println("Bill Saved Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
