class Sanity {
    protected final int HEAL = 15;
    protected final int MANA = 10;

    public void useHeal(User user) {
        try {
            user.hp += HEAL;
            System.out.println(Color.GREEN + user.name + ": Restarting system service..");
            Thread.sleep(400);
            System.out.println("System stabilized (+" + HEAL + ")" + Color.RESET);
            Thread.sleep(400);
            Thread.sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useMana(User user) {
        try {
            user.mana += MANA;
            System.out.println(Color.CYAN + user.name + ": sudo privileges refreshed..");
            Thread.sleep(400);
            System.out.println("sanity restored (+" + MANA + ")" + Color.RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}