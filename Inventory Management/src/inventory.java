import java.util.Scanner;


public class inventory {
    public static void main(String[] args) {
        boolean running = true;
        boolean valid = true;
        int selection;
        int choice;
        Scanner input = new Scanner(System.in);
        Products[] itemInventory = new Products[100];
        Software[] softwareInventory = new Software[100];


//        new Item("compute",52);
//        Item id3 = new Item("computs",52);
//        Software s1 = new Software("google", 2, 3);
        while (running) {
            selection = mainMenu();
            while (selection == 1) {
                System.out.println("Do you want to print items, software, or all?");
                System.out.println("1: Items");
                System.out.println("2: Software");
                System.out.println("3: All");
                System.out.println("4: Back");

                choice = input.nextInt();

                if (choice == 1) {
                    for (int i = 0; i < Products.productCounter; i++) {
                        System.out.println("ID: " + itemInventory[i].getProductId() + "   name: " + itemInventory[i].getName() + "   Quantity: " + itemInventory[i].getQuantity());

                    }

                } else if (choice == 2) {
                    for (int i = 0; i < Software.softwareCounter; i++) {
                        System.out.println("ID: " + softwareInventory[i].getSoftwareId() + "   name: " + softwareInventory[i].getName() + "   Quantity: " + softwareInventory[i].getQuantity() + "   Length: " + softwareInventory[i].getLength());
                    }
                } else if (choice == 3) {
                    System.out.println("Items");
                    for (int i = 0; i < Products.productCounter; i++) {
                        System.out.println("ID: " + itemInventory[i].getProductId() + "   name: " + itemInventory[i].getName() + "   Quantity: " + itemInventory[i].getQuantity());
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Software");
                    for (int i = 0; i < Software.softwareCounter; i++) {
                        System.out.println("ID: " + softwareInventory[i].getSoftwareId() + "   name: " + softwareInventory[i].getName() + "   Quantity: " + softwareInventory[i].getQuantity() + "   Length: " + softwareInventory[i].getLength());
                    }

                } else if (choice == 4) {
                    selection = 0;
                }else {
                    System.out.println("Please chose a valid selection");
                }


            }
            while (selection == 2) {
                boolean another = true;

                while (another) {
                    int check = 0;

                    System.out.println("Would you like to add an item, or a software?");
                    System.out.println("1: Item");
                    System.out.println("2: Software");
                    System.out.println("3: Back");
                    choice = input.nextInt();

                    if (choice == 1) {
                        while (itemInventory[check] != null) {
                            check++;
                        }
                        System.out.print("Please enter the item name");
                        String name = input.next();
                        System.out.println("Please enter the quantity");
                        int quantity = input.nextInt();
                        itemInventory[check] = new Products(name, quantity);


                    } else if (choice == 2) {
                        while (softwareInventory[check] != null) {
                            check++;
                        }

                        System.out.print("Please enter the Software name");
                        String name = input.next();
                        System.out.println("Please enter the quantity");
                        int quantity = input.nextInt();
                        System.out.println("Please enter the length of licence in months");
                        int duration = input.nextInt();
                        softwareInventory[check] = new Software(name,quantity,duration);

                    } else if (choice == 3) {
                        selection = 0;
                        break;


                    } else {
                        System.out.println("Please choose a valid selection");
                    }
                    System.out.println("Would you like to add another?");
                    System.out.println("1:Yes");
                    System.out.println("2:No");
                    int newSelection = input.nextInt();
                    if (newSelection == 2) {
                        another = false;
                        selection = 0;
                    }



                }

            }
            while (selection == 3) {
                System.out.println("1: Update Item Quantity");
                System.out.println("2: Update Software Quantity");
                System.out.println("3: Back");
                choice = input.nextInt();
                if (choice == 1) {
                    for (int i = 0; i < Products.productCounter; i++) {
                        System.out.println("ID: " + itemInventory[i].getProductId() + "   name: " + itemInventory[i].getName() + "   Quantity: " + itemInventory[i].getQuantity());
                    }
                    System.out.println("");
                    System.out.println("select an ID number to change");
                    int changeId = input.nextInt();
                    for (int i = 0; i < Products.productCounter; i++) {
                        if (itemInventory[i].getProductId() == changeId) {
                            System.out.println("How many of " + itemInventory[i].getName() + " are you changing it to?");
                            int newQuantity = input.nextInt();
                            itemInventory[i].setQuantity(newQuantity);
                            break;
                        }
                    }
                } else if (choice == 2) {
                    for (int i = 0; i < Software.softwareCounter; i++) {
                        System.out.println("ID: " + softwareInventory[i].getSoftwareId() + "   name: " + softwareInventory[i].getName() + "   Quantity: " + softwareInventory[i].getQuantity() + "Length: " + softwareInventory[i].getLength());
                    }
                    System.out.println("");
                    System.out.println("select an ID number to change");
                    int changeId = input.nextInt();
                    for (int i = 0; i < Software.softwareCounter; i++) {
                        if (softwareInventory[i].getSoftwareId() == changeId) {
                            System.out.println("How many of " + softwareInventory[i].getName() + " are you changing it to?");
                            int newQuantity = input.nextInt();
                            softwareInventory[i].setQuantity(newQuantity);
                            break;
                        }
                    }
                } else if (choice == 3) {
                    selection = 0;
                }else {
                    System.out.println("Please select a valid selection");
                }

            }
            if (selection == 4) {
                running = false;
            } else if (selection < 0 || selection < 4) {
                System.out.println("Please input a valid selection");

            } else {
                System.out.println("please input a valid selection");
            }

        }

        System.out.println("Goodbye!!!");


    }
    static int mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select from the menu by typing the associated number");
        System.out.println("1: View Inventory");
        System.out.println("2: Add Item");
        System.out.println("3: Update Quantity");
        System.out.println("4: Quit");
        int selection = input.nextInt();
        return selection;
    }


}