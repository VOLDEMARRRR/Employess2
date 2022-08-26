package humanResourses;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BusinessTravel bs1 = new BusinessTravel("Samara", 7, 1000, "travel in Samara");
        BusinessTravel bs2 = new BusinessTravel("Moskov", 10, 15000, "travel in Moskov");
        BusinessTravel bs3 = new BusinessTravel("London", 15, 30000, "travel in London");
        BusinessTravel bs4 = new BusinessTravel("Paris", 20, 20000, "travel in Paris");
        BusinessTravel bs5 = new BusinessTravel("Milan", 5, 50000, "travel in Milan");

        List<BusinessTravel> list = new MyList();


        list.add(bs1);
        list.add(bs2);
        list.add(bs3);
        list.add(bs4);
        list.add(bs5);

        List<BusinessTravel> list1 = list.subList(2,4);

        Object[] objects = list.toArray();
        for(Object o : objects){
            System.out.println(o);
        }


        for (BusinessTravel travel : list1) {
            System.out.println(travel);
        }
        System.out.println(list1.size());


        //list.print();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        for (BusinessTravel travel : list) {
            System.out.println(travel);
        }

        //System.out.println(list.remove(bs2));

        //System.out.println(list.get(3));
        //list.set(0, bs2);

        //list.print();

        //list.clear();
        //list.print();
        //System.out.println(list.get(1));
    }
}