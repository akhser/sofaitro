package pattern.visitor;

public class VisitorMain {
    public static void main(String ...args) {
        Visitor v1 = new VisitorImp1();
        Visitor v2 = new VisitorImp2();

        AbstractElement a1 = new ElementImp1();
        a1.accept(v1);
        a1.accept(v2);

        AbstractElement a2 = new ElementImp2();
        a2.accept(v2);


    }
}
