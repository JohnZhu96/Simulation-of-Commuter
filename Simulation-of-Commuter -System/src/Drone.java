import java.util.*;  //for array list

/**
 * This class is a subclass of the Resort class which will create an instance of drone and 
 * process the array list of jobs.
 * @author linfeng zhu
 * @version 1202v1
 * @since 1.8
 *
 */
public class Drone extends Resort{
    private ArrayList<Job> jobs;
    
    /**
     * This constructor takes in no parameter and set the field to null
     */
    public Drone() {
        this.jobs = null;
    }

    /**
     * This constructor takes in an array list of stops and initialize the jobs for the drone instance to null
     * @param stops
     */
    public Drone(ArrayList<Stop> stops){
        this.setStops(stops);
        this.jobs = null;
    }

    /**
     * This getter will return the jobs of the drone instance
     * @return  array list jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * This setter will change the jobs field of the drone instance
     * @param jobs
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * This method should simply add, in the right place, a new job to be completed 
     * by the drone.
     * @param person  an instance that represents a person
     * @param stop    an integer that represents one stop
     * @return boolean
     */
    public boolean createJob(Person person, int stop){
        if(jobs == null){
            jobs = new ArrayList<>();  //create an array list of jobs if it is null
        }
        jobs.add(new Job(person, stop));  //add job instances to the array list of jobs
        return true;
    }

    /**
     * This method will be used after completing (and removing) a job.
     */
    public void cleanUpJobs(){
        jobs.clear();
        System.out.println("Drone flies back to base.");
    }

    /**
     * This method will remove jobs one by one (in the right order) and process them individually
     */
    public void processAllJobs(){
        int i = 0;  // i is used to represent the location of the drone
        while (jobs!=null&&i<4) {
            boolean personExit =false;
            System.out.print("When drone is in Stop" +(i+1)+", ");
            for (Job job: jobs){
            	if (job.getStopnumber()==i+1) {
                    processJob(job);  //process the jobs one by one
                    personExit =true;
            	}
            }
            if(personExit==false) {
            	System.out.print("no one exits.");
            }
            System.out.println();
            if(jobs.size()>0){
            //once a person enters the drone, remove the person's information at stop0(resort)
            getStops().get(0).getPeople().remove(jobs.get(0).getPerson());}
            i++;
        }
        this.cleanUpJobs();
    }
    
    /**
     * This method will process a job and move the drone stop by stop
     * @param job  an instance that represent a job of the drone 
     * @return boolean
     */
    public boolean processJob(Job job){
        exit(job.getPerson(),job.getStopnumber());
        return true;
    }
    
    /**
     * This method will call a method on the Resort for a person to enter a given stop
     * @param person  an instance that represents one person
     * @param stop    an integer that represents one stop
     * @return  boolean
     */
    public boolean exit(Person person, int stop){
        enterStop(person,stop);
        System.out.print(person + " exits.");
        return true;
    }

}
