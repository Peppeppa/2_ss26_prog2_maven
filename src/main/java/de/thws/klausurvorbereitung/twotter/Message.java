package de.thws.klausurvorbereitung.twotter;

import java.time.LocalDate;
public class Message
{
    private final String text;
    private final String creationDate;

    public Message(String text)
    {
        if (text.length()<=140){
            this.text = text;
        }else{
            throw new IllegalArgumentException("nono text zu lang no");
        }
        creationDate = LocalDate.now().toString();
    }
    public String getText()
    {
        return text;
    }
    public String getCreationDate()
    {
        return creationDate;
    }

    @Override
    public String toString()
    {
        return text;
    }
}