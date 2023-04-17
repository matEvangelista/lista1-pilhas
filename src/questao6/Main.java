package questao6;

import java.util.Scanner;

/*
 * como foi feito: Pilha genérica de stacks. Cada stack representa uma palavra
 * primeiro, crio uma instância da Pilha Genérica de Stacks com o comprimento igual ao número de palavras
 * depois, coloco cada palavra em uma questao1equestao2.Stack e a inverto
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite algo: ");
        String input = scanner.nextLine().trim();
        System.out.println(reversesWords(input));
    }

    public static String reversesWords(String string) {
        String result = "";
        int len = numberOfWords(string);
        int strLen = string.length();
        Stack stack = new Stack(strLen);
        PilhaGenerica<Stack> pilhaGenerica = new PilhaGenerica<>(len);
        PilhaGenerica<Stack> auxPilhaGenerica = new PilhaGenerica<>(len);

        for (int i = 0; i < strLen; i++) {
            char temp = string.charAt(i);
            if (temp == ' ') {
                pilhaGenerica.push(stack);
                stack = new Stack(strLen);
            } else stack.push(temp);
        }

        if (!stack.empty()) pilhaGenerica.push(stack);

        // cria pilha génerica auxiliar, que a inversa da pilha normal
        while (!pilhaGenerica.vazia()) auxPilhaGenerica.push(pilhaGenerica.pop());

        // inverte de novo, mas coloca numa string
        while (!auxPilhaGenerica.vazia()) {
            Stack element = auxPilhaGenerica.pop();
            // inverte e coloca numa string
            while (!element.empty()) {
                result += element.pop();
            }
            result += " ";
        }

        return result.trim();

    }

    public static int numberOfWords(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') len++;
        }
        return ++len; // n espaços significam n + 1 palavras
    }

}
