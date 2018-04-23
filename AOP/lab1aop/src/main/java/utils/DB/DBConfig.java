package utils.DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DBConfig {

    private String dbDriver;
    private String dbUrl;
    private String dbUser;
    private String dbPass;
//    String[] a;

    public DBConfig(){
        this.dbDriver="";
        this.dbUrl="";
        this.dbUser="";
        this.dbPass="";
    }

    public String getDbDriver(){
        return this.dbDriver;
    }

    public void setDbDriver(String driver){
        this.dbDriver=driver;
    }

    public String getDbUrl(){
        return this.dbUrl;
    }

    public void setDbUrl(String url){
        this.dbUrl = url;
    }

    public String getDbUser(){
        return this.dbUser;
    }

    public void setDbUser(String user){
        this.dbUser = user;
    }

    public String getDbPass(){
        return this.dbPass;
    }

    public void setDbPass(String pass){
        this.dbPass=pass;
    }




    public void setConfiguration(String filename) {
        String[] a;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                a = sCurrentLine.split("=");

                if (a[0].equals("tasks.jdbc.driver")) {
                    setDbDriver(a[1]);
                } else if (a[0].equals("tasks.jdbc.url")) {
                    setDbUrl(a[1]);
                } else if (a[0].equals("tasks.jdbc.user")) {
                    setDbUser(a[1]);
                } else if (a.length == 1) {
                    setDbPass("");
                } else if (a[0].equals("tasks.jdbc.pass")) {
                    setDbPass(a[1]);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
