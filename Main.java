class Student {
    String name;
    int[] quizzes;

    Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    double average() {
        int sum = 0;
        for (int score : quizzes) {
            sum += score;
        }
        return (double) sum / quizzes.length;
    }
}

public class Main {
    public static void main(String[] args) {

       
        String[][] data = {
            {"Ryan", "90", "85", "90", "95"},
            {"Carl", "80", "85", "80", "85"},
            {"Geralyn", "90", "85", "90", "95"},
            {"Kevin", "75", "80", "85", "80"}
        };

       
        Student[] students = new Student[data.length];

        for (int i = 0; i < data.length; i++) {
            int[] scores = new int[4];

            for (int j = 0; j < 4; j++) {
                scores[j] = Integer.parseInt(data[i][j + 1]);
            }

            students[i] = new Student(data[i][0], scores);
        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].average() < students[j + 1].average()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

       
        System.out.println("=== STUDENT LEADERBOARD ===");
        System.out.println("Rank  Name   Average");

        int rank = 1;

        for (int i = 0; i < students.length; i++) {
            if (i > 0 &&
                students[i].average() != students[i - 1].average()) {
                rank = i + 1;
            }

            System.out.printf("%-6d %-6s %.2f%n",
                    rank, students[i].name, students[i].average());
        }

        
        String target = "Ryan";
        int foundRank = -1;

        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(target)) {
                foundRank = i + 1;

            
                for (int j = 0; j < i; j++) {
                    if (students[j].average() == students[i].average()) {
                        foundRank = j + 1;
                        break;
                    }
                }
                break;
            }
        }

        if (foundRank != -1) {
            System.out.println(target + "'s rank: " + foundRank);
        } else {
            System.out.println(target + " not found.");
        }
    }
}
