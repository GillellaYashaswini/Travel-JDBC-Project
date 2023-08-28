import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {

    public static void CSVCustomer(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\travel\\Travel\\src\\Customer.csv"));
            String custLine;
            while ((custLine = reader.readLine()) != null) {
               CustomerDAO.createCustomer(new Customer(custLine));
            }
            reader.close();
        } 
        catch (IOException e) {
           System.out.println(e.getLocalizedMessage());
        }
    }
    public static void CSVPackage(){
        try {
            BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\travel\\Travel\\src\\Package.csv"));
            String PLine;
            while ((PLine = r.readLine()) != null) {
                PackageDAO.createPackage(new Package(PLine));
            }
            r.close();
        } 
        catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
    
    public static void main(String[] args) {
        CustomerDAO c=new CustomerDAO();
        PackageDAO p=new PackageDAO();
        Customer tom =new Customer("Tom", "St 6","TimeSquare",940284756,"S203");
        switch (args[0]) {
            case "-create":
              App.CSVCustomer();
              System.out.println();
              App.CSVPackage();
              break;
            case "-printcust":            
             c.dispaly();
            System.out.println();
            break;
            case "-printpackage":
            p.dispaly();
            System.out.println();
            break;
            case "-insert":
            CustomerDAO.createCustomer(tom);
            break;
            case "-updateC":
            CustomerDAO.updateCustomer(args);
            break;
            case "-updateP":
            PackageDAO.updatePackage(args);
            break;
            case "-delete":
            CustomerDAO.DeleteCustomer(args);
            break;
            case "-printsubstring":
            System.out.println("\nThe List of Customers whose Name has substring :");
            List<Customer> customers= CustomerDAO.getCustomerByName(args);
            customers.forEach(System.out::println);
            System.out.println();
            break;
            case "-printusingid":
            System.out.println("\nThe List of Packages whose Id is:");
            PackageDAO.getPackageById(args);
            System.out.println();
            break;
            case "-packsubstring":
            System.out.println("\nThe List of Packages which has substring :");
            List<Package> packages= PackageDAO.getPackageByDestination(args);
            packages.forEach(System.out::println);
            break;
            case "-gt":
            System.out.println("\nThe List of Customers whose package cost > 45k:");
            JoinDAO.searchByLimit(args);
            break;
            case "-equal":
            System.out.println("\nThe List of Customers whose package cost is :");
            JoinDAO.searchByValue(args);
            break;
            case "-count":
            JoinDAO.getCount(args);
            break;
            case "-sum":
             System.out.println("\nThe Sum is:");
            JoinDAO.Sum();
            break;
            case "-average":
            System.out.println("\nThe Avg is:");
            JoinDAO.Avg();
            break;
            case "Standard_deviation":
            System.out.println("\nThe Stddev is:");
            JoinDAO.StdDev();
            break;
            default:
            System.out.println("Please enter correct choice");
            break;
}
    }
}