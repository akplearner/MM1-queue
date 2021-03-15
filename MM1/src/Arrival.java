import java.util.LinkedList;
import java.util.Random;

public class Arrival {
	//Variables
	static Random random = new Random ();
	double currentArriveTime;
	double nextArriveTime;
	
	//constructor
	public Arrival(Customer customers,double lambda,double latestArrivalTime) {
		//setting the new arrival time
		setNewCustTime(customers,lambda,latestArrivalTime);
	}
	
	//Methods
	public void setNewCustTime (Customer customer, double lambda, double latestArrivalTime) {
		if(latestArrivalTime==0) {
			latestArrivalTime = (-Math.log (random.nextDouble ()) / lambda);
		}
		currentArriveTime = latestArrivalTime;
		nextArriveTime = currentArriveTime  + (-Math.log (random.nextDouble ()) / lambda);
    }

}
