
public class Customer {
	//variables
	int CostumerNumber=0;
	double ArrivalTime=999999999;
	private double ServiceTime=0;
	
	//constructor
	public Customer(int latestNumber) {
		this.CostumerNumber = latestNumber;
	}

	//methods
	public void setArriveTime(double arrivalTime) {
		this.ArrivalTime = arrivalTime;
	}
	public void setServiceTime(double serviceTime) {
		this.ServiceTime = serviceTime;
	}

}
