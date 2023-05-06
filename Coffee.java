
public class Coffee extends Beverage{
	
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_PRICE = 0.5;
	private final double EXTRA_SYRUP_PRICE = 0.5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName,Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		
	}
	
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	public double calcPrice()
	{
		double price = 0 + addSizePrice();
		if(extraShot == true)
			price += EXTRA_SHOT_PRICE;
		if(extraSyrup == true)
			price += EXTRA_SYRUP_PRICE;
		return price;
		
	}
	
	public String toString()
	{
		return this.getBevName() + "," + this.getSize() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
	}
	
	public boolean equals(Object anotherBev)
	{
		Coffee s = (Coffee) anotherBev;
		
		if(s.getBevName().equals(this.getBevName()) && s.getSize().equals(this.getSize()) & s.getExtraShot()== this.getExtraShot() && this.getExtraSyrup() == s.getExtraSyrup() && this.calcPrice() == s.calcPrice())
			return true;
		else 
			return false;
			
	}
}
