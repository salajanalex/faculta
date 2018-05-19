package Repository;

import Domain.User;
import ValidatorsAndExceptions.Validator;

import java.io.BufferedWriter;
import java.io.IOException;

public class UserRepositoryInFile extends AbstractRepositoryInFile<User,String>{

    private String fileName;
    public UserRepositoryInFile(String fileName, Validator<User> validator)
    {
        super(fileName,validator);
    }

    @Override
    public void createInstance(String linie)
    {
        String[] atribute=linie.split("[|]");
        if(atribute.length!=3)
        {
            throw  new RepositoryException("Input line does not match!");
        }
        try
        {
            String email=atribute[0];
            String password=atribute[1];
            String rol=atribute[2];
            User user=new User(email,password,rol);
            super.add(user);
        }
        catch(Exception ex)
        {
            throw  new RepositoryException("Create instance Error!");
        }
    }

    public void writeInstace(BufferedWriter writer, User user) {
        try {
            writer.write("" + user.getID() + '|' + user.getPassword()+'|'+user.getRol()+'\n');
        } catch (Exception e) {
            throw  new RepositoryException("WriteInstance Error!");
        }
    }
}
