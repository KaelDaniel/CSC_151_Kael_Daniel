package labs.example.loops;

public class forLoop {
    public static void main(String[] args) {
        
        ececuteForLoop(); //this just executes the first for loop that goes from 0 to 20
        int decrease = sumTwoNumbers(1, 1); // this is meant to set decrease to the sum for lowering
        System.out.println("the sum is "+decrease); //just some info text
        decrease--; //decreases the sum by 1
        System.out.println("the sum decreased to "+decrease); //just some more text
        sumLoopCounter(10); // the last two here jsut call out the programs
        printMultiplicationTable(5);
        
                    }
                
                public static void ececuteForLoop(){
                    
                    int count = 0; //sets the count to zero
                    
                    for (;count <= 20;){ //begins the for loop 
                        System.out.println("the count is "+count); //starts the loop at zero
                        count++; //progressivly increases the count until 20
                    
                    };}

                public static int sumTwoNumbers(int x1, int y1){
                    int sum = x1+ y1; //just adds the two numbers and returns the sum
                    return sum;
                }
                public static void sumLoopCounter(int x){
                    int loopAmount = 0; //sets the loop to 0
                    for (;loopAmount <= x;){
                        loopAmount++; //with each loop it increase by one until it matches whatever x is
                    };
                    System.out.println("the loop went "+x+" times"); //at the end it states how many times the loop went
                }

                public static double printMultiplicationTable(double dx){
                    double multiply = 0; //sets the loop count to zero
                    for (;multiply <= 12;){ //makes it so the loop goes through 0 to 12
                        double result = dx * multiply; //multiplies the dx with the loop amount
                        System.out.println(dx+" * "+multiply+" = "+result); //prints the math and the result
                        multiply++; //then adds one to the result
                    }
                    return multiply; //only here becuase the program wants to return, so yeah
                }
}
