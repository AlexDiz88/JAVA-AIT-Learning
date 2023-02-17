/*
Предположим, ваша программа предоставляет пользователю возможность отослать письмо одним из 3 возможных способов:
DHL, E-Mail, Owl. Вам необходимо реализовать один общий метод отправки почты,
который в качестве параметра получает способ отправки почты. Реализация каждого из способов,
должна быть выполнена отдельным методом (каждый метод может просто выводить на экран соответствующее сообщения,
например, в случае DHL, что то типа: «кладу письмо в конверт, клею марку, иду на  почту»).
Выбор способа отправки определяется пользователем, например через Scanner
*/

public class Main {
    public static void main(String[] args) {
        MailDelivery [] services = {new DHL(), new Email(), new Owl()};
        MenuSelectMailService mailService = new MenuSelectMailService(services);
        MailDelivery service = mailService.select();
        service.sendMail();

    }

}
