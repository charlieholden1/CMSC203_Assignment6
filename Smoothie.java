
public class Smoothie extends Beverage{

	private int numFruits;
	private boolean addProtein;
	private final double PROTEIN_PRICE = 1.5;
	private final double FRUIT_PRICE = 0.5;
	
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numFruits = numOfFruits;
		this.addProtein = addProtein;
		
	}
	
	public int getNumOfFruits()
	{
		return numFruits;
	}
	
	public boolean getAddProtein()
	{
		return addProtein;
	}
	
	public String toString()
	{
		return getBevName() + "," + getSize() + "," + getAddProtein() + "," + getNumOfFruits() + "," + calcPrice();
	}
	
	public double calcPrice()
	{
		double price = 0 + addSizePrice();
		if(addProtein == true)
			price += PROTEIN_PRICE;
		for(int i = 0; i < numFruits; i++)
			price += FRUIT_PRICE;
		return price;
	}
	
	public boolean equals(Object anotherBev)
	{
			Smoothie s = (Smoothie) anotherBev;
		
		if(s.getBevName().equals(this.getBevName()) && s.getSize().equals(this.getSize()) & s.getAddProtein()== this.getAddProtein() && this.getNumOfFruits() == s.getNumOfFruits() && this.calcPrice() == s.calcPrice())
			return true;
		else 
			return false;
	}
}
