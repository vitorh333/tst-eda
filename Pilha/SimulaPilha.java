import java.util.*;

public class SimulaPilha {

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
            return this.topo == this.pilha.length - 1;
        }

        public int push(int n) {
            if(isFull()) {
                return (int) -1e9;
            }

            this.pilha[++this.topo] = n;
			return n;
        }

        public int pop() {
            if(isEmpty()) {
                return (int) -1e9;
            }

            int v = this.pilha[this.topo];
            this.topo--;
            return v;
        }

        public int getTopo() {
            if(isEmpty()) {
                return -1;
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

		public int procuraMaiorAteIndice(int idx) {
			Pilha aux = new Pilha(idx + 1);
			int count = 0;
			int maior = getTopo();

			while(count <= idx) {
				int v = pop();
				aux.push(v);
				maior = Math.max(v, maior);
				count += 1;
			}

			count = 0;

			while(count <= idx) {
				int v = aux.pop();
				push(v);
				count += 1;
			}

			return maior;
		}

		public String mostraLinha() {
			Pilha aux = new Pilha(size());
			String saida = "";

			while(!isEmpty()) {
				int v = pop();
				aux.push(v);
			}

			while(!aux.isEmpty()) {
				int v = aux.pop();
				push(v);
				saida += v + " ";
			}

			return saida.trim();
		}
	}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		//int n = input.nextInt();
		//input.nextLine();

        int t = input.nextInt();
		input.nextLine();

		Pilha pilha = new Pilha(t);

		while(true) {
			String comandos = input.nextLine();
			String[] comando = comandos.split(" ");

			if(comando[0].equals("end")) {
				break;
			} else if(comando[0].equals("print")) {
				if(pilha.size() == 0) {
					System.out.println("empty");
				} else {
					System.out.println(pilha.mostraLinha()); 
				}

			} else if(comando[0].equals("peek")) {
				System.out.println(pilha.getTopo());
			} else if(comando[0].equals("pop")) {
				int k = pilha.pop();
				if(k == (int) -1e9) {
					System.out.println("empty");
				}
			} else {
				int k = pilha.push(Integer.parseInt(comando[1]));
				if(k == (int) -1e9) {
					System.out.println("full");
				}
			}		
		}
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





