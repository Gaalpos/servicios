package Septiembre;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

class ProcessBuilderDemo {

  public static void main(String[] arg) throws IOException {
    // creating list of process
    List<String> list = new ArrayList<String>();
    list.add("notepad.exe");

    // create the process
    ProcessBuilder build = new ProcessBuilder(list);

    // checking the command i list
    System.out.println("command: " + build.command());
  }
}
