import entity.Client;
import entity.Dette;
import entity.Paiement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<Client> clients = new ArrayList<>();
    private static List<Dette> dettes = new ArrayList<>();
    private static List<Paiement> paiements = new ArrayList<>();

    public static void main(String[] args) {
        int choix;
        do {
            choix = afficherMenu();
            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    afficherClients();
                    break;
                case 3:
                    ajouterDette();
                    break;
                case 4:
                    enregistrerPaiement();
                    break;
                case 5:
                    afficherHistoriquePaiements();
                    break;
                case 6:
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);
    }

    // Afficher le menu principal
    public static int afficherMenu() {
        System.out.println("\n===== Gestion de Dettes =====");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Afficher la liste des clients");
        System.out.println("3. Ajouter une dette");
        System.out.println("4. Enregistrer un paiement");
        System.out.println("5. Afficher l'historique des paiements");
        System.out.println("6. Quitter");
        System.out.print("Votre choix : ");
        return sc.nextInt();
    }

    // Ajouter un client
    public static void ajouterClient() {
        sc.nextLine(); // Consommer l'entrée précédente
        System.out.print("Nom du client : ");
        String nom = sc.nextLine();
        System.out.print("Numéro de téléphone : ");
        String phone = sc.nextLine();
        System.out.print("Adresse : ");
        String adresse = sc.nextLine();

        Client client = new Client(clients.size() + 1, nom, phone, adresse);
        clients.add(client);
        System.out.println("Client ajouté avec succès !");
    }

    // Afficher la liste des clients
    public static void afficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }
        System.out.println("\nListe des Clients :");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    // Ajouter une dette pour un client
    public static void ajouterDette() {
        if (clients.isEmpty()) {
            System.out.println("Ajoutez d'abord un client.");
            return;
        }

        afficherClients();
        System.out.print("ID du client concerné : ");
        int clientId = sc.nextInt();

        Client client = trouverClientParId(clientId);
        if (client == null) {
            System.out.println("Client introuvable !");
            return;
        }

        System.out.print("Montant de la dette : ");
        float montant = sc.nextFloat();

        Dette dette = new Dette();
        dette.setId(dettes.size() + 1);
        dette.setMontantDette(montant);
        dette.setMontantPaye(0);
        dette.setMontantRestant(montant);

        dettes.add(dette);
        System.out.println("Dette ajoutée avec succès !");
    }

    // Enregistrer un paiement
    public static void enregistrerPaiement() {
        if (dettes.isEmpty()) {
            System.out.println("Aucune dette enregistrée. Ajoutez d'abord une dette.");
            return;
        }

        System.out.println("\nListe des Dettes :");
        for (Dette dette : dettes) {
            System.out.println("ID Dette: " + dette.getId() + " | Montant Dette: " + dette.getMontantDette()
                    + " | Payé: " + dette.getMontantPaye() + " | Restant: " + dette.getMontantRestant());
        }

        System.out.print("ID de la dette à payer : ");
        int detteId = sc.nextInt();
        Dette dette = trouverDetteParId(detteId);

        if (dette == null) {
            System.out.println("Dette introuvable !");
            return;
        }

        System.out.print("Montant du paiement : ");
        float montantPaiement = sc.nextFloat();

        if (montantPaiement <= 0 || montantPaiement > dette.getMontantRestant()) {
            System.out.println("Montant invalide. Assurez-vous qu'il ne dépasse pas la dette restante.");
            return;
        }

        Client client = trouverClientParDette(dette);
        if (client == null) {
            System.out.println("Client associé à la dette introuvable !");
            return;
        }

        Paiement paiement = new Paiement(client, dette, LocalDate.now(), montantPaiement);
        paiements.add(paiement);

        System.out.println("Paiement enregistré avec succès !");
    }

    // Afficher l'historique des paiements
    public static void afficherHistoriquePaiements() {
        if (paiements.isEmpty()) {
            System.out.println("Aucun paiement enregistré.");
            return;
        }

        System.out.println("\nHistorique des Paiements :");
        for (Paiement paiement : paiements) {
            System.out.println(paiement);
        }
    }

    // Trouver un client par son ID
    private static Client trouverClientParId(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    // Trouver une dette par son ID
    private static Dette trouverDetteParId(int id) {
        for (Dette dette : dettes) {
            if (dette.getId() == id) {
                return dette;
            }
        }
        return null;
    }

    // Trouver le client associé à une dette
    private static Client trouverClientParDette(Dette dette) {
        for (Client client : clients) {
            for (Dette d : dettes) {
                if (d.equals(dette)) {
                    return client;
                }
            }
        }
        return null;
    }
}
