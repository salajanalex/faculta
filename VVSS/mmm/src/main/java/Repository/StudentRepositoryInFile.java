package Repository;

import Domain.Student;
import ValidatorsAndExceptions.Validator;

import java.io.*;

public class StudentRepositoryInFile extends AbstractRepositoryInFile<Student,Integer>{

    private String fileName;
    public StudentRepositoryInFile(String fileName, Validator<Student> validator)
    {
        super(fileName,validator);
    }

    @Override
    public void createInstance(String linie)
    {
            String[] atribute=linie.split("[|]");
            if(atribute.length!=5)
            {
                throw  new RepositoryException("Input line does not match!");
            }
            try
            {
                int id=Integer.parseInt(atribute[0]);
                int grupa=Integer.parseInt(atribute[2]);
                String nume=atribute[1];
                String email=atribute[3];
                String cadru=atribute[4];
                Student student=new Student(id,nume,grupa,email,cadru);
                super.add(student);
                //super.dictionar.put(id,student);

            }
            catch(NumberFormatException numberException)
            {
                throw  new RepositoryException("Create instance Error!");
            }
    }

    public void writeInstace(BufferedWriter writer, Student student) {
        try {
            writer.write("" + student.getID() + '|' + student.getNume() + '|' + student.getGrupa() + '|' + student.getEmail() + '|' + student.getCadruDidactic() + '\n');
        } catch (Exception e) {
            throw  new RepositoryException("WriteInstance Error!");
        }
    }
}
