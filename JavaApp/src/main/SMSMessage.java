package main;

public class SMSMessage extends Message {
    public SMSMessage(ILogin login, String sender, String recipient, String content) {
        super(login, sender, recipient, content);
    }

    @Override
    public void send(String username, String password) {
        if (login.authenticate(username, password)) {
            System.out.printf("SMS sent from %s to %s: %s%n", 
                sender, recipient, content);
        } else {
            System.out.printf("SMS authentication failed for user: %s%n", username);
        }
    }
}
