
package trafficstimulation;

public class Truck extends Vehicle
{
    
    public Truck(int num, boolean isEmc, String truckString)
    {
        super(num, isEmc, truckString);
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
