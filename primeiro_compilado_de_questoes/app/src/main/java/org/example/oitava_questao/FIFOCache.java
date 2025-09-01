package org.example.oitava_questao;

public class FIFOCache {
	public Fila cache;

	public FIFOCache(int capacity) {
		this.cache = new Fila(capacity);
	}

    public String get(int k) {
		if(cache.contains(k)) {
			return "hit";
		}
		if(cache.isFull()) {
			cache.removeFirst();
		}
		
		this.cache.addLast(k);
		return "miss";
    }

    public int getNextEviction() {
		if(this.cache.isEmpty()) {
			throw new RuntimeException();
		}

		return this.cache.getFirst();
    }


class Fila {
	public int[] fila;
	public int fim;

	public Fila(int capacidade) {
		this.fila = new int[capacidade];
		this.fim = -1;
	}
	public boolean isEmpty() {
		return this.fim == -1;
	}
	public boolean isFull() {
		return this.fim == this.fila.length - 1;
	}
	public int size() {
		return this.fim + 1;
	}

	public void addLast(int k) {
		this.fila[++this.fim] = k;
	}

	public int removeFirst() {
		int value = this.fila[0];
		shiftLeft();
		this.fim--;
		return value;
	}

	public int getFirst() {
		return this.fila[0];
	}

	public void shiftLeft() {
		for(int i = 0; i < this.fim; i++) {
			swap(i, i + 1);
		}

	}

	public boolean contains(int k) {
		for(int i = 0; i <= this.fim; i++) {
			if(this.fila[i] == k) {
				return true;
			}
		}

		return false;
	}

	public void swap(int i, int j) {
		int aux = this.fila[i];
		this.fila[i] = this.fila[j];
		this.fila[j] = aux;
	}
}

}
