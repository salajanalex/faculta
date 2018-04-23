package Repository;

import Domain.Tema;
import ValidatorsAndExceptions.Validator;

import java.io.*;

public class TemaRepositoryInFile extends AbstractRepositoryInFile<Tema,Integer>
{
    private String fileName;
    public TemaRepositoryInFile(String fileName, Validator<Tema> validator)
    {
        super(fileName,validator);
    }

    @Override
    public void createInstance(String linie) {
        String[] atribute=linie.split("[|]");
//        if(atribute.length!=3)
//        {
//            System.err.println("Linie invalida"+linie);
//            return;
//        }

        if(atribute.length!=3)
        {
            throw  new RepositoryException("Input line does not match!");
        }
        try
        {

            int id=Integer.parseInt(atribute[0]);
            int deadline=Integer.parseInt(atribute[2]);
            String descriere=atribute[1];
            Tema tema=new Tema(id,descriere,deadline);
            super.add(tema);
        }
        catch (NumberFormatException numberException)
        {
            throw  new RepositoryException("Create instance Error!");
        }
    }

    @Override
    public void writeInstace(BufferedWriter writer, Tema tema) {

        try
        {
            writer.write("" + tema.getID() + '|' + tema.getDescriere() + '|' + tema.getDeadline() + '\n');
        }catch (Exception e)
        {
            //System.err.println("Can not write to file\n");
            throw  new RepositoryException("WriteInstance Error!");
        }
    }




}
