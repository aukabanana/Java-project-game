class Sanity {
    int heal = 30;
    int mana = 20;

    public void useHeal(User user) {
        try {
            user.hp += heal;
            System.out.println(user.name + ": Restarting system service..");
            Thread.sleep(400);
            System.out.println("System stabilized (+" + heal + ")");
            Thread.sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useMana(User user) {
        try {
            user.mana += mana;
            System.out.println(user.name + ": sudo privileges refreshed..");
            Thread.sleep(400);
            System.out.println("sanity restored (+" + mana + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}