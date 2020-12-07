package src;

public class Main {
  public static void main(String[] args) {
    clearScreen();

    GameText text = new GameText();
    GameInput input = new GameInput();

    while (true) {
      int step = text.getStep();
      text.getCurrentText();

      try {
        int inputChoice = Integer.parseInt(input.displayInput());
        int gotoLine = input.getChoiceMapTo(text.getCurrentChoiceAt(inputChoice));
        text.setStep(gotoLine);
      }
      // catch incorrect input (non-integer or out-of-bounds)
      catch (NumberFormatException e) {
        clearScreen();
        text.setStep(step);
        System.out.println("You didn't enter a correct choice. Try again.");
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      }
      catch (NullPointerException e) {
        clearScreen();
        text.setStep(step);
        System.out.println("You didn't enter a correct choice. Try again.");
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      }

      clearScreen();
    }
  }

  public static void clearScreen() {  
    for(int clear = 0; clear < 25; clear++) {
      System.out.println("\b") ;
    }
  }  
}