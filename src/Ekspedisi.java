import java.util.Scanner;

public class Ekspedisi {
    static Scanner input = new Scanner(System.in);

    //Variabel login
    static String[][] userAdmin = {
        {"admin", "admin123", "Admin"},
        {"admin1", "admin1", "Admin"},
    };
    static String[][] userEmployee = {
        {"petugas", "petugas123", "Petugas"},
        {"petugas2", "petugas222", "Petugas"}
    };
    static boolean checkRole = true;
    static boolean isLogin = true;
    static boolean isLoginAdmin = true;
    static boolean isLoginEmployee = true;
    
    public static void main(String[] args) {
        clearScreen();
        while (checkRole) {
            login();
        }
    }

    public static void login() {
        clearScreen();
        System.out.print("Selamat Datang di Sistem Pengiriman\nMasuk sebagai : \n1.Admin\n2.Petugas\n3.Keluar\n");

        System.out.print("Pilih Level (admin/petugas/keluar): ");
        String choose = input.nextLine();

        if (choose.equalsIgnoreCase("Admin")||choose.equalsIgnoreCase("Petugas")) isLogin(choose);
        else if (choose.equalsIgnoreCase("Keluar")) {
            checkRole = false;
        }
        else handleInvalidMenu();
    }

    public static void isLogin (String choose) {
        clearScreen();
        String username = "", password = "";
        while (isLogin) {
            System.out.println("LOGIN "+choose.toUpperCase());
            System.out.print("Username: ");
            username = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            if (choose.equalsIgnoreCase("admin")) {
                for (int j = 0; j < userAdmin.length; j++) {
                    if (username.equals(userAdmin[j][0]) && password.equals(userAdmin[j][1])) {
                        dashboardAdmin(username);
                    } else {
                        isLogin = true;
                    };
                }
            } else if (choose.equalsIgnoreCase("petugas")) {
                for (int j = 0; j < userEmployee.length; j++) {
                    if (username.equals(userEmployee[j][0]) && password.equals(userEmployee[j][1])) {
                        dashboardEmployee(username);
                    } else {
                        isLogin = true;
                    };
                }
            }
        }
    }

    public static void dashboardAdmin(String username) {
        clearScreen();
        while (isLoginAdmin) {
            System.out.println("=======================================");
            System.out.println("Nama : "+username);
            System.out.println("Role : "+userAdmin[0][2]);
            System.out.println("=======================================");                
            System.out.println("Menu Admin\n1. Manajemen Petugas\n2. Manajemen Pengiriman\n3. Laporan Pengiriman\n4. Logout\n5. Keluar");
            
            System.out.print("Pilih Menu : ");
            String pilihMenuAdmin = input.nextLine();
        }
    }

    public static void dashboardEmployee(String username) {
        clearScreen();
        while (isLoginEmployee) {
            clearScreen();
            System.out.println("=======================================");
            System.out.println("Nama : "+username);
            System.out.println("Role : "+userEmployee[0][2]);
            System.out.println("=======================================");
            System.out.println("Menu Petugas\n1. Informasi Layanan\n2. Manajemen Pengiriman\n3. Laporan Pengiriman\n4. Logout\n5. Keluar");

            System.out.print("Pilih Menu : ");
            String pilihMenuPetugas = input.nextLine();
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    static boolean handleInvalidMenu() {
        System.out.println("Maaf menu yang di pilih salah");
        clearScreen();
        return true;
    }

}
