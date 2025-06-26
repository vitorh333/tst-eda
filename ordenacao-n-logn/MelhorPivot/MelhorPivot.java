import java.util.*;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");
        String l = input.nextLine();
        String[] l2 = l.split(" ");

        int idx1 = Integer.parseInt(l2[0]);
        int idx2 = Integer.parseInt(l2[1]);

        int[] v1 = new int[lista.length];
        int[] v2 = new int[lista.length];

        for(int i = 0; i < lista.length; i++) {
            v1[i] = Integer.parseInt(lista[i]);
            v2[i] = Integer.parseInt(lista[i]);
        }

        int cand1 = particiona(v1, idx1, 0, v1.length - 1);
        int cand2 = particiona(v2, idx2, 0, v2.length - 1);


        if(cand1 > cand2) {
            System.out.println(idx2);
        } else {
            System.out.println(idx1);
        }
    }

    public static int particiona(int[] v, int idx, int ini, int fim) {
        swap(v, ini, idx);
        int pivot = v[ini];
        int i = ini;

        for(int j = ini +1; j <= fim; j++) {
            if(v[j] < pivot) {
                i++;
                swap(v, i, j);
            }
        }

        swap(v, i, ini);


        return Math.abs(i - ini - (fim - i));

    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
