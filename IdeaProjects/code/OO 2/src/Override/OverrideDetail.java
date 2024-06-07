package Override;

public class OverrideDetail {
}

class A {
    public Object m1(String a) {
        return null;
    }

    void m2() {

    }
}

class B extends A{
    //The return type of subclass is the same as or a subclass of the return type of the parent class.
    public String m1(String b) {
        return null;
    }

    //The modifier of the subclass is either the same as the parent class
    //or be larger in scope than the modifier of the parent class.
    public void m2() {

    }
}
