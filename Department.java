package humanResourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Department implements EmployeeGroup {
    String name_department;
    Employee[] mas_employee;
    int num_employee;

    public Department(String name_department){
        this(name_department,8);
    } // норм

    public Department(String name_department, int number){
        this(name_department, new Employee[number]);
    } // норм

    public Department(String name_department, Employee[] mas_employee){
        this.name_department = name_department;
        this.mas_employee = mas_employee;
        this.num_employee = mas_employee.length;
    } // норм

    @Override
    public void addEmployee(Employee employee){
        if (employee == null) return;
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) {
                mas_employee[i] = employee;
                return;
            }
        }
        Employee[] mas_employee_2 = new Employee[mas_employee.length * 2];
        System.arraycopy(mas_employee, 0, mas_employee_2, 0, mas_employee.length);
        mas_employee_2[mas_employee.length] = employee;
        mas_employee = mas_employee_2;
    } // норм

    @Override
    public boolean removeEmployee(Employee employee) {
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) return false;
            if (mas_employee[i].equals(employee)) {
                System.arraycopy(mas_employee, i + 1, mas_employee, i, mas_employee.length - i - 1);
                mas_employee[mas_employee.length - 1] = null;
                return true;
            }
        }
        return false;
    } //работает

    @Override
    public boolean removeEmployee(String name, String surname){
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) return false;
            if (mas_employee[i].getName().equals(name) && mas_employee[i].getSurname().equals(surname)) {
                System.arraycopy(mas_employee, i + 1, mas_employee, i, mas_employee.length - i - 1);
                mas_employee[mas_employee.length - 1] = null; // строка для уаления если 2 обьекта
                return true;
            }
        }
        return false;
    } // норм

    public void removeEmployeePost(JobTitlesEnum post) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) break;
            if (mas_employee[i].getPost().equals(post)) {
                indexes.add(i);
            }
        }
        int i = 0;
        for (Integer index : indexes) {
            removeEmployee(mas_employee[index - i]);
            i++;
        }
    } //работает

    @Override
    public Employee getEmployee(String name, String surname) {
        for (Employee employee : mas_employee) {
            if (employee == null) return null;
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                return employee;
            }
        }
        return null;
    } // работает

    @Override
    public Employee richMan(){
        int count = 0;
        Employee employee = null;
        for (Employee value : mas_employee) {
            if (value == null) return employee;
            if (value.getSalary() > count) {
                count = value.getSalary();
                employee = value;
            }
        }
        return employee;
    } // работает

    public JobTitlesEnum[] masPosts() {
        JobTitlesEnum[] mas = new JobTitlesEnum[mas_employee.length];
        int index = 0;

        for (Employee employee : mas_employee) {
            if (employee == null) break;
            int count = 0;
            for (JobTitlesEnum ma : mas) {
                if (employee.getPost().equals(ma)) count++;
            }
            if (count == 0) {
                mas[index] = employee.getPost();
                index++;
            }
        }

        JobTitlesEnum[] mas2 = new JobTitlesEnum[index];
        System.arraycopy(mas, 0, mas2, 0, index);
        return mas2;
    } // работает

    public Employee[] employeeWithTravels() {
        Employee[] mas = new Employee[mas_employee.length];
        int index = 0;

        for (Employee employee : mas_employee) {
            if (employee instanceof StaffEmployee && ((StaffEmployee) employee).getTravels().length > 0) {
                mas[index] = employee;
                index++;
            }
        }

        Employee[] mas2 = new Employee[index];
        System.arraycopy(mas, 0, mas2, 0, index);
        return mas2;
    } // работает

    @Override
    public int numEmployee() {
        int count = 0;
        for (Employee employee : mas_employee) {
            if (employee == null) return count;
            count++;
        }
        return count;
    } // норм

    @Override
    public Employee[] getMasEmployee() {
        int count = mas_employee.length;
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) {
                count = i;
                break;
            }
        }
        Employee[] mass = new Employee[count];
        System.arraycopy(mas_employee, 0, mass, 0, count);
        return mass;
    } // норм

    public Employee[] getMasPost(JobTitlesEnum post){
        Employee[] mass = getMas_employee();
        int count = 0;
        for (Employee employee : mass) {
            if (employee == null) break;
            if (employee.getPost().equals(post)) {
                count++;
            }
        }
        Employee[] mas_post = new Employee[count];
        int count1 = 0;
        for (Employee employee : mass) {
            if (employee == null) break;
            if (employee.getPost().equals(post)) {
                mas_post[count1] = employee;
                count1++;
            }
        }
        return mas_post;
    } // норм

    @Override
    public Employee[] getMasSortSalary() {
        Employee[] mass = getMas_employee();
        if (mass == null) return null;
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
    } // норм

    @Override
    public String getName() {
        return name_department;
    }
    @Override
    public void setName(String name_department) {
        this.name_department = name_department;
    }

    public Employee[] getMas_employee() {
        return mas_employee;
    }
    public void setMas_employee(Employee[] mas_employee) {
        this.mas_employee = mas_employee;
    }

    public int getNum_employee() {
        return num_employee;
    }
    public void setNum_employee(int num_employee) {
        this.num_employee = num_employee;
    }

    @Override
    public String toString() {
        Employee[] mas = getMasEmployee();
        String s = "\"Department " + name_department + ':' + mas.length + "\n";
        for (Employee emp : mas) {
            s += emp;
        }
        return s;
    } // нормально ли

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name_department.equals(that.name_department) && that.numEmployee() == ((Department) o).numEmployee();
    } //написать contains;

    @Override
    public int hashCode() {
        if (num_employee == 0) return name_department.hashCode()^ Arrays.hashCode(mas_employee);
        return name_department.hashCode()^ Arrays.hashCode(mas_employee)^num_employee;
    }
}