import java.util.Scanner;

public class MainMenu {
    MainMenu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");
        System.out.println("3. AutoDecrypt");
        System.out.println("4. Exit");
        System.out.print("Enter Input: ");
        int input=sc.nextInt();
        sc.nextLine();
        switch (input){
            case 1 -> new Encryption();
            case 2 -> new Decryption();
            case 3 -> new AutoDecrypt();
            case 4 -> System.exit(0);
            default -> System.out.println("Invalid Input!!");
        }
        new MainMenu();
    }
}
