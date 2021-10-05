package S181870286;

import java.util.LinkedList;

public abstract class Sorter {

    public class Pair {
        public int a, b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    protected int[] elements;
    protected LinkedList<Pair> plan = new LinkedList<Pair>();

    public void load(int[] elements) {
        this.elements = elements;
    }

    protected void swap(int i, int j) {
        if (i == j)
            return;
        int temp;
        temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        plan.add(new Pair(i, j));
    }

    abstract public void sort();



    public LinkedList<Pair> getPlan() {
        return this.plan;
    }
    
}
