package fr.yoann.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_role", nullable = false)
    private int id;

    @Column(name = "character_name", length = 100)
    private String characterName;


   //@Column(name = "film")
   // private Film film;

    public Role(final String characterName) {
        this.characterName = characterName;
    }

//    public Role(final String characterName, final Film film) {
//        this.characterName = characterName;
//        this.film = film;
//    }

    public int getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

// public Film getFilm() {
//     return film;
// }
//
// public void setFilm(final Film film) {
//     this.film = film;
// }
}
