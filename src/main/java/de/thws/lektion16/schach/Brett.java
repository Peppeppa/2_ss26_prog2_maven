package de.thws.lektion16.schach;

public class Brett
{
  boolean[][] brett = new boolean[8][8];
  
  public Brett()
  {
    
  }
  
  public void markiereFeld(int x, int y)
  {
    brett[x-1][y-1] = true;
  }
  
  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }

  public Brett kombiniere(Brett brett2){
      Brett result = new Brett();
      for (int i = 0; i < result.brett.length; i++){
          for (int j = 0; j < result.brett[i].length;j++){

              result.brett[i][j] = false;

              if(this.brett[i][j]==true){
                  result.brett[i][j]=true;
              }
              if(brett2.brett[i][j]==true){
                  result.brett[i][j]=true;
              }
          }
      }
      return result;
  }
}
