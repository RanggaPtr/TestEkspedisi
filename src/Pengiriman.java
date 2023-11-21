import java.util.Scanner;

public class Pengiriman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
        
        //Variabel Pengiriman
        String[][] pengiriman = {
            {"EXP123",
            "Suparman",
            "Paijo",
            "08-09-2023",
            null,
            "\nJl. Plaza Boulevard Jl. Pemuda No.33 - 37,\nEmbong Kaliasin, Kec. Genteng, Surabaya,\nJawa Timur 60271",
            "MSUR",
            "Dikirim",
            "Trenggalek",},
            {"REG123",
            "Jono",
            "Joko",
            "08-10-2023",
            "08-15-2023",
            "\nJl. Raya,\nRangkah Kidul, Kec. Sidoarjo, Kabupaten Sidoarjo,\nJawa Timur 61232",
            "MJAK",
            "Dikirim",
            "Kepanjen",}
        };
        String[][] malang = {
            {"Hemat","5000", "", "10000"},
            {"Reguler","7000", "8000", "11000"},
            {"Ekspres","10000", "9000", "12000"}
        };
        
        boolean checkRole = true;
        System.out.print("\033[H\033[2J");
        while (checkRole) {
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
                        System.out.println("Login Admin");
                        System.out.print("Username: ");
                        username = input.nextLine();
                        System.out.print("Password: ");
                        password = input.nextLine();
                
                        for (int j = 0; j < userAdmin.length; j++) {
                            if (username.equals(userAdmin[j][2]) && password.equals(userAdmin[j][3])) {
                                isLogin = false;
                                isLoginAdmin = true;
                                break;
                            } else {
                                isLogin = true;
                                System.out.println("\nUsername atau Password yang anda masukkan salah\n");
                                break;
                            }
                        }

                    }

                    System.out.print("\033[H\033[2J");
                    while (isLoginAdmin) {
                        System.out.println(
                        "Menu Admin\n1. Manajemen Petugas\n2. Manajemen Pengiriman\n3. Laporan Pengiriman\n4. Back\n5. Keluar"
                        );

                        System.out.print("Pilih Menu ? (1-5) : ");
                        String pilihMenuAdmin = input.nextLine();

                        switch (pilihMenuAdmin) {
                            case "1":
                                boolean isManagePetugas = true;
                                System.out.print("\033[H\033[2J");
                                while (isManagePetugas) {
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
                                            System.out.println("=============================================================");
                                            System.out.printf("%-5s|%-15s|%-15s|%-15s|%-15s\n", "ID", "Nama", "Username", "Password", "Role");
                                            System.out.println("=============================================================");
                                            for (String[] user : userPetugas) {
                                                System.out.printf("%-5s|%-15s|%-15s|%-15s|%-5s\n", user[0], user[1], user[2], user[3], user[4]);
                                            }
                                            System.out.println("=============================================================");
                                            System.out.println("Tambah Data Petugas ");
                                            System.out.println("=============================================================");
                                            System.out.print("Nama Lengkap : ");
                                            String nama = input.nextLine();
                                            System.out.print("Username : ");
                                            String usernameInput = input.nextLine();
                                            System.out.print("Password : ");
                                            String passwordInput = input.nextLine();

                                            String tambahPetugas[][] = new String[userPetugas.length + 1][5];
                                            int idPetugas = 2;
                                            
                                            for (int i = 0; i < userPetugas.length; i++) {
                                                tambahPetugas[i] = userPetugas[i];
                                            }
                                            
                                            for (int i = userPetugas.length; i < tambahPetugas.length; i++) {
                                                idPetugas++;
                                                tambahPetugas[i] = new String[5];
                                                tambahPetugas[i][0] = "PTG"+String.valueOf(idPetugas);
                                                tambahPetugas[i][1] = nama;
                                                tambahPetugas[i][2] = usernameInput;
                                                tambahPetugas[i][3] = passwordInput;
                                                tambahPetugas[i][4] = "Petugas";
                                            }
                                            userPetugas = tambahPetugas;
                                            System.out.println("=============================================================");
                                            System.out.printf("%-5s|%-15s|%-15s|%-15s|%-15s\n", "ID", "Nama", "Username", "Password", "Role");
                                            System.out.println("=============================================================");
                                            for (String[] user : userPetugas) {
                                                System.out.printf("%-5s|%-15s|%-15s|%-15s|%-5s\n", user[0], user[1], user[2], user[3], user[4]);
                                            }
                                            System.out.println("=============================================================");
                                            System.out.print("Kembali ke menu (y)? ");
                                            String ulang = input.nextLine();
                                            if (ulang.equalsIgnoreCase("y")) {
                                                isMenuPetugas = false;
                                            }
                                        }
                                    }
                                }
                                break;
                            case "2":
                                System.out.println("Manajemen Pengiriman");
                                break;
                            case "3":
                                System.out.println("Laporan Pengiriman");
                                break;
                            case "4":
                                isLoginAdmin = false;
                                break;
                            case "5":
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
                    while (isLogin) {
                        System.out.println("Login Petugas");
                        System.out.print("Username: ");
                        username = input.nextLine();
                        System.out.print("Password: ");
                        password = input.nextLine();
                
                        for (int j = 0; j < userPetugas.length; j++) {
                            if (
                                username.equals(userPetugas[j][0]) &&
                                password.equals(userPetugas[j][1])
                            ) {
                                isLogin = false;
                                isLoginPetugas = true;
                                break;
                            } else {
                                isLogin = true;
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
            }
            else if (pilih.equalsIgnoreCase("3")) break;
            else {
                System.out.println("Input tidak valid");
                continue;
            }
        }
    }
}
