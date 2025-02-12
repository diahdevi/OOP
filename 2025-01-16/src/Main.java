import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Mahasiswa{

}

public class Main {
//    Scanner input = new Scanner(System.in);
    int x;
    Integer y = 99; // sebuah class, bisa akses funtion tertentu
    String z = "10";
    String name = "Budi";
    String Hai = "Pro_helloworld";
    int[] array_x = new int[10];
    char[] nim = new char[10];

    // ArrayList
    ArrayList<Integer> array_list = new ArrayList<Integer>();

    // Hash map
    HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
    HashMap<Mahasiswa,Float> hashMap_mahasiswa = new HashMap<Mahasiswa, Float>();

    Mahasiswa mhs1 = new Mahasiswa();
    Mahasiswa mhs2 = new Mahasiswa();

    public Main(){
        x = Integer.parseInt(z);
        y.toString();
        y.longValue();
        System.out.println("x = " + x);
        System.out.println("max value : " + y.MAX_VALUE);
        System.out.println("compare : " + name.compareTo("Budin"));
        System.out.println("substring : " + Hai.substring(4));
        System.out.println("substring : " + Hai.substring(4, 9));
        System.out.println("index : " + Hai.indexOf('_'));
//        nim = input.next().toCharArray();
//        System.out.println("nim = " + nim);
        System.out.println();


        // add to arrayList
        array_list.add(7);
        array_list.add(5);
        array_list.add(40);
        array_list.add(90);
        for(Integer n : array_list){
            System.out.println(n + " size:" + array_list.size());
        }
        System.out.println();


        // Hash Map
        hashMap.put("sfx", 99);
        hashMap.put("bgm", 10);
        System.out.println("sfx : " + hashMap.get("sfx"));
        System.out.println("bgm : " + hashMap.get("bgm"));
        // Hash Map Class Mahasiswa
        hashMap_mahasiswa.put(mhs1, 77f);
        hashMap_mahasiswa.put(mhs2, 55f);
        System.out.println("mhs1 : " + hashMap_mahasiswa.get(mhs1));
        System.out.println("mhs2 : " + hashMap_mahasiswa.get(mhs2));
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        new Main();

    }
}