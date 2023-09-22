import java.util.*; //for array list

/**
 * This class is used mostly to hold information for stops.
 * @author linfeng zhu
 * @version 1202v1
 * @since 1.8
 *
 */
public class Stop {
    private int number;
    private ArrayList<Person> people;

    /**
     * Constructor that takes int and arraylist people
     * @param number   represents the number of one stop
     * @param people   represents a group of people that is in this stop
     */
    public Stop(int number, ArrayList<Person> people) {
        this.number = number;
        this.people = people;
    }

    /**
     * A getter that gets number field
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * A setter that sets number field
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * A getter that gets people field 
     * @return
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * A setter that sets the people field
     * @param people
     */
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
    
    /**
     * This method should save a reference to the person within the stop object
     * @param person
     * @return
     */
    public boolean enterStop(Person person){
        if(people == null){
            people = new ArrayList<>();
        }
        people.add(person);
        return true;
    }


}
