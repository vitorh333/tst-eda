import java.util.*;

class MergeSortPassoPasso {
	
	public static void sort(int v[], int ini, int fim) {
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(v, ini, fim + 1)));

		if(fim > ini) {
			int meio = (ini+fim) / 2;

			sort(v, ini, meio);
			sort(v, meio+1, fim);
			merge(v, ini, fim);

			System.out.println(Arrays.toString(Arrays.copyOfRange(v, ini, fim + 1)));


		}
	}

	public static void merge(int v[], int ini, int fim) {
		int[] aux = new int[v.length];
		for(int i = 0; i <= fim; i++) {
			aux[i] = v[i];
		}

		int i = ini;
		int meio = (ini+fim)/2;
		int j = meio + 1;

		while(i <= meio && j <= fim) {
			if(aux[i] <= aux[j]) {
				v[ini++] = aux[i++];
			} else {
				v[ini++] = aux[j++];
			}
		}

		while(i <= meio) {
			v[ini++] = aux[i++];
		}
	}



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int[] v = new int[lista.length];

		for(int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		sort(v, 0, v.length - 1);

	}
}

