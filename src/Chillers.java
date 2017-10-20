import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chillers {

    private Integer[] numbers = {40, 39, 24, 23, 18, 16};

    public Chillers() {
        List<Integer> perm = calc(new ArrayList<>(), 100, 0);
        for (int i : perm) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new Chillers();
    }

    private List<Integer> calc(List<Integer> used, int input, int useIndex) {
        if (Arrays.asList(numbers).contains(input)) {
            // The number left is one of the predefined numbers
            used.add(input);
            return used;
        } else if ((input - numbers[useIndex]) > 0) {
            used.add(numbers[useIndex]);
            return calc(used, input - numbers[useIndex], useIndex);
        } else {
            if (useIndex < numbers.length - 1) {
                return calc(used, input, useIndex + 1);
            } else {
                // Remove numbers until we can go on...
                int indexOfRemoved;
                do {
                    int removed = used.remove(used.size() - 1);
                    indexOfRemoved = Arrays.asList(numbers).indexOf(removed);
                    input += removed;
                } while (indexOfRemoved == numbers.length - 1);

                return calc(used, input, indexOfRemoved + 1);
            }
        }
    }

}

