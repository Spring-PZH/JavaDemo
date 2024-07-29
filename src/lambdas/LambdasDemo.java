package lambdas;

import java.util.function.UnaryOperator;

public class LambdasDemo {

  public LambdasDemo(String message) {
  }

  public static void show() {
    //Lambda表达式返回的是一个实现了接口的一个匿名类的一个实例
    //接口存在的意义就是进行一定的限制但是不完全限制，就比如接口的signature不能更改而里面的具体实现就因人而异
    ConsolePrinter cp = new ConsolePrinter();
    cp.print("COUPLED MESSAGE");
    greet(cp);
    greet(new ConsolePrinter());
    Printer test0 = String::length;
    Printer test1 = System.out::println;
    Printer test = s -> System.out.println(s.length());
    greet(message1 -> new LambdasDemo(message1));
    greet(LambdasDemo::new);

    greet( s-> System.out.println(s));
    greet(new Printer() {
      @Override
      public void print(String message) {

      }
    });
    greet(message -> {});

    Printer action = message -> System.out.println(message);
    action.print("123r");

    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var result = increment.andThen(square).apply(1);
    System.out.println(result);
  }

  public static void greet(Printer pinter) {
    pinter.print("Hello, ");
  }
}
