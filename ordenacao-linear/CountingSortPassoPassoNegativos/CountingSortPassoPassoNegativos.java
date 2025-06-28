import java.util.*;

class CountingSortingPassoPassoNegativo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int k = input.nextInt();
		input.nextLine();

		int m = input.nextInt();
		input.nextLine();

		int[] v = new int[lista.length];

		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		countingSort(v, k, m);
	}

	public static void countingSort(int[] v, int k, int m) {
		int salto = Math.abs(m);
		int[] count = new int[k + salto + 1];
		int[] saida = new int[v.length];

		for(int i = 0; i < v.length; i++) {
			count[v[i] + salto]++;
			printaArray(count);
		}

		somaAcumulada(count);
		System.out.print("Cumulativa do vetor de contagem - ");
		printaArray(count);

		for(int i = v.length - 1; i >= 0; i--) {
			saida[count[v[i] + salto] -1] = v[i];
			count[v[i] + salto]--;
		}

		printaArray(count);
		printaArray(saida);
	}

	public static void somaAcumulada(int[] a) {
		for(int i = 1; i < a.length; i++) {
			a[i] += a[i-1];
		}
	}
	
	public static void printaArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
}
