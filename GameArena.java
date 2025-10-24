import java.util.Scanner;

public class GameArena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your class:");
        System.out.println("1. Druid");
        System.out.println("2. Rogue");
        int choice = sc.nextInt();

        Character player, enemy;
        if (choice == 1) {
            player = new Druid("Player Druid");
            enemy = new Rogue("Enemy Rogue");
        } else {
            player = new Rogue("Player Rogue");
            enemy = new Druid("Enemy Druid");
        }

        System.out.println("\n=== Battle Start! ===");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour turn! Choose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Skill 1");
            System.out.println("4. Skill 2");
            int action = sc.nextInt();

            switch (action) {
                case 1 -> player.attack(enemy);
                case 2 -> player.defend();
                case 3 -> player.primarySkill(enemy);
                case 4 -> player.secondarySkill();
                default -> System.out.println("Invalid choice!");
            }

            if (!enemy.isAlive()) {
                System.out.println("\n🎉 You defeated the enemy!");
                break;
            }

            // --- Enemy's random move ---
            int enemyMove = (int)(Math.random() * 3); // random attack, defend, or skill
            System.out.println("\nEnemy's turn!");
            if (enemyMove == 0) enemy.attack(player);
            else if (enemyMove == 1) enemy.defend();
            else enemy.primarySkill(player);

            if (!player.isAlive()) {
                System.out.println("\n💀 You were defeated!");
                break;
            }
        }

        sc.close();
    }
}
