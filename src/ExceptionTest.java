import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {

    }
}

class A{
    public Object abc() {
        System.out.println("Inside A");
        return null;
    }
}
class B extends A{
    @Override
    public String abc(){
        System.out.println("Inside B");
        return "";
    }
}

//it will allow to throw unchecked exceptions in child class, but dot allow for checked exceptions.
//If we want the child to throw checked exceptions then parent also need to declair it.
// parent class should throw broader exception.