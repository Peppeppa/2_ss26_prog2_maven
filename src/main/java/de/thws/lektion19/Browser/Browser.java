package de.thws.lektion19.Browser;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser
{
    public URL back()
    {
        try
        {
            //simulate: fetch last URL from Stack
            return Math.random() < 0.5 ? new URL("http://google.de") : null;
        }
        catch(MalformedURLException e)
        {
            return null;
        }
    }

    public String retrieveSite(URL url)
    {
        //simulate download site:
        return url.toString();
    }
    public static void main(String[] args)
    {
        System.out.println("Normal back");
        Browser browser = new Browser();
        URL back = browser.back();
        if (back != null) browser.retrieveSite(back);
    }
}