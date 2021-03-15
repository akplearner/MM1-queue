import java.util.Random;
import java.util.*;
/**
 * @author Anthony Peña
 *
 */

public class Root {
	//variables
	static double lambda=8; //customers/sec (Interarrival),avg inerarrival = 1/8 (8 cust per sec)
	static double mu= 10;// customers/sec (service times),mean service time = 1/mu = 1/10 
	static double CLOCK = 0; //variable "clock" type double
	static int numberOfCustomer = 0;
	static double rho = 0.8;// rho = lambda/mu = 8/10 
	static LinkedList<Double> FEL = new LinkedList<Double>();//list of events to occur in the future, everything in queue
	static LinkedList<Double> DEL = new LinkedList<Double>();//delayed event list,  current customer delay
	static Customer CustomerArray[] = new Customer[10000];
	
	//Main
	public static void main(String[] args) {
		//create 10,000 customers in the world
		for(int i=0;i<10000;i++) {
			Customer cust = new Customer(i);
			CustomerArray[i]=cust;
		}
		double latestArrivalTime =0;
		double customerServiceEndTime =0;
		double endOfServiceTime =0;
		
		//run queue and add the services
		while(numberOfCustomer<10000) {
			//Set customer arrival time.
			Arrival arrival = new Arrival(CustomerArray[numberOfCustomer],lambda,latestArrivalTime);
			latestArrivalTime = arrival.currentArriveTime;
			CLOCK = arrival.currentArriveTime;//updating time to customer arrival time
			
			//create service time for customer
			Service service = new Service(arrival.currentArriveTime ,mu);//need to set service time to current customer	
			customerServiceEndTime = service.ServiceTime+arrival.currentArriveTime;
			
			//check if system is busy or not
			if(arrival.nextArriveTime <= customerServiceEndTime) {
				//means its busy- add Arrival to DEL
				DEL.add(arrival.nextArriveTime);
				endOfServiceTime = customerServiceEndTime;//service.ServiceTime+arrival.currentArriveTime;
				CLOCK = arrival.nextArriveTime;
				//System.out.println("busy:"+arrival.nextArriveTime +" "+service.EndOfService);
			}
			else {
				//create end of service, create end of service for cust/arrival, require ?5? units pf service, if not create end of service to it and add to fel
				if(!DEL.isEmpty()) {
					double getCustomerArrivalTime = DEL.pop();//first customer in delay
					Service addCustToService = new Service(getCustomerArrivalTime,mu);
					endOfServiceTime = addCustToService.ServiceTime+arrival.currentArriveTime;//TODO:end of service for endOfService complete
					
					FEL.add(endOfServiceTime);
					CLOCK = endOfServiceTime; //TODO:verify correct time =>arrival.nextArriveTime
				}
				endOfServiceTime = customerServiceEndTime;//service.ServiceTime+arrival.nextArriveTime;
				FEL.add(endOfServiceTime);
				CLOCK = endOfServiceTime; //TODO:verify correct time.
				//FEL.add(endService.ServiceTime);
			}
			latestArrivalTime = arrival.nextArriveTime;
			numberOfCustomer++;
		}
	}
	//methods
    static void printClockTimes(int cust) {
    	System.out.println("custumer #:"+cust);
    }
}
