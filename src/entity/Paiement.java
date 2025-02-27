package entity;

import java.time.LocalDate;

public class Paiement {
    private LocalDate date;
    private float montant;
    private Client client;
    private Dette dette;

    // Constructeur par défaut
    public Paiement() {
    }

    // Constructeur avec paramètres
    public Paiement(Client client, Dette dette, LocalDate date, float montant) {
        this.client = client;
        this.dette = dette;
        this.date = date;
        this.montant = montant;
        effectuerPaiement();
    }

    // Getter et Setter pour la date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter et Setter pour le montant
    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    // Getter et Setter pour le client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Getter et Setter pour la dette
    public Dette getDette() {
        return dette;
    }

    public void setDette(Dette dette) {
        this.dette = dette;
    }

    // Méthode pour effectuer un paiement et mettre à jour la dette
    public void effectuerPaiement() {
        if (dette != null) {
            float nouveauMontantPaye = dette.getMontantPaye() + montant;
            float nouveauMontantRestant = dette.getMontantDette() - nouveauMontantPaye;

            dette.setMontantPaye(nouveauMontantPaye);
            dette.setMontantRestant(nouveauMontantRestant);
        }
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "date=" + date +
                ", montant=" + montant +
                ", client=" + (client != null ? client.getNom() : "Inconnu") +
                ", dette=" + (dette != null ? dette.getId() : "Aucune") +
                '}';
    }
}
