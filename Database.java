package finalProject1;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
    Statement stat;
    String URL;
    static String uname,upass;
    
    Database(String n,String p){
        uname=n;
        upass=p;
    }
    public String createTables(){
        String[] cmdtxts=new String[15];
        cmdtxts[0]="CREATE TABLE TblStudent(\n" +
                            "SID int primary key identity,\n" +
                            "SUName varchar(30) not null UNIQUE,\n" +
                            "SPass varchar(30) not null,\n" +
                            "FName varchar(30) not null,\n" +
                            "Lname varchar(30) not null,\n" +
                            "Email varchar(30) not null UNIQUE, \n" +
                            "Picture VARBINARY(MAX)  " +
                            ")";
        cmdtxts[1]="CREATE TABLE TblTeacher(\n" +
                            "TID int primary key identity, \n" +
                            "TUName varchar(30) not null UNIQUE,\n" +
                            "TPass varchar(30) not null,\n" +
                            "FName varchar(30) not null,\n" +
                            "LName varchar(30) not null,\n" +
                            "Email varchar(30) not null UNIQUE,\n" +
                            "Picture VARBINARY(MAX)  " +
                            ")";
        cmdtxts[2]="CREATE TABLE COURSES (\n"+
                        "CourseID int primary key identity,\n"+
                        "CourseName varchar(50) not null,\n"+
                        "Instructor varchar(30) foreign key references TblTeacher(TUName)\n"+
                        ")";
        cmdtxts[3]="CREATE TABLE Files(\n" +
                            "FID int primary key identity,\n" +
                            "FName varchar(100) not null,\n" +
                            "FPath varchar(150) not null, \n"+
                            "TUName varchar(30) not null,\n" +
                            "UploadDate date not null,\n" +
                            "UPFile varbinary(MAX) not null,\n" +
                            "CourseID int foreign key references COURSES(CourseID)\n"+
                            ")";
        cmdtxts[4]= "CREATE TABLE TakesCourses(\n" +
                            "SID int not null,\n" +
                            "CourseID int not null,\n" +
                            "primary key(SID,CourseID)\n" +
                            ")";
        cmdtxts[5]="CREATE TABLE Notifications(\n" +
                            "Nid int primary key identity, \n"+
                            "SID int not null,\n" +
                            "TUName varchar(30) not null,\n" +
                            "Notification varchar(150) not null,\n" +
                            "NDate Date not null \n"+
                            ")";
        cmdtxts[6]="CREATE TABLE TNotifications(\n" +
                            "Nid int primary key identity, \n"+
                            "TID int not null foreign key references TblTeacher(TID),\n" +
                            "Notification varchar(150) not null,\n" +
                            "NDate Date not null \n" +
                            ")";
        cmdtxts[7]="ALTER TABLE Files\n" +
                            "ADD CONSTRAINT fk_cour\n" +
                            "FOREIGN KEY (TUName) REFERENCES TblTeacher(TUName)";
        cmdtxts[8]="ALTER TABLE TakesCourses\n" +
                            "ADD CONSTRAINT fk_tkc1\n" +
                            "FOREIGN KEY (SID) REFERENCES TblStudent(SID)";
        cmdtxts[9]="ALTER TABLE TakesCourses\n" +
                            "ADD CONSTRAINT fk_tkc2\n" +
                            "FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)";
        cmdtxts[10]="ALTER TABLE Notifications\n" +
                            "ADD CONSTRAINT fk_not1\n" +
                            "FOREIGN KEY (SID) REFERENCES TblStudent(SID)";
        cmdtxts[11]="ALTER TABLE Notifications\n" +
                            "ADD CONSTRAINT fk_not2\n" +
                            "FOREIGN KEY (TUName) REFERENCES TblTeacher(TUName)";
        cmdtxts[12]="INSERT INTO TblTeacher VALUES ('ROOT','ROOT','ROOT','ROOT','ROOT',DEFAULT)";
        
        cmdtxts[13]="Alter Table TblStudent\n" +
                    "Add constraint Df_t\n" +
                    "Default 0x010203 FOR Picture ";
          cmdtxts[14]="Alter Table TblTeacher \n" +
                    "Add constraint Df_t\n" +
                    "Default 0x010203 FOR Picture ";
     
        String s = "";
        int index=0;
        while(index<15)
        {
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL="jdbc:sqlserver://localhost:1433;databaseName=courseManagement";
            Connection con=DriverManager.getConnection(URL,uname,upass);
            stat=con.createStatement();
            stat.execute(cmdtxts[index]);
            index++;
            
            }catch(Exception ex)
                {
                    index++;
                    //s=ex.getMessage();
                    //break;
                }finally{
                     // con.close();
                        }

        }
                return s;
    }
    public String createDB (){
        String e="";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL="jdbc:sqlserver://localhost:1433;databaseName=master";
            Connection con=DriverManager.getConnection(URL,uname,upass);
            String cmdtxt="CREATE DATABASE courseManagement";
            stat=con.createStatement();
            stat.execute(cmdtxt);
            con.close();

        }catch(Exception ex)
        {
           if((ex.getMessage()).equals("Database 'courseManagement' already exists. Choose a different database name."))
               ;
           else
                e=ex.getMessage();
           
        }finally{
            
        }
        return e;
    }
    public static void AddSNotification(int sid, String TUName, String Notification)
    {
        Statement stat;
        String query;
        PreparedStatement pstmt;
        String url;
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             url = "jdbc:sqlserver://localhost:1433;databaseName=courseManagement";
             Connection con = DriverManager.getConnection(url, uname, upass);
             stat = con.createStatement();
             query="INSERT INTO Notifications VALUES (?,?,?,?)";
             pstmt = con.prepareStatement(query);
             pstmt.setInt(1,sid);
             pstmt.setString(2, TUName);
             pstmt.setString(3, Notification);
             pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
             pstmt.executeUpdate();
             con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
     public static void AddTNotification(int tid, String Notification)
    {
        Statement stat;
        String query;
        PreparedStatement pstmt;
        String url;
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             url = "jdbc:sqlserver://localhost:1433;databaseName=courseManagement";
             Connection con = DriverManager.getConnection(url, uname, upass);
             stat = con.createStatement();
             query="INSERT INTO TNotifications VALUES (?,?,?)";
             pstmt = con.prepareStatement(query);
             pstmt.setInt(1,tid);
             pstmt.setString(2, Notification);
             pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
             pstmt.executeUpdate();
             con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    
}

