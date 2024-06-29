import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<String> users = new ArrayList();
        users.add("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Authorization\\AuthorizedUsers\\users\\user1.txt");
        users.add("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Authorization\\AuthorizedUsers\\users\\user2.txt");

        List<String> admins = new ArrayList();
        admins.add("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Authorization\\AuthorizedUsers\\admins\\admin1.txt");

        String login = "admin1Login";
        String password = "admin1Password";

        boolean isAuthorized = true;

        for(var user : users){
            try {
                File file = new File(user);

                FileReader fr = new FileReader(file);

                BufferedReader reader = new BufferedReader(fr);

                String line = reader.readLine();
                if(line != null){
                    if(line.equals(login)){
                        isAuthorized = true;
                        System.out.println(line + " - LOGIN TRUE");
                    }
                    else{
                        isAuthorized = false;
                        continue;
                    }
                }

                line = reader.readLine();
                if(line != null){
                    if(line.equals(password) & isAuthorized){
                        System.out.println(line + " - PASSWORD TRUE");
                        break;
                    }
                    else {
                        isAuthorized = false;
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(var admin : admins){
            try {
                File file = new File(admin);

                FileReader fr = new FileReader(file);

                BufferedReader reader = new BufferedReader(fr);

                String line = reader.readLine();
                if(line != null){
                    if(line.equals(login)){
                        isAuthorized = true;
                        System.out.println(line + " - LOGIN TRUE");
                    }
                    else{
                        isAuthorized = false;
                        continue;
                    }
                }

                line = reader.readLine();
                if(line != null){
                    if(line.equals(password) & isAuthorized){
                        System.out.println(line + " - PASSWORD TRUE");
                        break;
                    }
                    else {
                        isAuthorized = false;
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(isAuthorized) System.out.println("ВОШЁЛ");
    }
}
