package pattern.visitor;

public class ElementImp2 extends AbstractElement {

    @Override
    void accept(Visitor visitor) {
        visitor.method2();
        visitor.method1();
    }
}
