import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        File addresses = new File("C:\\Users\\Evgeniy\\IdeaProjects\\LaboratoryWork15\\addresses.txt");
        addresses.createNewFile();

        Pattern p = Pattern.compile(
                "\\b(((\\d\\d?)|1\\d\\d|2([0-4]\\d|5[0-5]))\\.){3}(1\\d\\d|2([0-4]\\d|5[0-5])|(\\d\\d?))\\b");

        FileWriter fileWriter = new FileWriter(addresses, true);

        try{
            for(;;){
                System.out.print("Введите адрес: ");
                String ip = input.nextLine();

                if(ip == "")
                    break;

                Matcher m = p.matcher(ip);

                if(m.find())
                {
                    String address = m.group(0).replace(" ", "");
                    fileWriter.write(address + " - Адрес действителен\n");
                    System.out.printf(" - Адрес %s действителен\n", address);
                }else
                {
                    fileWriter.write("Адрес не действителен или не найден (" + ip + ")" + "\n");
                    System.out.println("Адрес не действителен или не найден");
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try{
                fileWriter.close();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
