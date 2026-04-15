class laporanMahasiswa22 {
    mahasiswa22 mahasiswa;   
    int totalPinjam;         
    int totalDenda;          
    int totalTerlambat;      

    laporanMahasiswa22(mahasiswa22 mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    void hitungLaporan(peminjaman22[] pinjam) {
        totalPinjam = 0;
        totalDenda = 0;
        totalTerlambat = 0;

        for (peminjaman22 p : pinjam) {
            if (p.mhs.nim.equals(mahasiswa.nim)) {
                totalPinjam++;
                totalDenda += p.denda;

                if (p.terlambat > 0) {
                    totalTerlambat++;
                }
            }
        }
    }

    void tampilLaporan() {
        System.out.println(
            "NIM: " + mahasiswa.nim +
            " | Nama: " + mahasiswa.nama +
            " | Total Pinjam: " + totalPinjam +
            " | Total Denda: Rp " + totalDenda +
            " | Terlambat: " + totalTerlambat + "x"
        );
    }
}