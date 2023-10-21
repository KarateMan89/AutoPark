import java.util.Objects;

public class Sedan extends PersonalVehicle {
    public Sedan(String make, String model, String color, int year, double price, int invQuantity){
        super(make,model,color,year,price,invQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sedan)) return false;
        Sedan sedan = (Sedan) o;
        return getMake().equals(sedan.getMake()) &&
                getModel().equals(sedan.getModel()) &&
                getColor().equals(sedan.getColor()) &&
                getYear() == sedan.getYear() &&
                getPrice() == sedan.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getColor(), getYear(), getPrice());
    }

    @Override
    public String toString(){
        return "Sedan: " + super.toString();
    }

}
