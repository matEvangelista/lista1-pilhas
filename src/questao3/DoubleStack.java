package questao3;/*
 * Como esta classe funciona?
 * Há apenas um array char, que será dividido em duas partes.
 * A primeira parte abrigará uma pilha normal.
 * A segunda abrigará uma pilha invertida, de forma que ela começa na posição
 * (length - 1) e os seus métodos de push (pop) colocam (removem) elementos na posição length - 1 - n
 */

public class DoubleStack {

    private char[] stackItself;
    private int length;
    // começa em -1 para o primeiro push ser na posição 0
    private int firstStackEnds = -1;
    // começa na posição length, apesar de não existir, para o primeiro push ser na posição length - 1;
    private int lastStackBegins;

    public DoubleStack(int length) {
        this.length = length;
        lastStackBegins = length;
        stackItself = new char[length];
    }

    // a primeira pilha estará cheia se ela terminar onde a segunda termina
    public boolean isFull() {
        return (firstStackEnds + 1) == lastStackBegins;
    }

    // true para acessar a primeira pilha, false para a segunda
    public boolean push(char c, boolean firstStack) throws Exception{
        if (isFull())
            throw new Exception("Pilha cheia!");
        if (firstStack) stackItself[++firstStackEnds] = c;
        else stackItself[--lastStackBegins] = c;

        return true;
    }

    // mesma coisa: boolean para identificar em qual pilha se faz pop
    public char pop(boolean firstStack) throws Exception {
        char c = '\0';
        if (firstStack) {
            if (firstStackEnds == -1) {
                throw new Exception("Primeira pilha vazia!");
            }
            c = stackItself[firstStackEnds--];
            return c;
        }
        if (lastStackBegins == length)
            throw new Exception("Segunda pilha vazia!");
        c = stackItself[lastStackBegins++];
        return c;
    }

}
