package de.thws.lektion16.muenzautomat;

public class OptimalerChangeCalculator implements ChangeCalculator{
    @Override
    public int[] getChange(int euros, int cent){
        int[] result = new int[8];
        int betrag = euros * 100 + cent;
        Coin[] coins = Coin.values();
        for (int i = coins.length - 1; i >= 0; i--){
            result[i]= betrag / coins[i].value;
            betrag=betrag % coins[i].value;
        }

        return result;
    }
}
