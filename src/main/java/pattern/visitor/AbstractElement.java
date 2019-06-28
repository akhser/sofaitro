package pattern.visitor;

public abstract class AbstractElement {
    abstract void accept(Visitor visitor);
}
