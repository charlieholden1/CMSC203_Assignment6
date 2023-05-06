import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class Order implements OrderInterface{

	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> bevs = new ArrayList<>();
	
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}
	
	public int generateOrder()
	{
		Random rand = new Random();
		int upper = 90001, lower = 10000;
		return rand.nextInt(upper-lower) + lower;
		
	}
	
	public int getOrderNo()
	{
		return orderNumber;
	}
	
	public int getOrderTime()
	{
		return orderTime;
	}
	
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(cust);
	}
	
	public Day getDay()
	{
		return orderDay;
	}
	
	public boolean isWeekend()
	{
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
			return true;
		else 
			return false;
	}
	
	public Beverage getBeverage(int itemNo)
	{
		return bevs.get(itemNo);
	}
	
	public int getTotalItems()
	{
		return bevs.size();
	}
	
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		bevs.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	public void addNewBeverage(String bevName, Size size)
	{
		bevs.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		bevs.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	public double calcOrderTotal()
	{
		double totalPrice = 0;
		for(int i = 0; i < bevs.size();i++)
		{
			totalPrice += bevs.get(i).calcPrice();
		}
		
		return totalPrice;
	}
	
	public int findNumOfBeveType(Type type)
	{
		int numOfType = Collections.frequency(bevs, type);
		return numOfType;
	}
	
	public String toString()
	{
		String tS = orderNumber + "," + orderTime + "," + orderDay + "," + cust.getName() + "," + cust.getAge()
		+ ", Beverages:\n";
		for(int i = 0; i < bevs.size();i++)
		{
			tS += bevs.get(i).getBevName() + "\n";
		}
		return tS;
	}
	
	public int compareTo(Order anotherOrder)
	{
		if(this.getOrderNo() > anotherOrder.getOrderNo())
			return 1;
		else if(this.getOrderNo() == anotherOrder.getOrderNo())
			return 0;
		else
			return -1;
	}
}
