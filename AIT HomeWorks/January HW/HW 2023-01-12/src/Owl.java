public class Owl implements MailDelivery{

    private String name = "Owl";

    @Override
    public void sendMail() {
        System.out.println("Feed the owl and give it a letter");
    }

    @Override
    public String name() {
        return name;
    }
}
