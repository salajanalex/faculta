package ro.salajan;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //   UserServiceImplementation imp = new UserServiceImplementation();
//        try{
//        System.out.println(imp.getAllUsers().toString());
//    }catch (Exception e){
//        System.out.println("error found! error: " + e );
//    }
    }
}

