
public abstract class Beverage {

	private String name;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	Beverage(String bevName, Type type, Size size)
	{
		name = bevName;
		this.type = type;
		this.size = size;
	}
	
	public double getBasePrice()
	{
		return BASE_PRICE;
	}
	
	public Size getSize()
	{
		return size;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public String getBevName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + "," + size;
	}
	
	public boolean equals(Object anotherBev)
	{
		Beverage s = (Beverage) anotherBev;
		if(s.getBevName().equals(this.getBevName()) && s.getSize().equals(this.getSize()) && s.getType().equals(this.getType()))
		{
			return true;
		} else
			return false;
	}
	
	public double addSizePrice()
	{
		if(size.equals(Size.SMALL))
		return BASE_PRICE;
		else if(size.equals(Size.MEDIUM))
			return BASE_PRICE + SIZE_PRICE;
		else
			return BASE_PRICE + SIZE_PRICE + SIZE_PRICE;
	}
	
	public abstract double calcPrice();
}
