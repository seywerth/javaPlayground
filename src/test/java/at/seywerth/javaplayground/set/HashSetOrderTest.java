package at.seywerth.javaplayground.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test order in Sets. HashMap in HashSet is implemented differently for JDK 7 and 8.
 * Results would be different using JDK 7.
 *
 */
public class HashSetOrderTest {

    private static final long OBJECT_NUMBER = 10000;
    private static final long NANOSECS = 1000000;
    
    @Test
    public void testHashSetOrder() {
        HashSetOrder set = new HashSetOrder();
        set.addToHashSets("abc");
        set.addToHashSets("bcd");
        set.addToHashSets("cde");

        assertFalse(set.hashSetToString() == set.linkedHashSetToString());
        assertFalse(set.linkedHashSetToString() == set.treeSetToString());
        assertEquals("[abc, bcd, cde]", set.linkedHashSetToString());
        assertEquals("[abc, bcd, cde]", set.treeSetToString());
        System.out.println("HashSet:       " + set.hashSetToString());
        System.out.println("LinkedHashSet: " + set.linkedHashSetToString());
        System.out.println("TreeSet:       " + set.treeSetToString());
    }

    @Test
    public void testHashSetTime() {
        long startTime = System.nanoTime();
        HashSetOrder set = createHashSets();
        long total = System.nanoTime() - startTime;
        System.out.println("created elements: " + (OBJECT_NUMBER*3) + " in " + total/NANOSECS + " ms");

        assertTrue(set.procTimeLinkedHashSet < set.procTimeTreeSet);
        System.out.println("HashSet:       " + set.procTimeHashSet/NANOSECS + " ms");
        System.out.println("LinkedHashSet: " + set.procTimeLinkedHashSet/NANOSECS + " ms");
        System.out.println("TreeSet:       " + set.procTimeTreeSet/NANOSECS + " ms");
    }

    private HashSetOrder createHashSets() {
        HashSetOrder set = new HashSetOrder();
        for (int i = 1; i <= OBJECT_NUMBER; i++) {
            set.addToHashSets("a" + i);
        }
        return set;
    }
}