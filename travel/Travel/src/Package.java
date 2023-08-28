public class Package {
   String PackageId;
   int NoOfpeople;
   int Days;
   String Destination;
   int Cost;

 public Package(String packageId, int noOfpeople, int days, String destination, int cost) {
    PackageId = packageId;
    NoOfpeople = noOfpeople;
    Days = days;
    Destination = destination;
    Cost = cost;
}
public Package(String Pline){
     String[] values=Pline.split(",");
     PackageId=values[0];
     NoOfpeople=Integer.valueOf(values[1]);
     Days=Integer.valueOf(values[2]);
     Destination=values[3];
     Cost=Integer.valueOf(values[4]);
 }
public String getPackageId() {
    return PackageId;
}
public void setPackageId(String packageId) {
    PackageId = packageId;
}
public int getNoOfpeople() {
    return NoOfpeople;
}
public void setNoOfpeople(int noOfpeople) {
    NoOfpeople = noOfpeople;
}

public int getDays() {
    return Days;
}
public void setDays(int days) {
    Days = days;
}
public String getDestination() {
    return Destination;
}
public void setDestination(String destination) {
    Destination = destination;
}
public int getCost() {
    return Cost;
}
public void setCost(int cost) {
    Cost = cost;
}
@Override
public String toString() {
    return " [Cost=" + Cost + ", Days=" + Days + ", Destination=" + Destination + ", NoOfpeople=" + NoOfpeople
            + ", PackageId=" + PackageId + "]";
}
 
}
