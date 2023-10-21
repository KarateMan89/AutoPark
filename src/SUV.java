import java.util.Objects;

public class SUV extends PersonalVehicle {
    private boolean AWD;

    public SUV(String make, String model, String color, int year,
                 boolean AWD,double price, int invQuantity){
        super(make,model,color,year,price,invQuantity);
        this.AWD = AWD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SUV)) return false;
        SUV suv = (SUV) o;
        return getMake().equals(suv.getMake()) &&
                getModel().equals(suv.getModel()) &&
                getColor().equals(suv.getColor()) &&
                getYear() == suv.getYear() &&
                AWD == suv.AWD &&
                getPrice() == suv.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getColor(), getYear(), AWD, getPrice());
    }

    @Override
    public String toString(){
        String result = super.toString();
        if(AWD){ result = "AWD SUV: " + result; }
        else{ result = "SUV: " + result; }
        return result;
    }
}
