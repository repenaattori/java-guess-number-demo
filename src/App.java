import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        //Sovelluksessa tarvittavat muuttujat
        int points = 0;
        int attempts = 5;
        int roundPoints = 0;
        String endGame = "n";    
        int randomNum = 0;
        int myGuess = 0;

        //Yksi toisto arvuuttelee yhden luvun
        do{

            //Arvotaan luku
            randomNum = rnd.nextInt(11);
        
            //Tämä toisto arvuuttelee max niin monta kertaa kuinka monta yritystä pelaajalla.
            do{
                //Kysytään ja talletetaan käyttäjän arvaus
                System.out.println("Arvaa mikä numero? Sinulla on " + attempts +" yritystä jäljellä.");
                myGuess = Integer.parseInt(sc.nextLine());

                //Asetetaan kierroksen pisteet jos menee oikein. Pisteet saadaan suoraan yrityksistä.
                //Yritykset nollataan, jotta tämän luvun arvuuttelu loppuu.
                if(myGuess == randomNum){
                    System.out.println("Vastasit oikein!!!");
                    roundPoints = attempts;
                    attempts = 0;
                }else{
                    //Vähennetään yrityksiä, jos arvaus menee väärin.
                    System.out.println("Vastasit väärin!");
                    attempts--;
                }

            }while(attempts > 0);
            
            //Lisätään kierroksen pisteet yhteispisteisiin.
            //Tiedotetaan käyttäjää tilanteesta.
            points += roundPoints;
            System.out.println("Sait tältä kierrokselta " + roundPoints + " pistettä.");
            System.out.println("Sinulla on yhteensä " + points + " pistettä.");

            //Kysytään haluaako arvuutella lisää numeroita.
            System.out.println("Haluatko jatkaa? (n/y)");
            endGame = sc.nextLine();

            //Resetoidaan yritykset ja kierrospisteet ennen seuraavaa kierrosta.
            attempts = 5;
            roundPoints = 0;
        }while(endGame.equals("y"));

        System.out.println("Sait yhteensä " + points + " pistettä!");

        sc.close();
    }
}
