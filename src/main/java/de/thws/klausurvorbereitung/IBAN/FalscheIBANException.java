package de.thws.klausurvorbereitung.IBAN;

public class FalscheIBANException extends RuntimeException {
    public FalscheIBANException(){
        super();
};
    public FalscheIBANException(String message) {
        super(message);
    }
}
