package de.thws.lektion20.SMS;

public class IllegalTelephoneNumberException extends Exception {
    public IllegalTelephoneNumberException(char invalidChar) {
        super("Ungueltiges Zeichen: " + invalidChar);
    }
}
