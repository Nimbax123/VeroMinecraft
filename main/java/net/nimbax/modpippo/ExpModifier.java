package net.nimbax.modpippo;

public class ExpModifier extends ModPippo{
    //if custom current == max -> lv++

    public static int[] getaddExperience() {
        int[] xpPerLevel = new int[51];
        float tempMaxPerLevel =100;

        for (int lvl = 0; lvl <= 50; lvl++){
            xpPerLevel[lvl] = (int) tempMaxPerLevel; //salvare l'exp
            tempMaxPerLevel *= 1.2;
        }
        return xpPerLevel;
    }


}
