import java.util.Scanner;

public class MenuSelectMailService {
    private MailDelivery[] services;

    public MenuSelectMailService(MailDelivery[] services) {
        this.services = services;
    }

    public MailDelivery select() {
        System.out.println("Select a service");
        for (int i = 0; i < services.length; i++) {
            System.out.printf("%d %s %n", i, services[i].name());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice < 0 || choice > services.length - 1) {
            return null;
        } else {
            return services[choice];
        }
    }
}
