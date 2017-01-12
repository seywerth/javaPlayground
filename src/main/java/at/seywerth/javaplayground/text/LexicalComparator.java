package at.seywerth.javaplayground.text;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Compare text with specific characters.
 *
 */
public class LexicalComparator {

    int strength;
    boolean stringCompare;
    ArrayList<Person> persons;

    public class Person implements Comparable<Person> {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Person person) {
            if (!stringCompare) {
                Collator collator = Collator.getInstance();
                collator.setStrength(strength);
                return collator.compare(this.name, person.getName());
            }
            return this.name.compareTo(person.getName());
        }

        public String getName() {
            return this.name;
        }
    }

    public LexicalComparator() {
        this.persons = new ArrayList<>();
        this.stringCompare = true;
    }

    public LexicalComparator(int strength) {
        this.persons = new ArrayList<>();
        this.strength = strength;
        this.stringCompare = false;
    }

    public void addPerson(String name) {
        this.persons.add(new Person(name)); 
    }

    public ArrayList<Person> sorted() {
        Collections.sort(this.persons);
        return this.persons;
    }

    public String formatString() {
        String out = "";
        for (Person p : this.persons) {
            out += String.format("%-8s", p.name);
        }
        return out;
    }

    public String getType() {
        if (this.stringCompare) {
            return "StringComp";
        }
        switch (this.strength) {
            case Collator.IDENTICAL:
                return "Identical ";
            case Collator.PRIMARY:
                return "Primary   ";
            case Collator.SECONDARY:
                return "Secondary ";
            case Collator.TERTIARY:
                return "Tertiary  ";
        }
        return "invalid";
    }
}