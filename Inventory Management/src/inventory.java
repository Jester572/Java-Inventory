//Libraries
import java.util.Scanner;
import java.util.ArrayList;

public class inventory {
    public static void main(String[] args) {
        //variables
        boolean running = true;
        boolean valid = true;
        int selection;
        int choice;
        Scanner input = new Scanner(System.in);

        //Two main lists
        ArrayList<Products> itemInventory = new ArrayList<Products>();
        ArrayList<Software> softwareInventory = new ArrayList<Software>();

       //Main loop
        while (running) {
            selection = mainMenu();
            while (selection == 1) {
                System.out.println("Do you want to print items, software, or all?");
                System.out.println("1: Items");
                System.out.println("2: Software");
                System.out.println("3: All");
                System.out.println("4: Back");

                choice = input.nextInt();
                //view only items
                if (choice == 1) {
                    for (Products pr : itemInventory) {
                        System.out.println("ID: " + pr.getProductId() + "   name: " + pr.getName() + "   Quantity: " + pr.getQuantity());

                    }
                //view only software
                } else if (choice == 2) {
                    for (Software sw : softwareInventory) {
                        System.out.println("ID: " + sw.getSoftwareId() + "   name: " + sw.getName() + "   Quantity: " + sw.getQuantity() + "   Length: " + sw.getLength());
                    }
                //view items and software
                } else if (choice == 3) {
                    System.out.println("Items");
                    for (Products pr : itemInventory) {
                        System.out.println("ID: " + pr.getProductId() + "   name: " + pr.getName() + "   Quantity: " + pr.getQuantity());

                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Software");
                    for (Software sw : softwareInventory) {
                        System.out.println("ID: " + sw.getSoftwareId() + "   name: " + sw.getName() + "   Quantity: " + sw.getQuantity() + "   Length: " + sw.getLength());
                    }

                } else if (choice == 4) {
                    selection = 0;
                }else {
                    System.out.println("Please chose a valid selection");
                }


            }
            //loop for creating an item or software
            while (selection == 2) {
                boolean another = true;

                while (another) {
                    int check = 0;

                    System.out.println("Would you like to add an item, or a software?");
                    System.out.println("1: Item");
                    System.out.println("2: Software");
                    System.out.println("3: Back");
                    choice = input.nextInt();

                    //Adds an item
                    if (choice == 1) {


                        System.out.print("Please enter the item name");
                        String name = input.next();
                        System.out.println("Please enter the quantity");
                        int quantity = input.nextInt();
                        itemInventory.add(new Products(name, quantity));

                    //Add software
                    } else if (choice == 2) {

                        System.out.print("Please enter the Software name");
                        String name = input.next();
                        System.out.println("Please enter the quantity");
                        int quantity = input.nextInt();
                        System.out.println("Please enter the length of licence in months");
                        int duration = input.nextInt();
                        softwareInventory.add(new Software(name,quantity,duration));

                    } else if (choice == 3) {
                        selection = 0;
                        break;

                    //Repeats if you want to add another
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
            //updates item quantities using the ID number
            while (selection == 3) {
                System.out.println("1: Update Item Quantity");
                System.out.println("2: Update Software Quantity");
                System.out.println("3: Back");
                choice = input.nextInt();

                //Changes item inventory
                if (choice == 1) {
                    for (Products pr : itemInventory) {
                        System.out.println("ID: " + pr.getProductId() + "   name: " + pr.getName() + "   Quantity: " + pr.getQuantity());
                    }
                    System.out.println("");
                    System.out.println("select an ID number to change");
                    int changeId = input.nextInt();
                    for (Products pr : itemInventory) {
                        if (pr.getProductId() == changeId) {
                            System.out.println("How many of " + pr.getName() + " are you changing it to?");
                            int newQuantity = input.nextInt();
                            pr.setQuantity(newQuantity);
                            break;
                        }
                    }
                    //Changes software inventory
                } else if (choice == 2) {
                    for (Software sw : softwareInventory) {
                        System.out.println("ID: " + sw.getSoftwareId() + "   name: " + sw.getName() + "   Quantity: " + sw.getQuantity() + "Length: " + sw.getLength());
                    }
                    System.out.println("");
                    System.out.println("select an ID number to change");
                    int changeId = input.nextInt();
                    for (Software sw : softwareInventory) {
                        if (sw.getSoftwareId() == changeId) {
                            System.out.println("How many of " + sw.getName() + " are you changing it to?");
                            int newQuantity = input.nextInt();
                            sw.setQuantity(newQuantity);
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
    //Creates a main menu
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
