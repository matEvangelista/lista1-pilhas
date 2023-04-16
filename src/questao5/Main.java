package questao5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Digite algo com parênteses, chaves e colchetes. Depois, diremos se você o fez corretamente: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        questao5(input);
    }

    public static void questao5(String string) {
        Stack stack = stringToStack(string);
        confereBalanceado(stack);
    }

    public static void confereBalanceado(Stack stack) {
        Stack closingBrackets = new Stack(stack.size());
        while (!stack.empty()) {
            char temp = stack.pop();
            if (isBracket(temp)) {
                if(closingBracket(temp)) {
                    closingBrackets.push(temp);
                }
                else {
                    if (closingBrackets.empty()) {
                        System.out.println("Erro");
                        return;
                    }
                    if (!areEquivalent(temp, closingBrackets.pop())) {
                        System.out.println("Erro");
                        return;
                    }
                }
            }
        }
        System.out.println("deu certo :)");
    }

    // ], ) e }
    public static boolean closingBracket(char c) {
        return c == ']' || c == ')' || c == '}';
    }

    public static boolean isBracket(char c) {
        return closingBracket(c) || c == '[' || c == '(' || c == '{';
    }

    // checa se são equivalentes, ou seja, (), [], {}
    public static boolean areEquivalent(char c1, char c2) {
        if (c1 == '(') return c2 == ')';
        if (c1 == '[') return c2 == ']';
        if (c1 == '{') return c2 == '}';
        return false;
    }


    public static Stack stringToStack(String string) {

        Stack stack = new Stack(string.length());
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));
        return stack;
    }
}
