package consult;

import java.util.Objects;

public class Materials {
    String title;
    double price;
    String description;

    public Materials(String title, double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " " + description + " (" + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materials materials = (Materials) o;
        return Double.compare(materials.price, price) == 0 && Objects.equals(title, materials.title) && Objects.equals(description, materials.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, description);
    }

    public class Tools{
        public static void print() {
            System.out.println("aaaaaaaa");
        }
    }
}
