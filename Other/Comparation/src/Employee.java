import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + " (" + salary + ")";
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id, o.id);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }
}

class idComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee1.getId(), employee2.getId());
    }
}

class firstNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getFirstName().compareTo(employee2.getFirstName());
    }
}

class lastNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getLastName().compareTo(employee2.getLastName());
    }
}

class salaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee1.getSalary(), employee2.getSalary());
    }
}
