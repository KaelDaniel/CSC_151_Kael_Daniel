package labs.example.mammals;

public class Mammal {

// javac -d bin src/labs/example/mammals/*.java (kael use this for debugging, probably gonna use it a lot)
    protected String eyeColor;
    protected String hairColor;
    protected String bodyTemp;
    protected String name;
    protected String habitat;
    protected String fur;
    protected String diet;





    public void run(){}

    public void scratch(){}

    public void eat(){}

    public void sleep(){}
    
    public void sit(){
        if(habitat == "water"){
            System.out.println("amphibious mammals cannot sit");}
        else{
            System.out.println("sit ubu sit");}
    }

    public void clean(){}

    public void swim(){}

    public void setName(String name){
        this.name = name;
        return;
    }

    public String getName(){
        return this.name;
    }

    public void warmth(){}

    public void getMammalDetails(){
        System.out.println(this.eyeColor);
    }

    public void mammalSound(){}
}    
