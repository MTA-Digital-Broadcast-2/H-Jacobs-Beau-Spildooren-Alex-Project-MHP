public class EersteProg {

public static void main(String args[])
	
	{
	Werknemer Herman=new Werknemer("Herman", "Hermans", 1, 1000);
	Werknemer Koen=new Werknemer("Koen", "Soontjes", 2, 1000);
	Werknemer Lorenz=new Werknemer("Lorenz", "Adriaensen", 3, 1000);
	Werknemer Jurgen=new Werknemer("Jurgen", "Dedeckere", 4, 1100);
	
	System.out.println(Koen.voornaam + " verdient " + Koen.getSalaris());

	//oef 2
	Herman.salarisVerhogen(10);
	Koen.salarisVerhogen(10);

	System.out.println(Herman.voornaam + " verdient " + Herman.getSalaris());
	System.out.println(Koen.voornaam + " verdient " + Koen.getSalaris());

	//oef 3
	PartTimeWerknemer Ilse=new PartTimeWerknemer("Ilse", "Luiaert", 5, 12, 8);
	PartTimeWerknemer Peggy=new PartTimeWerknemer("Peggy", "Tammegans", 6, 11, 10); 
	
	//oef 4
	Ilse.salarisVerhogen(10);
	Peggy.salarisVerhogen(5);

	//oef 5
	System.out.println(Ilse.voornaam + " betaalt " + Ilse.getSalaris());
	System.out.println(Peggy.voornaam + "betaalt " + Peggy.getSalaris());
	
	//oef 6 //werkt niet om een of andere reden
	//Ilse.setRSZ(2.0f);
	//System.out.println(Koen.voornaam + " betaalt " + Koen.getRSZ() + "% RSZ");
							     
	}

}