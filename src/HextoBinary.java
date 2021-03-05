import java.util.Scanner;

public class HextoBinary {
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);
        boolean validateUserInput = true;
        String userInput = "";

        //do while loop validates if user inputs correct number of hexadecimal
        do {
            System.out.println("Please enter a 4 digit hexadecimal (0-9, A-F)\n");

            System.out.println(userInput);

            userInput = object.nextLine().toUpperCase();
            if (userInput.length() == 4){
                validateUserInput = false;
            }
            else
                System.out.println("Please enter a valid hexadecimal");
        }
        while(validateUserInput);

        //After confirming user input is valid, start reading in the values
        //ABCD
        //ASCII A = 65, F = 70, in order to get correct value, we can subtract ASCII - 55
        int counter = userInput.length() -1;
        int decimalvalue = 0;


        for (int i = 0; i < 4; i++){                            //start at 4, check if 4 < 4, then increment i = 2
            if(Character.isAlphabetic(userInput.charAt(i))){
                decimalvalue += (userInput.charAt(i) - 55) * Math.pow(16,counter--);
            }
            else
                decimalvalue += (userInput.charAt(i) - 48) * Math.pow(16,counter--);
        }
        System.out.println(decimalvalue);

        int bin_num[] = new int[100];
        int j = 0;

        while (decimalvalue != 0){
            bin_num[j++] = decimalvalue % 2;
            decimalvalue /= 2;
        }

        for (int k = j - 1; k >= 0; k--){
            System.out.print(bin_num[k]);
        }
    }
}
