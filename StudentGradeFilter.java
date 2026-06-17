import java.util.ArrayList;
import java.util.Arrays;

public class StudentGradeFilter {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(
                95, 82, 39, 40, 76, 90, 12, 67, 88, 100
        ));

        for (int score : scores) {
            if (score >= 90) {
                System.out.println(score + " -> Distinction");
            } else if (score >= 40) {
                System.out.println(score + " -> Pass");
            } else {
                System.out.println(score + " -> Fail");
            }
        }
    }
}
