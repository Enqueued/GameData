package combat_usage;

import java.util.Random;

/**
 * Created by main on 4/20/16.
 */
public class rng {
    /**
     * This class will be used to return a random number
     * this will be used for combat situations:
     * spell dmg, weapon dmg
     * as well as stats and other rolls.
     * @param max
     * @param min
     * @return
     */
    public static int rng_maker(int max, int min){
        Random rand=new Random();
        /*int n = max - min + 1;
        int k = rand.nextInt() % n;
        return (min+k);*/
        int k = rand.nextInt(max);
        while (k <= min){
            k=rand.nextInt(max);
        }
        return k;
    }
}
