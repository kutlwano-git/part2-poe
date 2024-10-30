/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pelot
 */

public class Login {
    String enteredUserName; 
    String enteredPassword; 
     String firstName ; 
     String surname ; 
   String password ; 
     String userName ; 
    public boolean checkUsername(){
        
    
   boolean check=false;
    for(int i=0; i<userName.length(); i++){
   if(userName.length() <=5){
       
   if((int)userName.charAt(i) ==95)
       check=true;
   }
    }
    return check;
   } 
    
     public boolean checkPasswordComplexity(){

         boolean CapitalLetter=false;  
  boolean Number =false;
  boolean Special=false;
 for(int i=0; i<password.length(); i++){
   if(password.length() >= 8){ 
   if((int)password.charAt(i) >65 &&(int)password.charAt(i) <=90) {
       CapitalLetter=true;
   }  
  if((int)password.charAt(i) >=48 &&(int)password.charAt(i) <=57){
       Number=true;
               }          
   if((int)password.charAt(i) >=33 &&(int)password.charAt(i) <=47 || 
           (int)password.charAt(i) >=58 &&(int)password.charAt(i) <=64 || 
           (int)password.charAt(i) >=91 &&(int)password.charAt(i) <=96 || 
           (int)password.charAt(i) >=123 &&(int)password.charAt(i) <=126)   
          Special=true;
   }

       
   }
return CapitalLetter && Number && Special;
}

                
    
  public String registerUser(){
 
  if(checkUsername()==true){
           System.out.println("Username succefully captured.");
       }else{
           System.out.println("Username is not correctly formatted,please ensure that your Username contains an underscore and is no more than 5 characters in length.");
       }   
       if(checkPasswordComplexity()==true){
           System.out.println("Password succefully captured.");
       }else{
           System.out.println("Password is not correctly formatted please ensure that the password contains atleast 8characters, a capital letter , a number and a special character.");
       }
           if(checkUsername()==true && (checkPasswordComplexity()==true)){
         System.out.println("The two above conditions have been met and the user has been registered succefully.");  
         
           }
         if(checkPasswordComplexity()==false){
               System.out.println("The Password does not meet the complexity requirements.");      
         }
     if(checkUsername()==false){
         System.out.println("The username is incorrectly formatted.");
         
     }
      

       return("") ;
}
 
  public boolean loginUser(){
      
 boolean Compare=false;
   
 if(userName.equals(enteredUserName) && (password.equals(enteredPassword))){
     
     Compare=true;
 }
    return Compare;
}
 
 public String returnLoginStatus(){
         
     
if(loginUser()==true) {
    
    
    System.out.println("succeful login");
    
        System.out.println("welcome " +" "+ firstName+" " +" "+ " "+surname+" " + " it is great to see you again " );

}
else{

     System.out.println("A failed login"); 
     System.out.println("Username or Password incorrect please try again");
            
}  
     

    return"";
} 
         
       
    public static void main(String[] args) {
        Login login = new Login();
        Task info = new Task();
        //this scanner allows the user to be able to reply
        Scanner input = new Scanner(System.in);

                 System.out.println("Register..........");
         System.out.println("Enter FirstName :");// prompt the user to enter to enter first name
           login.firstName=input.next();// holds the input from the user
System.out.println("Enter LastName :");// prompt the user to enter lastname
           login.surname=input.next();// holds the input from the user 
            System.out.println("Enter UserName :");// prompt the create || add a user name
                    login.userName=input.next();// holds the input from the user
           System.out.println("Enter Password :");// prompt the create || add a password
                    login.password=input.next();// holds the input from the user
                    
System.out.println(login.registerUser());  // return the message wheather the user registered sucefully or not 
while(login.checkUsername()==false || (login.checkPasswordComplexity()==false)){
    System.out.println("Try to register again!!!!!");
      System.out.println("Enter UserName :");// prompt the create || add a user name
                    login.userName=input.next();// holds the input from the user
           System.out.println("Enter Password :");// prompt the create || add a password
                    login.password=input.next();// holds the input from the user
                    System.out.println(login.registerUser());  // return the message wheather the user registered sucefully or not 

}
              System.out.println("Login..........");
              System.out.println("Enter Username :");// prompt the user to enter the username they used login 
     login.enteredUserName=input.next();// holds the input from the user
    System.out.println("Enter Password :");// prompt the user to enter the password they used login 
       login.enteredPassword=input.next();// holds the input from the user
       System.out.println(login.returnLoginStatus());// return the message wheather the user logged sucefully or not  
       
while(login.loginUser()==false){
    System.out.println(" Try to Login again ..........");
              System.out.println("Enter Username :");// prompt the user to enter the username they used login 
     login.enteredUserName=input.next();// holds the input from the user
    System.out.println("Enter Password :");// prompt the user to enter the password they used login 
       login.enteredPassword=input.next();// holds the input from the user
       
      System.out.println(login.returnLoginStatus());// return the message wheather the user logged sucefully or not  
          }
        if (login.loginUser()==true) { // if the user loggged in sucefully the code will the user to add tasks
            JOptionPane.showMessageDialog(null, "Welcome To EasyKanban");// the user will be welcomed if logged in sucefully
            int choice;
            do {
                
                info.input = JOptionPane.showInputDialog("Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");// allow the user to choose an option using numbers 
                choice = Integer.parseInt(info.input);

                switch (choice) {
                    case 1:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));// allow the user to enter the number of tasks they want to add
                        Task task = new Task();
                        int totalHours = 0;

                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name:");// prompt the user to enter a task name 
                            String taskDescription = JOptionPane.showInputDialog("Enter task description:");// prompt the user to enter a description 
                            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");// prompt the user to enter first name
                            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");// prompt the user to enter last name
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration:"));// prompt the user to enter task duration

                            String taskID = task.createTaskID(taskName, i, developerLastName);
                            String taskStatus = "";

        int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose the Status of this task from the three options.\n"
                + "1.To Do\n"
                + "2.Doing\n"
                + "3.Done"));// allow the user to choose the task status using the number
        switch(option){
            case 1:
                taskStatus = "To Do"; // if the user enter 1 the task status will be to do
                break;
            case 2:
                taskStatus = "Doing";// if the user enter 2 the task status will be doing
                break;
            case 3:
                taskStatus = "Done";// if the user enter 3 the task status will be done
                break;
        }     String taskDetails = task.printTaskDetails(taskStatus, developerFirstName, developerLastName,
                                    i, taskName, taskDescription, taskID, taskDuration);
                            JOptionPane.showMessageDialog(null, taskDetails);

                            totalHours += taskDuration;
                       //Display the whole task information entered by the user
                       
                        }

                        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);//Display the total hours of all tasks added
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");// if the user entered option 2 it will display the message coming soon
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting the application.");// if the user entered option 3 it will display the message Exiting the application
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");//if the user choose a wrong option it will display this message and continue running 
                        break;
                }
            } while (choice != 3);
        
        }
    }}