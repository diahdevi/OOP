package main;

public abstract class Message {
    protected final ILogin login;
    protected final String sender;
    protected final String recipient;
    protected final String content;

    protected Message(ILogin login, String sender, String recipient, String content) {
        this.login = login;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public abstract void send(String username, String password);
}