import java.io.BufferedReader;
import java.io.InputStreamReader;

import Setup.UseCases;

public class Main {

  public static void main(String[] args) {
	//Menüpontok kiírása
	System.out.println("Válassz az alábbi menüpontok kzül, a megfelelõ use-case lejátszásához!\n"
					+ "1. Játék indítása \n"
					+ "2. Gyorsítás, lassítás \n"
					+ "3. Item lerakása \n"
					+ "4. Olaj lerakása \n"
					+ "5. Ragacs lerakása \n"
					+ "6. Lyukra ugrás \n"
					+ "7. Olajra lépés \n"
					+ "8. Ragacsra lépés \n"
					+ "9. Játék léptetése \n"
					+ "10. Játék vége \n\n"
					+ "Nyomj nullát a kilépéshez!");
	int place;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	try {
		String temp;
		boolean going = true;
		//Ciklus a menühöz
		while (going){
		temp = reader.readLine();
		place = Integer.parseInt(temp);
		switch(place){
			case 1: System.out.println("- 1. Játék indítása");
					UseCases.startGame();
					break;
					
			case 2:	System.out.println("- 2. Gyorsítás, lassítás");
					System.out.println("? Melyik irányba akarsz gyorsítani?	E/H");
					temp = reader.readLine();
					if (temp.equals("E"))	UseCases.accelerateOrDecelerate(true);
					else UseCases.accelerateOrDecelerate(false);
					break;
					
			case 3:	System.out.println("- 3. Item lerakása");
					UseCases.placeItems(true);
					break;
					
			case 4:	System.out.println("- 4. Olaj lerakása");
					UseCases.placeOil();
					break;
					
			case 5:	System.out.println("- 5. Ragacs lerakása");
					UseCases.placeTacky();
					break;
					
			case 6:	System.out.println("- 6. Lyukra ugrás");
					UseCases.holeInteract();
					break;
					
			case 7:	System.out.println("- 7. Olajra lépés");
					UseCases.oilInteract();
					break;
					
			case 8:	System.out.println("- 8. Ragacsra lépés");
					UseCases.tackyInteract();
					break;
					
			case 9:	System.out.println("- 9. Játék léptetése");
					UseCases.stepGame();
					break;
					
			case 10: System.out.println("- 10. Játék vége");
					 System.out.println("? Lejárt az idõ, vagy mindenki kiesett?	L/K");
					 temp = reader.readLine();
					 if (temp.equals("L"))	UseCases.endGame(false);
					 else UseCases.endGame(true);
					 break;
					 
			case 0: going = false;
					break;
					
			default: System.out.println("Érvénytelen parancs!");
				
		}
	}
	} catch (Exception e) {
		System.out.println("Hibás beolvasás! A program kilép.");
	}
  }

}
