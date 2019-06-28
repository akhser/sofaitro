package pattern.visitor;

public class VisitorImp2 implements Visitor {
    @Override
    public void method1() {
        System.out.println("VisitorImp2 nothing");
    }

    @Override
    public void method2() {
        System.out.println("VisitorImp2 method2");
    }
}
