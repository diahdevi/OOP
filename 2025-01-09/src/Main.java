import java.util.Scanner;

public class Main {
    public Scanner sc;

    int x = 99;
    String nama = "anton";

    // constructor
    public Main() {
        System.out.print("Enter name : ");
        sc = new Scanner(System.in);
        nama = sc.nextLine();
        x = 88;
        System.out.println("Welcome " + nama + x + x);
        System.out.println("Welcome " + nama + (x + x));
        System.out.println(Math.cos(88));

        Main m = new Main(0); // 1 kali
//        Main m = new Main(); // looping
        m.Hello();

        sc.close();

    }

    public Main(int a) {
        x = 88 + a;
        System.out.println(x);
    }

    public static void Hello(){
        System.out.println("Static void");
    }

    public static void main(String[] args) {
        new Main();
        new Main(100);
        System.out.println("Hello, World!");
    }

}