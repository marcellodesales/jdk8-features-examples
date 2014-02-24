package org.github.marcellodesales;

/**
 * @author Ediwn Dalorzo
 */
public class Jedi  {

    private String name;
    private int power;

    public Jedi(String name) {
        this(name, 10);
    }

    public Jedi(String name, int power){
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("Jedi[name: %s, power: %d]", this.name, this.power);
    }
}
