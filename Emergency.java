
package trafficstimulation;

public class Emergency extends Vehicle
{
    
    public Emergency(int num, boolean isEmc, String emcString)
    {
        super(num, isEmc, emcString);
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
