package Classes;
import combat_usage.*;

/**
 * Created by Parzival on 4/19/2016.
 */
public class Fighter extends Face_Hitter implements Base_Stat{

    @Override
    public void set_stat() {
        strength = rng.rng_maker(16, 6);
        dex = rng.rng_maker(14, 6);
        con = rng.rng_maker(14, 8);
        wisdom = rng.rng_maker(18, 6);
        charm = rng.rng_maker(16,6);
        intel = rng.rng_maker(20,10);
    }

    @Override
    public int get_dmg(String weapon) {return rng.rng_maker(1,12)+strength;}

    @Override
    public int get_dodge() {
        return 17;
    }

    @Override
    public int get_gud() {
        return 0;
    }

    public int get_hit() {return rng.rng_maker(1,20) + strength;}
}
