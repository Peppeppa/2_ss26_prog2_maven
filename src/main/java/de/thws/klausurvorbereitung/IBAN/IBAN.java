package de.thws.klausurvorbereitung.IBAN;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IBAN {





    public boolean checkiban(String iban){
       if ( iban.length() != 22){
           throw new FalscheIBANException("IBAN muss 22 Zeichen lang sein" + iban);
       }
       if (iban == null){
           throw new FalscheIBANException("IBAN darf nicht null sein" + iban);
       }
       if (!iban.startsWith("DE")){
           throw new FalscheIBANException("ungültiger Ländercode" + iban);
       }
      return true;
    }
    public List<String> liesIbanAusDatei(String pfad){
        List<String> result = new ArrayList<>();
        List<String> zwischen = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pfad)))){

            String line;
            while ((line = br.readLine()) != null){
                zwischen.add(line);
            }
            for (String iban : zwischen){
                try{
                    checkiban(iban);
                }catch (FalscheIBANException e){
                    result.add(iban);
                }
            }
        }catch( IOException e){
            e.printStackTrace();
        }
        return result;

    }
    public Map<String, List<String>> liesIbanAusDateien(String pfad){
return null;
    }
}
