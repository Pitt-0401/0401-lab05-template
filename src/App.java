/*
 * Created on 2024-09-30
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class App {

    private static Scanner myScanner = new Scanner(System.in);

    // TODO: adapt if you are reading data from a file
    private static boolean readingDataFromFile = false;

    public static void main(String[] args) {
        // TODO: read cats from the input file
        Cat userCat = readCatFromInput();
        printCatInfo(userCat);

        myScanner.close();
    }

    // TODO: implement this method
    public static void readCatsFromFile() {
        // myScanner...
    }

    // Read cat object from user input
    /*
     * NO NEED TO TOUCH readCatFromInput()
     * Hint: use this method!
     */
    public static Cat readCatFromInput() {
        System.out.println("\n------Reading a new cat------");

        Owner owner = promptForOwner();
        Cat userCat = promptForCat();

        if (userCat != null) {
            userCat.setOwner(owner);
            if (promptForStory()) {
                String story = promptForStoryDetails();
                userCat.setFunnyStory(story);
            }
        }
        System.out.println("-----------------------------");

        return userCat;
    }

    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * ! You only need to adapt (or remove) the *prompts* !
     * ! (print statements) from the helper methods below !
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */
    public static void printCatInfo(Cat cat) {
        System.out.println();
        if (cat != null && cat.getOwner() != null) {
            System.out.print(cat.getOwner().getName() + " has adopted " + cat.getName());
            if (cat.getAge() != 404) {
                System.out.print(" (" + cat.getAge() + ")");
            }
            if (!(cat.getFunnyStory().equals("n/a"))) {
                System.out.println(" and shared this story: ");
                System.out.println(cat.getFunnyStory().toString());
            } else {
                System.out.println(".");
            }
        }
    }

    // Helper methods to prompt the user for input
    private static Owner promptForOwner() {
        System.out.println("Please enter your name");
        String ownerName = myScanner.nextLine();
        return new Owner(ownerName);
    }

    private static Cat promptForCat() {
        System.out.println("What is your cat's name?");
        String name = myScanner.nextLine();

        System.out.println("Your cat says what?");
        String catSound = myScanner.nextLine();

        System.out.println("How old is your cat?");
        boolean isValidNumber = false;
        int age = 404; // Error code
        while (!isValidNumber) {
            try {
                age = myScanner.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
            myScanner.nextLine(); // Ignore the invalid input
        }

        System.out.println("Meet " + name + ", it says " + catSound + "!\n");
        return new Cat(name, age, catSound);
    }

    private static String promptForStoryDetails() {
        System.out.print("Story title:\t");
        String storyTitle = myScanner.nextLine();
        System.out.print("Story:\t\t");
        String storyDescription = myScanner.nextLine();
        if (storyTitle != "") {
            storyTitle = storyTitle.concat(" - ");
        }
        return storyTitle.concat(storyDescription);
    }

    private static boolean promptForStory() {
        if (readingDataFromFile) {
            return true;
        }
        System.out.println("Do you want to share a funny story about your cat? (yes/no)");
        String response = myScanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
