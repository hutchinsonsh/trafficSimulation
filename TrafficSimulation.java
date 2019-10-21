
package trafficstimulation;
import java.util.Scanner;

public class TrafficStimulation 
{

    public static void main(String[] args) 
    {
        runStimulation();   
    }
    
    // method for running main stimulation
    public static void runStimulation()
    {
        // scanner for when user presses enter; allows stimulation to continue
        Scanner in = new Scanner(System.in);
        
        // initial layout of the intersection
        System.out.println("Here's the initial intersection");
        TrafficLight one = new TrafficLight();
        one.printOutIntersection();
        
        // while loop- runs stimulation
        String input = in.nextLine();
        while(input.equals(""))
        {
            // if emeregency vehicle- right of way to vehicle direction
            // moves emc to the front of the line
            if(one.moveOutTheWay())
            {
                System.out.println("There's an emergency!");
                one.printOutIntersection();
                one.emcChangeOrder();
                one.printOutIntersection();
                System.out.println();
            }
            
            // if all vehicles are done- ends stimulation
            if(one.noVehiclesLeft())
            {
                one.printOutIntersection();
                System.out.println("All the cars are gone");
                input = " a ";
            }
            
            // as many vehicles in 'Time' move; lights change; random vehicle 
            // (or no vehicle) is addeded to a random direciton
            else
            {
                one.thereIsNoWayThisWorksOutInTheEnd();
                one.printOutIntersection();
                if(one.getDirection())
                    System.out.println("North and South had the right of way");
                else if(one.getDirection() == false)
                    System.out.println("East and West had the right of way");
                
                // checks if there are any cars left after cars cross street
                if(one.noVehiclesLeft() == false)
                {
                    one.lightChange();
                    one.addVehicle();
                }
                input = in.nextLine();
            } 
        }  
    }
}
