package labs.example.loops;

public class executeWhileLoop {
    public static void main(String[] args) {
        int count = 0; //sets the original count to an interger and assigns it as 0
        while (count <= 9) { //the while loop starts, with 1 and counts up to 10
            count++; //adds one to count with each loop
            System.out.println("the loops has looped " + count + " times");
        }
        System.out.println("the loop is no finished, YIPPEE"); // states that the loop is finished
    }
}
