import java.util.Scanner;

public class NilaiAkhir15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Nilai
        System.out.println("=== Program Kalkulator Nilai Akhir Mahasiswa ===");
        System.out.print("Masukkan Nilai Tugas  (0-100): ");
        double nilaiTugas = scanner.nextDouble();

        System.out.print("Masukkan Nilai Kuis   (0-100): ");
        double nilaiKuis = scanner.nextDouble();

        System.out.print("Masukkan Nilai UTS    (0-100): ");
        double nilaiUTS = scanner.nextDouble();

        System.out.print("Masukkan Nilai UAS    (0-100): ");
        double nilaiUAS = scanner.nextDouble();

        // Validasi nilai 
        if (nilaiTugas < 0 || nilaiTugas > 100 ||
            nilaiKuis  < 0 || nilaiKuis  > 100 ||
            nilaiUTS   < 0 || nilaiUTS   > 100 ||
            nilaiUAS   < 0 || nilaiUAS   > 100) {

            System.out.println("nilai tidak valid");

        } else {

            // Menghitung nilai akhir
            //dengan bobot : tugas 20%, kuis 20%, UTS 30%, UAS 30%
            double nilaiAkhir = (nilaiTugas * 0.20)
                              + (nilaiKuis  * 0.20)
                              + (nilaiUTS   * 0.30)
                              + (nilaiUAS   * 0.30);

            String  nilaiHuruf;
            double  nilaiSetara;
            String  kualifikasi;
            String  kelulusan;

            if (nilaiAkhir > 80 && nilaiAkhir <= 100) {
                nilaiHuruf  = "A";
                nilaiSetara = 4;
                kualifikasi = "Sangat Baik";
                kelulusan   = "LULUS";
            } else if (nilaiAkhir > 73 && nilaiAkhir <= 80) {
                nilaiHuruf  = "B+";
                nilaiSetara = 3.5;
                kualifikasi = "Lebih dari Baik";
                kelulusan   = "LULUS";
            } else if (nilaiAkhir > 65 && nilaiAkhir <= 73) {
                nilaiHuruf  = "B";
                nilaiSetara = 3;
                kualifikasi = "Baik";
                kelulusan   = "LULUS";
            } else if (nilaiAkhir > 60 && nilaiAkhir <= 65) {
                nilaiHuruf  = "C+";
                nilaiSetara = 2.5;
                kualifikasi = "Lebih dari Cukup";
                kelulusan   = "LULUS";
            } else if (nilaiAkhir > 50 && nilaiAkhir <= 60) {
                nilaiHuruf  = "C";
                nilaiSetara = 2;
                kualifikasi = "Cukup";
                kelulusan   = "LULUS";
            } else if (nilaiAkhir > 39 && nilaiAkhir <= 50) {
                nilaiHuruf  = "D";
                nilaiSetara = 1;
                kualifikasi = "Kurang";
                kelulusan   = "TIDAK LULUS";
            } else {
                // nilaiAkhir <= 39
                nilaiHuruf  = "E";
                nilaiSetara = 0;
                kualifikasi = "Gagal";
                kelulusan   = "TIDAK LULUS";
            }

            // OUTPUT HASIL
            System.out.println("\n=== Hasil Nilai Akhir ===");
            System.out.printf("Nilai Akhir    : %.2f%n", nilaiAkhir);
            System.out.println("Nilai Huruf    : " + nilaiHuruf);
            System.out.println("Nilai Setara   : " + nilaiSetara);
            System.out.println("Kualifikasi    : " + kualifikasi);
            System.out.println("Keterangan     : " + kelulusan);
        }

        scanner.close();
    }
}