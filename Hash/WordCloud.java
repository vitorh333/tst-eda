import java.util.*;

public class WordCloud {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		String[] palavras = frase.split(" ");

		HashMap<String, Integer> freq = new HashMap<>();

		for(int i = 0; i < palavras.length; i++) {
			if(freq.containsKey(palavras[i])) {
				freq.put(palavras[i], freq.get(palavras[i]) + 1);
			} else {
				freq.put(palavras[i], 1);
			}
		}

		while(true) {
			String comando = input.nextLine();

			if(comando.equals("fim")) {
				break;
			} else {
				if(freq.containsKey(comando)) {
					System.out.println(freq.get(comando));
				} else {
					System.out.println(0);
				}
			}
		}
	}
}
