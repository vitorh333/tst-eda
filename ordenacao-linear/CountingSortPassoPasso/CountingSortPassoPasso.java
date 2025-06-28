import java.util.*;

class CouningtSortPassoPasso {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int k = input.nextInt();
		input.nextLine();

		int[] v = new int[lista.length];

		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		countSort(v, k);
	}

	public static void countSort(int[] v, int k) {
		int[] count = new int[k+1];
		int[] saida = new int[v.length];

		for(int i = 0; i < v.length; i++) {
			count[v[i]]++;
			printaArray(count);
		}

		somaAcumulada(count);
		System.out.print("Cumulativa do vetor de contagem - ");
		printaArray(count);

		for(int i = v.length - 1; i >= 0; i--) {
			saida[count[v[i]] - 1] = v[i];
			count[v[i]]--;
		}

		printaArray(count);
		printaArray(saida);
	}


	public static void somaAcumulada(int[] count) {
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
	}

	public static void printaArray(int a[]) {
		for(int i = 0; i < a.length; i++) {
			if(i != a.length - 1) {
				System.out.print(a[i] + " ");
			} else {
				System.out.print(a[i]);
			}
		}

		System.out.println();
	}
}
