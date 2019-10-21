
package trafficstimulation;
import java.util.Random;
        
public class TrafficLight 
{
    // the four actual arrays for each direction
    Vehicle[] north = new Vehicle[5];
    Vehicle[] south = new Vehicle[5];
    Vehicle[] east = new Vehicle[5];
    Vehicle[] west = new Vehicle[5];
    
    // booleans for: stimulation running, NS has greenLight; EW has greenLight
    boolean running;
    boolean NS = false;
    boolean EW = true;
    final int time = 20;
    
    // whichDirection: where 'E' is; N = 1; S = 3; E = 2; W = 4;
    //emergencyExists: is there already an 'E'
    int whichDirection = 0;
    boolean emcExists = false;
    
    // constructor; makes array w/ random vehicles
    public TrafficLight()
    {
        // assigns each direciton a randomized number of random vehicles
        forTheLoveOfGodRefactorThis();
    }
    
    // for printing out which direction can cross; returns which direction went
    public boolean getDirection()
    {
        if(NS == true)
            return true;
        else
            return false;
    }
            
    // this chooses the order of how the arrays are created
    // so that all arrays have an equal chance of having an emc
    public void forTheLoveOfGodRefactorThis()
    {
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        if(n == 1)
        {
            north = makeRandVehicles(north);
            south = makeRandVehicles(south);
            east = makeRandVehicles(east);
            west = makeRandVehicles(west);
        }
        else if (n == 2)
        {
         
            south = makeRandVehicles(south);
            east = makeRandVehicles(east);
            west = makeRandVehicles(west);
            north = makeRandVehicles(north);
        }
        else if(n == 3)
        {
            east = makeRandVehicles(east);
            west = makeRandVehicles(west);
            north = makeRandVehicles(north);
            south = makeRandVehicles(south);
        }
        else if(n == 4)
        {
            west = makeRandVehicles(west);
            north = makeRandVehicles(north);
            south = makeRandVehicles(south);
            east = makeRandVehicles(east);
        }   
    }
    
    // Checks to see if all lanes are empty; returns true if no cars
    public boolean noVehiclesLeft()
    {
        boolean noCars = true;
        if(north[0] != null || south[0] != null || east[0] != null || west[0] 
                != null)
            noCars = false;
        return noCars;
    }    
    
    // this is suppose to be in the constructor; array of Rand vehicles
    // uses int arrays to make cooresponding vehicles for each element
    public Vehicle[] makeRandVehicles(Vehicle[] direction)
    {
        Random rand = new Random();
        int n = rand.nextInt(5) + 0;
        
        for(int i = 0; i < n; i++)
        {
            int m = rand.nextInt(3) + 1;
            if (m == 1)
            {
                Vehicle cars = new Car(5, false, "C");
                direction[i] = cars;
            }
            else if(m == 2)
            {
                Vehicle trucks = new Truck(10, false, "T");
                direction[i] = trucks;
            }
            else if(m == 3)
            {
                Vehicle semis = new Semi(15, false, "S");
                direction[i] = semis;
            }
        }
        return direction;
    }
    
    // prints out intersection
    public void printOutIntersection()
    {
        // prints out north cars
        for(int i = 4; i >= 0; i--)
        {
            System.out.print("\t   |");
            if(north[i] != null)
            {
                if(north[i].getString().equals("C"))
                    System.out.print("C   ");
                else if (north[i].getString().equals("T"))
                    System.out.print("T   ");
                else if(north[i].getString().equals("S"))
                    System.out.print("S   ");
                else if(north[i].getString().equals("E"))
                    System.out.print("E   ");
            }
            else
                System.out.print("    ");
            System.out.println("|");
        }
        System.out.println("-----------      -----------");
        
        // prints out west cars
        for(int i = 4; i >= 0; i--)
        {
            if(west[i] != null)
            {
                if(west[i].getString().equals("C"))
                    System.out.print(" C");
                else if (west[i].getString().equals("T"))
                    System.out.print(" T");
                else if(west[i].getString().equals("S"))
                    System.out.print(" S");
                else if(west[i].getString().equals("E"))
                    System.out.print(" E");
            }
            else
                System.out.print("  ");
        }
        System.out.println();
        System.out.print("\t\t");
        
        // prints out east cars
        for(int i = 0; i < 5; i++)
        {
            if(east[i] != null)
            {
                if(east[i].getString().equals("C"))
                    System.out.print(" C");
                else if (east[i].getString().equals("T"))
                    System.out.print(" T");
                else if(east[i].getString().equals("S"))
                    System.out.print(" S");
                else if(east[i].getString().equals("E"))
                    System.out.print(" E");
            }
            else
                System.out.print("  ");
        }
        System.out.println();
        System.out.println("-----------      -----------");
        
        // prints out south cars
        for(int i = 0; i < 5; i++)
        {
            System.out.print("\t   |");
            if(south[i] != null)
            {
                if(south[i].getString().equals("C"))
                    System.out.print("   C");
                else if (south[i].getString().equals("T"))
                    System.out.print("   T");
                else if(south[i].getString().equals("S"))
                    System.out.print("   S");
                else if(south[i].getString().equals("E"))
                    System.out.print("   E");
            }
            else
                System.out.print("    ");
            System.out.println("|");
        }
    }
    
    // checks to see if an emergency vehicle is in any direction; returns bool
    public boolean moveOutTheWay()
    {
        for(int i = 0; i < 5; i++)
        {
            if(north[i] != null && north[i].getString().equals("E"))
            {
                NS = true;
                EW = false;
                whichDirection = 1;
                return true;
            }
            else if(south[i] != null && south[i].getString().equals("E"))
            {
                NS = true;
                EW = false;
                whichDirection = 3;
                return true;
            }
            else if(east[i] != null && east[i].getString().equals("E"))
            {
                EW = true;
                NS = false;
                whichDirection = 2;
                return true;
            }
            else if(west[i] != null && west[i].getString().equals("E"))
            {
                EW = true;
                NS = false;
                whichDirection = 4;
                return true;
            }
        }
        return false;
    }
    
    // places the emergency vehicle in the front of the line
    // moves all other vehicles backwards
    // FUTURE INSTALMNETS: FIND A WAY TO SIMPLIFY
    public void emcChangeOrder()
    {
        // for if emergency vehicle is in the North lane
        if (whichDirection == 1)
        {
            int wheresE = 0;
            for(int i = 0; i < 5; i++)
            {
                if(north[i] != null && north[i].getString().equals("E"))
                    wheresE = i;
            }
            if(wheresE != 0)
            {
                for(int i = wheresE; i > 0; i--)
                {
                    Vehicle temp = north[i];
                    north[i] = north[i-1];
                    north[i-1] = temp;
                }
            }
        }
        
        // for if emergency vehicle is in the South lane
        if (whichDirection == 3)
        {
            int wheresE = 0;
            for(int i = 0; i < 5; i++)
            {
                if(south[i] != null && south[i].getString().equals("E"))
                    wheresE = i;
            }
            if(wheresE != 0)
            {
                for(int i = wheresE; i > 0; i--)
                {
                    Vehicle temp = south[i];
                    south[i] = south[i-1];
                    south[i-1] = temp;
                }
            }
        }
        
        // for if emergency vehicle is in the East lane
        if (whichDirection == 2)
        {
            int wheresE = 0;
            for(int i = 0; i < 5; i++)
            {
                if(east[i] != null && east[i].getString().equals("E"))
                    wheresE = i;
            }
            if(wheresE != 0)
            {
                for(int i = wheresE; i > 0; i--)
                {
                    Vehicle temp = east[i];
                    east[i] = east[i-1];
                    east[i-1] = temp;
                }
            }
        }
        
        // for if emergency vehicle is in the West lane
        if (whichDirection == 4)
        {
            int wheresE = 0;
            for(int i = 0; i < 5; i++)
            {
                if(west[i] != null && west[i].getString().equals("E"))
                    wheresE = i;
            }
            if(wheresE != 0)
            {
                for(int i = wheresE; i > 0; i--)
                {
                    Vehicle temp = west[i];
                    west[i] = west[i-1];
                    west[i-1] = temp;
                }
            }
        }
        // if its at the front of the line, and light changes- it will be false
        emcExists = false;
    }
    
    // this is the part of the code that runs the actual stimulation
    // as many vehicles as possible cross/other vehicles move up
    // FUTURE INSTALMENTS: refactor this- same code for all 4 directions
    public void thereIsNoWayThisWorksOutInTheEnd()
    {
        // for the NS crossings
        if(NS == true)
        {
            boolean keepRunning = true;
            int countNorth = 0;
            int numNorth = 0;
            if(north[0] != null)
            {
                do
                {
                    if((north[countNorth].getTime() + numNorth) <= time)
                    {
                        numNorth += north[countNorth].getTime();
                        countNorth += 1;
                    }
                    else
                        keepRunning = false;
                }while(numNorth <= time && north[countNorth] != null && keepRunning);

                north = moveUp(north, countNorth);
            }
            
            keepRunning = true;
            int countSouth = 0;
            int numSouth = 0;
            if(south[0] != null)
            {
                do
                {
                    if((south[countSouth].getTime() + numSouth) <= time)
                    {
                        numSouth += south[countSouth].getTime();
                        countSouth += 1;
                    }
                    else
                        keepRunning = false;
                }while(numSouth <= time && south[countSouth] != null && keepRunning);

                south = moveUp(south, countSouth); 
            }
        }
        
        // for the EW crossings
        if(EW == true)
        {
            boolean keepRunning = true;
            int countEast = 0;
            int numEast = 0;
            if(east[0] != null)
            {
                do
                {
                    if((east[countEast].getTime() + numEast) <= time)
                    {
                        numEast += east[countEast].getTime();
                        countEast += 1;
                    }
                    else
                        keepRunning = false;
                }while(numEast <= time && east[countEast] != null && keepRunning);

                east = moveUp(east, countEast);
            }
            
            int countWest = 0;
            int numWest = 0;
            
            keepRunning = true;
            if(west[0] != null)
            {
                do
                {
                    if((west[countWest].getTime() + numWest) <= time)
                    {
                        numWest += west[countWest].getTime();
                        countWest += 1;
                    }
                    else
                        keepRunning = false;
                }while(numWest <= time && west[countWest] != null && keepRunning);

                west = moveUp(west, countWest);
            }
        }
    }
    
    // moves the vehicles that are left up
    // for the actual vehicle array
    public Vehicle[] moveUp(Vehicle[] one, int count)
    {
        for(int i = count; i < 5; i++)
        {
            one[i-count] = one[i];
        }
        for(int i = 4; i >= (5-count); i--)
        {
            one[i] = null;
        }
        return one;
    }
    
    // checks to see which light was previously on/switches it
    public void lightChange()
    {
        if (NS == true)
        {
            NS = false;
            EW = true;
        }
        else if (EW == true)
        {
            NS = true;
            EW = false;
        }
    }
    
    // every run through- adds a randomized vehicle to a random direction
    public void addVehicle()
    {
        int temp = 0;
        int m;
        
        // for which direction a vehicle is added to; 5- no vehicle added
        Random rand = new Random();
        int n = rand.nextInt(5) + 1;
        
        // for what type of vehilce is added
        // probs having an else statement is useless
        if(emcExists == false)
            m = rand.nextInt(4) + 1;
        else
            m = rand.nextInt(3) + 1;
        
        if(n == 1 && north[4] == null)
        {
            temp = wheresWaldo(north);
            north[temp] = theresWaldo(north, m, temp);
        }
        else if(n == 2 && south[4] == null)
        {
            temp = wheresWaldo(south);
            south[temp] = theresWaldo(south, m, temp);
        }
        else if(n == 3 && east[4] == null)
        {
            temp = wheresWaldo(east);
            east[temp] = theresWaldo(east, m, temp);
        }
        else if(n == 4 && west[4] == null)
        {
            temp = wheresWaldo(west);
            west[temp] = theresWaldo(west, m, temp);
        }
        
        
        
    }
    
    // finds out where the randomized direction(addVehicle) has its last vehicle
    public int wheresWaldo(Vehicle[] one)
    {
        int temp = 0;
        for(int i = 4; i >= 0; i --)
        {
            if (one[i] == null)
                temp = i;
        }
        return temp;
    }
    
    // decides which vehicle is added to the array(one)
    public Vehicle theresWaldo(Vehicle[] one, int whichV, int whereV)
    {
        if (whichV == 1)
        {
            Vehicle cars = new Car(5, false, "C");
            one[whereV] = cars;
            System.out.println("a car entered the intersection");
        }
        else if(whichV == 2)
        {
            Vehicle trucks = new Truck(10, false, "T");
            one[whereV] = trucks;
            System.out.println("a truck entered the intersection");
        }
        else if(whichV == 3)
        {
            Vehicle semis = new Semi(15, false, "S");
            one[whereV] = semis;
            System.out.println("a semi-truck entered the intersection");
        }
        else if (whichV == 4)
        {
            Vehicle emcs = new Emergency(5, true, "E");
            one[whereV] = emcs;
            System.out.println("an emergency vehicle has appeared!");
        }
        return one[whereV];
    }
}
