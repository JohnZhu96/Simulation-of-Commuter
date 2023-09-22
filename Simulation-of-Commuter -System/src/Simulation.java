import java.util.*;  // array list
/**
 *  It is the client class to initiate the simulation
 *  
 *  This class was written for PA5 in COSI 12B at Brandeis University
 *  Department of Computer Science.
 *  
 * @author Linfeng Zhu
 * @version 1202v1
 * @since 1.8
 */
public class Simulation {
    public static void main(String[] args) {
        Drone drone = new Drone();
    	Person[] group1 ;
        Person[] group2 ;
        //group 1 has 5 people
        group1 = new Person[]{new Person("Mark", "John"), new Person("Mason", "Perk"), new Person("Lily", "Alice"),new Person("Jason", "Nick"),new Person("Park", "Tom")};
        //group 2 has 3 people
        group2 = new Person[]{new Person("Jack", "Perth"), new Person("Mary", "Land"), new Person("Pop", "Peter")};
       

        //Creates an array that will store stop objects 
        ArrayList<Stop> stops = new ArrayList<>();
        for (int i =0;i<10;i++){
            stops.add(new Stop(i,null));
        }

        //Creates an instance of the resort
        Resort resort = new Resort(stops);

        startTrip(group1,resort,drone);
        startTrip(group2,resort,drone);
    	
    }
    
    //This method will take one group to their trip
    public static void startTrip(Person[]group, Resort resort, Drone drone) {
    	// Each person enters the resort and puts in their desired stop
        if(group.length>=4) {
        	int leftOver=group.length%4;
        	for (int i=1; i<group.length;i+=4) {
        		for (int j = 0;j<4;j++){
        			Random num = new Random();  //I just use random to represent each person's desired stop
        			int stop = num.nextInt(4)+1;
        			group[j].enterResort(resort,stop);  //the resort instance is passed as a parameter
        			drone.createJob(group[j], stop);
        		}
        	}
        	resort.startDrone();
        	for (int i =group.length-leftOver-2;i<group.length;i++) {//Let drone take the left over to his desired destination
        			Random num = new Random(); 
        			int stop = num.nextInt(4)+1;
        			group[i].enterResort(resort,stop);
        			drone.createJob(group[i], stop);
        	}
        	resort.startDrone();
        }else {
        	for (int i =0;i<group.length;i++) {
    			Random num = new Random(); 
    			int stop = num.nextInt(4)+1;
    			group[i].enterResort(resort,stop);  
    			drone.createJob(group[i], stop);
        	}
        	resort.startDrone();
        }
    }
    
    
    
}


	