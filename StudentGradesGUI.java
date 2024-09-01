import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradesGUI extends JFrame {
    private JTextField[] marksFields;
    private JButton calculateButton;
    private JLabel totalMarksLabel;
    private JLabel averagePercentageLabel;
    private JLabel gradeLabel;

    public StudentGradesGUI(int numberOfSubjects) {
        setTitle("Student Grades Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(numberOfSubjects + 5, 2, 10, 10));

        marksFields = new JTextField[numberOfSubjects];

        // Input fields for marks
        for (int i = 0; i < numberOfSubjects; i++) {
            add(new JLabel("Marks for Subject " + (i + 1) + ":"));
            marksFields[i] = new JTextField();
            add(marksFields[i]);
        }

        // Button to calculate results
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(new JLabel("")); // Empty label for layout
        add(calculateButton);

        // Labels for results
        totalMarksLabel = new JLabel("Total Marks: ");
        add(totalMarksLabel);

        averagePercentageLabel = new JLabel("Average Percentage: ");
        add(averagePercentageLabel);

        gradeLabel = new JLabel("Grade: ");
        add(gradeLabel);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numberOfSubjects = marksFields.length;
                int[] marks = new int[numberOfSubjects];

                for (int i = 0; i < numberOfSubjects; i++) {
                    marks[i] = Integer.parseInt(marksFields[i].getText());
                }

                StudentGrades studentGrades = new StudentGrades(numberOfSubjects);
                studentGrades.setMarks(marks);

                int totalMarks = studentGrades.getTotalMarks();
                double averagePercentage = studentGrades.getAveragePercentage();
                String grade = studentGrades.getGrade();

                totalMarksLabel.setText("Total Marks: " + totalMarks);
                averagePercentageLabel.setText(String.format("Average Percentage: %.2f", averagePercentage));
                gradeLabel.setText("Grade: " + grade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(StudentGradesGUI.this, "Please enter valid numbers for all subjects.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int numberOfSubjects = 5; // Example: 5 subjects
            StudentGradesGUI gui = new StudentGradesGUI(numberOfSubjects);
            gui.setVisible(true);
        });
    }
}
