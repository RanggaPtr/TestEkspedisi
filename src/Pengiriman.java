import java.util.Scanner;

public class Pengiriman {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Scanner angka = new Scanner(System.in);

    //Variabel login
    String[][] userAdmin = {
      { "ADM1", "Firmansyah", "admin", "admin123", "Admin" },
      { "ADM2", "Setyo Handoko", "admin1", "admin1", "Admin" },
    };

    String[][] userPetugas = {
      { "PTG1", "Budi", "petugas", "petugas123", "Petugas" },
      { "PTG2", "Joko", "petugas2", "petugas222", "Petugas" },
    };
    String username = "", password;
    boolean isLogin = true;

    String[] detailPengiriman = {
      "Kode Pengiriman",
      "Nama Pengirim",
      "Nama Penerima",
      "Tanggal Kirim",
      "Tanggal Terima",
      "Alamat Pengiriman",
      "Status Paket",
      "Berat Paket",
      "Tujuan Pengiriman",
      "Total Harga",
    };

    //Variabel Pengiriman
    String[][] pengiriman = {
      {
        "EXP123",
        "Suparman",
        "Paijo",
        "08-09-2023",
        null,
        "\nJl. Plaza Boulevard Jl. Pemuda No.33 - 37,\nEmbong Kaliasin, Kec. Genteng, Surabaya,\nJawa Timur 60271",
        "Dikirim",
        "2",
        "Surabaya",
        "Sumber Pocung",
      },
      {
        "REG123",
        "Jono",
        "Joko",
        "08-10-2023",
        "08-15-2023",
        "\nJl. Raya,\nRangkah Kidul, Kec. Kediri, Kabupaten Kediri,\nJawa Timur 61232",
        "Selesai",
        "Kediri",
        "Sampai Tujuan",
      },
    };
    String[][] malang = {
      { "Surabaya", "5000", "7000", "10000" },
      { "Kediri", "6000", "8000", "11000" },
      { "Jogjakarta", "7000", "9000", "12000" },
      { "Jakarta", "10000", "12000", "15000" },
      { "Bogor", "10000", "12000", "15000" },
    };

    boolean checkRole = true;
    System.out.print("\033[H\033[2J");
    while (checkRole) {
      System.out.print("\033[H\033[2J");
      System.out.print(
        "Selamat Datang di Sistem Pengiriman\nMasuk sebagai : \n1.Admin\n2.Petugas\n3.Keluar\n"
      );

      System.out.print("Pilih Level Pengguna ? (1-3): ");
      String pilih = input.nextLine();

      if (pilih.equalsIgnoreCase("1") || pilih.equalsIgnoreCase("2")) {
        if (pilih.equalsIgnoreCase("1")) {
          boolean isLoginAdmin = false;
          System.out.print("\033[H\033[2J");
          while (isLogin) {
            System.out.print("\033[H\033[2J");
            System.out.println("Login Admin");
            System.out.print("Username: ");
            username = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            for (int j = 0; j < userAdmin.length; j++) {
              if (
                username.equals(userAdmin[j][2]) &&
                password.equals(userAdmin[j][3])
              ) {
                isLogin = false;
                isLoginAdmin = true;
                break;
              } else {
                isLogin = true;
                System.out.println(
                  "\nUsername atau Password yang anda masukkan salah\n"
                );
                break;
              }
            }
          }

          System.out.print("\033[H\033[2J");
          while (isLoginAdmin) {
            System.out.print("\033[H\033[2J");
            System.out.println(
              "Menu Admin\n1. Manajemen Petugas\n2. Manajemen Pengiriman\n3. Laporan Pengiriman\n4. Manajemen Kota Tujuan\n5. Back\n6. keluar"
            );

            System.out.print("Pilih Menu ? (1-5) : ");
            String pilihMenuAdmin = input.nextLine();

            switch (pilihMenuAdmin) {
              case "1":
                boolean isManagePetugas = true;
                System.out.print("\033[H\033[2J");
                while (isManagePetugas) {
                  System.out.print("\033[H\033[2J");
                  System.out.println(
                    "Menu Manajemen Petugas\n1. Input Data Petugas\n2. Edit Data Petugas\n3. Hapus Data Petugas\n4. Back"
                  );

                  System.out.print("Pilih Menu Manajemen Petugas: ");
                  pilihMenuAdmin = input.nextLine();

                  boolean isMenuPetugas = true;
                  switch (pilihMenuAdmin) {
                    case "1":
                      System.out.print("\033[H\033[2J");
                      while (isMenuPetugas) {
                        System.out.print("\033[H\033[2J");
                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.println("Input Data Petugas ");
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Nama Lengkap : ");
                        String nama = input.nextLine();
                        System.out.print("Username : ");
                        String usernameInput = input.nextLine();
                        System.out.print("Password : ");
                        String passwordInput = input.nextLine();

                        String tambahPetugas[][] = new String[userPetugas.length +
                        1][5];

                        for (int i = 0; i < userPetugas.length; i++) {
                          tambahPetugas[i] = userPetugas[i];
                        }

                        for (
                          int i = userPetugas.length;
                          i < tambahPetugas.length;
                          i++
                        ) {
                          int idPetugas = 2;
                          int newId = ++idPetugas;
                          tambahPetugas[i] = new String[5];
                          tambahPetugas[i][0] = "PTG" + String.valueOf(newId);
                          tambahPetugas[i][1] = nama;
                          tambahPetugas[i][2] = usernameInput;
                          tambahPetugas[i][3] = passwordInput;
                          tambahPetugas[i][4] = "Petugas";
                          idPetugas = newId;
                        }
                        userPetugas = tambahPetugas;
                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Kembali ke menu (y)? ");
                        String ulang = input.nextLine();
                        if (ulang.equalsIgnoreCase("y")) {
                          isMenuPetugas = false;
                        }
                      }
                      break;
                    case "2":
                      System.out.print("\033[H\033[2J");
                      while (isMenuPetugas) {
                        System.out.print("\033[H\033[2J");
                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Petugas Yang Ingin Di Edit : ");
                        String oldIndex = input.nextLine();
                        System.out.println(
                          "============================================================="
                        );
                        System.out.println("Edit Data Petugas ");
                        System.out.println(
                          "============================================================="
                        );

                        int index = 0;
                        for (int i = 0; i < userPetugas.length; i++) {
                          if (userPetugas[i][0].equals(oldIndex)) {
                            index = i;
                          }
                        }

                        String editPetugas[] = userPetugas[index];
                        System.out.print("ID Petugas : ");
                        String kode = input.nextLine();
                        System.out.print("Nama Lengkap : ");
                        String nama = input.nextLine();
                        System.out.print("Username : ");
                        String usernameInput = input.nextLine();
                        System.out.print("Password : ");
                        String passwordInput = input.nextLine();

                        editPetugas[0] = kode;
                        editPetugas[1] = nama;
                        editPetugas[2] = usernameInput;
                        editPetugas[3] = passwordInput;
                        editPetugas[4] = "Petugas";

                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Kembali ke menu (y)? ");
                        String ulang = input.nextLine();
                        if (ulang.equalsIgnoreCase("y")) {
                          isMenuPetugas = false;
                        }
                      }
                      break;
                    case "3":
                      System.out.print("\033[H\033[2J");
                      while (isMenuPetugas) {
                        System.out.print("\033[H\033[2J");
                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Petugas Yang Ingin Di Hapus : ");
                        String oldIndex = input.nextLine();

                        String hapusUser[][] = new String[userPetugas.length -
                        1][5];
                        int index = 0;

                        for (int i = 0; i < userPetugas.length; i++) {
                          if (userPetugas[i][0].equals(oldIndex)) continue;
                          hapusUser[index] = userPetugas[i];
                          index++;
                        }
                        userPetugas = hapusUser;

                        System.out.println(
                          "============================================================="
                        );
                        System.out.printf(
                          "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                          "ID",
                          "Nama",
                          "Username",
                          "Password",
                          "Role"
                        );
                        System.out.println(
                          "============================================================="
                        );
                        for (String[] user : userPetugas) {
                          System.out.printf(
                            "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                            user[0],
                            user[1],
                            user[2],
                            user[3],
                            user[4]
                          );
                        }
                        System.out.println(
                          "============================================================="
                        );
                        System.out.print("Kembali ke menu (y)? ");
                        String ulang = input.nextLine();
                        if (ulang.equalsIgnoreCase("y")) {
                          isMenuPetugas = false;
                        }
                      }
                      break;
                    case "4":
                      isManagePetugas = false;
                      break;
                    default:
                      System.out.println("\nInput Menu tidak valid\n");
                      break;
                  }
                }
                break;
              case "2":
                boolean isManagePengiriman = true;
                System.out.print("\033[H\033[2J");
                while (isManagePengiriman) {
                  System.out.print("\033[H\033[2J");
                  System.out.println(
                    "Menu Manajemen Pengiriman\n1. Menu Data Pengiriman\n2. Lacak Pengiriman\n3. Manajemen Lokasi Tujuan\n4. Back"
                  );

                  System.out.print("Pilih Menu Manajemen Pengiriman : ");
                  pilihMenuAdmin = input.nextLine();

                  switch (pilihMenuAdmin) {
                    case "1":
                      boolean isCrudPengiriman = true;
                      System.out.print("\033[H\033[2J");
                      while (isCrudPengiriman) {
                        System.out.print("\033[H\033[2J");
                        System.out.println(
                          "List Menu Data Pengiriman\n1. Input Data Pengiriman\n2. Cetak resi Paket\n3. Ganti Status Paket\n4. Back"
                        );

                        System.out.print("Pilih Menu Data Pengiriman : ");
                        String PilihMenuDataPengiriman = input.nextLine();

                        switch (PilihMenuDataPengiriman) {
                          case "1":
                            boolean isTambahPaket = true;
                            while (isTambahPaket) {
                              for (int i = 0; i < malang.length; i++) {
                                System.out.println(
                                  (i + 1) + ". " + malang[i][0]
                                );
                              }
                              System.out.print("Pilih kota tujuan (nomor): ");
                              int kotaInput = angka.nextInt();
                              System.out.println("input data pengiriman");
                              System.out.println("Masukkan ID Pengiriman");
                              pengiriman[0][0] = input.nextLine();
                              System.out.println("Masukkan Nama pengirim");
                              pengiriman[0][1] = input.nextLine();
                              System.out.println("MAsukkan Nama penerima");
                              pengiriman[0][2] = input.nextLine();
                              System.out.println(
                                "Masukkan asal pengirim(malang)"
                              );
                              //   System.out.println("Masukkan tujuan pengirim");
                              //   pengiriman[0][8] = input.nextLine();
                              System.out.println("Masukkan alamat pengiriman");
                              pengiriman[0][5] = input.nextLine();
                              System.out.println("Masukkan tanggal pengiriman");
                              pengiriman[0][3] = input.nextLine();
                              System.out.println("Masukkan Status pengiriman");
                              pengiriman[0][3] = input.nextLine();

                              System.out.println("\nJenis layanan:");
                              System.out.println("1. Hemat");
                              System.out.println("2. Regular");
                              System.out.println("3. Express");
                              System.out.println("masukkan jenis layanan");
                              int jenisLayanan = angka.nextInt();

                              int i = kotaInput - 1;
                              String tujuan = malang[i][0];
                              double harga = 0.0;

                              if (jenisLayanan >= 1 && jenisLayanan <= 3) {
                                switch (jenisLayanan) {
                                  case 1:
                                    harga = Double.parseDouble(malang[i][1]);
                                    break;
                                  case 2:
                                    harga = Double.parseDouble(malang[i][2]);
                                    break;
                                  case 3:
                                    harga = Double.parseDouble(malang[i][3]);
                                    break;
                                }

                                System.out.print(
                                  "Masukkan berat barang (kg): "
                                );
                                double berat = angka.nextDouble();
                                pengiriman[0][7] = Double.toString(berat);

                                double totalBiaya = harga * berat;
                                System.out.println();
                                // sout data pengiriman (struk)
                                System.out.println();
                                System.out.println(" data pengiriman");
                                System.out.println(" ID Pengiriman");
                                System.out.println(pengiriman[0][0]);

                                System.out.println(" Nama pengirim");
                                System.out.println(pengiriman[0][1]);

                                System.out.println("  Nama penerima");
                                System.out.println(pengiriman[0][2]);
                                System.out.println("pengirim(malang)");
                                System.out.println(" tujuan pengirim");
                                System.out.println(pengiriman[0][8]);
                                System.out.println(" alamat pengiriman");
                                System.out.println(pengiriman[0][5]);
                                System.out.println(" tanggal pengiriman");
                                System.out.println(pengiriman[0][3]);
                                System.out.println(" Status pengiriman");
                                System.out.println(pengiriman[0][6]);
                                System.out.println(
                                  "\nBiaya untuk perjalanan ke " +
                                  tujuan +
                                  " dengan layanan jenis " +
                                  jenisLayanan +
                                  " untuk berat " +
                                  berat +
                                  " kg adalah: " +
                                  totalBiaya
                                );
                                System.out.print("Kembali ke menu (y)? ");
                                String ulang = input.nextLine();
                                if (ulang.equalsIgnoreCase("y")) {
                                  isTambahPaket = false;
                                }
                              } else {
                                System.out.println(
                                  "Pilihan jenis layanan tidak valid"
                                );
                              }
                            }
                            break;
                          case "2":
                            boolean isCetakResi = true;
                            while (isCetakResi) {
                              System.out.printf(
                                "======================================================%n"
                              );
                              System.out.printf(
                                "                Lihat Pengiriman                    %n"
                              );
                              System.out.println(
                                "============================================================="
                              );
                              System.out.printf(
                                "%-5s|%-15s|%-15s|%-15s|%-15s\n",
                                "Id Pengiriman",
                                "Nama Pengirim",
                                "Nama Penerima",
                                "Tanggal Kirim",
                                "Status Paket"
                              );
                              System.out.println(
                                "============================================================="
                              );
                              for (String[] kirim : pengiriman) {
                                System.out.printf(
                                  "%-5s|%-15s|%-15s|%-15s|%-5s\n",
                                  kirim[0],
                                  kirim[1],
                                  kirim[2],
                                  kirim[3],
                                  kirim[6]
                                );
                              }
                              System.out.println(
                                "============================================================="
                              );
                              input.nextInt();
                            }
                            break;
                          case "3":
                            System.out.println("ganti status paket");
                            break;
                          case "4":
                            isCrudPengiriman = false;
                          default:
                            System.out.println("\nInput Menu tidak valid\n");
                            break;
                        }
                      }
                      break;
                    case "2":
                      boolean isLacakPengiriman = true;
                      System.out.print("\033[H\033[2J");
                      while (isLacakPengiriman) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("tampil data");
                        System.out.println("masukan id");
                        System.out.println("tampil lokasi");
                      }
                      break;
                    case "3":
                      boolean isLokasiTujuan = true;
                      System.out.print("\033[H\033[2J");
                      while (isLokasiTujuan) {
                        System.out.print("\033[H\033[2J");
                        System.out.println(
                          "Menu Manajemen Lokasi Tujuan\n1. Input Data Lokasi\n2. Edit Data Lokasi\n3. Hapus Data Lokasi\n4. Back"
                        );

                        System.out.print(
                          "Pilih Menu Manajemen Lokasi Tujuan ? (1-3)"
                        );
                        String PilihMenuLokasiTujuan = input.nextLine();

                        switch (PilihMenuLokasiTujuan) {
                          case "1":
                            System.out.println("input data lokasi");
                            break;
                          case "2":
                            System.out.println("edit data lokasi");
                            break;
                          case "3":
                            System.out.println("hapus data lokasi");
                            break;
                          case "4":
                            isLokasiTujuan = false;
                            break;
                          default:
                            System.out.println("\nInput Menu tidak valid\n");
                            break;
                        }
                      }
                    case "4":
                      isManagePengiriman = false;
                      break;
                    default:
                      System.out.println("\nInput Menu tidak valid\n");
                      break;
                  }
                }
                break;
              case "3":
                System.out.println("Laporan Pengiriman");
                break;
              case "4":
                int menu;
                do {
                  System.out.println("============== MENU ==============");
                  System.out.println("1. Input Data Kota Tujuan Baru");
                  System.out.println("2. Edit Data Kota Tujuan");
                  System.out.println("3. Delete Data Kota Tujuan");
                  System.out.println("0. Keluar");
                  System.out.print("Pilih menu (0-3): ");
                  menu = angka.nextInt();

                  switch (menu) {
                    case 1:
                      // Input Data Kota Tujuan Baru
                      System.out.println(
                        "\nMENU 1: INPUT DATA KOTA TUJUAN BARU"
                      );
                      System.out.print("Nama Kota Tujuan Baru: ");
                      String namaKotaBaru = input.nextLine();

                      System.out.print("Biaya Hemat: ");
                      double hematBaru = angka.nextDouble();

                      System.out.print("Biaya Regular: ");
                      double regularBaru = angka.nextDouble();

                      System.out.print("Biaya Express: ");
                      double expressBaru = angka.nextDouble();

                      // Menambahkan data kota tujuan baru ke dalam array malang
                      String[][] malangBaru = new String[malang.length + 1][4];
                      for (int i = 0; i < malang.length; i++) {
                        malangBaru[i] = malang[i];
                      }

                      malangBaru[malang.length] =
                        new String[] {
                          namaKotaBaru,
                          Double.toString(hematBaru),
                          Double.toString(regularBaru),
                          Double.toString(expressBaru),
                        };
                      malang = malangBaru;

                      System.out.println(
                        "\nData kota tujuan setelah penambahan:"
                      );
                      for (int i = 0; i < malang.length; i++) {
                        System.out.println((i + 1) + ". " + malang[i][0]);
                      }
                      break;
                    case 2:
                      // Edit Data Kota Tujuan
                      System.out.println("\nMENU 3: EDIT DATA KOTA TUJUAN");
                      System.out.println("Data kota tujuan saat ini:");
                      for (int j = 0; j < malang.length; j++) {
                        System.out.println((j + 1) + ". " + malang[j][0]);
                      }

                      System.out.print(
                        "Pilih kota tujuan yang akan di-edit (nomor): "
                      );
                      int kotaEdit = angka.nextInt();

                      if (kotaEdit >= 1 && kotaEdit <= malang.length) {
                        System.out.print("Nama Kota Tujuan Baru: ");
                        String namaKotaBaruEdit = input.nextLine();

                        System.out.print("Biaya Hemat Baru: ");
                        double hematBaruEdit = angka.nextDouble();

                        System.out.print("Biaya Regular Baru: ");
                        double regularBaruEdit = angka.nextDouble();

                        System.out.print("Biaya Express Baru: ");
                        double expressBaruEdit = angka.nextDouble();

                        malang[kotaEdit - 1] =
                          new String[] {
                            namaKotaBaruEdit,
                            Double.toString(hematBaruEdit),
                            Double.toString(regularBaruEdit),
                            Double.toString(expressBaruEdit),
                          };

                        System.out.println(
                          "\nData kota tujuan setelah perubahan:"
                        );
                        for (int j = 0; j < malang.length; j++) {
                          System.out.println((j + 1) + ". " + malang[j][0]);
                        }
                      } else {
                        System.out.println("Nomor kota tidak valid");
                      }
                      break;
                    case 3:
                      // Delete Data Kota Tujuan
                      System.out.println("\nMENU 4: DELETE DATA KOTA TUJUAN");
                      System.out.println("Data kota tujuan saat ini:");
                      for (int j = 0; j < malang.length; j++) {
                        System.out.println((j + 1) + ". " + malang[j][0]);
                      }

                      System.out.print(
                        "Pilih kota tujuan yang akan dihapus (nomor): "
                      );
                      int kotaHapus = angka.nextInt();

                      if (kotaHapus >= 1 && kotaHapus <= malang.length) {
                        malangBaru = new String[malang.length - 1][4];
                        for (int j = 0, k = 0; j < malang.length; j++) {
                          if (j != kotaHapus - 1) {
                            malangBaru[k++] = malang[j];
                          }
                        }
                        malang = malangBaru;

                        System.out.println(
                          "\nData kota tujuan setelah penghapusan:"
                        );
                        for (int j = 0; j < malang.length; j++) {
                          System.out.println((j + 1) + ". " + malang[j][0]);
                        }
                      } else {
                        System.out.println("Nomor kota tidak valid");
                      }
                      break;
                    case 0:
                      System.out.println("Program selesai. Sampai jumpa!");
                      break;
                    default:
                      System.out.println(
                        "Menu tidak valid. Silakan pilih lagi."
                      );
                      break;
                  }
                } while (menu != 0);
                break;
              case "5":
                isLoginAdmin = false;

                break;
              case "6":
                isLoginAdmin = false;
                checkRole = false;
                break;
              default:
                System.out.println("\nInput Menu tidak valid\n");
                break;
            }
          }
        } else if (pilih.equalsIgnoreCase("2")) {
          boolean isLoginPetugas = false;
          System.out.print("\033[H\033[2J");
          isLogin = true;
          while (isLogin) {
            System.out.print("\033[H\033[2J");
            System.out.println("Login Petugas");
            System.out.print("Username: ");
            username = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            for (int j = 0; j < userPetugas.length; j++) {
              if (
                username.equals(userPetugas[j][2]) &&
                password.equals(userPetugas[j][3])
              ) {
                isLogin = false;
                isLoginPetugas = true;
                break;
              } else {
                isLogin = true;
                System.out.println(
                  "\nUsername atau Password yang anda masukkan salah\n"
                );
                break;
              }
            }
          }

          while (isLoginPetugas) {
            System.out.println(
              "Menu Petugas\n1. Informasi Layanan\n2. Manajemen Pengiriman\n3. Laporan Pengiriman\n4. Logout\n5. Keluar"
            );

            System.out.print("Pilih Menu : ");
            String pilihMenuPetugas = input.nextLine();
          }
        }
      } else if (pilih.equalsIgnoreCase("3")) break; else {
        System.out.println("Input tidak valid");
        continue;
      }
    }
  }
}
