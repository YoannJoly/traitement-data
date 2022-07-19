create table realisateurs
(
    id_realisteurs      int         not null
        primary key,
    identite_realisteur varchar(60) null,
    url_realisteur      varchar(25) null
)
    engine = MyISAM;

