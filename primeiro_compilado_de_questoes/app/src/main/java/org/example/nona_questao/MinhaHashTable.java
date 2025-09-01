package org.example.nona_questao;
import java.util.*;

public class MinhaHashTable {
	public ArrayList<String>[] tabela;
	public final int CONST_MULTIPLICATIVA = 101;
	public final double FATOR_DE_CARGA = 0.75;
	public final int CAPACIDADE_DEFAULT = 7;
	public int size;

	public MinhaHashTable() {
		this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
		this.size = 0;
		for(int i = 0; i < CAPACIDADE_DEFAULT; i++) {
			this.tabela[i] = new ArrayList<String>();
		}
	}

	public MinhaHashTable(int capacidade) {
		this.tabela = new ArrayList[capacidade];
		this.size = 0;
		for(int i = 0; i < capacidade; i++) {
			this.tabela[i] = new ArrayList<String>();
		}
	}

	public int hash(String k, int tamanho) {
		return (k.length() * CONST_MULTIPLICATIVA) % tamanho;
	}

    public void put(String k) {
		if((double) (size / this.tabela.length) >= FATOR_DE_CARGA) {
			resize();
		}

        int pos = hash(k, this.tabela.length);
		this.tabela[pos].add(k);
	   	this.size++;	
    }

    public boolean contains(String k) {
        int pos = hash(k, this.tabela.length);
		for(int i = 0; i < this.tabela[pos].size(); i++) {
			if(this.tabela[pos].get(i).equals(k)) {
				return true;
			}
		}
        return false;
    }

    public boolean remove(String k) {
        int pos = hash(k, this.tabela.length);
		for(int i = 0; i < this.tabela[pos].size(); i++) {
			if(this.tabela[pos].get(i).equals(k)) {
				tabela[pos].remove(i);
				this.size--;
				return true;
			}
		}
		return false;
    }

	public void resize() {
		MinhaHashTable novaTabela = new MinhaHashTable(2 * this.tabela.length);

		for(int i = 0; i < this.tabela.length; i++) {
			for(int j = 0; j < this.tabela[i].size(); j++) {
				int pos = hash(this.tabela[i].get(j), 2 * this.tabela.length);
				novaTabela.tabela[pos].add(tabela[i].get(j));
			}
		}

		this.tabela = novaTabela.tabela;
		this.size = novaTabela.size;
	}


    public static void main(String[] args) {
        MinhaHashTable tabela = new MinhaHashTable();

        // Total inicial: capacidade = 11, Fator de carga = 0.75 → limite = 8
        // Então após o 9º elemento, resize será chamado

        String[] nomes = {
            "Ana", "Bia", "Caio", "Duda", "Eli",
            "Fábio", "Gustavo", "Helena", "Igor", // até aqui deve fazer resize
            "Joana", "Kleber", "Lívia"
        };

        System.out.println("Inserindo elementos...");
        for (String nome : nomes) {
            tabela.put(nome);
            System.out.println("Inserido: " + nome);
        }

        System.out.println("\n--- Estado final da tabela ---");
        System.out.println(toStringTabela(tabela));
    }

    public static String toStringTabela(MinhaHashTable tabela) {
        StringBuilder sb = new StringBuilder();
        sb.append("Tamanho da tabela: ").append(tabela.tabela.length).append("\n");

        for (int i = 0; i < tabela.tabela.length; i++) {
            sb.append(i).append(": ");
            if (tabela.tabela[i].isEmpty()) {
                sb.append("vazio");
            } else {
                for (String s : tabela.tabela[i]) {
                    sb.append(s).append(" -> ");
                }
                sb.append("null");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
