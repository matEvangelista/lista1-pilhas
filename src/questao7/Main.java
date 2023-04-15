package questao7;

/* como funciona esta questão?
 * Comecei removendo os espaços em branco da string de entrada
 * Depois,
 * */

public class Main {
    public static void main(String[] args) {
        // como dito em aula, são considerados apenas números de um dígito.
        String s = "( 9 - ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        printsAnswer(s);
    }

    public static void printsAnswer(String input) {
        String s;
        PilhaGenerica<Character> stack = stringToPostfixStack(input);
        s = stackToString(stack);
        Posfixada pf = new Posfixada(s.length(), s);
        System.out.printf("%s = %d", input, pf.resposta());
    }

    public static String stackToString(PilhaGenerica<Character> stack) {
        StringBuilder result = new StringBuilder("");
        while (!stack.vazia()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
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
