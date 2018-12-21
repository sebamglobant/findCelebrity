package findCelebrity.reader;

import findCelebrity.model.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private final String resourcesPath = "./src/main/resources/";
    private String currentLine;

    /***
     * This function read the testCases.txt file and return a list of teams with
     * the respective teamMatrix for each one.
     */
    public List<Team> loadTestCases() throws FileNotFoundException {

        List<Team> teams = new ArrayList<>();

        File file = new File( this.resourcesPath + "testCases.txt");
        Scanner sc = new Scanner(file);

        int numCases = sc.nextInt();
        sc.nextLine();
        System.out.println("Test Cases to load: " + numCases);

        int contCases = 1;
        while(contCases <= numCases) {
            System.out.println(" Loading test case " + contCases);

            teams.add(this.generateTeamMatrix(sc));
            contCases++;
        }

        return teams;
    }

    /**
     * This function return a Team Matrix based on the test case matrix
     * */
    private Team generateTeamMatrix(Scanner sc) {

        int teamMembers = Integer.parseInt(sc.nextLine());
        System.out.println("  People in this team: " + teamMembers);
        Team team = new Team(teamMembers);

        int contMembers = 0;
        while(contMembers < teamMembers) {
            this.currentLine = sc.nextLine();
            String[] data = this.currentLine.split(",");
            for (int i = 0; i < data.length; i++) {
                team.getTeamMatrix()[contMembers][i] = Integer.parseInt(data[i]);
            }
            contMembers++;
        }

        System.out.println("  Team matrix loaded");
        return team;
    }
}
