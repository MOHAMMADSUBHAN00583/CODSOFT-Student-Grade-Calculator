public class StudentGrades {
    private int[] marks;
    private int numberOfSubjects;

    public StudentGrades(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
        marks = new int[numberOfSubjects];
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAveragePercentage() {
        return (getTotalMarks() / (double) numberOfSubjects);
    }

    public String getGrade() {
        double percentage = getAveragePercentage();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
