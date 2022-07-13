package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "realisateurs")
public class Realisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_realisteurs", nullable = false)
    private int id;

    @Column(name = "identite_realisteur", length = 60)
    private String identiteRealisteur;

    @Column(name = "url_realisteur", length = 25)
    private String urlRealisteur;

    public Realisateurs(final String identiteRealisteur, final String urlRealisteur) {
        this.identiteRealisteur = identiteRealisteur;
        this.urlRealisteur = urlRealisteur;
    }

    public int getId() {
        return id;
    }

    public String getIdentiteRealisteur() {
        return identiteRealisteur;
    }

    public void setIdentiteRealisteur(final String identiteRealisteur) {
        this.identiteRealisteur = identiteRealisteur;
    }

    public String getUrlRealisteur() {
        return urlRealisteur;
    }

    public void setUrlRealisteur(final String urlRealisteur) {
        this.urlRealisteur = urlRealisteur;
    }
}
