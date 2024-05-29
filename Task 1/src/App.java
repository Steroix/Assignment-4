public class App {
    public static void main(String[] args) {

        MedianOfAges MedianOfAges = new MedianOfAges();
        MedianOfAges.insertNum(22);
        MedianOfAges.insertNum(35);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
        MedianOfAges.insertNum(30);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
        MedianOfAges.insertNum(25);
        System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
        }
}
