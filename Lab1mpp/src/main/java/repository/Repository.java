package repository;

import connection.DBConfig;
import model.Inscriere;

import java.sql.*;
import java.util.ArrayList;

public class Repository {

    private DBConfig dbc = new DBConfig();

   // dbc.setConnection("bd.config");  //se configureaza dbconfing pt orice baza de date.


    /**
     * Getters Setter ADD for repo.
     */

    private ArrayList<Inscriere> inscrieriRepo = new ArrayList<Inscriere>();

    public Repository(ArrayList<Inscriere> inscrieri) throws ClassNotFoundException, SQLException {
        this.inscrieriRepo = inscrieri;
    }

    public ArrayList<Inscriere> getInscrieriRepo() {
        return this.inscrieriRepo;
    }

    public void setInscrieriRepo(ArrayList<Inscriere> inscrieriRepo) {
        this.inscrieriRepo = inscrieriRepo;
    }

    public void addInscriere(Inscriere inscriere){
        inscrieriRepo.add(inscriere);
    }



//
//        try{
//        Class.forName(dbConnectionon.getDbDriver());
//        Connection con= DriverManager.getConnection(
//                dbConnectionon.getDbUrl(),dbConnectionon.getDbUser(),dbConnectionon.getDbPass());
//        Statement stmt=con.createStatement();
//        ResultSet rs=stmt.executeQuery("select * from inscriere");
//        while(rs.next())
//            System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//        con.close();
//    }catch(Exception e){ System.out.println(e);}
//}
}
