package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "casting")
public class Casting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_casting", nullable = false)
    private int id;

//    @Column(name = "acteur")
//    private Acteur acteur;
//
//    public Casting(final Acteur acteur) {
//        this.acteur = acteur;
//    }

    public int getId() {
        return id;
    }

//    public Acteur getActeur() {
//        return acteur;
//    }
//
//    public void setActeur(final Acteur acteur) {
//        this.acteur = acteur;
//    }
}
