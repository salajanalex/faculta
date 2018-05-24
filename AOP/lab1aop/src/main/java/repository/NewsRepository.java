package repository;

import model.News;
import utils.DB.DBConnection;
import utils.aspects.observer.ChangeState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//public class NewsRepository extends Subject implements Repository{

public class NewsRepository implements Repository{
    private Connection connection;

    /**
     * singleton pattern
     */
    private static NewsRepository instance = new NewsRepository();
    public static NewsRepository getInstance(){
        return instance;
    }

    /**
     * Logger
     */
    //public static final Logger LOGGER = Logger.getLogger(NewsRepository.class.getName());

    /**
     *daca dai new Repo da eroare
     */
    private NewsRepository() {
        DBConnection conn = new DBConnection();
        connection = conn.getConnection();
    }

    @Override
    @ChangeState
    public void addNews(News news) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO News(id, title, content) VALUES(?, ?, ?)");
            preparedStatement.setInt(1,news.getId());
            preparedStatement.setString(2,news.getTitle());
            preparedStatement.setString(3,news.getContent());
            preparedStatement.executeUpdate();
            //preparedStatement.execute();
        }catch(Exception e){
            System.out.println("Exception has occured");
            System.out.println(e);
        }
//        notifyObservers();
        //pt logger
//        LOGGER.log(Level.WARNING,"News added: {0}", news);
    }


    @Override
    @ChangeState
    public void removeNews(int id) {
        try {
            String query = " DELETE FROM news WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        //notifyObservers();
    }


    @Override
    public List<News> getAllNews() {
        ArrayList<News> newRepo = new ArrayList<>();
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from News");
            while (rs.next()){
                try {
                    News news = new News(rs.getInt(1), rs.getString(2), rs.getString(3));
                    newRepo.add(news);
                }catch (Exception ex){ System.out.println(ex);}
            }
        }catch(Exception e){ System.out.println(e);}
        return newRepo;
    }
}
