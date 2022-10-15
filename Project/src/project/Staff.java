package classes;

class Staff {
    public String staffID;
    public String staffPass;
    public String staffName;
    public String staffIcNo;
    public String staffTelNo;
    public int role;
    
    public String getStaffID(){
        return staffID;
    }
    public String getStaffPass(){
        return staffPass;
    }
    public String getStaffName(){
        return staffName;
    }
    public String getStaffIcNo(){
        return staffIcNo;
    }
    public String getStaffTelNo(){
        return staffTelNo;
    }
    public int getRole(){
        return role;
    }
    public void setStaffID(String staffID){
        this.staffID = staffID;
    }
    public void setStaffPass(String staffPass){
        this.staffPass = staffPass;
    }
    public void setStaffName(String staffName){
        this.staffName = staffName;
    }
    public void setStaffIcNo(String staffIcNo){
        this.staffIcNo = staffIcNo;
    }
    public void setStaffTelNo(String staffTelNo){
        this.staffTelNo = staffTelNo;
    }
    public void setRole(int role){
        this.role = role;
    }
    public static void main (String[]args){
        
    }
}

class Guard extends Staff {
    public String guardName;
    
    public Guard(String staffID, String staffPass, String staffName, 
               String staffIcNo, String staffTelNo, int role, String guardName)
    {
        
    }
}



