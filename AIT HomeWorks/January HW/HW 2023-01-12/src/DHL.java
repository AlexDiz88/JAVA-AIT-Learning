public class DHL implements MailDelivery{

    private String name = "DHL";

    @Override
    public void sendMail() {
        System.out.println("wrap a letter in an envelope");
    }

    @Override
    public String name() {
        return name;
    }
}
