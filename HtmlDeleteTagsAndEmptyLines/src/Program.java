import java.io.*;
import java.util.regex.*;

public class Program {
    public static void main(String[] args) {
        try{
            BufferedReader bf = new BufferedReader(new FileReader("text.txt"));

            String line = bf.readLine();
            
            String data = line;

            while(line != null){
                data += line + "\n";
                line = bf.readLine();
            }

            data.replaceAll("(<\\w*>\\s*</\\w*>)|(\\n+)", "");

            FileWriter fw = new FileWriter("newText.txt");

            fw.write(data);

            fw.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
