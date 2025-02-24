import java.util.Scanner;

import entity.Client;

public class App {
    private static final int N = 10;
    private static Client[] clients = new Client[N];
    private static Scanner sc = new Scanner(System.in);
    private static int clientId;

    public static void main(String[] args) throws Exception {
        Client c = saisiClient();

    }

    public static int menu(int choix) {
        System.out.println("Faire un choix");
        System.out.println("1:Ajouter Client");
        System.out.println("2: Afficher Client");

        if (choix == 1) {
            ajouterClient(null);
        }
        if (choix == 2) {

        }
    }

    public static Client saisiClient() {
        System.out.println("Saisir le nom du client : ");
        String nom = sc.nextLine();
        System.out.println("Saisir le numéro téléphone du client : ");
        String phone = sc.nextLine();
        System.out.println("Saisir l'adresse du client : ");
        String addresse = sc.nextLine();
        return new Client(++clientId, nom, phone, addresse);
    }

    public static boolean searchClientByPhone(String phone) {
        // Client c1 = new Client();
        // c1.setPhone(phone);

        Client c1 = new Client(phone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (clients[i].equals(c1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void ajouterClient(Client c1) {
        if (clientId - 1 < N) {
            clients[clientId - 1] = c1;
        } else {
            System.out.println("Gainde ndiaye, tableau bi féss na");
        }
    }
}