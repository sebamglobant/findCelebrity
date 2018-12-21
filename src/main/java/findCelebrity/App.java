package findCelebrity;

import findCelebrity.model.Team;
import findCelebrity.reader.FileReader;

import java.util.ArrayList;
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

            for (int i = 0; i < teams.size(); i++) {
                System.out.println("Celebrity ID in team " + i + ": " + teams.get(i).findCelebrity());
            }
        } catch (Exception e) {
            System.out.println("Can't find or read the test cases file.");
        }
    }
}
