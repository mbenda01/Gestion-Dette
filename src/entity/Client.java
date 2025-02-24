package entity;

public class Client {
    private int id;
    private String nom;
    private String phone;
    private String addresse;

    public Client(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Client() {
    }

    public Client(int id, String nom, String phone, String addresse) {
        this.id = id;
        this.nom = nom;
        this.phone = phone;
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", phone=" + phone + ", addresse=" + addresse + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }

    public void copy(Client client) {
        this.id = client.getId();
        this.nom = client.getNom();
        this.phone = client.getPhone();
        this.addresse = client.getAddresse();
    }
}