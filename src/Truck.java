import java.util.Objects;

public class Truck extends CommercialVehicle {
    private boolean heavyDuty;

    public Truck(String make, String model, int year,
                 String carries, boolean h,double price, int invQuantity) {
        super(make, model, year, carries,price, invQuantity);
        this.heavyDuty = h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        Truck truck = (Truck) o;
        return getMake().equals(truck.getMake()) &&
                getModel().equals(truck.getModel()) &&
                getYear() == truck.getYear() &&
                getCarries().equals(truck.getCarries()) &&
                heavyDuty == truck.heavyDuty &&
                getPrice() == truck.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear(), getCarries(), heavyDuty, getPrice());
    }

    @Override
    public String toString(){
        String result = super.toString();
        if(heavyDuty){ result = "Heavy-duty Truck: " + result; }
        else{ result = "Truck: " + result; }
        return result;
    }

}
