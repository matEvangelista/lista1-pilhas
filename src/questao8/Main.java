package questao8;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 14, 8, 7, 3, 9};
        printsSubArrays(array);
    }

    public static void printsSubArrays(int[] array) {
        sortArray(array);
        PilhaGenerica<int[]> stack = returnsSubArrays(array);
        while (!stack.vazia()) {
            int[] pop = stack.pop();
            System.out.printf("(%d, %d)\n", pop[0], pop[1]);
        }
    }

    public static PilhaGenerica<int[]> returnsSubArrays(int[] sortedArray) {
        // assumindo que serão digitados pelo menos 2 números
        PilhaGenerica<int[]> stack = new PilhaGenerica<>(sortedArray.length - 1);
        PilhaGenerica<Integer> stackNumbers = arrayToStack(sortedArray);
        int temp;
        while (!stackNumbers.vazia()) {
            int temp2 = stackNumbers.pop();
            if (temp2 == sortedArray[0])
                break;
            temp = stackNumbers.pop();
            stack.push(new int[]{temp2, temp});
            stackNumbers.push(temp);
        }
        return stack;
    }

    public static PilhaGenerica<Integer> arrayToStack(int[] array) {
        PilhaGenerica<Integer> stack = new PilhaGenerica<>(array.length);
        for (int x : array)
            stack.push(x);
        return stack;
    }

    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int temp = array[i];
                if (array[i] < array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
