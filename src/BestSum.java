import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/22/2022, Saturday
 * @project : dynamic-programming-tabulation-best-sum
 **/
public class BestSum {

    public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum+1, null));
        table.add(0, new ArrayList<>());
        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null){
                for (Integer num : numbers) {
                    ArrayList<Integer> clonedList = (ArrayList<Integer>) table.get(i).clone();
                    clonedList.add(num);
                    if ((i+num) <= targetSum) {
                        if (table.get(i + num) == null){
                            table.set((i + num), clonedList);
                        }
                        if (table.get(i + num).size() > clonedList.size()) {
                            table.set((i + num), clonedList);
                        }
                    }
                }
            }
        }
        return table.get(targetSum);
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(bestSum(8, Arrays.asList(2, 3, 5)));
        System.out.println(bestSum(8, Arrays.asList(1, 4, 5)));
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25)));
    }
}
