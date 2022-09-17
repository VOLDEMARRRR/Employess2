package humanResourses;

public interface EmployeeGroup {

    public String getName();

    public void setName(String name);

    public void addEmployee(Employee employee);

    public Employee getEmployee(String name, String surname);

    public boolean removeEmployee(String name, String surname);

    public boolean removeEmployee(Employee employee);

    public Employee richMan();

    public int numEmployee();

    public Employee[] getMasEmployee();

    public Employee[] getMasSortSalary();

    public String toString();

    public boolean equals(Object o);

    public int hashCode();
}
