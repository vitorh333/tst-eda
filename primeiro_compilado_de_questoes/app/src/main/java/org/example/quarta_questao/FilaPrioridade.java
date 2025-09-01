package org.example.quarta_questao;
import java.util.*;

public class FilaPrioridade {
	public ArrayList<Integer> fila;
	public int size;
	public int ultimoPrioridade;

	public FilaPrioridade() {
		this.fila = new ArrayList<Integer>();
		this.ultimoPrioridade = 0;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

    public void addLast(int k) {
		if(conferePrioridade(k)) {
			inserePrioritario(k);
			this.ultimoPrioridade++;
		} else {
			this.fila.add(k);
		}
		this.size++;
    }

    public int removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException();
		}
		if(conferePrioridade(this.fila.get(0))) {
			this.ultimoPrioridade--;
		}
		int value = this.fila.get(0);
		this.size--;
		this.fila.remove(0);
		return value;

    }

	public boolean conferePrioridade(int k) {
		return k < 100;
	}

	public void inserePrioritario(int k) {
		this.fila.add(k);

		for(int i = this.fila.size() - 1; i > ultimoPrioridade; i--) {
			swap(i, i-1);
		}
	}

	public void swap(int i, int j) {
		int aux = this.fila.get(i);
		this.fila.set(i, this.fila.get(j));
		this.fila.set(j, aux);
	}


}
