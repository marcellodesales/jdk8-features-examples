package org.github.marcellodesales.lambda;

public class RunnableLambdas {

  public static void main(String[] args) {

    // jdk7
    new Thread(new Runnable() {
      public void run() {
        System.out.println("Message from inside the thread! - Anonymous Class");
      }
    }).start();

    // jdk8 v.1
    new Thread(() -> { // code block
          System.out.println("Message from inside the thread! - Lambda v.1");
        }).start();

    // jdk8 v.2
    new Thread(() -> System.out.println("Message from inside the thread! - Lambda v.2")).start();
  }

}
