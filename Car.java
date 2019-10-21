package trafficstimulation;

public class Car extends Vehicle
{
    
    public Car(int num, boolean isEmc, String carString)
    {
        super(num, isEmc, carString);
    }
    
    public boolean getIsEmergency()
    {
        return isEmergency;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public String getString()
    {
        return vehicleType;
    }
}
