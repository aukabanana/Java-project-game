class Arch extends User {
    public Arch(String name) {
        super(name, 190, 16, 8, 20);
    }

    @Override
    public void attack(Characters target) {
        try {
            System.out.println(Color.BLUE + name + ": execute a custom command..");
            Thread.sleep(400);
            System.out.println("Optimizing attack pipeline...");
            Thread.sleep(400);

            int dmg = attack + rand.nextInt(7) - 3;

            target.takeDmg(dmg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useSkill(Characters target) {
        try {
            if (mana >= 10) {
                System.out.println(Color.BLUE + name + ": Applying system optimization..");
                Thread.sleep(400);
                System.out.println("Recompiling kernel flags...");
                Thread.sleep(400);

                int dmg = (attack * 2) + rand.nextInt(5);

                target.takeDmg(dmg);
                mana -= 10;
            } else {
                System.out.println("Not enough sanity!, Take more inhaler");
                Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
