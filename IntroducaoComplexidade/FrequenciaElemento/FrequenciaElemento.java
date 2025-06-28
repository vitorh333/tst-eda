import java.util.*;

class FrequenciaElemento {
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		int k = input.nextInt();
		input.nextLine();
		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int v[] = new int[lista.length];

		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		int cont = 0;

		for(int i = 0; i < v.length; i++) {
			if(v[i] == k) {
				cont++;
			}
		}

		System.out.println(cont);
	}
} 

