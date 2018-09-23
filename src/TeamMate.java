public class TeamMate {
    private String name;
    private int strength;
    private int runSpeed;
    private int jumpHeight;
    private int swimSpeed;
    private boolean finishCourse;

    TeamMate(String name, int strength, int runSpeed, int jumpHeight, int swimSpeed) {
        this.name = name;
        this.strength = strength;
        this.runSpeed = runSpeed;
        this.jumpHeight = jumpHeight;
        this.swimSpeed = swimSpeed;
        finishCourse = true;
    }

    TeamMate(String name) {
        this.name = name;
        this.strength = 5;
        this.runSpeed = 6;
        this.jumpHeight = 5;
        this.swimSpeed = 4;
        finishCourse = true;
    }

    TeamMate() {
        this.name = "замена";
        this.strength = 5;
        this.runSpeed = 5;
        this.jumpHeight = 5;
        this.swimSpeed = 5;
        finishCourse = true;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public boolean getFinishCourse() {
        return finishCourse;
    }


    public void setFinishCourse(boolean finishCourse) {
        this.finishCourse = finishCourse;
    }


    public void updateFinishCourse(boolean finishCourse) {
        this.finishCourse &= finishCourse;
    }

    public void showTeamMateInfo() {
        System.out.println(name + "'s strength is " + strength + "; run speed is " + runSpeed + "; jump height is " + jumpHeight + "; swim speed is " + swimSpeed);
    }
}
