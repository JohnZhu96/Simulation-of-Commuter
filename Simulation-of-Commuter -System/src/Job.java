/**
 * This class is used mostly to hold information.
 * @author linfeng zhu
 * @version 1202v1
 * @since 1.8
 *
 */
public class Job {
    Person person;
    int Stopnumber;

    /**
     * This constructor takes in a person object and a stopnumber integer and store it to its fields
     * @param person     an instance that represents one person
     * @param stopnumber an integer that represents stop number
     */
    public Job(Person person, int stopnumber) {
        //This class is used mostly to hold information
        this.person = person;
        Stopnumber = stopnumber;
    }

    /**
     * A getter that returns the person field
     * @return person instance
     */
    public Person getPerson() {
        return person;
    }

    /**
     * A setter that will set the person field
     * @param person  an instance that represents a person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * A getter that gets the stopnumber field 
     * @return  integer  stopnumber
     */
    public int getStopnumber() {
        return Stopnumber;
    }

    /**
     * A setter that sets stopnumber field
     * @param stopnumber
     */
    public void setStopnumber(int stopnumber) {
        Stopnumber = stopnumber;
    }

}
