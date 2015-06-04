public class Faktuur implements Betaalbaar {

	int bedrag = 0;
	int faktnr = 0;
	
	public Faktuur(int bedrag, int factnr)
	{
	this.bedrag = bedrag;
	this.faktnr = faktnr;
	}

	public void betaal()
	{
	System.out.println("Betaal het faktuur " + faktnr + " voor een bedrag van " + bedrag);
	}
}