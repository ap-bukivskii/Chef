package ua.training.bukivskii.viev;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {


    public void printMessage(String message) {
        System.out.println(message);
    }

    private Locale locale = new Locale("ua");
    private static String MESSAGES_BUNDLE = "ua\\training\\bukivskii\\Messages";

    private ResourceBundle messagesBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE, locale);



    public String unwrapBundled(String message){ //TODO very wrong!
        for (String key : messagesBundle.keySet()){
            if(message.contains(key)){
                message = message.replaceAll(key,messagesBundle.getString(key));
            }
        }
        return message;
    }


//    public String unwrapBundled(String message){
//        try{
//            return messagesBundle.getString(message);
//        }catch (MissingResourceException e){
//            return message;
//        }
//    }

//    public void printConcatedMessage(String... message){
//        printMessage(concatString(message));
//    }


//    public String concatString(String... message){
//        StringBuilder concatString = new StringBuilder();
//        for (String v : message){
//            concatString = concatString.append(unwrapBundled(v));
//        }
//        return new String(concatString);
//    }

}
