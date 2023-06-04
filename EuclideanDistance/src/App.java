import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        getIntelligence();
        //sortPlayers();
    }

    public static void getIntelligence() {
        List<Integer> individualPoints = Arrays.asList(2, 2, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2);
        String predominantIntelligenceType = IntelligenceClassifier.getPredominantIntelligenceType(individualPoints);
        System.out.println("The predominant intelligence type is: " + predominantIntelligenceType);
    }

    public static void sortPlayers() {

        List<Integer> personalPoints = Arrays.asList(2, 2, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2);

        List<String> playersNames = new ArrayList<>();
        playersNames.add("Pablo");
        playersNames.add("Pedro");
        playersNames.add("Maria");
        playersNames.add("Rolo");
        playersNames.add("Gonzalo");
        playersNames.add("Esperanza");

        List<List<Integer>> playersPoints = new ArrayList<>();
        playersPoints.add(Arrays.asList(2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1));
        playersPoints.add(Arrays.asList(2, 2, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2));
        playersPoints.add(Arrays.asList(1, 3, 1, 3, 3, 3, 2, 2, 3, 2, 2, 2));
        playersPoints.add(Arrays.asList(2, 1, 2, 2, 3, 2, 2, 2, 3, 3, 2, 2));
        playersPoints.add(Arrays.asList(2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 2, 2));
        playersPoints.add(Arrays.asList(1, 2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 3));
    
        List<String> sorted = IntelligenceClassifier.sortPlayersByIntelligence(personalPoints, playersNames, playersPoints);

        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
    }
}
