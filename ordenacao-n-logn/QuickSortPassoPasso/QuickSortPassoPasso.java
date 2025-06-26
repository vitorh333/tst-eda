import java.util.*;

class QuickSortPassoPasso {

	public static void quickSort(int[]v, int ini, int fim) {

		if(fim > ini) {
			int meio = particiona(v, ini, fim);

			for(int i = 0; i < v.length; i++) {
				if(i == v.length - 1) {
					System.out.print(v[i]);
				} else {
					System.out.print(v[i] + " ");
				}
			}

			System.out.println();

			quickSort(v, ini, meio-1);
			quickSort(v, meio+1, fim);

		}

	}

	public static int particiona(int v[], int ini, int fim) {
		int pivot = v[ini];
		int i = ini;

		for(int j = ini + 1; j <= fim; j++) {
			if(v[j] <= pivot) {
				i++;
				swap(v, i, j);
			}
		}

		swap(v, i, ini);
		return i;
	}

	public static void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int v[] = new int[lista.length];

		for(int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}
		
		quickSort(v, 0, v.length - 1);



	}
}
