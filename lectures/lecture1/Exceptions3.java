package lectures.lecture1;

public class Exceptions3 {
    public static void main(String[] args)
    {
        a();
    }

    public static void a() {
        b();
    }
    public static void b() {
        c();
    }

    public static void c() {
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }
}
