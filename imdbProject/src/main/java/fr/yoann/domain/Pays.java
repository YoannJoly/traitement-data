package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pays")
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_pays", nullable = false)
    private int id;

    @Column(name = "nom_pays", length = 56)
    private String nomPays;

    @Column(name = "url_pays", length = 25)
    private String urlPays;

    public Pays(final String nomPays, final String urlPays) {
        this.nomPays = nomPays;
        this.urlPays = urlPays;
    }

    public int getId() {
        return id;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(final String nomPays) {
        this.nomPays = nomPays;
    }

    public String getUrlPays() {
        return urlPays;
    }

    public void setUrlPays(final String urlPays) {
        this.urlPays = urlPays;
    }
}
