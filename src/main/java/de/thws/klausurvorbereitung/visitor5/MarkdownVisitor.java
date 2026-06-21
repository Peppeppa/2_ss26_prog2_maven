package de.thws.klausurvorbereitung.visitor5;

public class MarkdownVisitor {

    String result = "";


    public void visit(Bild bild){
       result += "![" + bild.getBeschreibung() + "](" + bild.getDateiname() + ")" + "\n\n";
    }
    public void visit(TextAbschnitt textAbschnitt){

        result += textAbschnitt.getText()+ "\n\n";
    }
    public void visit(Kapitel kapitel){
        result += "# " + kapitel.getTitel()+ "\n\n";
    }
    public String getResult(){
        return result;
    }
}
