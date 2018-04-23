import Domain.Student;
import Domain.Tema;
import Repository.IRepository;
import Repository.StudentRepositoryInFile;
import Repository.TemaRepositoryInFile;
import ValidatorsAndExceptions.Validator;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;

/**
 * Created by camelia on 2/26/2018.
 */
public class StartApplic {
    public static void main(String[] args) {
        Validator<Student> validatorStudent = new ValidatorStudent();
        IRepository<Student, Integer> repoStudent = new
                StudentRepositoryInFile("C:\\Users\\alex.salajan\\faculta.git\\vvss1\\src\\Resources\\Studenti.txt", validatorStudent);
        Validator<Tema> validatorTema = new ValidatorTema();
        IRepository<Tema, Integer> repoTema = new
                TemaRepositoryInFile("C:\\Users\\alex.salajan\\faculta.git\\vvss1\\src\\Resources\\Teme.txt", validatorTema);
//        Validator<Nota> validatorNota = new ValidatorsAndExceptions.ValidatorNota();
//        IRepository<Nota, Pair<Integer, Integer>> repoNota = new
//                NotaRepositoryInFile("Catalog.txt", validatorNota);

    }
}
