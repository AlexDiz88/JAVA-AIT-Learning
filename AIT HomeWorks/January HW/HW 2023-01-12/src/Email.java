public class Email implements MailDelivery {

    private String name = "Email";

    @Override
    public void sendMail() {
        System.out.println("Write a letter and send it by E-mail");
    }

    @Override
    public String name() {
        return name;
    }


}
