public class Druid extends Character {
    public Druid(String name) {
        super(name, 120, 80, 60); // HP, MP, SP
    }

    // Skill 1: Swipe (Physical)
    @Override
    public void primarySkill(Character enemy) {
        if (sp >= 25) {
            sp -= 25;
            int bonusDamage = 15 + rand.nextInt(6); // 15–20 bonus
            System.out.println(name + " uses Swipe! Deals " + bonusDamage + " guaranteed damage.");
            enemy.takeDamage(bonusDamage);
        } else {
            System.out.println(name + " doesn’t have enough SP!");
        }
    }

    // Skill 2: Healing Touch (Magical)
    @Override
    public void secondarySkill() {
        if (mp >= 60) {
            mp -= 60;
            boolean fullHeal = rand.nextDouble() < 0.6; // 60% chance
            if (fullHeal) {
                hp = maxHp;
                System.out.println(name + " casts Healing Touch and fully restores HP!");
            } else {
                System.out.println(name + " tried to heal, but it failed!");
            }
        } else {
            System.out.println(name + " doesn’t have enough MP!");
        }
    }
}
