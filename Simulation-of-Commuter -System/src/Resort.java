import java.util.*; //for array list

/**
 * This class will hold an array of stops and an instance of ski lift drone
 * 
 * @author linfeng zhu
 * @version 1202v1
 * @since 1.8
 */
public class Resort {
    private ArrayList<Stop> stops;
    private Drone drone ;

    /**
     * A default constructor without any parameters
     */
    public Resort(){
        // default constructor
    }
    
    /**
     * A constructor that will take in an array list of stops, and set the fields drone and stops
     * @param stops  an array list that represents stops
     */
    public Resort(ArrayList<Stop> stops) {
        //parameters constructor
        this.drone = new Drone( stops);
        this.stops = stops;
    }

    /**
     * A getter that returns the stops field
     * @return  array list stops
     */
    public ArrayList<Stop> getStops() {
        return stops;
    }
    /**
     * A getter that returns the instance of drone
     * @return  an instance of ski lift drone
     */
    public Drone getDrone() {
        return drone;
    }
    
    /**
     * A setter that will change the stops field
     * @param stops  an array list that represents stops 
     */
    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }
    
    /**
     * A setter that changes the drone field 
     * @param drone
     */
    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    /**
     * A method that processes the request made by a person to enter the resort.
     * Then, it passes on the request to a drone instance.
     * @param person  an instance that represents a person 
     * @param stop    an integer that represent one stop
     * @return  true
     */
    public boolean enterDrone(Person person, int stop){
        drone.createJob(person, stop);
        return true;
    }

    /**
     * This will call a method in the drone instance that should process all current jobs.
     */
    
    public void startDrone(){
        drone.processAllJobs();
    }

    
    /**
     * This method should simply access the given stop object and call a method to
     * save a reference to the person in the given stop.
     * @param person  an instance that represents a person
     * @param stop    an integer that represents one stop
     * @return boolean
     */
    public boolean enterStop(Person person, int stop){
        for (Stop value : stops) {
            if (value.getNumber() == stop) {
                value.enterStop(person);
                return true;
            }
        }
        return false;
    }
}
