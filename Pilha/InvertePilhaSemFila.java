import java.util.*;

public class InvertePilhaSemFila {

    public static class Pilha {
         private int[] pilha;
         private int topo;

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

        public void invertePilha() {
            Pilha aux = new Pilha(this.pilha.length);
            
            while(!isEmpty()) {
                aux.push(pop());
            }

            this.pilha = aux.pilha;
            this.topo = aux.topo;
        }

        public String toString() {
            Pilha aux = new Pilha(this.pilha.length);
            String saida = "";

            while(!isEmpty()) {
                int v = pop();
                aux.push(v);
                saida += v + "\n";
            }

            while(!aux.isEmpty()) {
                push(aux.pop());
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
        Pilha pilha = new Pilha(lista.length);

        for(int i = 0; i < n; i++) {
            pilha.push(Integer.parseInt(lista[i]));
        }
        pilha.invertePilha();
        System.out.print(pilha.toString());
    }
}

