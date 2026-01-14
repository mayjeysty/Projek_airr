package Projek_airr;

class Pelanggan {


    protected String namaPelanggan;
    protected String nomorPelanggan;

    // Setter untuk isi nama pelanggan
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    // Setter untuk isi nomor pelanggan
    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }

    // Method buat nampilin data pelanggan
    public void tampilkanInfo() {
        System.out.println("Nama   : " + namaPelanggan);
        System.out.println("Nomor  : " + nomorPelanggan);
    }
}

// Class ini untuk perhitungan tagihan air
// Class ini mewarisi dari Pelanggan
class Tagihan extends Pelanggan {

    // Data pemakaian dan keterlambatan
    protected int pemakaian;
    protected int keterlambatan;

    // Tarif dan biaya tambahan
    protected int tarif = 2000;
    protected int biayaAdmin = 2500;

    // Hasil perhitungan
    protected double totalTagihan;
    protected double denda;
    protected double totalBayar;

    // Setter untuk pemakaian air
    public void setPemakaian(int pemakaian) {
        this.pemakaian = pemakaian;
    }

    // Setter untuk keterlambatan
    public void setKeterlambatan(int keterlambatan) {
        this.keterlambatan = keterlambatan;
    }

    public void hitungTagihan(int hariTelat) {

        totalTagihan = pemakaian * tarif;

        if (hariTelat > 0) {
            denda = totalTagihan * 0.5;
        } else {
            denda = 0;
        }

        totalBayar = totalTagihan + biayaAdmin + denda;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Pelanggan  : " + namaPelanggan);
        System.out.println("Nomor Pelanggan : " + nomorPelanggan);
        System.out.println("Pemakaian Air   : " + pemakaian + " m³");
        System.out.println("Total Tagihan   : Rp " + totalTagihan);
        System.out.println("Biaya Admin     : Rp " + biayaAdmin);
        System.out.println("Denda           : Rp " + denda);
        System.out.println("------------------------------");
        System.out.println("Total Bayar     : Rp " + totalBayar);
    }
}


class Pembayaran extends Tagihan {

    // Data metode dan status pembayaran
    private String metodePembayaran;
    private String statusPembayaran;
    private String tanggalPembayaran;

    // Setter metode pembayaran
    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    // Setter status pembayaran
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    // Setter tanggal pembayaran
    public void setTanggalPembayaran(String tanggalPembayaran) {
        this.tanggalPembayaran = tanggalPembayaran;
    }
}
