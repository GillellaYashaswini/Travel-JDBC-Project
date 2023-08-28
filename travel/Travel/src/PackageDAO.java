import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO extends Display{
public static void createPackage(Package p){

    Connection con = ConnectionFactory.getConnection();
    final String SQL = "insert into Package values(?,?,?,?,?)";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
       stmt.setString(1,p.getPackageId());
       stmt.setInt(2,p.getNoOfpeople());
       stmt.setInt(3, p.getDays());
       stmt.setString(4, p.getDestination());
       stmt.setInt(5, p.getCost());
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" package rows created.");
    }
    catch(SQLException e){
        e.printStackTrace();
    }
}
public static void updatePackage(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "update Package set Cost=? where PackageId=?";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        int value=Integer.valueOf(args[1]);
       stmt.setInt(1,value);
       stmt.setString(2, args[2]); 
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" Package rows updated.");
    } catch(SQLException e){
        System.out.println(e.getLocalizedMessage());
    }
}
public static void DeletePackage(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "delete from package where PackageId=?";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
       stmt.setString(1,args[1]);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected+" package rows deleted.");
    } catch(SQLException e){
        e.printStackTrace();
    }
}
public static void getPackageById(String[] args){
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Package where PackageId = ?";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        stmt.setString(1,args[1]);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Package p = new Package(rs.getString("PackageId"),rs.getInt("NoOfPeople"),rs.getInt("Days"),rs.getString("Destination"),rs.getInt("Cost"));
            System.out.println(p);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
}
public static List<Package> getPackageByDestination(String[] args){
    List<Package>packages = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Package where Destination LIKE ? order by PackageId";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        stmt.setString(1,"%" +args[1] +"%");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Package p = new Package(rs.getString("PackageId"),rs.getInt("NoOfPeople"),rs.getInt("Days"),rs.getString("Destination"),rs.getInt("Cost"));
            packages.add(p);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return packages;
}

@Override
void dispaly() {
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from Package order by Cost";
    try(PreparedStatement stmt = con.prepareStatement(SQL)){
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
        System.out.println("[PackageId:"+rs.getString("PackageId")+",NoOfPeople"+rs.getInt("NoOfPeople")+",Days"+rs.getInt("Days")+",Destination:"+rs.getString("Destination")+",Cost:"+rs.getInt("Cost")+"]");
    } 
} catch(SQLException e){
        e.printStackTrace();
    }
    
}
}