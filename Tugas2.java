import java.util.Scanner;

public class Tugas2 {

    static Scanner scanner = new Scanner(System.in);


    // Fungsi 1: Menginput data jadwal kuliah ke array 2d
    static String[][] inputJadwal(int n) {
        String[][] jadwal = new String[n][4];

        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println("         INPUT DATA JADWAL KULIAH");
        System.out.println("=".repeat(50));

        for (int i = 0; i < n; i++) {
            System.out.println("\n  [ Jadwal ke-" + (i + 1) + " ]");
            System.out.print("  Nama Mata Kuliah : ");
            jadwal[i][0] = scanner.nextLine();

            System.out.print("  Ruang            : ");
            jadwal[i][1] = scanner.nextLine();

            System.out.print("  Hari Kuliah      : ");
            jadwal[i][2] = scanner.nextLine();

            System.out.print("  Jam Kuliah       : ");
            jadwal[i][3] = scanner.nextLine();
        }

        System.out.println();
        System.out.println("  Data berhasil disimpan!");
        return jadwal;
    }


    // Fungsi 2: Menampilkan seluruh jadwal dalam bentuk tabel

    static void tampilkanSemuaJadwal(String[][] jadwal) {
        System.out.println();
        System.out.println("=".repeat(75));
        System.out.println("                    SELURUH JADWAL KULIAH");
        System.out.println("=".repeat(75));
        System.out.printf(" %-3s | %-22s | %-18s | %-10s | %-12s%n",
            "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("-".repeat(75));

        if (jadwal.length == 0) {
            System.out.println("  Belum ada data jadwal.");
        } else {
            for (int i = 0; i < jadwal.length; i++) {
                System.out.printf(" %-3d | %-22s | %-18s | %-10s | %-12s%n",
                    (i + 1),
                    jadwal[i][0],
                    jadwal[i][1],
                    jadwal[i][2],
                    jadwal[i][3]);
            }
        }

        System.out.println("=".repeat(75));
        System.out.println("  Total jadwal: " + jadwal.length + " mata kuliah");
        System.out.println("=".repeat(75));
    }


    // Fungsi 3: Menampilkan jadwal berdasarkan hari tertentu

    static void cariJadwalByHari(String[][] jadwal, String hari) {
        System.out.println();
        System.out.println("=".repeat(75));
        System.out.println("  JADWAL KULIAH HARI : " + hari.toUpperCase());
        System.out.println("=".repeat(75));
        System.out.printf(" %-3s | %-22s | %-18s | %-12s%n",
            "No", "Mata Kuliah", "Ruang", "Jam");
        System.out.println("-".repeat(75));

        int count = 0;
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hari)) {
                count++;
                System.out.printf(" %-3d | %-22s | %-18s | %-12s%n",
                    count,
                    jadwal[i][0],
                    jadwal[i][1],
                    jadwal[i][3]);
            }
        }

        if (count == 0) {
            System.out.println("  Tidak ada jadwal kuliah pada hari " + hari + ".");
        }

        System.out.println("=".repeat(75));
        System.out.println("  Ditemukan: " + count + " jadwal");
        System.out.println("=".repeat(75));
    }


    // Fungsi 4: Menampilkan jadwal berdasarkan nama mata kuliah

    static void cariJadwalByMatkul(String[][] jadwal, String namaMatkul) {
        System.out.println();
        System.out.println("=".repeat(75));
        System.out.println("  HASIL PENCARIAN : \"" + namaMatkul + "\"");
        System.out.println("=".repeat(75));
        System.out.printf(" %-3s | %-22s | %-18s | %-10s | %-12s%n",
            "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("-".repeat(75));

        int count = 0;
        for (int i = 0; i < jadwal.length; i++) {
            // Pencarian dengan contains (tidak harus nama lengkap)
            if (jadwal[i][0].toLowerCase().contains(namaMatkul.toLowerCase())) {
                count++;
                System.out.printf(" %-3d | %-22s | %-18s | %-10s | %-12s%n",
                    count,
                    jadwal[i][0],
                    jadwal[i][1],
                    jadwal[i][2],
                    jadwal[i][3]);
            }
        }

        if (count == 0) {
            System.out.println("  Mata kuliah \"" + namaMatkul + "\" tidak ditemukan.");
        }

        System.out.println("=".repeat(75));
        System.out.println("  Ditemukan: " + count + " data");
        System.out.println("=".repeat(75));
    }


    // fungsi main
    static void tampilkanMenu() {
        System.out.println();
        System.out.println("=".repeat(40));
        System.out.println("       MENU JADWAL KULIAH");
        System.out.println("=".repeat(40));
        System.out.println("  1. Input Jadwal Kuliah");
        System.out.println("  2. Tampilkan Semua Jadwal");
        System.out.println("  3. Cari Jadwal Berdasarkan Hari");
        System.out.println("  4. Cari Jadwal Berdasarkan Mata Kuliah");
        System.out.println("  0. Keluar");
        System.out.println("=".repeat(40));
        System.out.print("  Pilihan Anda: ");
    }


    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {
        System.out.println();
        System.out.println("  *** SISTEM MANAJEMEN JADWAL KULIAH ***");

        String[][] jadwal = new String[0][4]; // array kosong awal
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = Integer.parseInt(scanner.nextLine().trim());

            switch (pilihan) {
                case 1:
                    System.out.print("\n  Masukkan jumlah jadwal kuliah (n): ");
                    int n = Integer.parseInt(scanner.nextLine().trim());
                    jadwal = inputJadwal(n);
                    break;

                case 2:
                    tampilkanSemuaJadwal(jadwal);
                    break;

                case 3:
                    System.out.print("\n  Masukkan hari yang dicari: ");
                    String hari = scanner.nextLine();
                    cariJadwalByHari(jadwal, hari);
                    break;

                case 4:
                    System.out.print("\n  Masukkan nama mata kuliah yang dicari: ");
                    String matkul = scanner.nextLine();
                    cariJadwalByMatkul(jadwal, matkul);
                    break;

                case 0:
                    System.out.println();
                    System.out.println("  Program selesai. Terima kasih!");
                    System.out.println();
                    break;

                default:
                    System.out.println("  Pilihan tidak valid. Coba lagi.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}