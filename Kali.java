class Kali extends User {
    public Kali(String name) {
        super(name, 100, 20, 2, 30);
    }

    @Override
    public void attack(Characters target) {
        try {
            System.out.println(name + ": Launching basic exploit..");
            Thread.sleep(400);
            System.out.println("Scanning vulnerability...");
            Thread.sleep(400);

            int dmg = attack + rand.nextInt(11) - 5;

            target.takeDmg(dmg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useSkill(Characters target) {
        try {
            if (mana >= 15) {
                System.out.println(name + ": Deploying adv. exploit toolkit..");
                Thread.sleep(400);
                System.out.println("Privilage escalation success...");
                Thread.sleep(400);

                int dmg = (attack * 3) + rand.nextInt(5);

                target.takeDmg(dmg);
                mana -= 15;
            } else {
                System.out.println("Not enough sanity!, Take more inhaler");
                Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
