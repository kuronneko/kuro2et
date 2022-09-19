
import dao.Filek2etDAO;
import dto.Filek2et;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Timestamp;
import utils.Connection;
import utils.KuroEncrypterTool;
import static utils.Properties.getConfigParameters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maindesktop
 */
public class Kuro2et extends Connection {

    public static void main(String[] args) {

        KuroEncrypterTool KuroEncrypterTool = new KuroEncrypterTool();
        System.out.println("Password: ");
        Scanner passwordRead = new Scanner(System.in);
        String password = passwordRead.nextLine();
        if (password.equals(KuroEncrypterTool.loadHexToString(getConfigParameters().getProperty("master")))) {
            Scanner sc = new Scanner(System.in);
            Filek2etDAO Filek2etDAO = new Filek2etDAO();
            System.out.println("");
            System.out.println("             __ __                       __                \n"
                    + "            / //_/_ _________  ___  ___ / /_____           \n"
                    + "           / ,< / // / __/ _ \\/ _ \\/ -_)  '_/ _ \\          \n"
                    + "          /_/|_|\\_,_/_/  \\___/_//_/\\__/_/\\_\\\\___/          \n"
                    + "                                                           \n"
                    + "   ____                       __         ______          __\n"
                    + "  / __/__  __________ _____  / /____ ___/_  __/__  ___  / /\n"
                    + " / _// _ \\/ __/ __/ // / _ \\/ __/ -_) __// / / _ \\/ _ \\/ / \n"
                    + "/___/_//_/\\__/_/  \\_, / .__/\\__/\\__/_/  /_/  \\___/\\___/_/  \n"
                    + "                 /___/_/                                   \n"
                    + "");
            System.out.println("***********************************************************");
            System.out.println("***********************************************************");
            System.out.println("** Select 1 to show full list                            **");
            System.out.println("** Select 2 to add new entry                             **");
            System.out.println("** Select 3 to edit entry                                **");
            System.out.println("** Select 4 to delete entry                              **");
            System.out.println("***********************************************************");
            System.out.println("***********************************************************");
            System.out.println("");
            String selection = sc.nextLine();

            if (selection.equals(String.valueOf(1))) {
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                    System.out.print("** [" + Filek2et.getId() + "]");
                    System.out.print("");
                    System.out.print(Filek2et.getName());
                    System.out.print(" -> ");
                    System.out.print(Filek2et.getText());
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getCreated_at() + "]");
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getUpdated_at() + "]");
                    System.out.println("");
                }
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                main(args);
            } else if (selection.equals(String.valueOf(2))) {
                Scanner textInput = new Scanner(System.in);
                System.out.println("Insert text you want to encrypt: ");
                String normalText = textInput.nextLine();
                System.out.println("");
                System.out.println("Insert filename: ");
                String filename = textInput.nextLine();
                System.out.println("");
                Filek2etDAO.add(new Filek2et(filename, normalText, String.valueOf(new Timestamp(System.currentTimeMillis())), String.valueOf(new Timestamp(System.currentTimeMillis()))));
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                    System.out.print("** [" + Filek2et.getId() + "]");
                    System.out.print("");
                    System.out.print(Filek2et.getName());
                    System.out.print(" -> ");
                    System.out.print(Filek2et.getText());
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getCreated_at() + "]");
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getUpdated_at() + "]");
                    System.out.println("");
                }
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                System.out.println("** Entry added successfully");
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                main(args);
            } else if (selection.equals(String.valueOf(3))) {
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                    System.out.print("** [" + Filek2et.getId() + "]");
                    System.out.print("");
                    System.out.print(Filek2et.getName());
                    System.out.print(" -> ");
                    System.out.print(Filek2et.getText());
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getCreated_at() + "]");
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getUpdated_at() + "]");
                    System.out.println("");
                }
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("Edit entry by ID: ");
                int editId = sc2.nextInt();
                Filek2et Filek2etEdited = Filek2etDAO.get(editId);
                if (Filek2etEdited.getName() != null) {
                    Scanner textInputEdit = new Scanner(System.in);
                    System.out.println("Inset new name: ");
                    String name = textInputEdit.nextLine();
                    System.out.println("Insert new text: ");
                    String text = textInputEdit.nextLine();

                    Filek2etEdited.setName(name);
                    Filek2etEdited.setText(text);
                    Filek2etEdited.setUpdated_at(String.valueOf(new Timestamp(System.currentTimeMillis())));
                    Filek2etDAO.update(Filek2etEdited);

                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                        System.out.print("** [" + Filek2et.getId() + "]");
                        System.out.print("");
                        System.out.print(Filek2et.getName());
                        System.out.print(" -> ");
                        System.out.print(Filek2et.getText());
                        System.out.print(" ");
                        System.out.print("[" + Filek2et.getCreated_at() + "]");
                        System.out.print(" ");
                        System.out.print("[" + Filek2et.getUpdated_at() + "]");
                        System.out.println("");
                    }
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    System.out.println("** Entry updated successfully");
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                } else {
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    System.out.println("** Entry not found");
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                }
                main(args);
            } else if (selection.equals(String.valueOf(4))) {
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                    System.out.print("** [" + Filek2et.getId() + "]");
                    System.out.print("");
                    System.out.print(Filek2et.getName());
                    System.out.print(" -> ");
                    System.out.print(Filek2et.getText());
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getCreated_at() + "]");
                    System.out.print(" ");
                    System.out.print("[" + Filek2et.getUpdated_at() + "]");
                    System.out.println("");
                }
                System.out.println("***********************************************************");
                System.out.println("***********************************************************");
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Delete entry by ID: ");
                int deleteId = sc3.nextInt();
                if (Filek2etDAO.get(deleteId).getName() != null) {
                    Filek2etDAO.delete(Filek2etDAO.get(deleteId));
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    for (Filek2et Filek2et : Filek2etDAO.getAll()) {
                        System.out.print("** [" + Filek2et.getId() + "]");
                        System.out.print("");
                        System.out.print(Filek2et.getName());
                        System.out.print(" -> ");
                        System.out.print(Filek2et.getText());
                        System.out.print(" ");
                        System.out.print("[" + Filek2et.getCreated_at() + "]");
                        System.out.print(" ");
                        System.out.print("[" + Filek2et.getUpdated_at() + "]");
                        System.out.println("");
                    }
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    System.out.println("** Entry delete successfully");
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                } else {
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                    System.out.println("** Entry not found");
                    System.out.println("***********************************************************");
                    System.out.println("***********************************************************");
                }

                main(args);
            } else if (selection.equals("exit")) {
                System.out.println("");
                System.out.println("***********************************************************");
                System.out.println("********** Sayonara ! *************************************");
                System.out.println("***********************************************************");
            } else {
                System.out.println("");
                System.out.println("***********************************************************");
                System.out.println("********** You need to select a valid option **************");
                System.out.println("********** Try again ! ************************************");
                System.out.println("***********************************************************");
            }
        }
    }
}
