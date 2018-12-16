package by.bsuir.dvornikova;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TestCase implements Iterable<String> {

    private Scanner sc;
    private InstructionFileIterator iterator = new InstructionFileIterator();

    public TestCase(File file) throws FileNotFoundException {
        sc = new Scanner(file);
    }

    public Iterator<String> iterator() {
        return iterator;
    }

    private class InstructionFileIterator implements Iterator<String> {

        public boolean hasNext() {
            return sc.hasNextLine();
        }

        public String next() {
            return sc.nextLine();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
