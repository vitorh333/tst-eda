import java.util.*;
class Radix3Digitos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        int d = input.nextInt();
        input.nextLine();

        String[] array = linha.split(" ");

        int[] v = new int[array.length];

        for(int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(array[i]);
        }

        int maior = (int) Math.pow(10, d);

        Radix(v, maior);
    }

    public static void Radix(int v[], int maior) {
        for(int exp = 1; maior / exp > 100; exp *= 1000) {
            countingSort(v, exp);
        }
    }

    public static void countingSort(int v[], int exp) {
        int[] count = new int[1000];
        int[] saida = new int[v.length];

        for(int i = 0; i < v.length; i++) {
            count[(v[i] / exp) % 1000]++;
        }
        somaAcumulada(count);

        for(int i = v.length - 1; i >= 0; i--) {
            saida[count[(v[i] / exp) % 1000] - 1] = v[i];
            count[(v[i] / exp) % 1000]--;
        }

        for(int i = 0; i < v.length; i++) {
            v[i] = saida[i];
        }

        System.out.println(Arrays.toString(v));
    }

    public static void somaAcumulada(int[] count) {
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }
}
