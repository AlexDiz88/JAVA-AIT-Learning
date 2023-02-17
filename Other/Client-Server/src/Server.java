import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket; // сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004); // серверсокет прослушивает порт 1111
                System.out.println("Сервер запущен"); // объявляем о запуске сервера
                clientSocket = server.accept(); // accept() будет ждать пока кто-нибудь не захочет подключиться
                try {
                    // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода. Теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String word = in.readLine(); // ждем пока клиент что-нибудь напишет
                    System.out.println(word); // выводим в консоль введенное слово
                    // отвечаем клиенту от сервера
                    out.write("Это Сервер! Подтверждаю, Вы написали : " + word + "\n");
                    out.flush();
                } finally {
                    // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    out.close();
                    in.close();
                }
            } finally {
                System.out.println("Сервер закрыт");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
