package at.seywerth.javaplayground.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Class that uses different Java Sets.
 *
 */
public class HashSetOrder extends HashSet<String> {

    private static final long serialVersionUID = 1L;

    private HashSet<String> hashSet;
    private LinkedHashSet<String> linkedHashSet;
    private TreeSet<String> treeSet;

    public long procTimeHashSet;
    public long procTimeLinkedHashSet;
    public long procTimeTreeSet;
    
    public HashSetOrder() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
    }

    /**
     * add to all Sets and take time.
     * 
     * @param value
     */
    public void addToHashSets(String value) {
        long startTime = System.nanoTime();
        hashSet.add(value);
        procTimeHashSet += System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedHashSet.add(value);
        procTimeLinkedHashSet += System.nanoTime() - startTime;

        startTime = System.nanoTime();
        treeSet.add(value);
        procTimeTreeSet += System.nanoTime() - startTime;
    }

    public String hashSetToString() {
        return hashSet.toString();
    }

    public String linkedHashSetToString() {
        return linkedHashSet.toString();
    }

    public String treeSetToString() {
        return treeSet.toString();
    }

}