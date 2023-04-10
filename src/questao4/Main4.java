package questao4;

public class Main4 {
    public static void main(String args[]) {

    }

    public static <T> void questao4(PilhaGenerica<T> pilhaGenerica, T elemento) {
        boolean encontrouT = false;
        PilhaGenerica<T> pilhaAuxiliar = new PilhaGenerica<>(pilhaGenerica.tamanho());

        while (!pilhaGenerica.vazia()) {
            T temp = pilhaGenerica.pop();
            if (temp.equals(elemento)) {
                encontrouT = true;
                break;
            }
            pilhaAuxiliar.push(temp);
        }

        if(!encontrouT) {
            System.out.println("Você fez algo de errado");
            return;
        }

        while (!pilhaAuxiliar.vazia()) {
            pilhaGenerica.push(pilhaAuxiliar.pop());
        }

    }
}
