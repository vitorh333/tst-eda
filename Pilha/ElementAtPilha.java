import java.util.*;

public class ElementAtPilha {

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
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");
        int ind = input.nextInt();
        Pilha pilha = new Pilha(lista.length);

        for(int i = lista.length - 1; i >= 0; i--) {
            pilha.push(Integer.parseInt(lista[i]));
        }

        int k = (pilha.procuraPorIndicie(ind));
        if(k == -1) {
            System.out.println("indice invalido");
        } else {
            System.out.println(k);
        }
    }
}
