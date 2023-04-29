public class ClassImplPrinter implements Printer{
    @Override
    public void print(String msg) {
        System.out.println("Class implements Printer-interface");
        System.out.println(msg);
    }
}
