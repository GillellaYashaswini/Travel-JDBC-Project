import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO extends Display{
public static void createCustomer(Customer cust){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "insert into Customer values(?,?,?,?,?)";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
       stmt.setString(1,cust.getName());
       stmt.setString(2, cust.getStreet());
       stmt.setString(3, cust.getArea()); 
       stmt.setInt(4, cust.getMobileNo());
       stmt.setString(5, cust.getPackageId());
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" customer rows created.");
    }
    catch(SQLException e){
        e.printStackTrace();
    }
}
public static void updateCustomer(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "update Customer set PackageId=? where Name=?";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
       stmt.setString(2,args[2]);
       stmt.setString(1,args[1]);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" customer rows updated.");
    } catch(SQLException e){
        e.printStackTrace();
    }
}
public static void DeleteCustomer(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "delete from customer where PackageId=?";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
       stmt.setString(1, args[1]);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" customer rows deleted.");
    } catch(SQLException e){
        e.printStackTrace();
    }
}
public static void getCustomerById(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Customer where PackageId = ? order by PackageId";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        stmt.setString(1, args[1]);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("[Area=" + rs.getString("Area") + ", MobileNo=" + rs.getInt("MobileNo") + ", Name=" + rs.getString("name") + ", PackageId=" + rs.getString("PackageId")
            + ", Street=" + rs.getString("Street") + "]");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
}
public static List<Customer> getCustomerByName(String[] args){
    List<Customer> customers = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Customer where name Like ? order by PackageId";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        stmt.setString(1, "%"+args[1]+"%");
        ResultSet rs = stmt.executeQuery();
       while(rs.next()){
            Customer cust = new Customer(rs.getString("name"),rs.getString("Street"),rs.getString("Area"),rs.getInt("MobileNo"),rs.getString("PackageId"));
            customers.add(cust);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return customers;
}
@Override
void dispaly() {
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Customer order by PackageId limit 2,6";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("[Area=" + rs.getString("Area") + ", MobileNo=" + rs.getInt("MobileNo") + ", Name=" + rs.getString("name") + ", PackageId=" + rs.getString("PackageId")
            + ", Street=" + rs.getString("Street") + "]");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    
}

}

