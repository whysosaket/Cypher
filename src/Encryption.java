import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Encryption implements Works{

    Encryption(){
        takeInput();
    }
    @Override
    public void takeInput() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Key(Enter \"RAND\" to Randomise): ");
        String s=sc.nextLine().toLowerCase();
        int key=0;
        try {
            key = Integer.parseInt(s);
        }catch (NumberFormatException e){

        }
        Random r = new Random();
        //sc.nextLine();
        System.out.print("Enter Message: ");
        String input=sc.nextLine();
        if(s.equals("rand")) {
            doTask(input, r.nextInt(0,65535));
        }
        else if(key!=0) doTask(input, key);
    }

    @Override
    public String doTask(String input, int key) {
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
        return encrypted.toString();
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
