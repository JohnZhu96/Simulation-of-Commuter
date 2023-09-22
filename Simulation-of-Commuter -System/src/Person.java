import java.util.*; //for array list

/**
 * This class is used to store information for person instances 
 * @author linfeng zhu
 * @version 1202v1
 * @since 1.8
 */
public class Person {
    private String firstname;
    private String lastname;

    /**
     * This constructor takes in a person's first name and last name 
     * @param firstname     
     * @param lastname
     */
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * A getter that returns a person's first name
     * @return firstname
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * A setter that sets a person's last name
     * @param firstname
     */
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    
    /**
     * A getter that returns a person's last name
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }
    
    /**
     * A setter that sets a person's last name
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * This method will simply call the appropriate method from the Resort 
     * instance to enter the drone and request a job.
     * @param resort  an instance that represents the resort
     * @param stop    an integer that represents one stop
     * @return boolean
     */
    public boolean enterResort(Resort resort, int stop){
        resort.getDrone().getStops().get(0).enterStop(this);
        resort.enterDrone(this,stop);
        return true;
    }

    /**
     * This method holds a variable that will say the location of a person and returns the location
     * @param resort
     * @return String  that represents the location of the person
     */
    public String getLocation(Resort resort){
        String location ="";

        for (Stop value:resort.getStops()){
            if(value.getPeople()==null){
                value.setPeople(new ArrayList<>());  //create a new array list to store person instances
            }
            for(Person person:value.getPeople()){
                if(this.equals(person)){
                    if(value.getNumber()==0){
                        //if we can find the person in stop 0,that means the person is in resort
                        location = "Resort";
                    }
                    else if(value.getNumber()!=0){
                        //if we can find the person in stop n , then change the location to stop n
                        location = "Stop"+String.valueOf(value.getNumber());
                    }
                }
            }
        }
        if(location.equals("")){
            // if we can't find the person in stops, that means the person is in drone.
            location = "Drone";
        }
        System.out.println("in "+location);
        return location;
    }
    
    public String toString() {
    	return firstname + " " + lastname;
    }
}
