package UI;

import Domain.Nota;
import Domain.Student;
import Domain.Tema;
import Repository.IRepository;
import ValidatorsAndExceptions.Validator;
import ValidatorsAndExceptions.ValidatorStudent;
import ValidatorsAndExceptions.ValidatorTema;
import javafx.util.Pair;

/**
 * Created by camelia on 2/26/2018.
 */
public class StartApplic {
    public static void main(String[] args) {
        Validator<Student> validatorStudent = new ValidatorStudent();
        IRepository<Student, Integer> repoStudent = new Repository.StudentRepositoryInFile("C:\\Users\\alex.salajan\\faculta.git\\vvss1\\src\\Resources\\Studenti.txt", validatorStudent);
        Validator<Tema> validatorTema = new ValidatorTema();
        IRepository<Tema, Integer> repoTema = new
                Repository.TemaRepositoryInFile("C:\\Users\\alex.salajan\\faculta.git\\vvss1\\src\\Resources\\Teme.txt", validatorTema);
        ValidatorsAndExceptions.Validator<Domain.Nota> validatorNota = new ValidatorsAndExceptions.ValidatorNota();
        IRepository<Nota, Pair<Integer, Integer>> repoNota = new Repository.NotaRepositoryInFile("C:\\Users\\alex.salajan\\faculta.git\\vvss1\\src\\Resources\\Catalog.txt", validatorNota);

    }
}
