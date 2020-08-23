package Application;

import DAO.AttachmentDAO;
import DAO.CaliberDAO;
import DAO.WeaponDAO;
import Entity.Attachment;
import Entity.Caliber;
import Entity.Weapon;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private WeaponDAO weaponDAO = new WeaponDAO();
    private CaliberDAO caliberDAO = new CaliberDAO();
    private AttachmentDAO attachmentDAO = new AttachmentDAO();

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Add Guns",
            "Add Calibers",
            "Add Attachments",
            "Update a Gun",
            "Update the Caliber",
            "Update Attachment",
            "Remove a Gun",
            "Remove a Caliber",
            "Remove an Attachment",
            "Display a Gun",
            "Display a Caliber",
            "Display an Attachment"
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
                    addGuns();
                } else if (selection.equals("2")) {
                    addCalibers();
                } else if (selection.equals("3")) {
                    addAttachments();
                } else if (selection.equals("4")) {
                    updateGuns();
                } else if (selection.equals("5")) {
                    updateCalibers();
                } else if (selection.equals("6")) {
                    updateAttachments();
                } else if (selection.equals("7")) {
                    removeGuns();
                }  else if (selection.equals("8")) {
                    removeCalibers();
                }  else if (selection.contentEquals("9")) {
                    removeAttachments();
                } else if (selection.equals("10")) {
                    displayGuns();
                } else if (selection.equals("11")) {
                    displayCalibers();
                }  else if (selection.contentEquals("12")) {
                    displayAttachments();
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

    private void addGuns() throws SQLException {
        System.out.print("Add Gun ID:");
        int gunId = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Gun Name:");
        String gun = scanner.nextLine();
        WeaponDAO.addNewWeapon(gunId, gun);
    }

    private void addCalibers() throws SQLException {
        System.out.print("Add Caliber ID:");
        int caliberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Caliber Type:");
        int caliberType = Integer.parseInt(scanner.nextLine());
        CaliberDAO.addNewCaliber(caliberId, caliberType);
    }

    private void addAttachments() throws SQLException {
        System.out.print("Add Attachment ID:");
        int attachmentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Attachment Type:");
        String attachmentType = scanner.nextLine();
        AttachmentDAO.addNewAttachment(attachmentId, attachmentType);
    }

    private void updateGuns() throws SQLException {
        System.out.print("Update Gun ID:");
        int gunId = Integer.parseInt(scanner.nextLine());
        System.out.print("Update Gun:");
        String gun = scanner.nextLine();
        WeaponDAO.updateWeapon(gunId, gun);
    }

    private void updateCalibers() throws SQLException {
        System.out.print("Update Caliber ID:");
        int caliberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Update Caliber Type:");
        int caliberType = Integer.parseInt(scanner.nextLine());
        CaliberDAO.updateCaliber(caliberId, caliberType);
    }

    private void updateAttachments() throws SQLException {
        System.out.print("Update Attachment ID:");
        int attachmentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Update Attachment Type:");
        String attachmentType = scanner.nextLine();
        AttachmentDAO.updateAttachment(attachmentId, attachmentType);
    }

    private void removeGuns() throws SQLException {
        System.out.print("Delete By Gun ID:");
        int gunId = Integer.parseInt(scanner.nextLine());
        WeaponDAO.deleteWeaponById(gunId);
    }

    private void removeCalibers() throws SQLException {
        System.out.print("Delete By Caliber ID:");
        int caliberId = Integer.parseInt(scanner.nextLine());
        CaliberDAO.deleteCaliberById(caliberId);
    }

    private void removeAttachments() throws SQLException {
        System.out.print("Remove Attachment by ID:");
        int attachmentId = Integer.parseInt(scanner.nextLine());
        AttachmentDAO.deleteAttachmentById(attachmentId);
    }

    private void displayGuns() throws SQLException {
        List<Weapon> weapons = WeaponDAO.Weapon();
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getWeaponId() + ": " + weapon.getGun());
        }
    }

    private void displayCalibers() throws SQLException {
        List<Caliber> calibers = CaliberDAO.Caliber();
        for (Caliber caliber : calibers) {
            System.out.println(caliber.getCaliberId() + ": " + caliber.getCaliberType());
        }
    }

    private void displayAttachments() throws SQLException {
        List<Attachment> attachments = AttachmentDAO.Attachment();
        for (Attachment attachment : attachments) {
            System.out.println(attachment.getAttachmentId() + ": " + attachment.getAttachmentType());
        }
    }

}
