import java.util.Scanner;

class AutoDecrypt{

    AutoDecrypt(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Message: ");
        String input = sc.nextLine();
        System.out.print("Enter First Letter(Or a few Letters) Of Message: ");
        String string = sc.nextLine();

        for(int i=0;i<65535;i++){
            System.out.println(i);
            //System.out.println(doTask(input, i));
            if(doTask(input,i).startsWith(String.valueOf(string))) {
                System.out.println(doTask(input, i));
                break;
            }
        }
    }

  

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
        return encrypted.toString().trim();
       // display(encrypted.toString());
    }
}