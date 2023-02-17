/*
Для жителей города "Observille" есть 3 новостных канала: "MainCityNews" "SportNews" и "IT-News".
Они рассылают новости через приложение.
- MainCityNews рассылают любую новость всем подписчикам автоматически. Любой житель автоматически становится подписчиком,
но имеет право отписаться в последствии. Также у MainCityNews есть особый тип новостей на предстоящие события в городе.
Эту рассылку можно активировать/отменить в приложении, нажав на кнопку switchOnEventsNotification / switchOffEventsNotification.
Изначально она выключена для всех подписчиков.
- SportNews рассылают все новости автоматически, но сначала нужно подписаться на рассылку.
- IT-News после подписки рассылают автоматически только "важные" новости. А "обычные" новости можно получить нажав на кнопку getRegularNews().
При нажатии отсылает 3 последних обычных новости.
Задача:
Реализовать систему подписки с возможностью для расширения (т.е. появления других новостных приложений)
 */

package PropertyChangeListener;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        City observille = new City("Observille");
        SocialMedia media1 = new MainCityNews();
        SocialMedia media2 = new SportNews();
        SocialMedia media3 = new ItNews();
        observille.setMainChannel(media1);
        observille.addChannels(List.of(media2, media3));

        // автоматическая подписка всех жителей на главный новостной канал при "регистрации" жителя в городе
        Citizen c1 = new Citizen("Jimmy", observille);
        Citizen c2 = new Citizen("Luc", observille);
        Citizen c3 = new Citizen("Thomas", observille);
        News n0 = new News("Идеальный день без происшествий", NewsType.MAIN_NEWS, NewsImportance.REGULAR_NEWS);
        media1.setNews(n0);

        // возможность отписаться от главных новостей города
        System.out.println("------------------");
        News n1 = new News("Обнаружены следы пришельцев возле озера", NewsType.MAIN_NEWS, NewsImportance.IMPORTANT_NEWS);
        media1.removeSubscriber(c2);
        media1.setNews(n1);

        // активация подписки на события города
        System.out.println("------------------");
        News n2 = new News("В ближайшую субботу пройдет выставка домашних животных", NewsType.EVENT_NEWS, NewsImportance.REGULAR_NEWS);
        c1.switchOnEventsNotification();
        c2.switchOnEventsNotification(); // активация подписки на события ничего не дала, т.к. житель не подписан на общую рассылку от этого субъекта
        media1.setNews(n2);

        // получение всех новостей от канала после подписки
        System.out.println("------------------");
        News n3 = new News("Местная футбольная команда победила главных конкурентов со счетом 4:2", NewsType.MAIN_NEWS, NewsImportance.REGULAR_NEWS);
        media2.addSubscriber(c2);
        media2.addSubscriber(c3);
        media2.setNews(n3);

        // получение IT-новостей (по степени важности)
        System.out.println("------------------");
        media3.addSubscriber(c3);
        News n4 = new News("Нейросеть выращивает морковь на 146% эффективнее", NewsType.MAIN_NEWS, NewsImportance.IMPORTANT_NEWS);
        media3.setNews(n4); // важная новость доставлена подписчику
        News n5 = new News("Чип вживили в собаку и она теперь читает газеты", NewsType.MAIN_NEWS, NewsImportance.REGULAR_NEWS);
        media3.setNews(n5); // обычную новость подписчик не получил

        // получение всех IT-новостей по запросу от пользователя (не более последних трёх)
        System.out.println("------------------");
        c3.getRegularItNews();
        c1.getRegularItNews(); // ничего не получает если не подписан (можно сделать чтобы получал вне зависимости о подписки)
    }
}
