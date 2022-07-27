import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Decryption extends JFrame implements Works{
    Decryption(){
        Scanner sc= new Scanner(System.in);
        System.out.println("1. Custom message");
        System.out.println("2. Choose File");
        System.out.print("Enter Option: ");
        int option=sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1 -> takeInput();
            case 2 -> File("Decrypt!!");
            default -> System.out.println("Invalid Output");
        }

    }
    @Override
    public void takeInput() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Key: ");
        int key= sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Message: ");
        String input=sc.nextLine();
        doTask(input, key);
    }

    @Override
    public String doTask(String input, int key) {
        String [] words= input.split("\\s");
        int k=key;
        StringBuilder encrypted= new StringBuilder();
        for(int i=0;i<words.length;i++){
            char[] letters = words[i].toCharArray();
            for(int j=0;j<letters.length;j++){
                encrypted.append(String.valueOf((char) (letters[j] - k)));
            }
            encrypted.append(String.valueOf(" "));
        }
        display(encrypted.toString());
        return encrypted.toString();
    }
    @Override
    public void display(String crypt) {
        System.out.println("------------------------------------------\n"+crypt+"\n------------------------------------------\n");
    }

    @Override
    public void File(String decrypt) {
        File file = null;
        String crypt="";
        this.setVisible(true);
        JFileChooser fileChooser= new JFileChooser();
        int response=fileChooser.showOpenDialog(null);
        fileChooser.setCurrentDirectory(new File("C:\\"));
        if(response== JFileChooser.APPROVE_OPTION){
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());  // to get chosen file path
        }
        this.dispose();
        try {
            FileReader reader = new FileReader(file);
            int data= reader.read();
            while(data != -1){
                crypt+=String.valueOf((char) data);
                data = reader.read();
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Key: ");
        int key= sc.nextInt();
        sc.nextLine();
        doTask(crypt,key);
    }
}
