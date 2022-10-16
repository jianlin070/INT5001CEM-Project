package project;

public class Visitor {
    public String name;
    public String icNo;
    public String telNo;

    public String getName(){
        return name;
    }
    public String getIcNo(){
        return icNo;
    }
    public String gettelNo(){
        return telNo;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setIcNo(String icNo){
        this.icNo = icNo;
    }
    public void setTelNo(String telNo){
        this.telNo = telNo;
    }
    public void checkTicStatus(){
                
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Visitor visitor = new Visitor();
        visitor.setName("Name: ");
        visitor.setIcNo("Ic No: ");
        visitor.setTelNo("Tel No: ");
        //Additional Info:
        //Picture, Time, Date, Reason
    }
}
