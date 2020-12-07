import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class GameInput {

  private Map<Integer, Integer> choices;
  private Scanner inputScanner;

  public GameInput() {
    this.choices = new HashMap<Integer, Integer>();
    this.inputScanner = new Scanner(System.in);
    readChoices();
  }

  public String displayInput() {
    System.out.print("> ");
    String input = inputScanner.next();
    
    return(input);
  }

  public int getChoiceMapTo(int lineNum) {
    return(choices.get(lineNum));
  }

  public void closeScanner() {
    inputScanner.close();
  }

  public void readChoices() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("res/choices.txt"));
			String line = reader.readLine();
			while (line != null) {
        // store in choices map
        int spacePos = line.indexOf(" ");
        choices.put(Integer.parseInt(line.substring(0, spacePos)), Integer.parseInt(line.substring(spacePos + 1)));
        
        // read next line
        line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}