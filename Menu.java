package Application;

import DAO.AttachmentDAO;
import DAO.CaliberDAO;
import DAO.TypeDAO;
import DAO.WeaponDAO;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private WeaponDAO weaponDAO = new WeaponDAO();
    private TypeDAO typeDAO = new TypeDAO();
    private CaliberDAO caliberDAO = new CaliberDAO();
    private AttachmentDAO attachmentDAO = new AttachmentDAO();

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Add a Gun",
            "Add Types",
            "Add Calibers",
            "Add Attachments",
            "Update a Gun",
            "Update the Type",
            "Update the Caliber",
            "Update Attachment",
            "Remove a Gun",
            "Remove a Type",
            "Remove a Caliber",
            "Remove an Attachment",
            "Display Guns",
            "Display Types",
            "Display Calibers",
            "Display Attachments"
    );

    public void start() {

        String selection = "";

        do {
            printMenu();
            System.out.print("\nPlease enter option: ");
            selection = scanner.nextLine();
            System.out.println();

            try {
                if (selection.equals("1")) {
                    addGun();
                } else if (selection.equals("2")) {
                    addType();
                } else if (selection.equals("3")) {
                    addCaliber();
                } else if (selection.equals("4")) {
                    addAttachment();
                } else if (selection.equals("5")) {
                    updateGun();
                } else if (selection.equals("6")) {
                    updateType();
                } else if (selection.equals("7")) {
                    updateCaliber();
                } else if (selection.equals("8")) {
                    updateAttachment();
                } else if (selection.equals("9")) {
                    removeGun();
                } else if (selection.equals("10")) {
                    removeType();
                }  else if (selection.equals("11")) {
                    removeCaliber();
                }  else if (selection.contentEquals("12")) {
                    removeAttachment();
                } else if (selection.equals("13")) {
                    displayGun();
                }  else if (selection.equals("14")) {
                    displayType();
                } else if (selection.equals("15")) {
                    displayCaliber();
                }  else if (selection.contentEquals("16")) {
                    displayAttachment();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Press enter to continue...");
            selection =  scanner.nextLine();


        } while (!selection.equals("-1"));
    }

    private void printMenu() {
        System.out.println("Select an Option:\n-------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ")" + options.get(i));
        }
    }

}
