import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Encryption implements Works{
    Encryption(){
        takeInput();
    }
    @Override
    public void takeInput() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Key: ");
        char key= sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Enter Message: ");
        String input=sc.nextLine();
        doTask(input, key);
    }

    @Override
    public void doTask(String input, char key) {
        String [] words= input.split("\\s");
        int k=key;
        StringBuilder encrypted= new StringBuilder();
        for(int i=0;i<words.length;i++){
            char[] letters = words[i].toCharArray();
            for(int j=0;j<letters.length;j++){
                encrypted.append(String.valueOf((char) (letters[j] + k)));
            }
            encrypted.append(String.valueOf(" "));
        }
        display(encrypted.toString());
        File(encrypted.toString());
    }
    @Override
    public void display(String crypt) {
        System.out.println("------------------------------------------\n"+crypt+"\n------------------------------------------\n");
    }

    @Override
    public void File(String encrypt) {
        File file = new File("Encrypt.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter("Encrypt.txt");
            writer.write(encrypt);        //writes to the file
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
