import java.util.Random;

public abstract class Character {
    protected String name;
    protected int hp, mp, sp;
    protected int maxHp, maxMp, maxSp;
    protected Random rand = new Random();

    public Character(String name, int hp, int mp, int sp) {
        this.name = name;
        this.hp = this.maxHp = hp;
        this.mp = this.maxMp = mp;
        this.sp = this.maxSp = sp;
    }

    // ----- Basic Actions -----
    public void attack(Character enemy) {
        if (sp >= 2) {
            sp -= 2;
            int damage = 10 + rand.nextInt(6); // 10–15 damage
            System.out.println(name + " attacks and deals " + damage + " damage!");
            enemy.takeDamage(damage);
        } else {
            System.out.println(name + " has no enough SP to attack!");
        }
    }

    public void defend() {
        if (sp >= 3) {
            sp -= 3;
            System.out.println(name + " defends and takes reduced damage next turn!");
        } else {
            System.out.println(name + " has no enough SP to defend!");
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " now has " + hp + " HP left.");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    // ----- Abstract methods (to be implemented in subclasses) -----
    public abstract void primarySkill(Character enemy);
    public abstract void secondarySkill();
}
