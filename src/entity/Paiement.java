package entity;

public class Paiement {
    private int date;
    private float montant;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public float getMontant() {
        return montant;
    }

    public Paiement() {
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Paiement(int date, float montant) {
        this.date = date;
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Paiement [date=" + date + ", montant=" + montant + "]";
    }
}