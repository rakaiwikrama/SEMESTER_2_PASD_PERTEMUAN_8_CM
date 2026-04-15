import java.util.Scanner;

public class main22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        peminjamanService22 service = new peminjamanService22();

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
            System.out.println("6. Tambah Data Peminjaman");
            System.out.println("7. Statistik");
            System.out.println("8. Laporan Per Mahasiswa");
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
                    System.out.println("=== Menggunakan Insertion Sort (Descending) ===");
                    // service.urutkanDenda(pinjam);
                    service.insertionSortByDendaDesc(pinjam);
                    // System.out.println("Setelah diurutkan:");
                    service.tampilSemua(pinjam);
                    break;

                case 5:
                    // sc.nextLine();
                    // System.out.print("Masukkan NIM: ");
                    // String nim = sc.nextLine();
                    // service.cariByNIM(pinjam, nim);
                    // break;

                    sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nimCari = sc.nextLine();

                    // service.urutkanByNIM(pinjam);
                    // service.binarySearchByNIM(pinjam, nimCari);
                    peminjaman22[] copy = service.copyArray(pinjam);
                    service.insertionSortByNIMAsc(copy);
                    service.binarySearchAllByNIM(copy, nimCari);
                    break;
                
                case 6:
                    sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nimBaru = sc.nextLine();
                    mahasiswa22 m = service.cariMahasiswa(mhs, nimBaru);
                    if (m == null) {
                        System.out.println("NIM tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine();
                    buku22 b = service.cariBuku(buku, kode);
                    if (b == null) {
                        System.out.println("Kode buku tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan Lama Pinjam: ");
                    int lama = sc.nextInt();
                    peminjaman22 baru = new peminjaman22(m, b, lama);
                    pinjam = service.tambahData(pinjam, baru);
                    System.out.println("Data peminjaman berhasil ditambahkan!");
                    break;

                case 7:
                    service.tampilStatistik(pinjam);
                    break;

                case 8:
                    System.out.println("\n=== LAPORAN PER MAHASISWA ===");
                    laporanMahasiswa22[] laporan = new laporanMahasiswa22[mhs.length];
                    for (int i = 0; i < mhs.length; i++) {
                        laporan[i] = new laporanMahasiswa22(mhs[i]); 
                        laporan[i].hitungLaporan(pinjam);          
                        laporan[i].tampilLaporan();                
                    }

                    break;
                
            }
        } while (pilih != 0);
    }
}