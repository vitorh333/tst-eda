package org.example.quinta_questao;

public class MeuArrayList {
	public int[] lista;
	public int fim;
	public int size;
	public final double FATOR_DE_CARGA = 0.75;
	public final int CAPACIDADE_DEFAULT = 2;

	public MeuArrayList() {
		this.lista = new int[CAPACIDADE_DEFAULT];
		this.fim = -1;
		this.size = 0;
	}

	public MeuArrayList(int capacidade) {
		this.lista = new int[capacidade];
		this.fim = -1;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

    public void add(int k) {
		if( (double) (this.fim + 1 / this.lista.length)  >= FATOR_DE_CARGA) {
			resize();
		}

		this.lista[++this.fim] = k;
		this.size++;
    }

	public void removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException();
		}

		shiftLeft(0);
		this.fim--;
		this.size--;
	}

	public void removeLast() {
		if(isEmpty()) {
			throw new RuntimeException();
		}

		this.fim--;
		this.size--;
	}

    public void removeAll(int k) {
		int i = 0;
		while(i <= this.fim) {
			if(this.lista[i] == k) {
				removeByIndex(i);
			} else {
				i++;
			}
    	}
	}

	public void removeByValue(int k) {
		int ind = get(k);
		removeByIndex(ind);

	}

	public void removeByIndex(int idx) {
		shiftLeft(idx);
		this.fim--;
		this.size--;
	}

    public int get(int idx) {
		if(idx < 0 || idx > this.size) {
			throw new RuntimeException();
		}

		return this.lista[idx];
    }

	public void resize() {
		MeuArrayList novo = new MeuArrayList(2 * this.lista.length);
		
		for(int i = 0; i <= this.fim; i++) {
			novo.lista[i] = this.lista[i];
		}

		this.lista = novo.lista;
	}

	public void shiftLeft(int idx) {
		for(int i = idx; i < this.fim; i++) {
			this.lista[i] = this.lista[i+1];
		}
	}


    public void insertSorted(int k) {
		add(k);
		int aux = this.fim;
		while(aux > 0 && this.lista[aux] < this.lista[aux - 1]) {
			swap(aux, aux-1);
			aux--;
		}	
    }

	public void swap(int i, int j) {
		int aux = this.lista[i];
		this.lista[i] = this.lista[j];
		this.lista[j] = aux;
	}

    public int size() {
        return this.size;
    }

}
