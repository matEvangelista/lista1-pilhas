package questao3;

public class Main {
    public static void main(String[] args) {
        DoubleStack ds = new DoubleStack(5);
        // sem erros aqui
        try {
            ds.push('a', true);
            ds.push('b', true);
            ds.push('c', true);
            ds.push('z', false);
            ds.push('y', false);
        } catch (Exception e) {
            System.out.println(e);
        }

        // pilha cheia
        try {
            ds.push('f', false);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ds.push('a', true);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // sem erros nos dois primeiros
            ds.pop(false);
            ds.pop(false);
            // erro aqui
            ds.pop(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        // sem erros aqui
        try {
            ds.push('g', false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
