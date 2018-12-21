package findCelebrity;

import findCelebrity.model.Team;
import findCelebrity.reader.FileReader;

import java.util.List;

public class App {
    public String getGreeting() {
        return "Find the celebrity!.";
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<Team> teams;

        try {
            teams = fileReader.loadTestCases();
        } catch (Exception e) {
            System.out.println("Can't find or read the test cases file.");
        }
    }
}
