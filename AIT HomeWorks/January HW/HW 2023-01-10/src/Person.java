public class Person {
    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    @Override
    public String toString() {
        String firstName = fName.length()==0 ? "" : fName.substring(0, 1);
        return String.format("%s %s., %d", lName, firstName, age);
    }

    public int getAge() {
        return age;
    }
}
