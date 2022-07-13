package fr.yoann.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id_film", nullable = false)
    private int id;

    @Column(name = "nom_film", length = 100)
    private String nomFilm;

    @Column(name = "url_film", length = 40)
    private String urlFilm;

    @Column(name = "plot_film", length = 200)
    private String plotFilm;

    @Column(name = "id_imdb_film", length = 10)
    private String idImdbFilm;

    @Column(name = "langue_film", length = 20)
    private String langueFilm;

    @Column(name = "lieu_tournage_film", length = 50)
    private String lieuTournageFilm;

    @Column(name = "année_sortie_film")
    private int anneeSortieFilm;

    @Column(name = "genre")
    private Genre genre;

    @Column(name = "casting")
    private Casting casting;

    @Column(name = "pays")
    private Pays pays;

    @Column(name = "realisateurs")
    private Realisateurs realisateurs;

    public Film(final String nomFilm, final String urlFilm, final String plotFilm, final String idImdbFilm, final String langueFilm, final String lieuTournageFilm, final int anneeSortieFilm, final Genre genre, final Casting casting, final Pays pays, final Realisateurs realisateurs) {
        this.nomFilm = nomFilm;
        this.urlFilm = urlFilm;
        this.plotFilm = plotFilm;
        this.idImdbFilm = idImdbFilm;
        this.langueFilm = langueFilm;
        this.lieuTournageFilm = lieuTournageFilm;
        this.anneeSortieFilm = anneeSortieFilm;
        this.genre = genre;
        this.casting = casting;
        this.pays = pays;
        this.realisateurs = realisateurs;
    }

    public int getId() {
        return id;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(final String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public String getUrlFilm() {
        return urlFilm;
    }

    public void setUrlFilm(final String urlFilm) {
        this.urlFilm = urlFilm;
    }

    public String getPlotFilm() {
        return plotFilm;
    }

    public void setPlotFilm(final String plotFilm) {
        this.plotFilm = plotFilm;
    }

    public String getIdImdbFilm() {
        return idImdbFilm;
    }

    public void setIdImdbFilm(final String idImdbFilm) {
        this.idImdbFilm = idImdbFilm;
    }

    public String getLangueFilm() {
        return langueFilm;
    }

    public void setLangueFilm(final String langueFilm) {
        this.langueFilm = langueFilm;
    }

    public String getLieuTournageFilm() {
        return lieuTournageFilm;
    }

    public void setLieuTournageFilm(final String lieuTournageFilm) {
        this.lieuTournageFilm = lieuTournageFilm;
    }

    public int getAnneeSortieFilm() {
        return anneeSortieFilm;
    }

    public void setAnneeSortieFilm(final int anneeSortieFilm) {
        this.anneeSortieFilm = anneeSortieFilm;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(final Genre genre) {
        this.genre = genre;
    }

    public Casting getCasting() {
        return casting;
    }

    public void setCasting(final Casting casting) {
        this.casting = casting;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(final Pays pays) {
        this.pays = pays;
    }

    public Realisateurs getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(final Realisateurs realisateurs) {
        this.realisateurs = realisateurs;
    }
}
