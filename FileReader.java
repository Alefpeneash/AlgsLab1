import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class FileReader{
  public static ArrayList<String> read(String path){
    try{
        ArrayList<String> words = new ArrayList<String>();
       FileInputStream fstream = new FileInputStream(path);
       BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
       String line;
       while ((line = br.readLine()) != null){
         for (String retval : line.split(" ")) {
           words.add(retval);
         }
       }
       return words;
    }catch (IOException e){
       System.out.println("Error");
    }
    return null;
  }
}
