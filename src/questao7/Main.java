package questao7;

/* como funciona esta questão?
 * Comecei removendo os espaços em branco da string de entrada
 * Depois, coloquei a entrada na notação pós-fixada
 * Por fim, fiz a conta com esta notação.
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Digite uma expressão aritmética: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        questao7(input);
    }

    public static void questao7(String input) {
        String s;
        PilhaGenerica<Character> stack = stringToPostfixStack(input);
        s = stackToString(stack);
        Posfixada pf = new Posfixada(s.length(), s);
        System.out.printf("%s = %d", input, pf.resposta());
    }

    public static String stackToString(PilhaGenerica<Character> stack) {
        PilhaGenerica<Character> aux = new PilhaGenerica<>(stack.tamanho());
        String s = "";
        while (!stack.vazia())
            aux.push(stack.pop());
        while (!aux.vazia())
            s += aux.pop();
        return s;
    }

    private static PilhaGenerica<Character> stringToPostfixStack(String string) {
        // remove todos os espaços em branco
        string = string.replaceAll("\s++", "");
        PilhaGenerica<Character> stackOperators = new PilhaGenerica<>(string.length()); // espaços desnecessários, mas não consigo pensar de outra forma
        PilhaGenerica<Character> result = new PilhaGenerica<Character>(string.length());
        char temp;

        for (int i = 0; i < string.length(); i++) {
            temp = string.charAt(i);
            if (Character.isDigit(temp)) result.push(temp);
            else if (temp == '(') {
                stackOperators.push(temp);
            } else if (temp == ')') {
                while (stackOperators.retornaTopo() != '(') {
                    result.push(stackOperators.pop());
                }
                stackOperators.pop();
            } else {
                while (!stackOperators.vazia() && stackOperators.retornaTopo() != '(')
                    result.push(stackOperators.pop());
                stackOperators.push(temp);
            }
        }
        while (!stackOperators.vazia()) result.push(stackOperators.pop());

        return result;
    }
}
