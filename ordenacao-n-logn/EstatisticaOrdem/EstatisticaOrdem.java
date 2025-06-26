import java.util.*;

class EstatisticaOrdem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String lista[] = linha.split(" ");

        int[] v = new int[lista.length];

        for(int i = 0; i < lista.length; i++) {
            v[i] = Integer.parseInt(lista[i]);
        }

        System.out.println(particiona(v, 0, v.length - 1));

    }

    public static int particiona(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini;

        for(int j = ini + 1; j <= fim; j++) {
            if(v[j] < pivot) {
                i++;
                swap(v, i, j);
            }
        }

        swap(v, i, ini);
        return i+1;
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
