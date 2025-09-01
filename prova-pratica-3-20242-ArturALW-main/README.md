[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/tiipfzGB)
# Identificação

* Nome: Vitor Hugo Dias
* Email (@ccc): viotr.hugo.dias.botelho.de.oliveira@ccc.ufcg.edu.br
* Matrícula: 124110737

# Prova Prática 3

## O template

> Não altere o arquivo build.gradle

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/test/java/**

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `gradle compileJava` na raiz do projeto.

> Executando os testes públicos: `gradle test` na raiz do projeto.


## A Prova

### Questão 1: LFU (3.0)

Implemente a estratégia Menos Frequentemente Utilizado / Least Frequently Used (LFU) de _cache eviction_. Nessa estratégia, quando o cache está cheio e um elemento precisa entrar, o elemento menos acessado deve ser removido. Os elementos que foram mais acessados vão para o final da lista, pois devem ser removidos por último. 

Funciona assim. Sempre que um elemento é utilizado/acessado, sua frequência de uso deve ser incrementada e, se for o caso, ele deve ser reposicionado na lista para manter a ordem conforme a frequência. Os elementos considerados "menos acessados" são guardados no ínicio da lista e devem ser removidos primeiro, caso preciso, porque são acessados com menos frequência. A lista é sempre mantida ordenada.

Veja que se um elemento for o próximo a sair, mas for acessado muitas vezes, sua frequência aumenta e ele é reposicionado na lista, pois se tornou "mais acessado". Isso garante sua permanência no cache enquanto continuar sendo acessado frequentemente.

Analise o teste abaixo para entender a especificação desse comportamento.

```java
        LFUEvictionStrategy lfucache = new LFUEvictionStrategy(4);
        assertNull(lfucache.getNextEviction());
        assertEquals(0, lfucache.size());

        assertEquals("miss", lfucache.get("a"));
        // cache status: [<"a", 1>, null, null, null]
        assertNull(lfucache.getNextEviction());
        assertEquals(1, lfucache.size());

        assertEquals("hit", lfucache.get("a"));
        assertEquals("hit", lfucache.get("a"));
        // cache status: [<"a", 3>, null, null, null]
        assertEquals(1, lfucache.size());

        assertEquals("miss", lfucache.get("b"));
        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, null]
        assertNull(lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("d"));
        // cache status: [<"d", 1>, <"c", 1>, <"b", 1>, <"a", 3>]
        assertEquals("d", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "d" foi para o final da lista, pois é o elemento mais acessado
        // e "c" passa a ser o menos acessado.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("e"));
        // cache status: [<"e", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "c" teve que sair para entrada do "e", pois "c" é o menos acessado da lista.
        assertEquals("e", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());

        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"b", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // trocamos o "e" e "b", pois "e" foi mais acessado que "b"
        // e "b" passa a ser o elemento menos acessado da lista.
        assertEquals("b", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // "b" teve que sair para "c" voltar, pois "b" é o menos acessado da lista.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("e"));
        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"c", 1>, <"a", 3>, <"e", 4>, <"d", 4>]
        assertEquals("c", lfucache.getNextEviction());
        
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        // cache status: [<"a", 3>, <"e", 4>, <"d", 4>, <"c", 5>]
        // "c" foi para o final da lista, pois é o elemento mais acessado
        // e "a" passa a ser o menos acessado.
        assertEquals("a", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());
```

Implemente os métodos das classes **LFUEvictionStrategy**, **LFUCache** e **LinkedList** (`sortByFrequency`). Note que a classe Node já foi modificada para armazenar não somente o valor, mas sua frequência também.

Importante: entenda os testes. Leia. Compreenda. Faça mais testes. Testes são uma excelente forma de especificação de como seu algoritmo deve funcionar.


#### Restrições

    - Você deve implementar com uma LinkedList e apenas essa estrutura. O código foi disponibilizado, exceto pelo método `sortByFrequency`, que você deve implementar.
    
    - A busca por um elemento no cache é O(n) ainda porque não estamos usando outra estrutura além da LinkedList.
    
    - Adição e remoção de um elemento da linkedlist **deve ser O(1)**.

    - Inserção de um elemento ordenado pela frequência na linkedlist **deve ser O(n)**.

    - Seu cache deve ter o tamanho fixo, mesmo sendo implementado com uma linked list.

Ah...confira (sempre!) se você passa nos testes: `gradle test`.


### Questão 2: Parênteses (3.0)

Implemente o método `boolean checkParenteses(String parenteses)` que verifica se uma sequência de parênteses é bem formada. Você não precisa implementar uma pilha. Pode usar a classe LinkedList de java para apoiar a sua decisão. 

Exemplos:

    (()) -> true
    ))(( -> false


#### Restrições

- Você deve, necessariamente, usar LinkedList como uma pilha.
- Não há restrições em relação ao número de instâncias de LinkedList que você precisa criar.


### Teoria

* (1.0) Quais as principais diferenças entre ArrayList e LinkedList?

* (2.0) a) Compare e contraste os métodos de encadeamento (chaining) e endereçamento aberto (open addressing) para o tratamento de colisões, analisando suas vantagens e desvantagens; b) Explique como o fator de carga (load factor) de uma tabela hash influencia a probabilidade de colisões e o desempenho geral da estrutura.


* (1.0) Considere uma tabela hash com as seguintes características:

    * Tamanho da tabela: 100 posições
    * Conjunto de chaves a inserir: keys = [200, 205, 210, 215, ..., 495, 500] (valores de 200 a 500, com incremento de 5)
    * Função de hash utilizada: h(k) = k % 100 (resto da divisão por 100)
    * Método de resolução de colisões: endereçamento fechado (usando listas encadeadas)

    Qual a quantidade total de colisões que ocorrerão ao inserir todas essas chaves na tabela hash? O que você faria para diminuir esse número?

 ```
  


## Entregando a prova

> Passo 0. Modifique o arquivo README. Coloque seu nome, email @ccc e matrícula nos lugares indicados. Se você não fizer isso, não considero que sua prova foi assinada e, portanto, não vou corrigir. Não mude a formatação da linha. Apenas inclua seus dados.

> Passo 1. Certifique-se **NO TERMINAL** de que sua solução compila e passa nos testes. Isso deve ser feito com os comandos do gradle (compileJava e test).

> Passo 2. Submeta sua solução para o repositório

  * `git pull`
  * `git commit -m "entregando a prova 2"`
  * `git push origin main`

## Importante

* A correção da prova não é automática. Os testes que são executados quando você faz push são apenas testes de sanidade.

* Vou considerar sempre a última submissão antes do deadline final. 

* A nota será dada pelos testes no servidor e depois da correção que eu efetuar. Sempre tento corrigir o mais rápido possível. Portanto, tenha paciência.

* A nota será calculada a partir dos testes e análise manual do código. Essa análise manual vai considerar se a solução é eficiente, se não tem loops desnecessários etc.

* Só serão corrigidas as provas dos alunos que assinaram a lista de presença física no laboratório.
