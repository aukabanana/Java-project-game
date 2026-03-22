import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Scanner sc = new Scanner(System.in);
            // ! Greeting Section
            System.out.println("=======================================");
            Thread.sleep(500);

            String[] greet = { "`Welcome,", " You ", "are", " the ", "chosen", " one !!`" };
            for (String gt : greet) {
                System.out.print(gt);
                Thread.sleep(400);
            }
            System.out.println();
            Thread.sleep(500);

            System.out.println("=======================================");
            Thread.sleep(500);

            // ! Enter Name
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            Thread.sleep(500);

            // ! Select Role
            String[] roleSelect = {
                    "---------------------------------------",
                    "Choose role:",
                    "1: Warrior",
                    "2: Mage",
                    "---------------------------------------",
                    "`Choose role by typing or enter number`"
            };

            for (String rs : roleSelect) {
                System.out.println(rs);
                Thread.sleep(400);
            }

            System.out.print("Role: ");
            String role = sc.next().toLowerCase();

            Player player = null;

            switch (role) {
                case "warrior":
                case "1":
                    player = new Warrior(name);
                    role = "Warrior";
                    break;
                case "mage":
                case "2":
                    player = new Mage(name);
                    role = "mage";
                    break;
                default:
                    System.out.println("`Wrong input boo ~, Try again`");
            }

            String[] lastCall = { "`Alright ", name, " now you are ", role, "`" };
            for (String lc : lastCall) {
                System.out.print(lc);
                Thread.sleep(300);
            }
            System.out.println();
            System.out.println("---------------------------------------");

            System.out.println("Loading");
            Thread.sleep(500);
            System.out.println("Loading.");
            Thread.sleep(700);
            System.out.println("Loading..");
            Thread.sleep(900);
            System.out.println("Loading...");
            Thread.sleep(1100);
            System.out.println("Loading Comp...");
            Thread.sleep(1000);
            System.out.println("Oop! have something wrong...");
            Thread.sleep(1500);
            System.out.println("Can't enter to the game !");
            Thread.sleep(1500);
            System.out.println("The Monster have approaching to you");
            Thread.sleep(1500);
            System.out.println("Deal with it quickly to out of this console");
            Thread.sleep(2000);

            // ! Create Monster and Potion
            Monster monster = new Monster("Goblin", 200, 10, 2);
            Potion potion = new Potion();

            // ! Action
            while (player.isAlive() && monster.isAlive()) {
                System.out.println("=======================================");
                System.out.println(name + " Info:");
                System.out.println("HP: " + player.hp);
                System.out.println("mana: " + player.mana);
                Thread.sleep(1000);

                System.out.println("---------------------------------------");
                System.out.println("Monster Info:");
                System.out.println("HP: " + monster.hp);
                Thread.sleep(400);

                System.out.println("---------------------------------------");
                System.out.println("Choose action");
                System.out.println("1) Attack");
                System.out.println("2) Skill");
                System.out.println("3) Heal potion");
                System.out.println("4) Mana potion");
                int action = sc.nextInt();

                if (action == 1) {
                    player.attack(monster);
                } else if (action == 2) {
                    player.useSkill(monster);
                } else if (action == 3) {
                    potion.useHeal(player);
                } else if (action == 4) {
                    potion.useMana(player);
                } else {
                    System.out.println("Invalid action !");
                    continue;
                }

                if (monster.isAlive()) {
                    monster.attack(player);
                }

            }
            Thread.sleep(1000);
            System.out.println("=======================================");
            Thread.sleep(500);
            if (player.isAlive()) {
                System.out.println("Complete, You Win !");
                Thread.sleep(500);
            } else {
                System.out.println("GAME OVER");
                Thread.sleep(500);
            }
            System.out.println("=======================================");

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

abstract class Characters {
    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;

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

        if (reduced < 0)
            reduced = 0;
        hp -= reduced;

        try {
            System.out.println(name + " took " + reduced + " damage!");
            Thread.sleep(400);
            // System.out.println("HP: " + hp + " units");
            // Thread.sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public abstract void attack(Characters target);

}

abstract class Player extends Characters {
    protected int mana;

    public Player(String name, int hp, int attack, int defense, int mana) {
        super(name, hp, attack, defense);
        this.mana = mana;
    }

    public abstract void useSkill(Characters target);
}

class Warrior extends Player {
    public Warrior(String name) {
        super(name, 200, 16, 5, 20);
    }

    @Override
    public void attack(Characters target) {
        try {
            System.out.println(name + " slashes!");
            Thread.sleep(400);
            target.takeDmg(attack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useSkill(Characters target) {
        try {
            if (mana >= 10) {
                System.out.println(name + " use Heavy Strike!");
                Thread.sleep(400);
                target.takeDmg(attack * 2);
                mana -= 10;
            } else {
                System.out.println("Not enough mana!");
                Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Mage extends Player {
    public Mage(String name) {
        super(name, 120, 20, 2, 30);
    }

    @Override
    public void attack(Characters target) {
        try {
            System.out.println(name + " fire ball !");
            Thread.sleep(400);
            target.takeDmg(attack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useSkill(Characters target) {
        try {
            if (mana >= 15) {
                System.out.println(name + " use Meteorite Strike !");
                Thread.sleep(400);
                target.takeDmg(attack * 3);
                mana -= 15;
            } else {
                System.out.println("Not enough mana!");
                Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Monster extends Characters {
    public Monster(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    @Override
    public void attack(Characters target) {
        try {
            System.out.println(name + " attack !");
            Thread.sleep(400);
            target.takeDmg(attack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Potion {
    int heal = 30;
    int mana = 20;

    public void useHeal(Player player) {
        try {
            player.hp += heal;
            System.out.println(player.name + " healed " + heal + " units!");
            Thread.sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useMana(Player player) {
        try {
            player.mana += mana;
            System.out.println(player.mana + " + mana " + mana + " units");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}