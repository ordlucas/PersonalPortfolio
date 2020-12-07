public class Main {
  public static void main(String[] args) {
    clearScreen();

    GameText text = new GameText();
    GameInput input = new GameInput();

    while(true) {
      text.getCurrentText();
      
      int inputChoice = Integer.parseInt(input.displayInput());
      int gotoLine = input.getChoiceMapTo(text.getCurrentChoiceAt(inputChoice));
      text.changeStep(gotoLine);
      
      clearScreen();
    }
  }

  public static void clearScreen() {  
    for(int clear = 0; clear < 25; clear++) {
      System.out.println("\b") ;
    }
  }  
}