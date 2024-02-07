//https://www.w3schools.com/java/java_methods.asp
//https://www.geeksforgeeks.org/io-bufferedwriter-class-methods-java/
//https://www.educative.io/answers/what-is-the-printstacktrace-method-in-java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class File {
    private static BufferedWriter writer;
    static void openFile(){
        try {
            writer = new BufferedWriter(new FileWriter("usage_data.txt", true));

            // Add date stamp to the first new line
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String dateStamp = dateFormat.format(new Date());
            writer.write(dateStamp);
            writer.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }

//        java.io.File theFile = new java.io.File("usage_data.txt");
  //      theFile.create

    }
    static void writeToFile(String line){
        try{
            writer.write(line);
            writer.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    static void closeFile(){
        try{
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
