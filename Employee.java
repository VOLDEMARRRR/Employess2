package humanResourses;

import java.util.Objects;

public abstract class Employee {
    String name;
    String surname;
    JobTitlesEnum post;
    int salary;

    protected Employee(String name, String surname) {
        this(name, surname, JobTitlesEnum.NONE,0);
    }

    protected Employee(String name, String surname, JobTitlesEnum post, int salary) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.salary = salary;
    }

    public abstract int getPremium();
    public abstract void setPremium(int b);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public JobTitlesEnum getPost() {
        return post;
    }
    public void setPost(JobTitlesEnum post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String s = '"' + name + " " + surname + ", ";
        if (post != JobTitlesEnum.NONE) s += post + ", ";
        if (salary != 0) s += salary + "р.";
        return s + '"';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(post, employee.post);
    }

    @Override
    public int hashCode() {
        if (salary == 0) salary = 31;
        return name.hashCode()^surname.hashCode()^post.hashCode()^salary;
    }
}
