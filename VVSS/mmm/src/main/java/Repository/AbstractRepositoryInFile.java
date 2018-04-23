package Repository;

import Domain.HasID;
import ValidatorsAndExceptions.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class AbstractRepositoryInFile<E extends HasID<ID>,ID> extends AbstractRepository<E,ID>
{
    private String fileName;

    public AbstractRepositoryInFile(String filename, Validator<E>validator)
    {
        super(validator);
        this.fileName=filename;
        loading();
    }

    public abstract void createInstance(String line);

    public abstract void writeInstace(BufferedWriter writer, E instance);

    private void loading()
    {
        Path path= Paths.get(fileName);
        Stream<String> lines;
        try
        {
            lines= Files.lines(path);
            lines.forEach(instance->createInstance(instance));
        }catch (Exception e)
        {
            throw  new RepositoryException("Can't load data from file\n");
        }
    }

    private void writeToFile()
    {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName)))
        {
            for(E instance:getAll())
            {
                System.out.println(fileName);
                writeInstace(writer,instance);
            }
        } catch (Exception e)
        {
            throw  new RepositoryException("Can't write to file\n");
        }
    }

    @Override
    public void add(E entity)
    {
        super.add(entity);
        writeToFile();
    }

    @Override
    public E delete(ID id)
    {
        E old=super.delete(id);
        writeToFile();
        return old;
    }

    @Override
    public void update(E entity)
    {
        super.update(entity);
        writeToFile();
    }

    public void setFileName(String fileName){
        this.fileName=fileName;
    }
}
