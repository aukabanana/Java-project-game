import java.util.Random;

abstract class Characters {
    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;
    protected static final Random rand = new Random();

    public Characters(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDmg(int damage) {
        int reduced = damage - defense;

        if (reduced < 0) {
            reduced = 0;
        }

        hp -= reduced;

        try {
            System.out.println(Color.RED + name + " deleted " + reduced + " files!");
            Thread.sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public abstract void attack(Characters target);

}
