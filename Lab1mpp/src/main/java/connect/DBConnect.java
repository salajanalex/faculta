package connect;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBConnect {

    private static final String FILENAME = "bd.config";

    public static void main(String[] args) {

        String dbDriver="";
        String dbUrl="";
        String dbUser="";
        String dbPass="";
        String[] a;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                a = sCurrentLine.split("=");

                if (a[0].equals("tasks.jdbc.driver")) {
                    dbDriver = a[1];
                }
                else if (a[0].equals("tasks.jdbc.url")){
                    dbUrl=a[1];
                }
                else if (a[0].equals("tasks.jdbc.user")){
                    dbUser=a[1];
                }
                else if (a.length==1) {
                    dbPass = "";
                }
                else if (a[0].equals("tasks.jdbc.pass")){
                        dbPass=a[1];
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dbDriver);
        System.out.println(dbUrl);
        System.out.println(dbUser);
        System.out.println(dbPass);

        }


}
