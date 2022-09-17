package humanResourses;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Project implements EmployeeGroup {
    String projectName;
    List<Employee> list;

    public Project(String projectName) {
        this.projectName = projectName;
        this.list = new ProjectList();
    }

    public Project(String projectName, Employee[] mas_employee) {
        this.projectName = projectName;
        this.list = new ProjectList(mas_employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        list.add(employee);
    } // работает

    @Override
    public Employee getEmployee(String name, String surname) {
        for (Employee employee : list) {
            if (employee.name.equals(name) && employee.surname.equals(surname)) {
                return employee;
            }
        }
        return null;
    } // работает

    @Override
    public boolean removeEmployee(String name, String surname) {
        for (Employee employee : list) {
            if (employee.name.equals(name) && employee.surname.equals(surname)) {
                list.remove(employee);
                return true;
            }
        }
        return true;
    } // работает

    @Override
    public boolean removeEmployee(Employee employee) {
        list.remove(employee);
        return true;
    } // работает

    @Override
    public Employee richMan() {
        int count = 0;
        Employee employee = null;

        for (Employee emp : list) {
            if (emp.getSalary() > count) {
                count = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    } // работает

    @Override
    public int numEmployee(){
        return list.size();
    } // работает

    @Override
    public Employee[] getMasEmployee() {
        return list.toArray(new Employee[0]);
    } // работает

    @Override
    public Employee[] getMasSortSalary(){
        Employee[] mass = list.toArray(new Employee[0]);

        for (int i = 0; i < mass.length; i++) {
            Employee buffer;
            for (int j = 0; j < mass.length - i - 1; j++) {
                if (mass[j + 1] == null) break;
                if (mass[j].getSalary() < mass[j + 1].getSalary()){
                    buffer = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buffer;
                }
            }
        }
        return mass;
    } // работает

    @Override
    public String getName() {
        return projectName;
    }
    @Override
    public void setName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getList() {
        return list;
    }
    public void setList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String s = "\"Project " + projectName + ':' + list.size() + "\n";
        for (Employee emp : list) {
            s += emp;
        }
        return s;
    } // норм ли

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName) && list.equals(project.list);
    }

    @Override
    public int hashCode() {
        return projectName.hashCode()^list.hashCode();
    }
}
