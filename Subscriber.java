import java.util.List;

public class Subscriber {
	private String userID;
	private String name;
	private MyMedia myMedia;
	
	public Subscriber(String userID, String name, MyMedia myMedia) {
		this.userID = userID;
		this.name = name;
		this.myMedia = myMedia;
	}
	
	public double getFees() {
		return myMedia.calculateFees();
	}
	
	public List<?> sort(String orderType) {
		return myMedia.sort(orderType);
	}
	
	@Override
	public String toString() {
		return (this.name + " Acc. No: " + this.userID + " total charge is " + String.format("%.2f", getFees()) + " for:\n\n" + myMedia.toString());
	}
}
