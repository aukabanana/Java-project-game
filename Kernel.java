import java.util.Scanner;

public class Kernel {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // ! Greeting Section
            System.out.println("=================================================");
            Thread.sleep(500);

            String[] greet = { "Terminal: ", "`Welcome,", " to ", "command", " line ", "world", " :D`" };
            for (String gt : greet) {
                System.out.print(gt);
                Thread.sleep(400);
            }
            System.out.println();
            Thread.sleep(500);

            System.out.println("Kernel Core is heart of the all system");
            Thread.sleep(1500);
            System.out.println("One day, something went wrong... ");
            Thread.sleep(1500);
            System.out.println("The system was attacked by malware");
            Thread.sleep(1500);
            System.out.println("It began consuming resources.");
            Thread.sleep(1500);
            System.out.println("causing services to crash once by one");
            Thread.sleep(1500);
            System.out.println();
            System.out.println("Please help us, You are the only");
            Thread.sleep(1500);
            System.out.println("that can handle this situation.");
            Thread.sleep(1500);

            System.out.println("=================================================");
            Thread.sleep(500);

            // ! Enter Name
            System.out.println("Terminal: What should we call you our Hero");
            System.out.print("Anonymous: ");
            String name = sc.next();
            Thread.sleep(500);

            System.out.println("Terminal: Alright " + name + " please choose your OS");
            Thread.sleep(1500);

            // ! Select OS
            String[] OSSelect = {
                    "-------------------------------------------------",
                    "Choose Operator System:",
                    "1: Arch (optimize system)",
                    "2: Kali (exploit , burst damage)",
                    "-------------------------------------------------",
                    "`Choose OS by typing or enter number`"
            };

            for (String rs : OSSelect) {
                System.out.println(rs);
                Thread.sleep(400);
            }

            System.out.print("OS: ");
            String os = sc.next().toLowerCase();

            User user = null;

            switch (os) {
                case "arch":
                case "1":
                    user = new Arch(name);
                    os = "Arch";
                    break;
                case "kali":
                case "2":
                    user = new Kali(name);
                    os = "Kali";
                    break;
                default:
                    System.out.println("`Error typing, Try again...`");
            }

            String[] lastCall = { "Terminal: Initializing...", "setname: " + name, "set OS: " + os };
            for (String lc : lastCall) {
                System.out.println(lc);
                Thread.sleep(1000);
            }
            System.out.println();
            System.out.println("-------------------------------------------------");

            System.out.println("Terminal: Let's deal with that troublemaker !!");
            Thread.sleep(500);
            System.out.println("!--ALERT--!");
            Thread.sleep(700);
            System.out.println("System Alert: High CPU Usage detected...");
            Thread.sleep(1000);
            System.out.println("malware ID <undefine> consuming resources...");
            Thread.sleep(1000);
            System.out.println();
            System.out.println("You must TERMINATE it before system crash !");
            Thread.sleep(1500);
            System.out.println("Terminal: Come on hurry up !!");
            Thread.sleep(2000);

            // ! Create Malware and Sanity
            Malware malware = new Malware("Kerny Buggy", 200, 16, 8);
            Sanity sanity = new Sanity();

            // ! Action
            while (user.isAlive() && malware.isAlive()) {
                System.out.println("=================================================");
                System.out.println(name + " Info:");
                System.out.println("HP: " + user.hp);
                System.out.println("mana: " + user.mana);
                Thread.sleep(1000);

                System.out.println("-------------------------------------------------");
                System.out.println(malware.name + " Info:");
                System.out.println("HP: " + malware.hp);
                Thread.sleep(400);

                System.out.println("-------------------------------------------------");
                System.out.println("Available commands:");
                System.out.println("> (1) kill                 (terminate process)");
                System.out.println("> (2) exploit              (use special skill)");
                System.out.println("> (3) systemctl_restart    (recover system)");
                System.out.println("> (4) sudo_su              (restore sanity)");
                String action = sc.next();

                switch (action) {
                    case "1":
                    case "kill":
                        user.attack(malware);
                        break;
                    case "2":
                    case "exploit":
                        user.useSkill(malware);
                        break;
                    case "3":
                    case "systemctl_restart":
                        sanity.useHeal(user);
                        break;
                    case "4":
                    case "sudo_su":
                        sanity.useMana(user);
                        break;
                    default:
                        System.out.println("Invalid action !");
                        continue;
                }

                if (malware.isAlive()) {
                    malware.attack(user);
                }

            }
            Thread.sleep(1000);
            System.out.println("=================================================");
            Thread.sleep(500);
            if (user.isAlive()) {
                System.out.println("System Recovered Successfully");
                Thread.sleep(800);
                System.out.println("All services are now running");
                Thread.sleep(800);
                System.out.println();
                System.out.println("Thank you for help us :D");
            } else {
                System.out.println("Kerny Buggy!");
                Thread.sleep(800);
                System.out.println("System halted...");
                Thread.sleep(800);
                System.out.println();
                System.out.println("Failed to save LINUX...");
            }
            System.out.println("=================================================");

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
