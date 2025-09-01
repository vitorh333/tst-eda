import java.util.*;

public class InvertePilhaIndex {

    public static class Pilha {
         public int[] pilha;
         public int topo;

        public Pilha(int capacidade) {
            this.pilha = new int[capacidade];
            this.topo = -1;
        }

        public boolean isEmpty() {
            return this.topo == -1;
        }

        public boolean isFull() {
            return this.topo == this.pilha.length;
        }

        public void push(int n) {
            if(isFull()) {
                throw new RuntimeException("Pilha Cheia");
            }

            this.pilha[++this.topo] = n;
        }

        public int pop() {
            if(isEmpty()) {
                throw new RuntimeException("Pilha vazia");
            }

            int v = this.pilha[this.topo];
            this.topo--;
            return v;
        }

        public int getTopo() {
            if(isEmpty()) {
                throw new RuntimeException("Pilha vazia");
            }

            return this.pilha[topo];
        }

        public int size() {
            return this.topo + 1;
        }

        public int procuraPorIndicie(int ind) {
            if(ind >= size()) {
                return -1;
            }
            Pilha aux = new Pilha(this.pilha.length);
            int idx = -1;

            while(ind > idx) {
                aux.push(pop());
                idx++;
            }

            int element = aux.getTopo();

            while(!aux.isEmpty()) {
                push(aux.pop());
            }

            return element;
        }

		public void inverteAteIndice(int idx) {
			Fila aux = new Fila(idx +1);
			int count = 0;

			while(count <= idx) {
				int v = pop();
				aux.addLast(v);
				count += 1;
			}

			count = 0;
			while(count <= idx) {
				int v = aux.removeFirst();
				push(v);
				count += 1;
			}
		}

		public String mostraPorElemento() {
			Pilha aux = new Pilha(size());
			String saida = "";
			while(!isEmpty()) {
				int v = pop();
				aux.push(v);
				saida += v + "\n";
			}

			while(aux.isEmpty()) {
				int v = aux.pop();
				push(v);
			}

			return saida;
		}
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();

        String linha = input.nextLine();
        String[] lista = linha.split(" ");

		int idx = input.nextInt();
        Pilha pilha = new Pilha(lista.length);

        for(int i = 0; i < n; i++) {
            pilha.push(Integer.parseInt(lista[i]));
			//System.out.println(lista[i]);
		}
		pilha.inverteAteIndice(idx);
		System.out.println("-");
		System.out.print(pilha.mostraPorElemento());
	}
}

class Fila {

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
}



