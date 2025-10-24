public class Rogue extends Character {
    public Rogue(String name) {
        super(name, 100, 40, 90); // HP, MP, SP
    }

    // Skill 1: Shadow Step
    @Override
    public void primarySkill(Character enemy) {
        if (sp >= 20) {
            sp -= 20;
            int damage = 20 + rand.nextInt(10); // 20–29 bonus
            System.out.println(name + " uses Shadow Step! Deals " + damage + " guaranteed hit!");
            enemy.takeDamage(damage);
        } else {
            System.out.println(name + " doesn’t have enough SP!");
        }
    }

    // Skill 2: Evasion
    @Override
    public void secondarySkill() {
        if (sp >= 35) {
            sp -= 35;
            System.out.println(name + " activates Evasion! Dodges most attacks for 2 turns!");
        } else {
            System.out.println(name + " doesn’t have enough SP!");
        }
    }
}
