import java.util.*;

class PosicoesElemento {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		input.nextLine();

		String linha = input.nextLine();
		String lista[] = linha.split(" ");

		int[] v = new int[lista.length];

		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}

		String resp = "";

		for(int i = 0; i < lista.length; i++) {
			if(v[i] == k) {
				resp += i + " ";
			}
		}

		if(resp.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(resp.trim());
		}
	}
}
