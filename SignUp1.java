
package finalProject1;

//import static finalProject.LogIn1.name;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SignUp1 extends javax.swing.JFrame {
 String Pass; public static int us;
 String un=Database.uname, up=Database.upass;
    /**
     * Creates new form SignUp
     */
    public SignUp1() {
        initComponents();
         
        ComboBoxStudTeacher.addItem(" - ");
        ComboBoxStudTeacher.addItem("Student");
        ComboBoxStudTeacher.addItem("Teacher");
        Toolkit toolkit= getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2 );
        
        
    }
    
     public void SignUpTeacher()
     {
         Statement Stat;
     String URL;
     ResultSet RS;
     
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL= "jdbc:sqlserver://localhost:1433;databasename=CourseManagement";
                   
            Connection Con=DriverManager.getConnection(URL,un,up);
            String sqltxt="SELECT * FROM TblTeacher";
            Stat= Con.createStatement(); 
            RS=Stat.executeQuery(sqltxt);
            if (IsDuplicateSignUp("Teacher")==1)
            {
                  JOptionPane.showMessageDialog(null, "Username Already Exists!");
            }
            else 
            {
                if (!RS.isAfterLast()){
               
              sqltxt="INSERT INTO TblTeacher VALUES ('" 
                      + UsernameTextField.getText()  + "','" 
                      + Pass  + "','"
                      + FirstNameTextField.getText() + "','"
                      + LastNameTextField.getText()  + "','"
                      + EmailTextField.getText()     + "',0x010203)";
              
          }else {
               sqltxt="UPDATE TblTeacher SET " 
                       + "FName= '"     + FirstNameTextField.getText()
                       + "',Lname='"    + LastNameTextField.getText() + "'," 
                       + "Email = '"    + EmailTextField.getText() + "'," 
                       + "TUName = '"   + UsernameTextField.getText() + "'," 
                       + "TPass = '"    + Pass + "', Picture = 0x010203";
      }
            
          Stat=Con.createStatement();
          Stat.execute(sqltxt);
          sqltxt="SELECT TID,TUName FROM TblTeacher WHERE TUName='"+UsernameTextField.getText()+"'";
          RS=Stat.executeQuery(sqltxt);
          RS.next();
          int tid=RS.getInt(1);
          Con.close();
           
                 JOptionPane.showMessageDialog(null, "Sign Up Succesful");
                 Database.AddTNotification(tid, "Welcome to Birana");
                  this.dispose();
                   LogIn1.main(null);
            }       
       }catch (ClassNotFoundException | SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage());
               JOptionPane.showMessageDialog(null, "Sign Up Unsuccesful"); 
               }
       finally{
        
       }
     }
public void SignUpStudent()
{
  Statement Stat;
     String URL;
     ResultSet RS;
     
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL= "jdbc:sqlserver://localhost:1433;databasename=CourseManagement";
                   
            Connection Con=DriverManager.getConnection(URL,un,up);
            String sqltxt="SELECT * FROM TblStudent";
            Stat= Con.createStatement(); 
            RS=Stat.executeQuery(sqltxt);
            if (IsDuplicateSignUp("Student")==1)
            {
                  JOptionPane.showMessageDialog(null, "Username Already Exists!");
            }
            else 
            {
                if (!RS.isAfterLast()){
               
              sqltxt="INSERT INTO TblStudent VALUES ('" 
                      + UsernameTextField.getText()  + "','" 
                      + Pass  + "','"
                      + FirstNameTextField.getText() + "','"
                      + LastNameTextField.getText()  + "','"
                      + EmailTextField.getText()     + "',Default)";
              
          }else {
               sqltxt="UPDATE TblStudent SET " 
                       + "FName= '"     + FirstNameTextField.getText()
                       + "',Lname='"    + LastNameTextField.getText() + "'," 
                       + "Email = '"    + EmailTextField.getText() + "'," 
                       + "SUName = '"   + UsernameTextField.getText() + "'," 
                       + "SPass = '"    + Pass + "', Picture = Default";
      }
            
          Stat=Con.createStatement();
          Stat.execute(sqltxt);
          sqltxt="SELECT SID,SUName FROM TblStudent WHERE SUName='"+UsernameTextField.getText()+"'";
          RS=Stat.executeQuery(sqltxt);
          RS.next();
          int sid=RS.getInt(1);
          Con.close();
           
                 JOptionPane.showMessageDialog(null, "Sign Up Succesful");
                 Database.AddSNotification(sid, "ROOT", "Welcome to Birana");
                  this.dispose();
                   LogIn1.main(null);
            }       
       }catch (ClassNotFoundException | SQLException ex){
               JOptionPane.showMessageDialog(null, "Sign Up Unsuccesful"); 
               }
       finally{
        
       }
}  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        FirstNameTextField = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        UsernameTextField = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        lblIAmA = new javax.swing.JLabel();
        ComboBoxStudTeacher = new javax.swing.JComboBox<>();
        btnSignUp = new javax.swing.JButton();
        LastNameTextField = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        logo1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAvailable1 = new javax.swing.JLabel();
        lblAvailable2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        FirstNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        FirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(FirstNameTextField);
        FirstNameTextField.setBounds(30, 80, 220, 30);

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setText("First Name");
        jPanel1.add(lblFirstName);
        lblFirstName.setBounds(30, 50, 220, 30);

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("Email");
        jPanel1.add(lblEmail);
        lblEmail.setBounds(30, 170, 220, 30);

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setText("Username");
        jPanel1.add(lblUsername);
        lblUsername.setBounds(30, 240, 220, 30);

        EmailTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(EmailTextField);
        EmailTextField.setBounds(30, 200, 220, 30);

        UsernameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        UsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(UsernameTextField);
        UsernameTextField.setBounds(30, 270, 220, 30);

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPassword.setText("Password");
        jPanel1.add(lblPassword);
        lblPassword.setBounds(30, 300, 220, 30);

        passwordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(passwordField);
        passwordField.setBounds(30, 330, 220, 30);

        lblIAmA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIAmA.setForeground(new java.awt.Color(255, 255, 255));
        lblIAmA.setText("Title");
        jPanel1.add(lblIAmA);
        lblIAmA.setBounds(50, 380, 36, 23);

        ComboBoxStudTeacher.setModel(ComboBoxStudTeacher.getModel());
        ComboBoxStudTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStudTeacherActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxStudTeacher);
        ComboBoxStudTeacher.setBounds(90, 380, 130, 30);

        btnSignUp.setBackground(new java.awt.Color(0, 0, 51));
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51)));
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp);
        btnSignUp.setBounds(30, 430, 220, 35);

        LastNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(LastNameTextField);
        LastNameTextField.setBounds(30, 140, 220, 30);

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLastName.setText("Last Name");
        jPanel1.add(lblLastName);
        lblLastName.setBounds(30, 110, 220, 30);

        lblSignUp.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUp.setText("SIGN UP");
        jPanel1.add(lblSignUp);
        lblSignUp.setBounds(100, 10, 90, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalProject1/Space-PNG-HD.png"))); // NOI18N
        jLabel8.setText("jLabel7");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(-10, -10, 290, 540);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(670, -10, 280, 530);

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("orange juice", 2, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("EASY TO USE");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(390, 50, 170, 30);

        jLabel16.setBackground(new java.awt.Color(255, 0, 0));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Create an account , choose your Teacher and");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(290, 80, 340, 20);

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("get access to an updated course material");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(310, 100, 300, 20);

        jLabel21.setBackground(new java.awt.Color(255, 0, 0));
        jLabel21.setFont(new java.awt.Font("orange juice", 2, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 0, 0));
        jLabel21.setText("EASY TO USE");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(390, 50, 150, 30);

        btnLogIn.setText("BACK");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogIn);
        btnLogIn.setBounds(0, 0, 70, 30);

        jLabel22.setBackground(new java.awt.Color(255, 0, 0));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("with just a click of a button.");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(360, 120, 220, 20);

        jPanel2.setLayout(null);

        logo1.setBackground(new java.awt.Color(255, 0, 0));
        logo1.setFont(new java.awt.Font("Starcruiser", 2, 36)); // NOI18N
        logo1.setForeground(new java.awt.Color(0, 0, 102));
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalProject1/download (1).png"))); // NOI18N
        jPanel2.add(logo1);
        logo1.setBounds(190, 170, 260, 210);

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("orange juice", 2, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ALL IN ONE ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(110, 380, 140, 30);

        jLabel19.setBackground(new java.awt.Color(255, 0, 0));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("start catching up with your lecturer");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(40, 450, 260, 20);

        jLabel20.setBackground(new java.awt.Color(255, 0, 0));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("No worries at all! choose your Course and");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(20, 430, 320, 20);

        jLabel18.setBackground(new java.awt.Color(255, 0, 0));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Freshman? Middleton? Senior?");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(60, 410, 240, 20);

        lblAvailable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAvailable1.setForeground(new java.awt.Color(204, 204, 204));
        lblAvailable1.setText("About Us");
        lblAvailable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvailable1MouseClicked(evt);
            }
        });
        jPanel2.add(lblAvailable1);
        lblAvailable1.setBounds(570, 460, 100, 20);

        lblAvailable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAvailable2.setForeground(new java.awt.Color(204, 204, 204));
        lblAvailable2.setText("@ 2019 Birana");
        lblAvailable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvailable2MouseClicked(evt);
            }
        });
        jPanel2.add(lblAvailable2);
        lblAvailable2.setBounds(550, 480, 100, 20);

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("orange juice", 2, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalProject1/bac4k.png"))); // NOI18N
        jLabel14.setText("BIRANA");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(0, 0, 680, 520);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 670, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameTextFieldActionPerformed

    private void FirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameTextFieldActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:
        LogIn1.main(null);
        this.dispose(); 
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
          char[] input = passwordField.getPassword();
           this.Pass=String.valueOf(input) ;
          if(ComboBoxStudTeacher.getSelectedIndex()== 0)
          {
                JOptionPane.showMessageDialog(null, "Please Choose your Title");  
          }
      
          else
          {
                      
        if(FirstNameTextField.getText().isEmpty()) 
        {
          JOptionPane.showMessageDialog(null, "First Name Cannot be Empty");  
        }
        else if(LastNameTextField.getText().isEmpty()) 
        {
          JOptionPane.showMessageDialog(null, "Last Name Cannot be Empty");  
        }
        else if( EmailTextField.getText().isEmpty()) 
        {
          JOptionPane.showMessageDialog(null, "Email Cannot be Empty");  
        }
        else   if(UsernameTextField.getText().isEmpty()) 
        {
          JOptionPane.showMessageDialog(null, "User Name Cannot be Empty");  
        }
          else  if( passwordField.getText().isEmpty()) 
        {
          JOptionPane.showMessageDialog(null, "Password Cannot be Empty");  
        }
           else   {
               if(ComboBoxStudTeacher.getSelectedIndex()== 1)
               {
                     SignUpStudent();
    }//GEN-LAST:event_btnSignUpActionPerformed
      if(ComboBoxStudTeacher.getSelectedIndex()== 2)
               {
                     SignUpTeacher();
               }                
          }
          }
          
    }
    
    
    
    
     private int IsDuplicateSignUp(String Title) {                                         
        // TODO add your handling code here:
     Statement Stat;
     String URL;
     ResultSet RS;
     int Flag=0;
     
     // ---- for checking duplicates
    // String FirstName=FirstNameTextField.getText(); ---- for checking duplicates
     //String UserPasswordLogin=LastNameTextField.getText();
     //String Email=EmailTextField.getText();
     String UserName=UsernameTextField.getText(); 
    // String Password=Pass;
     
     String un=Database.uname, up=Database.upass;
     if (Title=="Student")
     {
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL= "jdbc:sqlserver://localhost:1433;databasename=CourseManagement";
                   
            Connection Con=DriverManager.getConnection(URL,un,up);
            String  sqltxt="SELECT * FROM TblStudent WHERE SUName = " + "'"+UserName+"'" ;
            
            Stat= Con.createStatement(); 
            RS=Stat.executeQuery(sqltxt);
            
            
            if (RS.next())
           {
                
                Flag=1;
           }  
            else 
            { 
                Flag=0;
                
            }
            
            
           
             Con.close();
       }catch (ClassNotFoundException | SQLException ex){
            //   JOptionPane.showMessageDialog(null, "Sign Up Unsuccesfull"); 
               }
       finally{
       
      }}
     else if  (Title=="Teacher")
     {
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            URL= "jdbc:sqlserver://localhost:1433;databasename=CourseManagement";
                   
            Connection Con=DriverManager.getConnection(URL,un,up);
            String  sqltxt="SELECT * FROM TblTeacher WHERE TUName = " + "'"+UserName+"'" ;
            
            Stat= Con.createStatement(); 
            RS=Stat.executeQuery(sqltxt);
            
            
            if (RS.next())
           {
                
                Flag=1;
           }  
            else 
            { 
                Flag=0;
                
            }
            
            
           
             Con.close();
       }catch (ClassNotFoundException | SQLException ex){
            //   JOptionPane.showMessageDialog(null, "Sign Up Unsuccesfull"); 
               }
       finally{
       
      }   
     }
     
      return Flag;
     }
                
     

    private void UsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextFieldActionPerformed

    private void ComboBoxStudTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStudTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxStudTeacherActionPerformed

    private void lblAvailable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvailable1MouseClicked
        this.dispose();
        AboutUs.main(null);
        us=1;
    }//GEN-LAST:event_lblAvailable1MouseClicked

    private void lblAvailable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvailable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAvailable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxStudTeacher;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField FirstNameTextField;
    private javax.swing.JTextField LastNameTextField;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAvailable1;
    private javax.swing.JLabel lblAvailable2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblIAmA;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel logo1;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
