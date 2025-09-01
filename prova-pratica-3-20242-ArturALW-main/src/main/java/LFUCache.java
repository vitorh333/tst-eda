public class LFUCache {

    private int capacidade;
    private LinkedList cache;

    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LFUCache(int capacidade) {
        this.capacidade = capacidade;
        this.cache = new LinkedList();
    }

    public boolean isEmpty() {
    	return cache.size() == 0;
    }

    public boolean isFull() {
        return cache.size() == this.capacidade;
    }

    // deve ser O(1)
    public void addFirst(String chave) {
		if(isFull()) {
			cache.removeFirst();
			cache.addFirst(chave);
		} else {
			cache.addFirst(chave);
    	}
	}

	public void removeFirst() {
		cache.removeFirst();
	}

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Caso não encontre, adicione o elemento no início da fila e
    // toma as providências necessárias em relação à frequência
    public String get(String value) {
		if(cache.contain(value)) {
			Node a = cache.getNode(value);
			a.frequency++;
			cache.sortByFrequency(a);
			return value;
		}

        return null;
    }

    // O(1)
    public String getFirst() {
        if (cache.size() > 0) {
            return cache.getFirst();
        }

        return null;
    }

    // O(1)
    public String getLast() {
        if (cache.size() > 0) {
            return cache.getLast();
        }

        return null;
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return cache.toString();
    }
    
    public int size() {
        return cache.size();
    }
}
