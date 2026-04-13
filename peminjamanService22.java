class peminjamanService22 {

    void tampilSemua(peminjaman22[] data) {
        for (peminjaman22 p : data) {
            p.tampilPeminjaman();
        }
    }

    void urutkanDenda(peminjaman22[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].denda > data[max].denda) {
                    max = j;
                }
            }
            peminjaman22 temp = data[i];
            data[i] = data[max];
            data[max] = temp;
        }
    }

    void cariByNIM(peminjaman22[] data, String nim) {
        boolean ketemu = false;

        for (peminjaman22 p : data) {
            if (p.mhs.nim.equals(nim)) {
                p.tampilPeminjaman();
                ketemu = true;
            }
        }

        if (!ketemu) {
            System.out.println("Data tidak ditemukan!");
        }
    }
}