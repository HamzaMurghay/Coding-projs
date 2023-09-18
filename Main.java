import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    int guess = -1, tries = 0;
    ArrayList guesses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in); //imp, this is how we solved the main prob, NOTOCE HOW THERE IS STATIC

    public static void main(String args[]) {

        Random random = new Random();
        int choice = 6, secretNumber = 1;
        
        System.out.print("Hey buddy! How you doin'? ");
        sc.next();
        System.out.println("I dont care! :), lets play a game!");
        System.out.println("So I'm gonna think of a number, it's your job to guess that number");
        System.out.println("Of course, you have multiple tries, and you're not on your own! I will give you tips based on how close you are to the 'Secret Number' ");
        System.out.println("Before you start you need to choose the difficulty mode that you are going to play on, that is the range from which the 'Secret Number will be chosen!':");
        System.out.println();

        while (choice == 6) { 
            System.out.println("---------------------Difficulty Mode---------------------");
            System.out.println("1) Little Bitch Mode [0-10]  (It's called that because if you choose this, you're a little bitch! ;)");
            System.out.println("2) Mere Mortal Mode [0-100]");
            System.out.println("3) Chad Mode [0-1000]");
            System.out.println("4) Giga Chad Mode [0-10,000]");
            System.out.println("5) Sigma Mode [0-100,000]");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    secretNumber = random.nextInt(11);
                    break;
                case 2:
                    secretNumber = random.nextInt(101);
                    break;
                case 3:
                    secretNumber = random.nextInt(1001);
                    break;
                case 4:
                    secretNumber = random.nextInt(10001);
                    break;
                case 5:
                    secretNumber = random.nextInt(100001);
                    break;
                default:
                    choice = 6;
                    System.out.println("Invalid choice! Please enter a valid choice. Try again");
                    break;
            }
        }

        System.out.println("Ok so here goes, the game has begun! start your gueessing!");
        // System.out.println(secretNumber);

        Main m = new Main(); //imp, this is how we solved the main prob
        m.CheckGuess(secretNumber); //imp, this is how we solved the main prob
        sc.close();
    }

    public void CheckGuess(int secNum) { //imp, this is how we solved the main prob NOTICE HOW THERES NO STATIC?
            
        while (guess != secNum) {
            System.out.print("Enter Your Guess! ");
            guess = sc.nextInt();

            if (!guesses.contains(guess)) {
                guesses.add(guess);
                tries++;
            }
            
            if (guess == secNum) {
                System.out.println("Congratulations! You guessed the Secret Number!");
                System.out.println("It took you "+ tries +" tries!");
                System.out.println("Here are all your tries! ---> "+ guesses);
            }    
            else if (guess < secNum) {
                System.out.println("Too Small!");
            }

            else if (guess > secNum) {
                System.out.println("Too Big!");
            }
        }
    }

}