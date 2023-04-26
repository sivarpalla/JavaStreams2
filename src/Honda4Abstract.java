abstract class Bike{
    abstract void run();
}
public class Honda4Abstract extends Bike{
    void run(){System.out.println("running safely");}
    public static void main(String args[]){
        Bike obj = new Honda4Abstract();
        obj.run();
    }
}
