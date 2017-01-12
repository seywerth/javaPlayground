package at.seywerth.javaplayground.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import at.seywerth.javaplayground.text.LexicalComparator.Person;

/**
 * visualize and test different text compare methods.
 * <br>
 * missing:<br>
 * - differentiate between locale (fe: Locale.FRANCE)<br>
 * - tertiary and identical differences
 *
 */
public class LexicalComparatorTest {

    @Test
    public void testPrintCompares() {
        List<LexicalComparator> comps = new ArrayList<>();
        comps.add(new LexicalComparator(Collator.PRIMARY));
        comps.add(new LexicalComparator(Collator.SECONDARY));
        comps.add(new LexicalComparator(Collator.TERTIARY));
        comps.add(new LexicalComparator(Collator.IDENTICAL));
        comps.add(new LexicalComparator());

        for (LexicalComparator comp : comps) {
            createPersons(comp);
            comp.sorted();
            System.out.println(comp.getType() + " -> " + comp.formatString());
        }
    }

    @Test
    public void testSortStringCompare() {
        LexicalComparator comparator = new LexicalComparator();
        createPersons(comparator);
        ArrayList<Person> persons = comparator.sorted();
        assertNotNull(persons);
        int i = 0;
        assertEquals("A", persons.get(i++).getName());
        assertEquals("Best", persons.get(i++).getName());
        assertEquals("aest", persons.get(i++).getName());
        assertEquals("Áest", persons.get(i++).getName());
        assertEquals("Ä est", persons.get(i++).getName());
        assertEquals("Äest", persons.get(i++).getName());
        assertEquals("Äést", persons.get(i++).getName());
        assertEquals("áest", persons.get(i++).getName());
        assertEquals("áést", persons.get(i++).getName());
    }

    @Test
    public void testSortIdentical() {
        LexicalComparator comparator = new LexicalComparator(Collator.IDENTICAL);
        createPersons(comparator);
        ArrayList<Person> persons = comparator.sorted();
        assertNotNull(persons);
        int i = 0;
        assertEquals("A", persons.get(i++).getName());
        assertEquals("aest", persons.get(i++).getName());
        assertEquals("áest", persons.get(i++).getName());
        assertEquals("Áest", persons.get(i++).getName());
        assertEquals("áést", persons.get(i++).getName());
        assertEquals("Äest", persons.get(i++).getName());
        assertEquals("Äést", persons.get(i++).getName());
        assertEquals("Ä est", persons.get(i++).getName());
        assertEquals("Best", persons.get(i++).getName());
    }

    @Test
    public void testSortPrimary() {
        LexicalComparator comparator = new LexicalComparator(Collator.PRIMARY);
        createPersons(comparator);
        ArrayList<Person> persons = comparator.sorted();
        assertNotNull(persons);
        int i = 0;
        assertEquals("A", persons.get(i++).getName());
        assertEquals("Áest", persons.get(i++).getName());
        assertEquals("áest", persons.get(i++).getName());
        assertEquals("áést", persons.get(i++).getName());
        assertEquals("Ä est", persons.get(i++).getName());
        assertEquals("Äest", persons.get(i++).getName());
        assertEquals("Äést", persons.get(i++).getName());
        assertEquals("aest", persons.get(i++).getName());
        assertEquals("Best", persons.get(i++).getName());
    }

    @Test
    public void testSortSecondary() {
        LexicalComparator comparator = new LexicalComparator(Collator.SECONDARY);
        createPersons(comparator);
        ArrayList<Person> persons = comparator.sorted();
        assertNotNull(persons);
        int i = 0;
        assertEquals("A", persons.get(i++).getName());
        assertEquals("aest", persons.get(i++).getName());
        assertEquals("Áest", persons.get(i++).getName());
        assertEquals("áest", persons.get(i++).getName());
        assertEquals("áést", persons.get(i++).getName());
        assertEquals("Äest", persons.get(i++).getName());
        assertEquals("Äést", persons.get(i++).getName());
        assertEquals("Ä est", persons.get(i++).getName());
        assertEquals("Best", persons.get(i++).getName());
    }

    @Test
    public void testSortTertiary() {
        LexicalComparator comparator = new LexicalComparator(Collator.TERTIARY);
        createPersons(comparator);
        ArrayList<Person> persons = comparator.sorted();
        assertNotNull(persons);
        int i = 0;
        assertEquals("A", persons.get(i++).getName());
        assertEquals("aest", persons.get(i++).getName());
        assertEquals("áest", persons.get(i++).getName());
        assertEquals("Áest", persons.get(i++).getName());
        assertEquals("áést", persons.get(i++).getName());
        assertEquals("Äest", persons.get(i++).getName());
        assertEquals("Äést", persons.get(i++).getName());
        assertEquals("Ä est", persons.get(i++).getName());
        assertEquals("Best", persons.get(i++).getName());
    }

    private void createPersons(LexicalComparator comparator) {
        comparator.addPerson("Best");
        comparator.addPerson("Áest");
        comparator.addPerson("áest");
        comparator.addPerson("áést");
        comparator.addPerson("Ä est");
        comparator.addPerson("Äest");
        comparator.addPerson("Äést");
        comparator.addPerson("aest");
        comparator.addPerson("A");
    }

}