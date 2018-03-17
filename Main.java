import java.io.*;
import java.util.ArrayList;


class Main{
  public static void main(String[] args) {
    ArrayList<String> words = FileReader.read("test.txt");
    Hash hash = new Hash(1024);

    int wc = 0;
    int hc = 0;
    for (String w : words){
      switch(hash.add(w)){
        case -1:
          System.out.println("the word \"" + w + "\" failed to add: the hash table overflowed");
          break;
        case -2:
          System.out.println("the word \"" + w + "\" failed to add: the word is less than 3 letters");
          break;
      }
      wc++;
    }

    String hashArr[] = hash.get();

    for (int i = 0; i < 1024; i++) {
      System.out.println(hashArr[i]);
      if(hashArr[i] != null)
        hc++;
    }

    System.out.println(wc);
    System.out.println(hc);

    System.out.println(hash.find("whom"));
  }
}
