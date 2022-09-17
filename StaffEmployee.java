package humanResourses;

import java.util.Arrays;
import java.util.List;

public class StaffEmployee extends Employee implements BusinessTraveller {
    List<BusinessTravel> list;
    int bonus;


    public StaffEmployee(String name, String surname) {
        super(name, surname);
        this.bonus = 0;
        this.list = new MyList();
    }

    public StaffEmployee(String name, String surname, JobTitlesEnum post, int salary) {
        super(name, surname, post, salary);
        this.bonus = 0;
        this.list = new MyList();
    }

    public StaffEmployee(String name, String surname, JobTitlesEnum post, int salary, BusinessTravel[] businessTravels) {
        this(name, surname, post, salary);
        this.bonus = 0;
        this.list = new MyList(businessTravels);
    }


    @Override
    public void businessTravelInfo(BusinessTravel businessTravel) {
        list.add(businessTravel);
    }

    @Override
    public BusinessTravel[] getTravels() {
        return list.toArray(new BusinessTravel[0]);
    }

    @Override
    public int getPremium() {
        return bonus;
    }

    @Override
    public void setPremium(int b) {
        this.bonus = b;
    }

    @Override
    public String toString() {
        String s = '"' + name + " " + surname + ", ";
        if (post != JobTitlesEnum.NONE) s += post + ", ";
        if (salary != 0 && bonus == 0) s += salary + "р. \n";
        if (salary == 0 && bonus != 0) s += salary + "р., " + bonus + "р. \n";
        if (salary != 0 && bonus != 0) s += salary + "р., " + bonus + "р. \n";
        s += "Командировки:\n";
        s += Arrays.toString(this.getTravels()) + "\"\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaffEmployee that = (StaffEmployee) o;
        return bonus == that.bonus && list.size() == that.list.size();
    }

    @Override
    public int hashCode() {
        if (salary == 0 && bonus != 0) return name.hashCode()^surname.hashCode()^post.hashCode()^bonus;
        if (salary != 0 && bonus == 0) return name.hashCode()^surname.hashCode()^post.hashCode()^salary;
        if (salary == 0 && bonus == 0) return name.hashCode()^surname.hashCode()^post.hashCode();
        return name.hashCode()^surname.hashCode()^post.hashCode()^salary^bonus;
    }
}
