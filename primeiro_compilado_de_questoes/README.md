#Lista de Exercícios de Estrutura de Dados (Java)

Este repositório reúne uma seleção de 10 exercícios práticos e 10 questões teóricas com foco nos seguintes tópicos:

- Pilha com arrays
- Fila com arrays
- ArrayList
- LinkedList
- Cache (FIFO e LRU)
- Tabelas de Hash (com encadeamento)

---

## 💡 Questões Práticas

### 1. Pilha com Redimensionamento Dinâmico
Implemente uma pilha com array interno que:
- Dobre a capacidade ao atingir o limite.
- Reduza pela metade se estiver usando apenas 1/4 da capacidade após um `pop()`.
- Métodos: `push(int x)`, `int pop()`, `boolean isEmpty()`

### 2. Verificador de Expressão Balanceada
Verifique se uma expressão com `()[]{}` está corretamente balanceada. Utilize uma pilha.
- Método: `boolean isBalanceada(String expr)`

### 3. Fila Circular com Arrays
Implemente uma fila circular com capacidade fixa.
- Métodos: `addLast(int x)`, `removeFirst()`
- Trate os casos de fila cheia e fila vazia.

### 4. Fila com Prioridade por Faixa
Itens < 100 saem antes dos ≥ 100, mas respeitando a ordem de chegada dentro de cada grupo.
- Métodos: `addLast(int x)`, `removeFirst()`

### 5. ArrayList Customizado
Replique funcionalidades de um `ArrayList`, sem usar a API Java Collections.
- Métodos:
  - `add(int x)`
  - `get(int index)`
  - `removeAll(int value)`
  - `insertSorted(int value)`
  - `size()`

### 6. LinkedList com Remoção Recursiva
Crie uma lista encadeada com remoção recursiva de elementos.
- Métodos: `add(int x)`, `removeAllRec(int value)`, `toList()`

### 7. LRU Cache (Least Recently Used)
Cache com capacidade fixa que remove o item menos recentemente utilizado.
- Métodos:
  - `String get(int key)` → "hit" ou "miss"
  - `Integer getNextEviction()` → qual será o próximo a ser removido (ou `null`)

### 8. FIFO Cache
Cache com remoção do item mais antigo (first-in).
- Métodos:
  - `String get(int key)` → "hit" ou "miss"
  - `Integer getNextEviction()` → próximo item a ser removido (ou `null`)

### 9. HashTable com Encadeamento (Chaining)
Implemente uma hash table com colisão resolvida via listas ligadas.
- Tipos fixos: `int` ou `String`.
- Métodos: `put(Object v)`, `contains(Object v)`, `remove(Object v)`

### 10. Cache de Acessos por Usuário
Semelhante ao LRU, mas com chaves do tipo `String`.
- Métodos:
  - `String get(String userId)`
  - `String getNextEviction()`
  - `List<String> getLastUsers(int n)`

---

## 🤔 Questões Teóricas

1. **Explique o conceito de stack overflow e como ele pode ocorrer em uma pilha implementada com arrays.

    Pilhas são implementadas com arrays, que por sua vez, possuem capacidade limitada, stack overflow ocorre então , quando essa capacidade
    limitada é atingida, para resolver este problema existem duas heurísticas principais, a primeira delas é simplesmente nao deixar que sejam
    adicionados mais elementos na pilha, lancando stack overflow. Outro é fazer o resize da pilha, que consiste em copiar os elementos da pilha     original para uma pilha com mais capacidade, o que acaba sendo custoso.
    

2. **Compare os métodos de redimensionamento de arrays em uma pilha e em um array list. Qual é mais eficiente e por quê?**

    Como explicado anteriormenete o redimensinamento ocorre quando a capacidade máxima da pilha é atingida. Para uma pilha implementada
    com array seria necessário fazer o resize que é extremamente custoso, pois , temos que criar outro array com um tamanho maior que o original    e copiar os elementos para esse novo array, o que resulta em uma complexidade temporal e de memoria de O(n). Ja em uma implementaçao por Arr    aysList esse problema de capacidade limitada que temos no array não ocorre, podemos apenas continuar adicionando elementos no topo da pila.     Mas note que o apesar de o ArrayList usar de um alocamento de memória dinamica essa memoria nao e ilimitada, temos também que fazer resizes,    porem ,o arrayList utiliza algumas implementacoes que faz com que resizes ocorram raramente em comparacoes com insercoes. Desse modo, fica e    vidente que o metodo de redimensionamento é bem mais eficiente com implmentacoes que usam ArraysList.

3. **Descreva a diferença de comportamento entre uma fila circular e uma fila linear com array fixo.**
        Filas são geralmente implementadas atraves de arrays, que por sua vez possuem tamanho fixo , para isso existem diferentes tipos de implementacao, entre elas fila circular e fila linear. Na fila circular aceitamos que a fila possui um tamanho fixo e optamos por nao fazer resize
    , ja na fila linear quando a fila enche optamos por fazer o resize, que consiste em criar uma outra fila com mais capacidade. Outra diferen    ca importante de se discutir é a operação "removeFirst", na implementacao de fila linear, quando removemos o primeiro elemento temos que faz    er o "shiftLeft" que consiste em mover todos os elementos da lista para esquerda (ja que removemos o mais a esquerda), na fila circular por     outro lado, manipulamos as variaveis "tail" e "head" para conseguir ocupar as posicoes livres da fila de maneira circular. Em resumo, ad        icoes na fila circular sao O(1) mas possui capacidade limitada, enqaunto adicoes na fila linear sao em media O(1) (pois a quantidade de resie    e pequena em comparacao com com as adicoes) e permite capacidade ilimitada (dentro das limites computacionais, é claro), a remocao na fila c    ircular tambem é O(1) pois precisamos somente manipular as variaveis que controlam o inicio e o fim da fila, enquanto na linear e preciso fa    zer o "shiftleft" que ocorre em O(n).

4. **Quais as vantagens de se usar listas encadeadas em relação a arrays em estruturas dinâmicas como pilhas e filas?**

      Uma questao importante que sempre discutimos quando implementamos filas e pilhas é a capacidade limitada de tamanho dessas estruturas, em algumas implementacoes optamos por fazer o resize, que por sua vez é custoso (O(n)), em outras optamos por nao adicionar mais elementos quandoa capacidade maxima é atingida. Por outro lado quando usamos listas encadeadas não precisamos nos preocupar com essa questao, adicoes no inicio e no fim da lista sao feitas em O(1) sem se preocupar com resize. Outra questao que discutimos em fila é a remocao do primeiro elemento, que na implementacao de fila linear, exige o resize que por sua vez tambem é custoso O(n), ja quando usamos listas encadeadas conseguimos fazer     essa operacao em O(1) apenas mudando as referencias de cada nó.

5. **Explique o que é um cache LRU. Dê um exemplo do mundo real onde ele é usado.**
    
    Cache consiste em uma memória de acesso rápido, porém capacidade reduzida, cache LRU é uma politica de como usar essa memória cache. Quando
    essa memoria atinge a capacidade limite a politica se baseia na seguinte forma: Removemos o elemento que esta a mais tempo sem ser pesquisad    o ou ainda o "menos em alta", para dar lugar a um novo elemento. Um exemplo de aplicacao no mundo real pode ser o filtro de
    pesquisas na web, por exemplo, suponha que voce esta pesquisando sobre um tema A no google, esse tema agora esta armazenado no cache, mas di    gamos que agora voce pesquise sobre outro tema B que nao tem relacao com o tema A, esse elemento tambem vai para o cache, nesse momento voce    comeca a pesquisar temas com mais relacao com o tema B que tambem vao para o cache, note que o tema A vai sendo "esquecido"
    seguindo a politica LRU esse elemento sera o removido para dar lugar a outros temas que estao "mais em alta" no momento.

6. **Compare as estratégias de remoção FIFO e LRU em caches. Em quais contextos cada uma se encaixa melhor?**

    Como ja discutido anteriormente a politica de LRU se baseia em remover do cache o elemento a mais tempo ser ser pesquisado, por outro lado,     a politica de FIFO (first in first out) se baseia em remover o primeiro elemento a chegar no cache. Como visto anteriormente no exemplo de
    pesquisas na web é uma boa aplicacao da politica de LRU, uma aplicacao para a politica FIFO poderia ser a manutencao de uma lista de tarefas    , se pensarmos que retirar a tarefa do cache seria equivalente a executa - la, faz sentido executar a tarefa que esta a mais tempo 
    esperando no cache. Vale ressaltar que nao exite uma politica melhor que a outra, elas consistem apenas em heuristicas diferentes de como li    dar com cache, no fim das contas o que queremos é maximizar os "hits" (idas bem sucedidas ao cache) e minimizar os "miss" (idas mal suceidad    as ao cache) entao diferentes situacoes pedem diferentes politicas de cache.

7. **Explique o funcionamento de uma tabela de hash com encadeamento. Quais suas vantagens sobre o endereçamento aberto?**
    
    Quando estudamos tabelas hashs um dos topicos mais importantes a discutir é como lidar com colisoes, que muitas vezes sao inevitaveis. Para issso temos duas politicas principais, tabelas hashs encadeadas e tabelas por endereçamento aberto, na estrategia de encadeamento, utilizamos     a seguinte estrategia, quando temos colisoes (dois elementos mapeados para mesma posicao), criamos uma lista onde mantemos elementos com o m    esmo hash. Na politica de enderecamento aberto, quando temos colisoes, procuramos outra posicao livre na tabela para adicionar um novo elemen    to e assim sucessivamente para cada colisao. Note que a insercao de elementos por encadeamento é em media (a quantidades de resizes ocorre raramente em comparacoes a adicoes) O(1) (basta calcular o hash e inserir na lista) enquanto por enderacamento aberto temos que procurar outra posicao livre, que no pior caso pode ser O(n) (quando a tabela esta cheia) note tambem que a busca de elementos na tabela encadeada depende do tamanho das listas com o mesmo hash, entao dizemos q ela é O(k), onde k é o tamanho medio das listas, enquanto em tabelas por enderacamento aberto a procura é O(n), porem, é valido ressaltar que devidos as estrategias de resize e rehash que existem na tabela por encadeamento o tamanho medio das listas (k) sao sempre menores que o tamanho da tabela (n). O mesmo acontece com as remocoes, na esrtategia de encadeamento apenas calculamos e hash e buscamos na lista desse hash, que configura uma comlexidade O(k), enquanto na por enderacamento (no pior caso), pode ser O(n).
    Desse modo, podemos perceber que a politica de encadeamento se sai melhor que a de endereçamento aberto, sobre tudo em insercoes/remocoes e     pesquisa.

8. **O que é uma colisão em hash tables? Como o encadeamento resolve isso?**

    Colisoes em tabelas hashs acontecem quando dois elementos diferentes sao mapeados para mesma posicao da tabela (possuem o mesmo hash). A pol    itica de encadeamento resolve isso criando listas de elementos com o mesmo hash, e utiliza alguas heuristicas de resizes e rehashs para cons    eguir utilizar a maior qauntidade possivel de posicoes da tabela, evitando assim colisoes, que por sua vez sao pessimas quando tratamos de t    abela hash.

9. **Qual a complexidade de inserção, busca e remoção em uma hash table com encadeamento?**

10. **Qual a importância de uma boa função de hash? Quais problemas podem surgir com uma função ruim?**

---

> Todos os testes para as questões práticas estão definidos em `EstruturasDadosTest.java`, com 1 `@Test` por atividade. As implementações não devem utilizar generics, conforme restrições indicadas.

Bons estudos e boa sorte na prova! ✨
