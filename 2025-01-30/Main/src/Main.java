import java.util.HashSet;

class Main{
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<String>();

        colors.add("Red");
        colors.add("Yellow");
        colors.add("Green");
        System.out.println("Colors : " + colors);

        boolean hasRed = colors.contains("Red");
        System.out.println("Has red : " + hasRed);

        System.out.println("Remove Green");
        colors.remove("Green");
        System.out.println("Colors : " + colors);

        colors.add("Brown");
        colors.add("Black");

        System.out.println("Colors : " + colors);
        int size = colors.size();
        System.out.println("Size of Colors : " + size + "\n");

        System.out.println("Color using for-each loop");
        for(String color : colors){
            System.out.println(color);
        }
    }
}



