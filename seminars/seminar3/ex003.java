package seminars.seminar3;


public class ex003 {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            counter.add();
            counter.add();
            System.out.println("Count: " + counter.getCount());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
