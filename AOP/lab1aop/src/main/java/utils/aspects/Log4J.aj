package utils.aspects;

import org.apache.log4j.Logger;


public aspect Log4J {

    private static final Logger LOGGER = Logger.getLogger( Log4J.class );

    pointcut MethodExecuted(): execution(public * *.*(..));

    after(): MethodExecuted() {

        LOGGER.warn("Enters method: " + thisJoinPoint.getSignature() +  "\n");

        Object[] arguments = thisJoinPoint.getArgs();
        for (int i = 0; i < arguments.length; i++) {
            Object argument = arguments[i];
            if (argument != null) {
                String msg = "With argument of type " + argument.getClass().toString() + " and value " + argument + "\n";
                LOGGER.warn(msg);
            }
        }
        LOGGER.warn("Exits method: " + thisJoinPoint.getSignature() + "\n");
    }

}


//pt controller
//public aspect Log4J {
//
//    private static final Logger LOGGER = Logger.getLogger( Log4J.class );
//
//    pointcut controlerMethodExecuted(): execution(public * controller.Controller.*(..));
//
//    after(): controlerMethodExecuted() {
//
//        LOGGER.warn("Enters method: " + thisJoinPoint.getSignature() +  "\n");
//
//        Object[] arguments = thisJoinPoint.getArgs();
//        for (int i = 0; i < arguments.length; i++) {
//            Object argument = arguments[i];
//            if (argument != null) {
//                String msg = "With argument of type " + argument.getClass().toString() + " and value " + argument + "\n";
//                LOGGER.warn(msg);
//            }
//        }
//        LOGGER.warn("Exits method: " + thisJoinPoint.getSignature() + "\n");
//    }
//
//}
