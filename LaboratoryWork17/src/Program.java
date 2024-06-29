import java.io.*;
import java.util.*;

class Equation implements Serializable{
    public double x;
    public double y;

    public Equation(double x) {
        this.x = x;
        y = x - Math.sin(x);
    }
}

class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print(
                    "y = x - sin(x)" + "\n" +
                    "Введите x: ");

            String str = input.nextLine();
            if(str == "")
                return;

            double x = Double.parseDouble(str);

            Equation eq = new Equation(x);

            while(true){
                System.out.print("Команда: ");
                str = input.nextLine();

                if(str.equals("save"))
                    saveResult(eq);
                else if(str.equals("upload")){
                    uploadResult();
                    break;
                }
                else if(str == "")
                    break;
            }

            System.out.print("\n\n");
        }
    }

    static void saveResult(Equation eq){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Result.txt"))){
            oos.writeObject(eq);
            System.out.println("Объект сохранён");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static void uploadResult(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Result.txt"))){
            Equation eq = (Equation) ois.readObject();
            System.out.printf(
                    "x = %f\n" +
                    "y = %f",
                    eq.x, eq.y);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
