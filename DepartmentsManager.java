package humanResourses;

public class DepartmentsManager {
    String name_organization;
    EmployeeGroup[] employeeGroups;

    public DepartmentsManager(String name_organization) {
        this(name_organization, new Department[0]);
    } // норм

    public DepartmentsManager(String name_organization, EmployeeGroup[] employeeGroups) {
        this.name_organization = name_organization;
        this.employeeGroups = employeeGroups;
    }  // норм

    public void addDepartment(EmployeeGroup employeeGroup){
        if (employeeGroup == null) return;
        for (int i = 0; i < employeeGroups.length; i++) {
            if (employeeGroups[i] == null) {
                employeeGroups[i] = employeeGroup;
                return;
            }
        }
        EmployeeGroup[] mas_department_2 = new Department[employeeGroups.length * 2 + 1];
        System.arraycopy(employeeGroups, 0, mas_department_2, 0, employeeGroups.length);
        mas_department_2[employeeGroups.length] = employeeGroup;
        employeeGroups = mas_department_2;
    } // норм

    public boolean deleteDepartment(String name){
        for (int i = 0; i < employeeGroups.length; i++) {
            if (employeeGroups[i] == null) return false;
            if (employeeGroups[i].getName().equals(name)) {
                System.arraycopy(employeeGroups, i + 1, employeeGroups, i, employeeGroups.length - i - 1);
                employeeGroups[employeeGroups.length - 1] = null; // строка для уаления если 2 обьекта
                return true;
            }
        }
        return false;
    } // норм

    public EmployeeGroup choiceDepartment(String name) {
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup.getName().equals(name)) {
                return employeeGroup;
            }
        }
        return null;
    } // норм

    public EmployeeGroup[] getEmployeeGroups() {
        return employeeGroups;
    } // норм

    public int countDepartment() {
        int count = 0;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) return count;
            count++;
        }
        return count;
    } // норм

    public int countEmployee() {
        int count = 0;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) return count;
            count += employeeGroup.numEmployee();
        }
        return count;
    } // норм

    public int countEmployeePost(JobTitlesEnum post) {
        int count = 0;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) return count;
            for (Employee employee : employeeGroup.getMasEmployee()) {
                if (employee == null) break;
                if (employee.getPost().equals(post)) count++;
            }
        }
        return count;
    } // норм

    public Employee richMan() {
        int count = 0;
        Employee rich = null;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) return rich;
            for (Employee employee : employeeGroup.getMasEmployee()) {
                if (employee == null) break;
                if (employee.getSalary() > count) {
                    count = employee.getSalary();
                    rich = employee;
                }
            }
        }
        return rich;
    } // норм

    public EmployeeGroup employeeEmployeeGroup(String name, String surname) {
        Employee[] find_employee;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) return null;
            find_employee = employeeGroup.getMasEmployee();
            for (Employee employee : find_employee) {
                if (employee == null) break;
                if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                    return employeeGroup;
                }
            }
        }
        return null;
    } // норм

    public int numGroup(){
        int count = 0;
        for (EmployeeGroup employeeGroup : employeeGroups) {
            if (employeeGroup == null) continue;
            count++;
        }
        return count;
    } // работает

    public int removeGroup(EmployeeGroup group) {
        int count = 0;
        for (int i = 0; i < employeeGroups.length; i++) {
            if (employeeGroups[i].equals(group)) {
                employeeGroups[i] = null;
                count++;
            }
        }
        return count;
    } // работает
}
