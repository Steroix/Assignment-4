public class App {
    public static void main(String[] args) {
        MedianOfAges medianOfAges = new MedianOfAges();
        medianOfAges.insertNum(22);
        medianOfAges.insertNum(35);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
        medianOfAges.insertNum(30);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
        medianOfAges.insertNum(25);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
    }
}
