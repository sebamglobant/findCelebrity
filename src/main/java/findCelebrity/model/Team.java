package findCelebrity.model;

import java.util.Stack;

public class Team {
    private int teamMatrix[][];
    private int n;

    public Team(int n) {
        this.n = n;
        this.teamMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                teamMatrix[i][j] = 0;
            }
        }
    }

    public int[][] getTeamMatrix() {
        return teamMatrix;
    }

    public void setTeamMatrix(int[][] teamMatrix) {
        this.teamMatrix = teamMatrix;
    }

    /**
     * Functions that return the celebrity in the team
     * */
    public void findCelebrity() {

        Stack<Integer> members = new Stack<>();
        /**
         * Add every id member into the Stack
         * */
        for(int i = 0; i < this.n; i++) {
            members.push(i);
        }

        while (members.size() > 1) {
            int a = members.pop();
            int b = members.pop();

            if(this.knows(a,b)) {
                /**
                 * Return b to the stack because if a knows b, may be b is the celebrity and a is discarded
                 * because knows someone
                 * */
                members.push(b);
            } else {
                /**
                 * Return a to the stack because if a doesn't know b, may be a is the celebrity and b is
                 * discarded because there is at least one member that doesn't know b
                 * */
                members.push(a);
            }
        }
    }

    /**
     * Functions that takes 2 members ids (a and b), and return true if a knows b,
     * false if a doesn't knows b
     * */
    private boolean knows(int a, int b) {
        return (this.teamMatrix[a][b] == 1) ? true : false;
    }

    @Override
    public String toString() {
        String printedTeam = "";
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (j != this.n - 1){
                    printedTeam += this.teamMatrix[i][j] + ",";
                } else {
                    printedTeam += this.teamMatrix[i][j] + "\n";
                }
            }
        }
        return printedTeam;
    }
}
