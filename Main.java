package humanResourses;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BusinessTravel bs1 = new BusinessTravel("Samara", 7, 1000, "travel in Samara");
        BusinessTravel bs2 = new BusinessTravel("Moskov", 10, 15000, "travel in Moskov");
        BusinessTravel bs3 = new BusinessTravel("London", 15, 30000, "travel in London");
        BusinessTravel bs4 = new BusinessTravel("Paris", 20, 20000, "travel in Paris");
        BusinessTravel bs5 = new BusinessTravel("Milan", 5, 50000, "travel in Milan");
        BusinessTravel bs6 = new BusinessTravel("P", 20, 20000, "travel");
        BusinessTravel bs7 = new BusinessTravel("M", 5, 50000, "travel");

        PartTimeEmployee pt = new PartTimeEmployee("Victor", "Pupkin", JobTitlesEnum.AGENT, 1000);

        StaffEmployee stf = new StaffEmployee("Ivan", "Sutkin", JobTitlesEnum.ANALYST, 10000);
        stf.businessTravelInfo(bs1);
        stf.businessTravelInfo(bs2);
        stf.businessTravelInfo(bs3);
        stf.setPremium(500);

        StaffEmployee stf1 = new StaffEmployee("Lana", "Fay", JobTitlesEnum.ANALYST, 50);
        StaffEmployee stf2 = new StaffEmployee("Obi-Wan","Kenobi", JobTitlesEnum.ASSISTANT, 1000 );
        StaffEmployee stf3 = new StaffEmployee("Thor", "Odinson", JobTitlesEnum.DIRECTOR, 400000);


        Department sport = new Department("sport");

        sport.addEmployee(stf);
        sport.addEmployee(stf1);
        sport.addEmployee(stf2);
        sport.addEmployee(stf3);
        sport.addEmployee(pt);


        List<Employee> list = new ProjectList();
        list.add(stf);
        list.add(stf1);
        list.add(stf2);
        list.add(stf3);
        list.add(stf);


        for (Employee emp : list) {
            System.out.println(emp);
        }





        Project lab = new Project("Laba");
        lab.addEmployee(stf);
        lab.addEmployee(stf1);
        lab.addEmployee(stf2);


        lab.setName("Lab2");

        System.out.println(lab);

        DepartmentsManager apple = new DepartmentsManager("apple", new Project[]{lab});
        System.out.println(apple.numGroup());
        System.out.println(apple.removeGroup(lab));
        System.out.println(apple.numGroup());


    }
}