import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue antrian = new Queue(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        // instansiasi kendaraan
        Kendaraan[] kendaraan = new Kendaraan[4];
        
        kendaraan[0] = new Kendaraan("N11A", " Basko", "Mobil", 2000, 2012, 4);
        kendaraan[1] = new Kendaraan("N22B", "Arta", "Mobil", 2500, 2015, 3);
        kendaraan[2] = new Kendaraan("N33C", "Wisnu", "Motor", 125, 2010, 2);
        kendaraan[3] = new Kendaraan("N44D", "Sisa", "Motor", 150, 2020, 1);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan transaksi berdasarkan nama Pemilik");
            System.out.println("5. keluar");
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    cetakKendaraan(kendaraan);
                    break;
            
                    case 2:
                        System.out.println("Bayar Pajak");
                        System.out.println("===============================");
                        System.out.println("Masukkan data pembayaran!");
                        System.out.println("===============================");
                        System.out.print("Masukkan nomor TNKB: ");
                        String noTNKB = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Masukkan Bulan Bayar: ");
                        int bulanYgDibayarkanBayar = sc.nextInt();
                        
                        antrian.enqueue(searchKendaraan(kendaraan, noTNKB), bulanYgDibayarkanBayar);
                        break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void cetakKendaraan(Kendaraan[] kendaraan){
        System.out.println("Daftar Kendaraan");
        System.out.println("===============================");
        System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |\n", "No TNKB", "Nama Pemilik", "Jenis", "CC Kendaraan", "Tahun", "Bulan Harus Bayar");
        for (int i = 0; i < kendaraan.length; i++) {
            System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |\n", kendaraan[i].noTNKB, kendaraan[i].nama, kendaraan[i].jenis, kendaraan[i].cc, kendaraan[i].tahun, kendaraan[i].bulanHarusBayar);
        }
    }

    public static Kendaraan searchKendaraan(Kendaraan[] kendaraan,String noTNKB){
        for (int i = 0; i < kendaraan.length; i++) {
            if (kendaraan[i].noTNKB.equals(noTNKB)) {
                return kendaraan[i];
            }
            
        }
        return null;
    }
}
