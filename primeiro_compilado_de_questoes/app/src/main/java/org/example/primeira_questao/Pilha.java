package org.example.primeira_questao;

public class Pilha {
	public int[] pilha;
	public int topo;
	public final int CAPACIDADE_DEFAULT = 10;

	public Pilha(int capacidade) {
		this.pilha = new int[capacidade];
		this.topo = -1;
	}

	public Pilha() {
		this.pilha = new int[CAPACIDADE_DEFAULT];
		this.topo = -1;
	}

	public boolean isFull() {
		return this.topo == this.pilha.length - 1;
	}

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public void push(int k) {
		if(isFull()) {
			dobraCapacidade();
		}

        this.pilha[++this.topo] = k;
    }

    public int pop() {
        if(isEmpty()) {
			return -1;
		}
		int value = this.pilha[this.topo];
		this.topo--;
		return value;
    }

	public int size() {
		return this.topo + 1;
	}

	public void dobraCapacidade() {
		Pilha aux1 = new Pilha(2 * size());
		Pilha aux2 = new Pilha(size());

		while(!isEmpty()) {
			int v = pop();
			aux2.push(v);
		}

		while(!aux2.isEmpty()) {
			int v = aux2.pop();
			aux1.push(v);
		}

		this.pilha = aux1.pilha;
		this.topo = aux1.topo;
	}

}
