abstract class User extends Characters {
    protected int mana;

    public User(String name, int hp, int attack, int defense, int mana) {
        super(name, hp, attack, defense);
        this.mana = mana;
    }

    public abstract void useSkill(Characters target);
}
