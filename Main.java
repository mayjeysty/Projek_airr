package Projek_airr;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Tagihan> daftarPembayaran = new ArrayList<>();

        Tagihan pembayaran = new Tagihan();

    
        System.out.print("Nama Pelanggan: ");
        pembayaran.setNamaPelanggan(input.nextLine()); 

        System.out.print("Nomor Pelanggan: ");
        pembayaran.setNomorPelanggan(input.nextLine()); 

        int pemakaian = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Pemakaian (m³): ");
                pemakaian = input.nextInt();
                pembayaran.setPemakaian(pemakaian); 
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Input harus berupa angka!");
                input.nextLine(); 
            }
        }

        int telat = 0;
        validInput = false;

        while (!validInput) {
            try {
                System.out.print("Keterlambatan (hari): ");
                telat = input.nextInt();
                pembayaran.setKeterlambatan(telat); 
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Input harus berupa angka!");
                input.nextLine();
            }
        }

        pembayaran.hitungTagihan(telat);
        daftarPembayaran.add(pembayaran);
        System.out.println("\nDetail Pembayaran");

        for (Tagihan t : daftarPembayaran) {
            t.tampilkanInfo(); 
        }

        input.close();
    }
}
