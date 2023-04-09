public class Stack {
    private int n;
    private char elements[];
    private int top;

    public Stack(int size) {
        n = size;
        elements = new char[size];
        top = -1;
    }

    public boolean empty() {
        return top == -1;
    }

    public boolean full() {
        return top == n - 1;
    }

    public char pop() {
        char c = '\0';

        if (!empty()) {
            c = elements[top];
            top--;
        } else {
            System.out.println("Pilha vazia: pop não funcionou.");
        }

        return c;
    }

    public boolean push(char element) {
        if (!full()) {
            elements[++top] = element;
            return true;
        }
        System.out.println("Pilha cheia: push não funcionou.\n");
        return false;
    }

    public char returnsTop() {
        char element = '\0';

        if (!empty())
            element = elements[top];
        else
            System.out.println("Pilha vazia.");
        return element;
    }


    public static Stack convertsStringToStack(String string) {
        Stack stack = new Stack(string.length());
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));
        return stack;
    }

    public int size() {
        return top + 1;
    }

}
