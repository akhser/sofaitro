package pattern.visitor;

public class ElementImp1 extends AbstractElement {
    @Override
    void accept(Visitor visitor) {
        visitor.method1();
        visitor.method2();
    }
}
