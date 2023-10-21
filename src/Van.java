import java.util.Objects;

public class Van extends CommercialVehicle {
    //attributes
    private boolean covered;

    //constructor
    public Van(String make, String model, int year,
                 String carries, boolean covered,double price, int invQuantity) {
        super(make, model, year, carries,price, invQuantity);
        this.covered = covered;
    }

    public boolean getCovered(){return covered;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Van)) return false;
        Van van = (Van) o;
        return getMake().equals(van.getMake()) &&
                getModel().equals(van.getModel()) &&
                getYear() == van.getYear() &&
                getCarries().equals(van.getCarries()) &&
                covered == van.covered &&
                getPrice() == van.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear(), getCarries(), covered, getPrice());
    }

    @Override
    public String toString(){
        String result = super.toString();
        if(covered){ result = "Covered Van: " + result; }
        else{ result = "Van: " + result; }
        return result;
    }


}
