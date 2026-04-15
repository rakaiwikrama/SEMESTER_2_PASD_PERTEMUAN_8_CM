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

    void insertionSortByNIMAsc(peminjaman22[] data) {
        for (int i = 1; i < data.length; i++) {
                peminjaman22 key = data[i];
                int j = i - 1;
                while (j >= 0 && data[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                    data[j + 1] = data[j];
                    j--;
                }
                data[j + 1] = key;
        }
    }

    void insertionSortByDendaDesc(peminjaman22[] data) {
        for (int i = 1; i < data.length; i++) {
            peminjaman22 key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j].denda < key.denda) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }

    void binarySearchAllByNIM(peminjaman22[] data, String nim) {
        int left = 0;
        int right = data.length - 1;
        int found = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hasil = data[mid].mhs.nim.compareTo(nim);

            if (hasil == 0) {
                found = mid;
                break;
            } else if (hasil < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found == -1) {
            System.out.println("Data tidak ditemukan!");
            return;
        }

        System.out.println("=== [Binary Search] Hasil ===");

        data[found].tampilPeminjaman();


        int i = found - 1; //kiri
        while (i >= 0 && data[i].mhs.nim.equals(nim)) {
            data[i].tampilPeminjaman();
            i--;
        }

    
        i = found + 1; //nganan
        while (i < data.length && data[i].mhs.nim.equals(nim)) {
            data[i].tampilPeminjaman();
            i++;
        }
    }

    peminjaman22[] copyArray(peminjaman22[] data) {
        peminjaman22[] copy = new peminjaman22[data.length];
            for (int i = 0; i < data.length; i++) {
                copy[i] = data[i];
            }
            return copy;
    }

    void cariByNIM(peminjaman22[] data, String nim) { //sequential
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

    void urutkanByNIM(peminjaman22[] data) { //selection sorting
    for (int i = 0; i < data.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j].mhs.nim.compareTo(data[min].mhs.nim) < 0) {
                    min = j; 
                }
            }

            peminjaman22 temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    void bubbleSortByNIM(peminjaman22[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {

                if (data[j].mhs.nim.compareTo(data[j + 1].mhs.nim) > 0) {
                    peminjaman22 temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }

            }
        }
    }

    void insertionSortByNIM(peminjaman22[] data) {
        for (int i = 1; i < data.length; i++) {
            peminjaman22 key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key; 
        }
    }



    void binarySearchByNIM(peminjaman22[] data, String nim) {
        int left = 0;
        int right = data.length - 1;
        boolean ketemu = false;

        while (left <= right) {
            int mid = (left + right) / 2; 

            int hasil = data[mid].mhs.nim.compareTo(nim);

            if (hasil == 0) {
                data[mid].tampilPeminjaman();
                ketemu = true;
                break;
            } else if (hasil < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!ketemu) {
            System.out.println("Data tidak ditemukan!");
        }
    }

    mahasiswa22 cariMahasiswa(mahasiswa22[] data, String nim) {
        for (mahasiswa22 m : data) {
            if (m.nim.equals(nim)) {
                return m;
            }
        }
        return null;
    }



    buku22 cariBuku(buku22[] data, String kode) {
        for (buku22 b : data) {
            if (b.kodeBuku.equals(kode)) {
                return b;
            }
        }
        return null;
    }



    peminjaman22[] tambahData(peminjaman22[] data, peminjaman22 baru) {
    peminjaman22[] newArr = new peminjaman22[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[i]; 
        }
        newArr[data.length] = baru; 
        return newArr;
    }

    void tampilStatistik(peminjaman22[] data) {
    int totalDenda = 0;
    int jumlahTerlambat = 0;
    int tepatWaktu = 0;
        for (peminjaman22 p : data) {
            totalDenda += p.denda;
            if (p.terlambat > 0) {
                jumlahTerlambat++;
            } else {
                tepatWaktu++;
            }
        }
    System.out.println("\n=== STATISTIK PEMINJAMAN ===");
    System.out.println("Total Denda Keseluruhan: Rp " + totalDenda);
    System.out.println("Jumlah Peminjaman Terlambat: " + jumlahTerlambat);
    System.out.println("Jumlah Peminjaman Tepat Waktu: " + tepatWaktu);
    }


}