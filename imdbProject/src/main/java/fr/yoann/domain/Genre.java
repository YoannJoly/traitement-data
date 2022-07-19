package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_genre", nullable = false)
    private int id;

    @Column(name = "nom_genre", length = 50)
    private String nomGenre;

    public Genre(final String nomGenre) {
        this.nomGenre = nomGenre;
    }

    public int getId() {
        return id;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(final String nomGenre) {
        this.nomGenre = nomGenre;
    }
}
