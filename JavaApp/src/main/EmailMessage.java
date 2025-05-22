package main;

public class EmailMessage extends Message {
 public EmailMessage(ILogin login, String sender, String recipient, String content) {
     super(login, sender, recipient, content);
 }

 @Override
 public void send(String username, String password) {
     if (login.authenticate(username, password)) {
         System.out.printf("Email sent from %s to %s: %s%n", 
             sender, recipient, content);
     } else {
         System.out.printf("Email authentication failed for user: %s%n", username);
     }
 }
}