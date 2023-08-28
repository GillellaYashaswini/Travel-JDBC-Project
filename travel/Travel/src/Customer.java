public class Customer {
    String Name;
    String Street;
    String Area;
    int MobileNo;
    String PackageId;
public Customer(String name, String street, String area, int mobileNo, String packageId) {
        Name = name;
        Street = street;
        Area = area;
        MobileNo = mobileNo;
        PackageId = packageId;
    }
    public Customer(String custline){
        String[] values=custline.split(",");
       Name=values[0];
       Street=values[1];
       Area=values[2];
       MobileNo=Integer.valueOf(values[3]);
       PackageId=values[4];
    }
    
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getStreet() {
        return Street;
    }
    public void setStreet(String street) {
        Street = street;
    }
    public String getArea() {
        return Area;
    }
    public void setArea(String area) {
        Area = area;
    }
    public int getMobileNo() {
        return MobileNo;
    }
    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }
    public String getPackageId() {
        return PackageId;
    }
    public void setPackageId(String packageId) {
        PackageId = packageId;
    }
    @Override
    public String toString() {
        return "[Area=" + Area + ", MobileNo=" + MobileNo + ", Name=" + Name + ", PackageId=" + PackageId
                + ", Street=" + Street + "]";
    }
    
}
