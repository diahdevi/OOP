import java.util.ArrayList;

class MainArrayList {
        public static void main(String[] args) {

            ArrayList<String> fruits = new ArrayList();

            // add element to ArrayList
            fruits.add("Banana");
            fruits.add("Apple");
            fruits.add("Cherry");
            fruits.add("Mango");
            System.out.println("Fruits = " + fruits);


            // access element in fruits ArrayList
            String fristFruit = fruits.get(0);
            System.out.println("First fruit : " + fristFruit);

            // change element to fruits ArrayList
            System.out.println("\nChange index 3 to Dragonfruit");
            fruits.set(3, "Dragonfruit");
            System.out.println("Fruits = " + fruits);


            // remove element in fruits ArrayList
            System.out.println("\nRemove index 1 :");
            fruits.remove(1);
            System.out.println("Fruits = " + fruits);


            // get size of fruits ArrayList
            System.out.println("Size of fruits : " + fruits.size());

            System.out.println("\nUsing loop :");
            // loop element of fruits ArrayList
            for(int i = 0; i < fruits.size(); i++){
                System.out.println(fruits.get(i));
            }

            System.out.println("\nUsing for each:");
            // loop element of fruits ArrayList using for each
            for(String fruit : fruits){
                System.out.println(fruit);
            }

            System.out.println("\nDelete all element:");
            fruits.clear();
            System.out.println("Fruits = " + fruits);


        }

}
