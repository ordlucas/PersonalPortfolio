import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameText {
  private int step;
  private List<String> lines;
  private Map<Integer, Integer> currentChoices;
  
  public GameText() {
    this.step = 1;
    this.lines = new ArrayList<String>();
    this.currentChoices = new HashMap<Integer, Integer>();
    readText();
  }

  public void getCurrentText() {
    currentChoices.clear();
    for(int i = step; i < lines.size(); i++) {
      // if it is a comment
      if(lines.get(i).charAt(0) != '#') {
        // check for end of block
        if(!lines.get(i).equals("---") && !lines.get(i).equals("???")) {
          System.out.println(lines.get(i));
        }
        // choices
        if (lines.get(i).equals("???")) {
          // store choices in map
          int j = i + 1;
          while(!lines.get(j).equals("---")) {
            currentChoices.put(j-i, j);
            j++;
          }
        }
        // end of block
        if (lines.get(i).equals("---")) {
          step = i;
          break;
        }
      }
    }
  }

  public int getCurrentChoiceAt(int choice) {
    return(currentChoices.get(choice));
  }

  public void changeStep(int step) {
    this.step = step;
  }


	public void readText() {
		BufferedReader reader;
		try {
      reader = new BufferedReader(new FileReader("res/text.txt"));
      
      lines.add("");
      
			String line = reader.readLine();
			while (line != null) {
        // store in lines array
        this.lines.add(line);

        // read next line
        line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}