package BattleOfAges.TurretTypes;


public class Turret{

    private int attack = 2;
    private int range = 4;
    private int cost = 800;

    public Turret(int bonus) {
        this.attack = 2 + bonus;
        this.cost = 800 + (int)Math.pow(200,bonus);
    }

    public int getAttack() {
        return attack;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }


}
