import java.util.Scanner;

public class Source {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Algorithm algorithm = new Algorithm();

        System.out.println("===============================================");
        System.out.println("Enter a valid or invalid VIN number: ");
        System.out.println("===============================================");

        String line = scanner.nextLine();

        String answer = algorithm.checkLine(line);
        //testing with these two VIN numbers:
        //valid VIN: 1HGCM82633A004352
        //invalid VIN: 1HGCM82633A00435X

        if(algorithm.isValid()) {
            System.out.println("The inputted line was a valid VIN!");
        }else{
            System.out.println("The inputted line was not a valid VIN number.");
        }

    }

}
