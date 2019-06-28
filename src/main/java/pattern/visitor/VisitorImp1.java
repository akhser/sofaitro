package pattern.visitor;

public class VisitorImp1 implements Visitor {
    @Override
    public void method1() {
        System.out.println("VisitorImp1 method1");
    }

    @Override
    public void method2() {
        System.out.println("VisitorImp1 nothing");
    }
}
