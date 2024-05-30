public class PQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N; // Size of the priority queue
    private boolean isMinHeap; // Flag to determine heap type

    public PQ(int capacity, boolean isMinHeap) {
        pq = (Key[]) new Comparable[capacity + 1];
        this.isMinHeap = isMinHeap;
    }

    public PQ(boolean isMinHeap) {
        this(1, isMinHeap);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        if (N == pq.length - 1) resize(2 * pq.length);
        pq[++N] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && compare(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && compare(j + 1, j)) j++;
            if (!compare(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean compare(int i, int j) {
        return isMinHeap ? pq[i].compareTo(pq[j]) < 0 : pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public Key delTop() {
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        Key top = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
        return top;
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public Key peek() {
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }

    public int size() {
        return N;
    }
}
