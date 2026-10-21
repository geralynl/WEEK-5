import java.util.Arrays;

public class SearchSortMiniTool {
    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88, 76, 95, 80};
        int target = 88;
        int index = -1;

    
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1)
            System.out.println("Found at index: " + index);
        else
            System.out.println("Score not found.");

     
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        System.out.println("Original: " + Arrays.toString(scores));
        System.out.println("Sorted: " + Arrays.toString(sortedScores));
    }
}
