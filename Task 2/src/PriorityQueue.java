import java.util.Vector;

public class PriorityQueue {
    private Vector<Task> heap;

    public PriorityQueue() {
        heap = new Vector<>();
    }

    public void addTask(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
        System.out.println(Scheduler.currentTime + ": adding " + task.getName() + 
                           " with deadline " + task.getDeadline() + 
                           " and duration " + task.getDuration());
    }

    public Task removeTask() {
        if (heap.isEmpty()) return null;
        Task removedTask = heap.firstElement();
        Task lastTask = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastTask);
            heapifyDown(0);
        }
        return removedTask;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap.get(index).getDeadline() < heap.get(parentIndex).getDeadline()) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).getDeadline() < heap.get(smallest).getDeadline()) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).getDeadline() < heap.get(smallest).getDeadline()) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int index1, int index2) {
        Task temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
