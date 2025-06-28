import java.util.*;

class RadixSort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int d = input.nextInt();
		input.nextLine();

		int[] v = new int[lista.length];

		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		int maior = (int) Math.pow(10, d);
		RadixSort(v, maior);

	}

	public static void RadixSort(int[] v, int maior) {
		for(int exp = 1; maior / exp > 1; exp *= 10) {
			countingSortPorDigito(v, exp);
		}

	}

	public static void countingSortPorDigito(int v[], int exp) {
		int[] count = new int[10];
		int[] saida = new int[v.length];

		for(int i = 0; i < v.length; i++) {
			count[(v[i] / exp) % 10]++;
		}

		somaAcumulada(count);

		for(int i = v.length - 1; i >= 0; i--) {
			saida[count[(v[i] / exp) % 10] - 1] = v[i];
			count[(v[i] / exp) % 10]--;
		}

		for(int i = 0; i < v.length; i++) {
			v[i] = saida[i];
		}

		System.out.println(Arrays.toString(v));
	}

	public static void somaAcumulada(int[] a) {
		for(int i = 1; i < a.length; i++) {
			a[i] += a[i-1];
		}
	}
}
