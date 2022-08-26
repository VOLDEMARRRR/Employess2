package humanResourses;

import java.util.Objects;

public final class BusinessTravel {
    private final String city;
    private final int daysCount;
    private final int compensation;
    private final String description;

    public BusinessTravel(){
        this("",0,0,"");
    }

    public BusinessTravel(String city, int daysCount, int compensation, String description) {
        this.city = city;
        this.daysCount = daysCount;
        this.compensation = compensation;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public int getCompensation() {
        return compensation;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String s = '"' + "";
        if (!city.equals("")) s += city + " ";
        if (daysCount != 0) s += daysCount + " ";
        if (compensation != 0) s += "(" + compensation + "). "; // если скобка как символ странное поведение
        if (!description.equals("")) s += description;
        return s + '"';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessTravel that = (BusinessTravel) o;
        return daysCount == that.daysCount && compensation == that.compensation && Objects.equals(city, that.city) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        if (daysCount == 0 && compensation != 0) return city.hashCode()^compensation^description.hashCode();
        if (daysCount != 0 && compensation == 0) return city.hashCode()^daysCount^description.hashCode();
        if (daysCount == 0 && compensation == 0) return city.hashCode()^description.hashCode();
        return city.hashCode()^daysCount^compensation^description.hashCode();
    }
}
