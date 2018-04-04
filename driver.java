import getsentiment.*;

class Main {

  public static void main(String [] args) {
    System.out.println("Hello World");

    Document d = new Document(4, "en", "tomatoes");

    System.out.println("This document is in" + d.languange);

  }
}
