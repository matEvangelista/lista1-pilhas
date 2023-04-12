package questao8;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printsSubArrays(array);
    }

    public static void printsSubArrays(int[] array) {
        PilhaGenerica<PilhaGenerica<Integer>> stack = returnsSubArrays(array);
        while (!stack.vazia()) {
            PilhaGenerica<Integer> subSequences = stack.pop();
            System.out.printf("(%d, %d)\n", subSequences.pop(), subSequences.pop());
        }
    }

    public static PilhaGenerica<PilhaGenerica<Integer>> returnsSubArrays(int[] sortedArray) {
        // assumindo que serão digitados pelo menos 2 números
        PilhaGenerica<PilhaGenerica<Integer>> stack = new PilhaGenerica<>(sortedArray.length - 1);
        PilhaGenerica<Integer> stackNumbers = arrayToStack(sortedArray);
        int temp1, temp2;
        while (!stackNumbers.vazia()) {
            temp1 = stackNumbers.pop();
            if (sortedArray[0] == temp1) // naturalmente, o menor da lista não vai ser maior que qualquer um
                break;
            temp2 = stackNumbers.pop();
            PilhaGenerica<Integer> tempStack = new PilhaGenerica<>(2);
            tempStack.push(temp2);
            tempStack.push(temp1);
            stack.push(tempStack);
            stackNumbers.push(temp2); // o segundo maior vai para o topo
        }
        return stack;
    }

    public static PilhaGenerica<Integer> arrayToStack(int[] array) {
        PilhaGenerica<Integer> stack = new PilhaGenerica<>(array.length);
        for (int x : array)
            stack.push(x);
        return stack;
    }

}
