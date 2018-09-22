public class Team {
    private String name;
    private TeamMate[] team;

    Team(String name) {
        this.name = name;
        this.team = new TeamMate[4];
        this.team[0] = new TeamMate("Viktor", 6, 8, 9, 3);
        this.team[1] = new TeamMate();
        this.team[2] = new TeamMate("Valentina");
        this.team[3] = new TeamMate("Mikhail", 10, 10, 10, 10);
    }

    public void showTeamInfo() {
        System.out.println("The team " + name + ":");
        for (int i = 0; i < 4; i++) {
            team[i].showTeamMateInfo();
        }
    }

    public void showResults() {
        System.out.println("Следующие участники команды прошли дистанцию:");
        for (int i = 0; i < 4; i++) {
            if (this.team[i].getFinishCourse()) {
                System.out.println(team[i].getName());
            }
        }
    }

    public TeamMate[] getTeam() {
        return team;
    }
}
