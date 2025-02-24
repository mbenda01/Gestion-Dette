package entity;

public class Dette {
    private int id;
    private float montantDette;
    private float montantPaye;
    private float montantRestant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontantDette() {
        return montantDette;
    }

    public void setMontantDette(float montantDette) {
        this.montantDette = montantDette;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    @Override
    public String toString() {
        return "Dette [id=" + id + ", montantDette=" + montantDette + ", montantPaye=" + montantPaye
                + ", montantRestant=" + montantRestant + "]";
    }

    public Dette() {
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public float getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(float montantRestant) {
        this.montantRestant = montantRestant;
    }
}