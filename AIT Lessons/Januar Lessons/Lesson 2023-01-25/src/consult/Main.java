package consult;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

public class Main {
    public static void main(String[] args) {

        HashSet<String> boots = new HashSet<>();
        boots.add("Timberlands");
        boots.add("Martens");
        boots.add("Nike sneakers");
        boots.add("Convers");
        boots.add("Nike Air");
        boots.add("Nike Air");
        System.out.println(boots);

        HashSet<Materials> materials = new HashSet<>();
        materials.add(new Materials("plank", 120, "very useful material"));
        materials.add(new Materials("concrete", 840, "a good material"));
        materials.add(new Materials("plank", 120, "very useful material"));
        System.out.println(materials);
        System.out.println(materials.contains(new Materials("plank", 120, "very useful material")));
        System.out.println(materials.contains(new Materials("plank", 130, "very useful material")));

        Iterator<Materials> iterator = materials.iterator();
        iterator.next();
        iterator = materials.iterator(); // обновить позицию итератора
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(materials);

        Spliterator<Materials> spliterator = materials.spliterator();
        System.out.println(spliterator);
        Materials.Tools.print();

    }
}
