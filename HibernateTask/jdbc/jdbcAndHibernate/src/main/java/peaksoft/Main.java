package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        switch (new Scanner(System.in).nextLine()){
            case "1"-> {
                userService.saveUser("erkin","toigonbaev", (byte) 21);
            }
            case "2"-> {
                System.out.println(userService.getAllUsers());
            }
            case "3"-> {
                userService.cleanUsersTable();
            }
            case "4"-> {
                userService.dropUsersTable();
            }
        }
    }
}
