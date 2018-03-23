package repository;

import connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class InscriereRepo {

    /**
     * Connection & ArrayList
     */
    private ArrayList<Inscriere> inscrieriRepo = new ArrayList<Inscriere>();
    private static DBConnection connection = new DBConnection();
    static Connection con = connection.getConnection();

    /**
     * close connection
     */
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            {
                System.out.println(e);
            }
        }
    }

    /**
     * Setting Inscrieri from DB in Repo (DB -> Repo)
     */
    public void setInscrieriRepo(){
        try{
            ArrayList<Inscriere> newInscrieriRepo = new ArrayList<Inscriere>();
            String query = "Select * from inscriere";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Inscriere inscriere = new Inscriere(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3),resultSet.getString(4));
                newInscrieriRepo.add(inscriere);
            }
            inscrieriRepo = newInscrieriRepo;

        }catch (Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Get all inscrieri from repo
     * @return
     */
    public ArrayList<Inscriere> getInscrieriRepo(){
        return this.inscrieriRepo;
    }

    /**
     * add new Inscriere to DB & Update Repo
     * @param
     */
    public void addInscriere(Inscriere inscriere){
        try {
            String query = "insert into inscriere (capacitate, nume, echipa)" + " values (?, ?, ?)";
            PreparedStatement prpStmt = con.prepareStatement(query);
            prpStmt.setInt(1, inscriere.getCapacitate());
            prpStmt.setString(2, inscriere.getNume());
            prpStmt.setString(3, inscriere.getEchipa());
            prpStmt.execute();

            setInscrieriRepo();

        }catch (Exception e){
            System.out.println("There hase been an exception!");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete inscriere from DB & update Repo
     * @param inscriere
     */
    public void deleteInscriere(Inscriere inscriere) {
        try {
            String query = " DELETE FROM inscriere WHERE nume = ? and echipa = ?";
            PreparedStatement prpstmt = con.prepareStatement(query);
            prpstmt.setString(1, inscriere.getNume());
            prpstmt.setString(2, inscriere.getEchipa());
            prpstmt.execute();
            setInscrieriRepo();

        } catch (Exception e) {
            System.out.println("Exception occured!");
            System.out.println(e.getMessage());
        }
    }


}
