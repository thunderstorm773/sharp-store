package sharpStore.models;

public class ReplyMessage {

    private String recipient;

    private String subject;

    private String content;

    public ReplyMessage() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String sender) {
        this.recipient = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
