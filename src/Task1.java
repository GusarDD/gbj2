public class Task1 {
    public static void main(String[] args) {
        Course c = new Course(5);
        Team team = new Team("bamby");
        team.showTeamInfo();
        c.doIt(team);
        team.showResults();
    }
}
