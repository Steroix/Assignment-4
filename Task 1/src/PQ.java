public class PQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N; // Size of the priority queue

    public PQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1]; 
    }
    
    public PQ() {
        this(1);
    }
    

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j))
                j++;
            if (!less(j, k))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return min;
    }

}
