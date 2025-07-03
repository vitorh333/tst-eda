import java.util.*;

class MoveN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");

        int[] v = new int[lista.length];

        for(int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(lista[i]);
        }

        moveN(v);
    }

    public static void moveN(int[] v) {
        for(int i = 1; i < v.length; i++) {
            if(v[i] < v[i-1]) {
                movePrinta(v, i);
            }
        }
    }

    public static void movePrinta(int[] v, int k) {
        while(k > 0 && v[k] < v[k-1]) {
            swap(v, k);
            k--;
            System.out.println(Arrays.toString(v));
        }
    }

    public static void swap(int v[], int i) {
        int aux = v[i];
        v[i] = v[i-1];
        v[i-1] = aux;
    }
}
