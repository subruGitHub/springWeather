package com.example.springWeather;

public class Reporter {
    int rollNo;
 String fName;
 String lName;
 String emailID;

 public Reporter() {
     rollNo = 0;
     fName = "";
     lName = "";
     emailID = "";

 }
    public Reporter(int r, String f, String l, String e) {
        rollNo=r;
        fName = f;
        lName = l;
        emailID = e;

    }

    public String getEmailID() {
        return emailID;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

}
