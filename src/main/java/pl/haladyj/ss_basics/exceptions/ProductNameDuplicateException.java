package pl.haladyj.ss_basics.exceptions;

public class ProductNameDuplicateException extends RuntimeException {

    public ProductNameDuplicateException(String message){
        super(message);
    }
}
