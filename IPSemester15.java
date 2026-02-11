import java.util.Scanner;

public class IPSemester15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Menghitung IP Semester");

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMK = scanner.nextInt();
        scanner.nextLine(); // buang newline

        String[] namaMK     = new String[jumlahMK];
        int[]    sksMK      = new int[jumlahMK];
        double[] nilaiAngka = new double[jumlahMK];

        // Input
        for (int i = 0; i < jumlahMK; i++) {
            System.out.println("\n--- Mata Kuliah " + (i + 1) + " ---");
            System.out.print("Nama MK          : ");
            namaMK[i] = scanner.nextLine();

            System.out.print("Bobot SKS        : ");
            sksMK[i] = scanner.nextInt();

            System.out.print("Nilai Angka (0-100): ");
            nilaiAngka[i] = scanner.nextDouble();
            scanner.nextLine(); 
        }

        // hitung ip semestr

        String[] nilaiHuruf  = new String[jumlahMK];
        double[] nilaiSetara = new double[jumlahMK];

        for (int i = 0; i < jumlahMK; i++) {
            double na = nilaiAngka[i];

            if (na > 80 && na <= 100) {
                nilaiHuruf[i]  = "A";
                nilaiSetara[i] = 4.0;
            } else if (na > 73 && na <= 80) {
                nilaiHuruf[i]  = "B+";
                nilaiSetara[i] = 3.5;
            } else if (na > 65 && na <= 73) {
                nilaiHuruf[i]  = "B";
                nilaiSetara[i] = 3.0;
            } else if (na > 60 && na <= 65) {
                nilaiHuruf[i]  = "C+";
                nilaiSetara[i] = 2.5;
            } else if (na > 50 && na <= 60) {
                nilaiHuruf[i]  = "C";
                nilaiSetara[i] = 2.0;
            } else if (na > 39 && na <= 50) {
                nilaiHuruf[i]  = "D";
                nilaiSetara[i] = 1.0;
            } else {
                nilaiHuruf[i]  = "E";
                nilaiSetara[i] = 0.0;
            }
        }

        // Hitung total bobot nilai dan total SKS
        double totalBobotNilai = 0;
        int    totalSKS        = 0;

        for (int i = 0; i < jumlahMK; i++) {
            totalBobotNilai += nilaiSetara[i] * sksMK[i];
            totalSKS        += sksMK[i];
        }

        double ipSemester = totalBobotNilai / totalSKS;

        // Output
        System.out.println("\nhasil Konversi Nilai");
        System.out.println("====================");
        System.out.printf("%-20s %-14s %-14s %-10s%n",
                          "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");

        for (int i = 0; i < jumlahMK; i++) {
            System.out.printf("%-20s %-14.2f %-14s %-10.2f%n",
                              namaMK[i],
                              nilaiAngka[i],
                              nilaiHuruf[i],
                              nilaiSetara[i]);
        }

        System.out.println("====================");
        System.out.printf("IP : %.2f%n", ipSemester);
        scanner.close();
    }
}