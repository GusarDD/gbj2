public class Course {
    private int difficulty;
    private OneCourse[] course;

    Course(int difficulty) {
        this.difficulty = difficulty;
        this.course = new OneCourse[6];
        this.course[0] = new OneCourse("Run", 0.3, 0.5, 0.1, 0.1);
        this.course[1] = new OneCourse("Swimming", 0.15, 0.25, 0.1, 0.5);
        this.course[2] = new OneCourse("Jump", 0.15, 0.25, 0.5, 0.1);
        this.course[3] = new OneCourse("Weight", 0.5, 0.1, 0.1, 0.3);
        this.course[4] = new OneCourse("Common");
        this.course[5] = new OneCourse();
    }

    public OneCourse[] getCourse() {
        return course;
    }

    public void setCourse(OneCourse[] course) {
        this.course = course;
    }

    public void doIt(Team teamMen) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < course.length; j++) {
                teamMen.getTeam()[i].updateFinishCourse(course[j].goTrowCourse(teamMen.getTeam()[i], difficulty));
            }
        }
    }
}
