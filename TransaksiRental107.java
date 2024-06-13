public class TransaksiRental107 {
    private static int nextKodeTransaksi = 1;
    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private BarangRental107 barangRental;

    public TransaksiRental107(String namaPeminjam, int lamaPinjam, double totalBiaya, BarangRental107 barangRental) {
        this.kodeTransaksi = nextKodeTransaksi++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.totalBiaya = totalBiaya;
        this.barangRental = barangRental;
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public BarangRental107 getBarangRental() {
        return barangRental;
    }
}