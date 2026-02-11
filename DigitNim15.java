import java.util.Scanner;

public class DigitNim15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan 2 digit terakhir NIM: ");
        int n = sc.nextInt();
        sc.close();

        // Jika n < 10, tambahkan 10
        if (n < 10) {
            n += 10;
        }

        System.out.println("=== Deret Bilangan 1 sampai " + n + " ===");

        for (int i = 1; i <= n; i++) {

            // d. Bilangan 10 dan 15 tidak dicetak
            if (i == 10 || i == 15) {
                continue;
            }

            // a. Bilangan kelipatan 3 dicetak dengan simbol #
            if (i % 3 == 0) {
                System.out.print("# ");
            }
            // b. Bilangan genap selain kelipatan 3 dicetak sesuai angkanya
            else if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            // c. Bilangan ganjil dicetak dengan simbol *
            else {
                System.out.print("* ");
            }
        }

        System.out.println(); // baris baru di akhir
    }
}