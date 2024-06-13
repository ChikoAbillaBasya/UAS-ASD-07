import java.util.ArrayList;
import java.util.Scanner;

public class RentalBarangMain107 {
    private static ArrayList<BarangRental107> daftarKendaraan = new ArrayList<BarangRental107>();
    private static ArrayList<TransaksiRental107> daftarTransaksi = new ArrayList<TransaksiRental107>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi data kendaraan
        daftarKendaraan.add(new BarangRental107("B 1234 ABC", "Toyota Avanza", "Mobil", 2018, 200000));
        daftarKendaraan.add(new BarangRental107("D 4567 DEF", "Honda Brio", "Mobil", 2020, 150000));
        daftarKendaraan.add(new BarangRental107("F 7890 GHI", "Suzuki Ertiga", "Mobil", 2019, 180000));
        daftarKendaraan.add(new BarangRental107("H 0123 JKL", "Mitsubishi Pajero", "Mobil", 2021, 250000));
        daftarKendaraan.add(new BarangRental107("J 3456 MNO", "Nissan Terrano", "Mobil", 2022, 300000));

        while (true) {
            // Menampilkan menu
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampilkan seluruh tansaksi");
            System.out.println("4. Urutkan Transaksi urut no TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih(1-5) : ");

            int pilihan = sc.nextInt();
            sc.nextLine(); // Membuang newline

            switch (pilihan) {
                case 1:
                    tampilkanDaftarKendaraan();
                    break;
                case 2:
                    melakukanPeminjaman();
                    break;
                case 3:
                    tampilkanSeluruhTransaksi();
                    break;
                case 4:
                    urutkanTransaksiUrutNoTNKB();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tampilkanDaftarKendaraan() {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Kendaraan Rental Serba Serbi");
        System.out.println("++++++++++++++++++++++++++++++++++++");

        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada data kendaraan.");
            return;
        }

        for (BarangRental107 kendaraan : daftarKendaraan) {
            System.out.println("------------------------------------");
            System.out.println("No. TNKB        : " + kendaraan.getNoTNKB());
            System.out.println("Nama Kendaraan  : " + kendaraan.getNamaKendaraan());
            System.out.println("Jenis Kendaraan : " + kendaraan.getJenisKendaraan());
            System.out.println("Tahun           : " + kendaraan.getTahun());
            System.out.println("Biaya Sewa      : Rp " + kendaraan.getBiayaSewa());
            System.out.println("------------------------------------");
        }
    }

    private static void melakukanPeminjaman() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan Nama Peminjam : ");
        String namaPeminjam = scanner.nextLine();

        System.out.println("Pilih Kendaraan : ");
        tampilkanDaftarKendaraan();
        System.out.print("Masukkan No TNKB : ");
        String noTNKB = scanner.nextLine();

        BarangRental107 barangRental = null;
        for (BarangRental107 kendaraan : daftarKendaraan) {
            if (kendaraan.getNoTNKB().equals(noTNKB)) {
                barangRental = kendaraan;
                break;
            }
        }

        if (barangRental == null) {
            System.out.println("Kendaraan tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan Lama Pinjam (hari) : ");
        int lamaPinjam = scanner.nextInt();
        scanner.nextLine(); // Membuang newline

        double totalBiaya = lamaPinjam * barangRental.getBiayaSewa();

        TransaksiRental107 transaksi = new TransaksiRental107(namaPeminjam, lamaPinjam, totalBiaya, barangRental);
        daftarTransaksi.add(transaksi);

        System.out.print("====================");
        System.out.println("\nTransaksi Berhasil!");
        System.out.println("Kode Transaksi : " + transaksi.getKodeTransaksi());
        System.out.println("====================");
    }

    private static void tampilkanSeluruhTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada data transaksi.");
            return;
        }

        for (TransaksiRental107 transaksi : daftarTransaksi) {
            System.out.println("--------------------------------");
            System.out.println("Kode Transaksi : " + transaksi.getKodeTransaksi());
            System.out.println("Nama Peminjam  : " + transaksi.getNamaPeminjam());
            System.out.println("Lama Pinjam    : " + transaksi.getLamaPinjam() + " hari");
            System.out.println("Total Biaya    : Rp " + transaksi.getTotalBiaya());
            System.out.println("--------------------------------");
        }
    }

    private static void urutkanTransaksiUrutNoTNKB() {
        System.out.println("Fitur urutkan transaksi berdasarkan No TNKB belum diimplementasikan.");
    }
}