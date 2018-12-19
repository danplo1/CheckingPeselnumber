import java.util.Scanner;

/**
 * Created by Daniel_D'AGE on 19.12.2018.
 */
public class PeselNumber {


    public static boolean check(String pesel) {
        //zakładamy tablice z wagami

        int[] weight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        // sprawdzamy długość nr pesel, jeśli != 11 zwracamy false
        if (pesel.length() != 11)
            return false;
        //  zmienną jako sumą kontrolną
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weight[i];
        }
        // pobieramy do zmiennej controlNumber wartość ostatniej cyfry z nr pesel
        int controlNumber = Integer.parseInt(pesel.substring(10, 11));

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        // zwracamy wartość logiczną porównania obliczonej i pobranej cyfry kontrolnej
        return (sum == controlNumber);

    }

    //sprawdzenie płci
    public String getSex() {

        String numberPesel = null;

        Integer digit = Integer.parseInt(numberPesel.substring(10, 11));
        String getSex = "";
        if ((digit % 2) == 0)
            getSex = " nr pesel kobiety.";
        else
            getSex = " nr pesel mężczyzny.";

        return getSex;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer PESEL: ");

        String pesel = scanner.nextLine();
        System.out.println("Twój pesel jest " + ((check(pesel)) ? "poprawny." : "niepoprawny."));
        System.out.println();


    }

}
