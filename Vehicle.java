
package trafficstimulation;

public abstract class Vehicle 
{
    protected int time;
    protected boolean isEmergency;
    protected String vehicleType;
    
    public Vehicle()
    {
        time = 0;
        isEmergency = false;
    }
    
    public Vehicle(int num, boolean isEmc, String vType)
    {
        time = num;
        isEmergency = isEmc;
        vehicleType = vType;
        
    }
    
    abstract int getTime();
    abstract boolean getIsEmergency();
    abstract String getString();
}
