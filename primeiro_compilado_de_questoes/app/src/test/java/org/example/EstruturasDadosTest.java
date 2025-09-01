package org.example;

import org.example.decima_questao.AcessoUsuariosCache;
import org.example.nona_questao.MinhaHashTable;
import org.example.oitava_questao.FIFOCache;
import org.example.primeira_questao.Pilha;
import org.example.quarta_questao.FilaPrioridade;
import org.example.quinta_questao.MeuArrayList;
import org.example.segunda_questao.VerificadorExpressao;
import org.example.setima_questao.LRUCache;
import org.example.sexta_questao.MinhaLinkedList;
import org.example.terceira_questao.FilaCircular;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstruturasDadosTest {

    @Test
    void testPilhaRedimensionamento() {
        Pilha p = new Pilha();
        for (int i = 0; i < 128; i++) p.push(i);
        for (int i = 127; i >= 64; i--) assertEquals(i, p.pop());
        for (int i = 63; i >= 0; i--) assertEquals(i, p.pop());
        assertTrue(p.isEmpty());
    }

    @Test
    void testVerificadorExpressao() {
        VerificadorExpressao v = new VerificadorExpressao();
        assertTrue(v.isBalanceada("({[]})"));
        assertTrue(v.isBalanceada("(){}[]"));
        assertFalse(v.isBalanceada("{[(])}"));
        assertFalse(v.isBalanceada("((())"));
        assertFalse(v.isBalanceada("([)]"));
    }

    @Test
    void testFilaCircular() {
        FilaCircular f = new FilaCircular(3);
        assertThrows(RuntimeException.class, f::removeFirst); // fila vazia
        f.addLast(10);
        f.addLast(20);
        f.addLast(30);
        assertThrows(RuntimeException.class, () -> f.addLast(40)); // fila cheia
        assertEquals(10, f.removeFirst());
        f.addLast(40);
        assertEquals(20, f.removeFirst());
        assertEquals(30, f.removeFirst());
        assertEquals(40, f.removeFirst());
        assertTrue(f.isEmpty());
		f.addLast(10);
		assertEquals(10, f.removeFirst());
		f.addLast(5);
		f.addLast(6);
		f.addLast(3);
		assertThrows(RuntimeException.class, () -> f.addLast(2));
		assertEquals(5, f.removeFirst());
		assertEquals(6, f.removeFirst());
		assertEquals(3, f.removeFirst());
		assertTrue(f.isEmpty());
    }

    @Test
    void testFilaPrioridade() {
        FilaPrioridade f = new FilaPrioridade();
		assertThrows(RuntimeException.class, () -> f.removeFirst());
        f.addLast(101);
        f.addLast(5);
        f.addLast(120);
        f.addLast(10);
        assertEquals(5, f.removeFirst());
        assertEquals(10, f.removeFirst());
        assertEquals(101, f.removeFirst());
        assertEquals(120, f.removeFirst());
		assertTrue(f.isEmpty());
		assertThrows(RuntimeException.class, () -> f.removeFirst());
		f.addLast(200);
		assertEquals(200, f.removeFirst());
		f.addLast(200);
		f.addLast(5);
		f.addLast(10);
		f.addLast(2);
		assertEquals(5, f.removeFirst());
		assertEquals(10, f.removeFirst());
		assertEquals(2, f.removeFirst());
		assertEquals(200, f.removeFirst());
		assertTrue(f.isEmpty());
    }

    @Test
    void testMeuArrayList() {
        MeuArrayList l = new MeuArrayList();
        l.add(5); l.add(7); l.add(5); l.add(10);
		assertEquals(5, l.get(0));
		assertEquals(10, l.get(3));
        l.removeAll(5);
        assertEquals(7, l.get(0));
        assertEquals(10, l.get(1));
        l.insertSorted(8);
        l.insertSorted(6);
        assertEquals(6, l.get(0));
        assertEquals(7, l.get(1));
        assertEquals(8, l.get(2));
        assertEquals(10, l.get(3));
        assertEquals(4, l.size());
    }

    @Test
    void testMinhaLinkedList() {
        MinhaLinkedList list = new MinhaLinkedList();
        list.add(9); list.add(1); list.add(9); list.add(3);
        list.removeAllRec(9);
        List<Integer> resultado = list.toList();
        assertEquals(List.of(1, 3), resultado);
        list.removeAllRec(3);
        assertEquals(List.of(1), list.toList());
        list.removeAllRec(1);
        assertTrue(list.toList().isEmpty());
    }

    @Test
    void testLRUCache() {
        LRUCache cache = new LRUCache(5);
		assertThrows(RuntimeException.class, () -> cache.getNextEviction());
        assertEquals("miss", cache.get(100));
        assertEquals("miss", cache.get(200));
		assertEquals("miss", cache.get(300));
        assertEquals("miss", cache.get(400));
		assertEquals("miss", cache.get(500));

        assertEquals("hit", cache.get(100));
		assertEquals("hit", cache.get(200));
		assertEquals("hit", cache.get(300));
		assertEquals("hit", cache.get(400));
	    assertEquals("hit", cache.get(500));

		assertEquals(100, cache.getNextEviction());

		assertEquals("miss", cache.get(600));
		assertEquals(200, cache.getNextEviction());
		assertEquals("miss", cache.get(700));
		assertEquals(300, cache.getNextEviction());

        assertEquals("hit", cache.get(300));
        assertEquals(400, cache.getNextEviction());
    }

    @Test
    void testFIFOCache() {
        FIFOCache cache = new FIFOCache(2);
        assertEquals("miss", cache.get(11));
        assertEquals("miss", cache.get(22));
		assertEquals(11, cache.getNextEviction());
		assertEquals("miss", cache.get(33));
        assertEquals(22, cache.getNextEviction());
		assertEquals("hit", cache.get(22));
        assertEquals("hit", cache.get(33));
		assertEquals(22, cache.getNextEviction());
		assertEquals("miss", cache.get(44));
        assertEquals(33, cache.getNextEviction());
    }

    @Test
    void testMinhaHashTable() {
        MinhaHashTable table = new MinhaHashTable();
        table.put("uva");
        table.put("banana");
        table.put("morango");
        table.put("uva"); // duplicata
        table.put("abacaxi");
        assertTrue(table.contains("uva"));
        assertTrue(table.contains("banana"));
        assertFalse(table.contains("melancia"));
        table.remove("banana");
        assertFalse(table.contains("banana"));
        // Colisão: insere várias chaves que colidem intencionalmente
        table.put("key1");
        table.put("key2");
        table.put("key3");
        assertTrue(table.contains("key1"));
        assertTrue(table.contains("key2"));
        assertTrue(table.contains("key3"));
    }

    @Test
    void testAcessoUsuariosCache() {
        AcessoUsuariosCache cache = new AcessoUsuariosCache(3);
        assertEquals("miss", cache.get("Gabi"));
        assertEquals("miss", cache.get("Tiago"));
        assertEquals("miss", cache.get("Lia"));
        assertEquals("hit", cache.get("Gabi"));
        assertEquals("miss", cache.get("Rafa")); // Evicta Tiago
        assertEquals("Lia", cache.getNextEviction());
        List<String> ultimos = cache.getLastUsers(3);
        assertEquals(List.of("Rafa", "Gabi", "Lia"), ultimos);
    }
}

