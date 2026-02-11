public class RoyalGarden15 {


    static String[] namaCabang = {
        "RoyalGarden 1",
        "RoyalGarden 2",
        "RoyalGarden 3",
        "RoyalGarden 4"
    };

    static String[] namaBunga = {"Aglonema", "Keladi", "Alocasia", "Mawar"};

    static int[][] stock = {
        {10, 5, 15, 7},   // RoyalGarden 1
        {6, 11, 9, 12},   // RoyalGarden 2
        {2, 10, 10, 5},   // RoyalGarden 3
        {5, 7, 12, 9}     // RoyalGarden 4
    };

    static int[] harga = {75000, 50000, 60000, 10000};
    // Aglonema=75.000, Keladi=50.000, Alocasia=60.000, Mawar=10.000


    // fungsi 1, menghitung pendapatan 1 cabang
    static long hitungPendapatan(int[] stockCabang) {
        long total = 0;
        for (int i = 0; i < harga.length; i++) {
            total += (long) stockCabang[i] * harga[i];
        }
        return total;
    }


    //fungsi 2,menentukan satus cabang berdasarkan pendapatan
    static String cekStatus(long pendapatan) {
        if (pendapatan > 1500000) {
            return "Sangat Baik";
        } else {
            return "Perlu Evaluasi";
        }
    }


    //fungsi 3 ,mengubah format ke rupiah
    static String formatRupiah(long angka) {
        String str = String.valueOf(angka);
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                result.insert(0, ".");
            }
            result.insert(0, str.charAt(i));
            count++;
        }
        return "Rp" + result.toString();
    }


    //fungsi 4 menampilan stok bunga
    static void tampilkanStock() {
        System.out.println("=".repeat(65));
        System.out.println("               DATA STOCK BUNGA ROYALGARDEN");
        System.out.println("=".repeat(65));
        System.out.printf("%-16s %-12s %-10s %-12s %-8s%n",
            "Cabang", "Aglonema", "Keladi", "Alocasia", "Mawar");
        System.out.println("-".repeat(65));

        for (int i = 0; i < namaCabang.length; i++) {
            System.out.printf("%-16s %-12d %-10d %-12d %-8d%n",
                namaCabang[i],
                stock[i][0],
                stock[i][1],
                stock[i][2],
                stock[i][3]);
        }
        System.out.println("=".repeat(65));
    }


    //fungsi 5,laporan pendapatan sluruh cabang
    static long[] tampilkanPendapatan() {
        System.out.println();
        System.out.println("=".repeat(65));
        System.out.println("          LAPORAN PENDAPATAN ROYALGARDEN");
        System.out.println("          (Jika Semua Bunga Habis Terjual)");
        System.out.println("=".repeat(65));

        long[] semuaPendapatan = new long[namaCabang.length];

        for (int i = 0; i < namaCabang.length; i++) {
            semuaPendapatan[i] = hitungPendapatan(stock[i]);
            System.out.printf("%-16s : %s%n",
                namaCabang[i],
                formatRupiah(semuaPendapatan[i]));
        }

        System.out.println("=".repeat(65));
        return semuaPendapatan;
    }


    //fungsi 6, menampilkan status cabang
    static void tampilkanStatus(long[] semuaPendapatan) {
        System.out.println();
        System.out.println("=".repeat(65));
        System.out.println("              STATUS SETIAP CABANG");
        System.out.println("  (Sangat Baik jika pendapatan > Rp1.500.000)");
        System.out.println("=".repeat(65));

        for (int i = 0; i < namaCabang.length; i++) {
            String status = cekStatus(semuaPendapatan[i]);
            System.out.printf("%-16s : %-20s [%s]%n",
                namaCabang[i],
                status,
                formatRupiah(semuaPendapatan[i]));
        }

        System.out.println("=".repeat(65));
    }


    // fungsi main
    public static void main(String[] args) {

        System.out.println();
        System.out.println("  *** PROGRAM ROYALGARDEN - TOKO BUNGA ***");
        System.out.println();

        // Tampilkan data stock
        tampilkanStock();

        // Hitung dan tampilkan pendapatan
        long[] pendapatan = tampilkanPendapatan();

        // Tampilkan status setiap cabang
        tampilkanStatus(pendapatan);

        System.out.println();
    }
}