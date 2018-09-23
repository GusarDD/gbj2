public class OneCourse {
    private double weightStrength;
    private double weightJump;
    private double weightSpeed;
    private double weightSwim;
    private String name;

    OneCourse(String name) {
        this.name = name;
        weightStrength = 0.25;
        weightJump = 0.25;
        weightSpeed = 0.25;
        weightSwim = 0.25;
    }

    OneCourse() {
        this.name = "Usual";
        this.weightStrength = 0.25;
        this.weightJump = 0.25;
        this.weightSpeed = 0.25;
        this.weightSwim = 0.25;
    }

    OneCourse(String name, double weightStrength, double weightJump, double weightSpeed, double weightSwim) {
        this.name = name;
        if (weightStrength + weightSpeed + weightJump + weightSwim != 1) {
            System.out.println("Сумма коэффициентов препятствий должна быть равна единице! Будут заданы параметры полосы препятствий по умолчанию!");
            this.weightStrength = 0.25;
            this.weightJump = 0.25;
            this.weightSpeed = 0.25;
            this.weightSwim = 0.25;
        } else {
            this.weightStrength = weightStrength;
            this.weightJump = weightJump;
            this.weightSpeed = weightSpeed;
            this.weightSwim = weightSwim;
        }
    }

    public boolean goTrowCourse(TeamMate man, int dificulty) {
        double res = man.getStrength() * weightStrength + man.getRunSpeed() * weightSpeed + man.getSwimSpeed() * weightSwim + man.getJumpHeight() * weightJump;
        return res >= dificulty;
    }

}
