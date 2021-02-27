
package addressbook;
import java.sql.*;

public class AddressBook {

    
    public static void main(String[] args) {
        String SQL="select*from ContactInfo ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook", "root", "1234");
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) { //move first row
               String id = rst.getString("ContactId");
                String first = rst.getString("FirstName");
                String last = rst.getString("LastName");
                String address = rst.getString("Address");
                int contact = rst.getInt("Contact");
                String email = rst.getString("EmailAddress");
                
                
                
                System.out.println(id + "\t" + first + "\t" + last + "\t" + address + "\t" +contact +"\t"+ email);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
            System.out.println(ex.getMessage());
            return;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
