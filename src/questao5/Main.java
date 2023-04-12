package questao5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Stack stack = convertsStringToStack(input);
        confereBalanceado(stack, input.length());
    }


    public static void confereBalanceado(Stack stack, int length) {
        Stack ultimoTras = new Stack(length);
        while (!stack.empty()) {
            char temp = stack.pop();
            if (ehChave(temp)) {
                if(estaParaTras(temp)) {
                    ultimoTras.push(temp);
                }
                else {
                    if (ultimoTras.empty()) {
                        System.out.println("Erro");
                        return;
                    }
                    if (!saoEquivalentes(temp, ultimoTras.pop())) {
                        System.out.println("Erro");
                        return;
                    }
                }
            }
        }
        System.out.println("deu certo :)");
    }

    // ], ) e }
    public static boolean estaParaTras(char c) {
        return c == ']' || c == ')' || c == '}';
    }

    public static boolean ehChave(char c) {
        return c == ']' || c == ')' || c == '}' || c == '[' || c == '(' || c == '{';
    }

    // checa se são equivalentes, ou seja, (), [], {}
    public static boolean saoEquivalentes(char c1, char c2) {
        if (c1 == '(') return c2 == ')';
        if (c1 == '[') return c2 == ']';
        if (c1 == '{') return c2 == '}';
        return false;
    }


    public static Stack convertsStringToStack(String string) {

        Stack stack = new Stack(string.length());
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));
        return stack;
    }
}
