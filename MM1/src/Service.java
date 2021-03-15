import java.util.LinkedList;
import java.util.Random;

public class Service {
	//variables
	double ServiceTime=0;
	static Random random = new Random ();
	//double EndOfService;
	//Customer Cust;

	//constructor
	public Service(double currentArriveTime,double mu) {
		setServiceTime(mu);
		//setEndServiceTime(currentArriveTime,mu);
	}

	//methods
	public void setServiceTime(double mu) {
		this.ServiceTime =  -Math.log (random.nextDouble ()) / mu; // customers/sec (service times),mean service time = 1/mu = 1/10 
	}
//	//TODO:should remove?
//	public void setEndServiceTime(double currentClock,double mu) {
//		this.EndOfService = currentClock+( -Math.log (random.nextDouble ()) / mu); // customers/sec (service times),mean service time = 1/mu = 1/10 
//	}
}
