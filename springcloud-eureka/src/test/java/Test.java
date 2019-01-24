import java.lang.reflect.Type;


public class Test {

    public static void main(String[] args) {
        String name = Test.class.getName();
        String typeName = Test.class.getTypeName();
        Class clazz = Test.class;
        System.out.println("name:" + name);
        System.out.println("typeName:" + typeName);
        System.out.println("clazz:" + clazz);
        Type superType = Test.class.getGenericSuperclass();
        System.out.println("superType:" + superType);
        boolean result = clazz.isAssignableFrom(Test.class);
        System.out.println("boolean result:" + result);
        Class<Round> roundClass = Round.class;
        Class<? super Round> superClass = roundClass.getSuperclass();
        System.out.println("superClass is :" + superClass);
    }

    class Round extends Test {

    }
}
