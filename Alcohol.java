
public class Alcohol extends Beverage{

	private boolean isWeekend;
	private final double WEEKEND_PRICE = 0.6;
	
	
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	
	public double calcPrice()
	{
		double price = 0 + addSizePrice();
		if(isWeekend == true)
			price += 0.6;
		return price;
	}
	
	public String toString()
	{
		return this.getBevName() + "," + this.getSize() + "," + isWeekend + "," + calcPrice();
	}
	
	public boolean equals(Object anotherBev)
	{
Alcohol s = (Alcohol) anotherBev;
		
		if(s.getBevName().equals(this.getBevName()) && s.getSize().equals(this.getSize()) & s.isWeekend()== this.isWeekend() && this.calcPrice() == s.calcPrice())
			return true;
		else 
			return false;
	}
	
	public boolean isWeekend()
	{
		if(isWeekend == true)
			return true;
		else
			return false;
	}
}
