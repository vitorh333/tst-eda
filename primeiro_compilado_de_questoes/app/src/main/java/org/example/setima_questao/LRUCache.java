package org.example.setima_questao;

public class LRUCache {
	public FilaCircular cache;

	public LRUCache(int capacity) {
		this.cache = new FilaCircular(capacity);
	}

    public String get(int k) {
		if(this.cache.contains(k)) {
			this.cache.moveToFim(k);
			return "hit";
		} else {
			if(this.cache.isFull()) {
				this.cache.removeFirst();
			}

			this.cache.addLast(k);
			return "miss";
		}
    }

    public int getNextEviction() {
		if(this.cache.isEmpty()) {
			throw new RuntimeException();
		}

		return this.cache.getFirst();
    }

}

class FilaCircular {
	public int[] fila;
	public int fim;
	public int ini;
	public int size;

	public FilaCircular(int capacity) {
		this.fila = new int[capacity];
		this.size = 0;
		this.fim = -1;
		this.ini = -1;
	}

	public boolean isFull() {
		return this.size >= this.fila.length;
	}

    public boolean isEmpty() {
        return this.size == 0;
    }

	public int getFirst() {
		return this.fila[this.ini];
	}

    public void addLast(int k) {
		if(isFull()) {
			throw new RuntimeException();
    	}

		if(isEmpty()) {
			this.fila[++this.fim] = k;
			this.ini++;
		} else {
			this.fim = (this.fim + 1) % this.fila.length;
			this.fila[this.fim] = k;
		}

		this.size++;
	}

    public int removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException();
		}

		int value = -1;

		if(this.ini == this.fim) {
			value = this.fila[this.ini];
			this.ini = -1;
			this.fim = -1;
		} else {
			value = this.fila[ini];
			this.ini = (this.ini + 1) % this.fila.length;
		}
		
		this.size--;
		return value;
	}

	public boolean contains(int k) {
		int count = 0;

		while(count < size) {
			if(this.fila[count] == k) {
				return true;
			}

			count++;
		}

		return false;
	}

	public int procuraElemento(int k) {
		int count = 0;

		while(count < size) {
			if(this.fila[count] == k) {
				return count;
			}

			count++;
		}

		return -1;
	}

	public void moveToFim(int k) {
		int pos = procuraElemento(k);

		while(pos != this.fim) {
			swap(pos, (pos + 1) % this.fila.length);
			pos = (pos + 1) % this.fila.length;
		}
	}

	public void swap(int i, int j) {
		int aux = this.fila[i];
		this.fila[i] = this.fila[j];
		this.fila[j] = aux;
	}
}
