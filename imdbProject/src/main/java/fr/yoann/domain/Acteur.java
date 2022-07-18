package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_acteur", nullable = false)
    private int id;

    @Column(name = "identite", length = 60)
    private String identite;

    @Column(name = "url", length = 50)
    private String url;

    @Column(name = "id_imdb", length = 10)
    private String idImdb;

//    @Column(name = "naissance")
//    private Naissance naissance;

//    @Column(name = "role")
//    private Role role;

    public Acteur(final String identite, final String url, final String idImdb) {
        this.identite = identite;
        this.url = url;
        this.idImdb = idImdb;
    }

//    public Acteur(final String identite, final String url, final String idImdb, final Naissance naissance, final Role role) {
//        this.identite = identite;
//        this.url = url;
//        this.idImdb = idImdb;
//        this.naissance = naissance;
//        this.role = role;
//    }

    public int getId() {
        return id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(final String identite) {
        this.identite = identite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(final String idImdb) {
        this.idImdb = idImdb;
    }

//    public Naissance getNaissance() {
//        return naissance;
//    }
//
//    public void setNaissance(final Naissance naissance) {
//        this.naissance = naissance;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(final Role role) {
//        this.role = role;
//    }

    @Override
    public String toString() {
        return "Acteur{" + "id=" + id + ", identite='" + identite + '\'' + ", url='" + url + '\'' + ", idImdb='" + idImdb + '\'' + '}';
    }
}
