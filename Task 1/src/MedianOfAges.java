public class MedianOfAges {
    private PQ<Integer> minHeap;
    private PQ<Integer> maxHeap;

    public MedianOfAges() {
        // minHeap for the larger half (natural ordering)
        minHeap = new PQ<>(true);
        // maxHeap for the smaller half (reverse ordering)
        maxHeap = new PQ<>(false);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.insert(num);
        } else {
            minHeap.insert(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.insert(maxHeap.delTop());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.insert(minHeap.delTop());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
