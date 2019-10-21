
package trafficstimulation;

public class Semi extends Vehicle
{
    
    public Semi(int num, boolean isEmc, String semiString)
    {
        super(num, isEmc, semiString);
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
