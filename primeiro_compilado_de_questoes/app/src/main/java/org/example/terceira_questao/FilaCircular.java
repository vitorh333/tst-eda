package org.example.terceira_questao;

public class FilaCircular {
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
}
