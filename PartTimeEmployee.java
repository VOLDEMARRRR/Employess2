package humanResourses;

public class PartTimeEmployee extends Employee{

    public PartTimeEmployee(String name, String surname, JobTitlesEnum post, int salary) {
        super(name, surname, post, salary);
    }

    public PartTimeEmployee(String name, String surname) {
        super(name, surname);
    }

    @Override
    public int getPremium() {
        return 0;
    }

    @Override
    public void setPremium(int b) {
    }

    @Override
    public String toString() {
        String s = '"' + name + " " + surname + ", ";
        if (post != JobTitlesEnum.NONE) s += post + " (внешний совместитель), ";
        if (salary != 0) s += salary + "р.";
        return s + '"';
    }
}
