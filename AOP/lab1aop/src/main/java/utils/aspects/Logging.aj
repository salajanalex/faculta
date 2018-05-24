package utils.aspects;

import java.util.logging.Level;
import java.util.logging.Logger;

public aspect Logging {

    private static final Logger LOGGER = Logger.getLogger( Logging.class.getName() );


    pointcut repositoryMethodExecuted(): execution(public * Repository.DBRepository.*(..));

    after(): repositoryMethodExecuted() {

        LOGGER.log(Level.WARNING,"Enters method: " + thisJoinPoint.getSignature() +  "\n");

        Object[] arguments = thisJoinPoint.getArgs();
        for (int i = 0; i < arguments.length; i++) {
            Object argument = arguments[i];
            if (argument != null) {
                String msg = "With argument of type " + argument.getClass().toString() + " and value " + argument + "\n";
                LOGGER.log(Level.WARNING, msg);
            }
        }
        LOGGER.log(Level.WARNING,"Exits method: " + thisJoinPoint.getSignature() + "\n");
    }
}
