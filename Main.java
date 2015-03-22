import java.io.BufferedReader;
import java.io.InputStreamReader;

import Setup.UseCases;

public class Main {

  public static void main(String[] args) {
  	//Displaying the menu
  	System.out.println("Valassz az alabbi menupontok kozul, a megfelelo use-case lejatszasahoz!\n"
  					+ "1. Jatek inditasa \n"
  					+ "2. Gyorsitas, lassitas \n"
  					+ "3. Item lerakasa \n"
  					+ "4. Olaj lerakasa \n"
  					+ "5. Ragacs lerakasa \n"
  					+ "6. Lyukra ugras \n"
  					+ "7. Olajra lepes \n"
  					+ "8. Ragacsra lepes \n"
  					+ "9. Jatek leptetese \n"
  					+ "10. Jatak vege \n\n"
  					+ "Nyomj nullat a kilepeshez!");
  	int place;
  	
  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  	
  	try {
  		String temp;
  		boolean going = true;
  		
  		// Loop for the menu
  		while (going){
        temp = reader.readLine();
  		  place = Integer.parseInt(temp);
  		  
  		  // Handling the typed in command
  		  switch(place){
    			case 1: System.out.println("- 1. Jatek inditasa");
    				UseCases.startGame();
    				break;
    					
    			case 2:	System.out.println("- 2. Gyorsitas, lassitas");
  					System.out.println("? Melyik iranyba akarsz gyorsitani?	E/H");
  					temp = reader.readLine();
  					if (temp.equals("E"))	UseCases.accelerateOrDecelerate(true);
  					else UseCases.accelerateOrDecelerate(false);
  					break;
    					
    			case 3:	System.out.println("- 3. Item lerakasa");
  					UseCases.placeItems(true);
  					break;
    					
    			case 4:	System.out.println("- 4. Olaj lerakasa");
  					UseCases.placeOil();
  					break;
    					
    			case 5:	System.out.println("- 5. Ragacs lerakasa");
  					UseCases.placeTacky();
  					break;
    					
    			case 6:	System.out.println("- 6. Lyukra ugras");
  					UseCases.holeInteract();
  					break;
    					
    			case 7:	System.out.println("- 7. Olajra lepes");
  					UseCases.oilInteract();
  					break;
    					
    			case 8:	System.out.println("- 8. Ragacsra lepes");
  					UseCases.tackyInteract();
  					break;
    					
    			case 9:	System.out.println("- 9. Jatek leptetese");
  					UseCases.stepGame();
  					break;
    					
    			case 10: System.out.println("- 10. Jatek vege");
  					 System.out.println("? Lejart az ido, vagy mindenki kiesett?	L/K");
  					 temp = reader.readLine();
  					 if (temp.equals("L"))	UseCases.endGame(false);
  					 else UseCases.endGame(true);
  					 break;
    					 
    			case 0: going = false;
  				  break;
    					
    			default: System.out.println("Ervenytelen parancs!");
  		  }
  		}
  	} catch (Exception e) {
  	  // If a wrong key was pressed the program exits
  		System.out.println("Hibas beolvasas! A program kilep.");
  	}
  }
}
