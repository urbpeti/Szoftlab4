import Setup.UseCases;

public class Main {

  public static void main(String[] args) {
    UseCases.startGame();

    UseCases.endGame(true);

    UseCases.accelerateOrDecelerate(true);

    UseCases.placeItems(true);

    UseCases.placeOil();

    UseCases.placeTacky();

    UseCases.stepGame();

    UseCases.holeInteract();

    UseCases.oilInteract();

    UseCases.tackyInteract();
  }

}
