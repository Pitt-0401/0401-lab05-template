/*
 * Created on 2024-09-30
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

 public class Owner {

    private String name;
    private Cat ownedCat;

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, Cat ownedCat) {
        this.name = name;
        this.ownedCat = ownedCat;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }

    public Cat getOwnedCat() {
        return this.ownedCat;
    }

    // Owner behavior
    public void adoptCat(Cat cat) {
        if (this.ownedCat == null && cat.isAdoptable()) {
            this.ownedCat = cat;
            cat.setOwner(this);
            System.out.println(name + " just adopted " + ownedCat.getName());
        } else if (cat.isAdoptable()) {
            System.out.println(name + " cannot adopt " + cat.getName() + ". " + name + " already owns a cat: "
                    + ownedCat.getName() + ".");
        } else {
            System.out.println(name + " cannot adopt " + cat.getName() + " because it is not adoptable. Its owner is "
                    + cat.getOwner().getName() + ".");
        }
    }
}
