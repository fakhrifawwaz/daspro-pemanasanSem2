import java.util.Scanner;

public class Tugas1 {


    static char[] KODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};

    static char[][] KOTA = {
        {'B','A','N','T','E','N',' ',' ',' ',' ',' ',' '},  // A
        {'J','A','K','A','R','T','A',' ',' ',' ',' ',' '},  // B
        {'B','A','N','D','U','N','G',' ',' ',' ',' ',' '},  // D
        {'C','I','R','E','B','O','N',' ',' ',' ',' ',' '},  // E
        {'B','O','G','O','R',' ',' ',' ',' ',' ',' ',' '},  // F
        {'P','E','K','A','L','O','N','G','A','N',' ',' '},  // G
        {'S','E','M','A','R','A','N','G',' ',' ',' ',' '},  // H
        {'S','U','R','A','B','A','Y','A',' ',' ',' ',' '},  // L
        {'M','A','L','A','N','G',' ',' ',' ',' ',' ',' '},  // N
        {'T','E','G','A','L',' ',' ',' ',' ',' ',' ',' '}   // T
    };


    // Fungsi 1: Mencari index kode plat
    static int cariKode(char inputKode) {
        for (int i = 0; i < KODE.length; i++) {
            if (KODE[i] == Character.toUpperCase(inputKode)) {
                return i;
            }
        }
        return -1;
    }


    // Fungsi 2:nama kota array 2d
    static String getNamaKota(int index) {
        StringBuilder nama = new StringBuilder();
        for (int j = 0; j < KOTA[index].length; j++) {
            if (KOTA[index][j] != ' ') {
                nama.append(KOTA[index][j]);
            }
        }
        return nama.toString();
    }

    // fungsi 3: tabel data
    static void tampilkanSemuaData() {
        System.out.println("=".repeat(30));
        System.out.println("   DAFTAR KODE PLAT & NAMA KOTA");
        System.out.println("=".repeat(30));
        System.out.printf(" %-6s | %-15s%n", "KODE", "KOTA");
        System.out.println("-".repeat(30));
        for (int i = 0; i < KODE.length; i++) {
            System.out.printf("  %-6c | %-15s%n", KODE[i], getNamaKota(i));
        }
        System.out.println("=".repeat(30));
    }


    // Fungsi 4 : pencarian kota dengan input
    static void cariKota(char inputKode) {
        int index = cariKode(inputKode);

        System.out.println();
        if (index != -1) {
            System.out.println("  Kode Plat  : " + Character.toUpperCase(inputKode));
            System.out.println("  Nama Kota  : " + getNamaKota(index));
        } else {
            System.out.println("  Kode plat '" + Character.toUpperCase(inputKode)
                + "' tidak ditemukan!");
        }
        System.out.println();
    }


    // Fungsi main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("  *** PROGRAM PENCARIAN KOTA PLAT NOMOR ***");
        System.out.println();

        tampilkanSemuaData();

        char ulang = 'y';
        while (ulang == 'y' || ulang == 'Y') {
            System.out.print("\n  Masukkan kode plat nomor: ");
            String input = scanner.next();
            char kode = input.charAt(0);

            cariKota(kode);

            System.out.print("  Cari lagi? (y/n): ");
            ulang = scanner.next().charAt(0);
        }

        System.out.println();
        System.out.println("  Program selesai. Terima kasih!");
        System.out.println();
        scanner.close();
    }
}