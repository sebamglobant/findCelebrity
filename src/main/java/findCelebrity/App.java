package findCelebrity;

import findCelebrity.model.Team;
import findCelebrity.reader.FileReader;
import findCelebrity.util.AppLogger;

import java.util.List;
import java.util.logging.Logger;

public class App {

    private static final Logger log = Logger.getLogger("AppLogger");
    public String getGreeting() {
        return "Find the celebrity!.";
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<Team> teams;

        try {
            teams = fileReader.loadTestCases();

            for (int i = 0; i < teams.size(); i++) {
                log.info("Celebrity ID in team " + i + ": " + teams.get(i).findCelebrity());
            }
        } catch (Exception e) {
            log.info("Can't find or read the test cases file.");
        }
    }
}
