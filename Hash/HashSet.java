import java.util.*;

public class HashSet {

	public static class Hash {
		public Integer[] tabela;
		public int size;

		public Hash(int capacidade) {
			this.tabela = new Integer[capacidade];
			this.size = 0;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public boolean isFull() {
			return this.size == tabela.length;
		}

		public Integer hash(Integer key) {
			return key % tabela.length;
		}

		public void put(Integer key) {
			if(isFull()) {
				return;
			}

			if(contains(key)) {
				return;
			}

			Integer hash = hash(key);
			if(tabela[hash] == null) {
				tabela[hash] = key;
			} else {
				int count = 1;
				while(true) {
					Integer hashAtual = hash(count + hash);
					if(tabela[hashAtual] == null) {
						tabela[hashAtual] = key;
						break;
					} else {
						count++;
					}
					if(count == tabela.length - 1) {
						break;
					}
				}
			}

			size++;
		}
		public void remove(Integer key) {
			Integer hash = hash(key);
			if(tabela[hash] == key) {
				tabela[hash] = null;
				size--;
			} else {
				int count = 1;

				while(true) {
					Integer novoHash = hash(hash + count);
					if(tabela[novoHash] == key) {
						tabela[novoHash] = null;
						size--;
						break;
					} else {
						count++;
					}

					if(count == tabela.length -1) {
						break;
					}
				}
			}
		}

		public String toString() {
			return Arrays.toString(tabela);
		}

		public boolean contains(Integer key) {
			Integer hash = hash(key);

			if(tabela[hash] == key) {
				return true;
			} else {
				int count = 1;

				while(true) {
					Integer novoHash = hash(count + hash);
					if(tabela[novoHash] == key) {
						return true;
					} else {
						count++;
					}

					if(count == tabela.length - 1){
						break;
					}
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();
		input.nextLine();

		Hash tabelaHash = new Hash(t);

		while(true) {
			String comandos = input.nextLine();
			String[] comando = comandos.split(" ");

			if(comando[0].equals("end")) {
				break;
			} else if(comando[0].equals("put")) {
				tabelaHash.put(Integer.parseInt(comando[1]));
				System.out.println(tabelaHash.toString());
			} else if(comando[0].equals("remove")) {
				tabelaHash.remove(Integer.parseInt(comando[1]));
				System.out.println(tabelaHash.toString());
			} else if(comando[0].equals("contains")) {
				System.out.println(tabelaHash.contains(Integer.parseInt(comando[1])));
			} 
		}
	}
}
