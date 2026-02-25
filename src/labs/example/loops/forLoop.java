package labs.example.loops;

public class forLoop {
    public static void main(String[] args) {
        
        ececuteForLoop();
        int decrease = sumTwoNumbers(1, 1);
        System.out.println("the sum is "+decrease);
        decrease--;
        System.out.println("the sum decreased to "+decrease);
        sumLoopCounter(10);
        
                    }
                
                public static void ececuteForLoop(){
                    
                    int count = 0; //sets the count to zero
                    
                    for (;count <= 20;){ //begins the for loop 
                        System.out.println("the count is "+count); //starts the loop at zero
                        count++; //progressivly increases the count until 20
                    
                    };}
                public static int sumTwoNumbers(int x1, int y1){
                    int sum = x1+ y1;
                    return sum;
                }
                public static void sumLoopCounter(int x){
                    int loopAmount = 0;
                    for (;loopAmount <= x;){
                        loopAmount++;
                    };
                    System.out.println("the loop wnet "+x+" times");
                }
}
