import java.util.*;

public class BevShop implements BevShopInterface{

	public ArrayList<Order> orders;
	int MIN_AGE_FOR_ALCOHOL = 21;  //Minimum age for offering alcohol drink
	int MAX_ORDER_FOR_ALCOHOL= 3;   /*Maximum number of alcohol beverages
										that can be ordered within an order  */
	int MIN_TIME= 8;				//earliest time for the order
	int MAX_TIME= 23;				//latest  time for the order
	int MAX_FRUIT = 5;				//Maximum number of fruits that this shop offers for SMOOTHIE beverage
	
	
	public BevShop()
	{
		
	}
	
	public boolean isValidTime(int time)
	{
		if(time >= MIN_TIME && time <=MAX_TIME)
			return true;
		else
			return false;
	}
	
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits)
	{
		if(numOfFruits > MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public boolean isEligibleForMore()
	{
		if(getNumOfAlcoholDrink() > 2)
			return false;
		else
			return true;
	}
	
	public int getNumOfAlcoholDrink()
	{
		int numOfType = Collections.frequency(orders, Type.ALCOHOL);
		return numOfType;
	}
	
	public boolean isValidAge(int age)
	{
		if(age >= MIN_AGE_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		
		Customer thisCust = new Customer(customerName, customerAge);
		orders.add(new Order(time, day, thisCust));
	}
	
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, Size size)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size);
	}
	
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	public int findOrder(int orderNo)
	{
		for(int i = 0;i < orders.size();i++)
		{
			if(orders.get(i).getOrderNo() == orderNo)
				return i;
		}
			return -1;
	}
	
	public double totalOrderPrice(int orderNo)
	{
		int i = 0;

		double total = orders.get(i).calcOrderTotal();

		return total;
	}
	
	public double totalMonthlySale()
	{
		double total = 0;
		for(int i = 0;i < orders.size();i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}
	
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}
	
	public Order getCurrentOrder()
	{
		return orders.get(orders.size()-1);
	}
	
	public Order getOrderAtIndex(int index)
	{
		return orders.get(index);
	}
	
	public void sortOrders()
	{
		for(int i = 0;i < orders.size();i++)
		{
			int index = i;
			 for (int j = i + 1; j < orders.size(); j++)
			 {  
				 if(orders.get(j).getOrderNo() < orders.get(index).getOrderNo())
					 index = j;
			 }
			 Order smallest = orders.get(index);
			 Collections.swap(orders, index, i);
			 orders.set(i, smallest);
		}
		
	}
	
	public String toString()
	{
		String tS = "Orders:";
		for(int i = 0;i < orders.size();i++)
		{
			tS += orders.get(i).toString() + "\n";
		}
		tS += totalMonthlySale();
		return tS;
	}
}
