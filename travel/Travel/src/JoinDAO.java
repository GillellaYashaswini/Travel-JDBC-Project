import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDAO {
    public static void searchByValue(String[] args){
        Connection con = ConnectionFactory.getConnection();
           
            final String SQL = "select * from Customer inner join package on Customer.PackageId=Package.PackageId and Package.Cost=? order by Package.Cost";
            try(PreparedStatement stmt = con.prepareStatement(SQL)){
              int value =Integer.valueOf(args[1]);
                stmt.setInt(1, value);
                ResultSet rs = stmt.executeQuery();
               if(rs.next()){
                    System.out.println("[Name:" +rs.getString("name") +", PackageId:"+rs.getString("PackageId") +", Cost:"+rs.getInt("Cost")+"]");
                }
                else{
                    System.out.println("Empty Set");
                }
        }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    public static void searchByLimit(String[] args){
    Connection con = ConnectionFactory.getConnection();
       
        final String SQL = "select * from Customer inner join package on Customer.PackageId=Package.PackageId and Package.Cost>? order by Package.Cost";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            int value =Integer.valueOf(args[1]);
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("[Name:" + rs.getString("name") +", PackageId:"+rs.getString("PackageId") +", Cost:"+rs.getInt("Cost")+"]");
            }
    }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void getCount(String[] args){
        Connection con = ConnectionFactory.getConnection();
        final String SQL ="select count(*) from "+args[1];
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
            int count=rs.getInt(1);
                System.out.println("\nNo Of Records in the table"+args[1]+" : "+count);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
 public static void Sum(){
        Connection con = ConnectionFactory.getConnection();
            final String SQL = "select sum(Cost) as 'Total Cost',sum(NoofPeople) as 'Total People',sum(Days) as 'Total Days' from Package inner join customer on Customer.PackageId=Package.PackageId";
            try(PreparedStatement stmt = con.prepareStatement(SQL)){
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
         System.out.println("[Total Cost:" +rs.getInt("Total Cost")+ ",Total NoOfPeople:" + rs.getInt("Total People") + ",Total Days:"+ rs.getInt("Total Days") +"]");
         } 
            } catch(SQLException e){
                e.printStackTrace();
            }
   }
     
   public static void Avg(){
    Connection con = ConnectionFactory.getConnection();
        final String SQL = "select avg(Cost) as 'Avg Cost',avg(NoofPeople) as 'Avg People',avg(Days) as 'Avg Days' from Package inner join customer on Customer.PackageId=Package.PackageId";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
     System.out.println("[Avg Cost:" +rs.getDouble("Avg Cost")+ ",Avg NoOfPeople:" + rs.getDouble("Avg People") + ",Avg Days:"+ rs.getDouble("Avg Days") +"]");
     } 
        } catch(SQLException e){
            e.printStackTrace();
        }
}
public static void StdDev(){
    Connection con = ConnectionFactory.getConnection();
        final String SQL = "select stddev(Cost) as 'StdDev Cost',stddev(NoofPeople) as 'StdDev People',stddev(Days) as 'StdDev Days' from Package inner join customer on Customer.PackageId=Package.PackageId";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
     System.out.println("[StdDev Cost:" +rs.getDouble("StdDev Cost")+ ",StdDev NoOfPeople:" + rs.getDouble("StdDev People") + ",StdDev Days:"+ rs.getDouble("StdDev Days") +"]");
     } 
        } catch(SQLException e){
            e.printStackTrace();
        }
}
    
  } 
