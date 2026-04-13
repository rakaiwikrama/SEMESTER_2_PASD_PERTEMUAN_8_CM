import java.util.Scanner;

public class main22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        peminjamanService22 service = new peminjamanService22();

        // ===== DATA =====
        mahasiswa22[] mhs = {
            new mahasiswa22("22001", "Andi", "Teknik Informatika"),
            new mahasiswa22("22002", "Budi", "Teknik Informatika"),
            new mahasiswa22("22003", "Citra", "Sistem Informasi Bisnis")
        };

        buku22[] buku = {
            new buku22("B001", "Algoritma", 2020),
            new buku22("B002", "Basis Data", 2019),
            new buku22("B003", "Pemrograman", 2021),
            new buku22("B004", "Fisika", 2024)
        };

        peminjaman22[] pinjam = {
            new peminjaman22(mhs[0], buku[0], 7),
            new peminjaman22(mhs[1], buku[1], 3),
            new peminjaman22(mhs[2], buku[2], 10),
            new peminjaman22(mhs[2], buku[3], 6),
            new peminjaman22(mhs[0], buku[1], 4)
        };

        int pilih;

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    for (mahasiswa22 m : mhs) m.tampilMahasiswa();
                    break;

                case 2:
                    for (buku22 b : buku) b.tampilBuku();
                    break;

                case 3:
                    service.tampilSemua(pinjam);
                    break;

                case 4:
                    service.urutkanDenda(pinjam);
                    System.out.println("Setelah diurutkan:");
                    service.tampilSemua(pinjam);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.nextLine();
                    service.cariByNIM(pinjam, nim);
                    break;
            }

        } while (pilih != 0);

        sc.close();
    }
}