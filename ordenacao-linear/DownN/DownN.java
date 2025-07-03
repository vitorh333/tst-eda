import java.util.*;

class DownN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");

        int[] v = new int[lista.length];

        for(int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(lista[i]);
        }

        int s = input.nextInt();

        MergeSort(v, 0, v.length - 1);
        pegaS(v, s);
    }

    public static void MergeSort(int[] v, int ini, int fim) {
        if(fim > ini) {
            int meio  = (ini+fim) / 2;
            MergeSort(v, ini, meio);
            MergeSort(v, meio+1, fim);
            Merge(v, ini, fim);
        }
    }

    public static void Merge(int[] v, int ini, int fim) {
        int[] aux = new int[v.length];

        for(int i = 0; i <= fim; i++) {
            aux[i] = v[i];
        }

        int meio = (ini + fim) / 2;
        int k = ini;
        int i = ini;
        int j = meio + 1;

        while(i <= meio && j <= fim) {
            if(aux[i] < aux[j]) {
                v[k++] = aux[i++];
            } else {
                v[k++] = aux[j++];
            }
        }

        while(i <= meio) {
            v[k++] = aux[i++];
        }
    }

    public static void pegaS(int[] v, int s) {
        String saida = "";
        for(int i = 0; i < s; i++) {
            if(i != s - 1) {
                saida += v[i] + " ";
            } else {
                saida += v[i];
            }
        }

        System.out.println(saida);
    }
}
