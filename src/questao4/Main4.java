package questao4;

public class Main4 {
    public static void main(String args[]) {

        // usei String como exemplo, mas qualquer instância de uma classe cujo ".equals()" funcione
        PilhaGenerica<String> stringPilhaGenerica = new PilhaGenerica<>(5);

        // não faz parte da questão, só usei para organizar
        String[] names = new String[5];
        names[0] = "Miles Davis";
        names[1] = "Chet Baker";
        names[2] = "John Coltrane";
        names[3] = "Julie London";
        names[4] = "Bill Evans";
        System.out.println("A pilha tem os nomes: ");
        for (String name : names) {
            System.out.printf("%s, ", name);
            stringPilhaGenerica.push(name);
        }
        System.out.printf("\nQuer-se remover %s da pilha\n", names[2]);
        questao4(stringPilhaGenerica, names[2]);
        System.out.println("Nova pilha: ");
        while (!stringPilhaGenerica.vazia()) {
            System.out.printf("%s, ",stringPilhaGenerica.pop());
        }
    }

    // o "retorno" será pela passagem por referência pelo parâmetro da função
    public static <T> void questao4(PilhaGenerica<T> pilhaGenerica, T elemento) {
        boolean foundT = false;
        PilhaGenerica<T> auxStack = new PilhaGenerica<>(pilhaGenerica.tamanho());

        while (!pilhaGenerica.vazia()) {
            T temp = pilhaGenerica.pop();
            if (temp.equals(elemento)) {
                foundT = true;
                break;
            }
            auxStack.push(temp);
        }

        if(!foundT) {
            System.out.println("Elemento que se quer remover não encontrado.");
            return;
        }

        while (!auxStack.vazia()) {
            pilhaGenerica.push(auxStack.pop());
        }

    }
}
