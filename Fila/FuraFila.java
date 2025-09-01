

public class FuraFila {
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

		public void addLast(int valor) {
			if(isFull()) {
				throw new RuntimeException("Esta linha não pode ser executada");
			}

			if(isEmpty()) {
				this.head = 0;
			}

			this.size++;
			this.tail = (this.tail + 1) % fila.length;
			this.fila[this.tail] = valor;
		}

		public int removeFirst() {
			if(isEmpty()) {
				throw new RuntimeException("Esta linha não pode ser executada");
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
				throw new RuntimeException("Esta linha não pode ser executada");
			}

			return this.fila[this.head];
		}

		public int getLast() {
			if(isEmpty()) {
				throw new RuntimeException("Este comando não pode ser executado");
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
					resp += getFirst() + ", ";
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

			return resp;
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

		public void moveInd1ParaInd2(int ind1, int ind2) {
			while(ind1 != ind2) {
				swap(ind1, ind1 - 1);
				ind1--;
			}
		}

		public void swap(int i, int j) {
			int aux = fila[i];
			fila[i] = fila[j];
			fila[j] = aux;
		}

		public String mostraComChaves() {
			return Arrays.toString(fila);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);


		String linha = input.nextLine();
		String[] lista = linha.split(" ");

		int k = input.nextInt();

		Fila fila = new Fila(lista.length);

		for(int i = 0; i < lista.length; i++) {
			fila.addLast(Integer.parseInt(lista[i]));
		}
		int count = lista.length - k;

		for(int i = 0; i < count; i++) {
			fila.moveInd1ParaInd2(k++, i);
			System.out.println(fila.mostraComChaves());
		}
	}
}
