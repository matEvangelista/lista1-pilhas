package questao1equestao2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        // assumi que o usuário não vai digitar espaços entre as palavras
        System.out.print("Digite um palíndromo conforme pede a questão 1, sem espaços: ");
        String input = scanner.nextLine().toLowerCase();
        questao1(input);

        System.out.print("Digite uma string segundo as intruções da questão 2, sem espaços: ");
        input = scanner.nextLine().toLowerCase();
        questao2(input);
    }

    public static void questao1(String input) {
        if (isPalindrome(stringToStack(input))) System.out.println("Você digitou um palíndromo :)");
        else System.out.println("Você não seguiu as intruções como deveria");
    }

    public static void questao2(String input) {
        boolean foundD = false;
        Stack stack = new Stack(input.length()); // valor alto para não dar problema
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'd') {
                foundD = true;
                // não pode começar nem terminar com a letra D, e a stack formada com os caracteres precisa
                // ser da forma x c y
                if (i + 1 == input.length() || i == 0 || !isPalindrome(stack)) {
                    System.out.println("Você não seguiu as intruções como deveria");
                    return;
                }
                stack = new Stack(input.length()); // "renova" a pilha
                continue;
            }
            stack.push(input.charAt(i)); // adiciona o char da posição i à stack
        }
        
        if (!isPalindrome(stack) || !foundD) {
            System.out.println("Você não seguiu as intruções");
            return;
        }

        System.out.println("Você soube seguir as intruções");

    }

    // apenas coloca a string numa instância da classe Stack
    public static Stack stringToStack(String string) {

        Stack stack = new Stack(string.length());
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));
        return stack;
    }

    // retorna se está na forma como descrito no exercício 1
    public static boolean isPalindrome(Stack stack) {
        /* naturalmente, não pode ser um número par já que, necessariamente, há uma letra C partindo
         * a ‘string’ em dois pedaços iguais*/
        if (stack.size() % 2 == 0) return false;

        int size = stack.size() / 2; // arrendonda para baixo
        Stack firstHalf = new Stack(size); // primeira metada da stack
        Stack secondHalf = new Stack(size); // segunda metade
        Stack invertedSecondHalf = new Stack(size); // segunda metade ao contrário
        boolean foundC = false;

        while (!stack.empty()) {
            char pop = stack.pop();
            if (pop == 'c') {
                foundC = true;
                continue;
            }
            if (foundC) secondHalf.push(pop);
            else firstHalf.push(pop);
        }

        // não está sob o padrão demandado
        if (!foundC) return false;

        // inverte secondHalf e armazena em invertedSecondHalf
        while (!secondHalf.empty()) {
            invertedSecondHalf.push(secondHalf.pop());
        }

        // faz comparação
        while (!firstHalf.empty()) {
            if (firstHalf.pop() != invertedSecondHalf.pop()) return false;
        }

        return true;

    }


}
