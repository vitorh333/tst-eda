import java.util.*;

public class SimulaFila {
	public static class Fila {

		private int[] fila;
		private int head;
		private int tail;
		private int size;

		public Fila(int capacidade) {
			this.fila = new int[capacidade];
			this.head = -1;
			this.tail = -1;
			this.size = 0;

		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public boolean isFull() {
			return this.size == fila.length;
		}

		public int addLast(int valor) {
			if(isFull()) {
				return (int) 1e9;
			}

			if(isEmpty()) {
				this.head = 0;
			}

			this.size++;
			this.tail = (this.tail + 1) % fila.length;
			this.fila[this.tail] = valor;

			return valor;
		}

		public int removeFirst() {
			if(isEmpty()) {
				return (int) 1e9;
			}

			int valor = this.fila[this.head];

			if(this.head == this.tail) {
				this.head = -1;
				this.tail = -1;
			} else {
				this.head = (this.head+1) % fila.length;
			}
			this.size--;
			return valor;
		}

		public int getFirst() {
			if(isEmpty()) {
				return (int) 1e9;
			}

			return this.fila[this.head];
		}

		public int getLast() {
			if(isEmpty()) {
				return (int) 1e9;
			}

			return this.fila[this.tail];
		}

		public String toString() {
			if(isEmpty()) {
				return "";
			}
			return mostraFila(this.size);
		}

		public int indexOf(int valor) {
			if(isEmpty()) {
				return -1;
			}
			return procuraPrimeiraOcorrencia(valor, this.size);
		}

		public int lastIndexOf(int valor) {
			if(isEmpty()) {
				return -1;
			}

			return procuraUltimaOcorrencia(valor, this.size);
		}

		public int size() {
			return this.size;
		}

		public String mostraFila(int t) {
			Fila aux = new Fila(t);
			String resp = "";

			while(!isEmpty()) {
				if(size() != 1) {
					resp += getFirst() + " ";
				} else {
					resp += getFirst();
				}
				aux.addLast(getFirst());
				removeFirst();
			}

			while(!aux.isEmpty()) {
				addLast(aux.getFirst());
				aux.removeFirst();
			}

			return resp.trim();
		}

		public int procuraPrimeiraOcorrencia(int valor, int t) {
			Fila aux = new Fila(t);
			int idx = -1;

			while(!isEmpty()) {
				if(getFirst() == valor && idx == -1) {
					idx = t - size();
				}
				aux.addLast(getFirst());
				removeFirst();
			}

			while(!aux.isEmpty()) {
				addLast(aux.getFirst());
				aux.removeFirst();
			}

			return idx;
		}

		public int procuraUltimaOcorrencia(int valor, int t) {
			Fila aux = new Fila(t);
			int idx = -1;

			while(!isEmpty()) {
				if(getFirst() == valor) {
					idx = t - size();
				}

				aux.addLast(getFirst());
				removeFirst();
			}

			while(!aux.isEmpty()) {
				addLast(aux.getFirst());
				aux.removeFirst();
			}

			return idx;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();

		input.nextLine();

		Fila fila = new Fila(t);

		while(true) {
			String comandos = input.nextLine();
			String[] comando = comandos.split(" ");
			
			if(comando[0].equals("end")) {
				break;

			} else if(comando[0].equals("print")) {
				String saida = fila.toString();
				if(saida.equals("")) {
					System.out.println("empty");
				} else {
					System.out.println(saida);
				}

			} else if(comando[0].equals("element")) {
				int k = fila.getFirst();
				if(k == (int) 1e9) {
					System.out.println("empty");
				} else {
					System.out.println(k);
				}

			} else if(comando[0].equals("remove")) {
				int k = fila.removeFirst();

				if(k == (int) 1e9) {
					System.out.println("empty");
				}

			} else {
				int k = fila.addLast(Integer.parseInt(comando[1]));

				if (k == (int) 1e9) {
					System.out.println("full");
				}
			}
		}
	}
}
