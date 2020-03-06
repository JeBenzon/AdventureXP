# AdventureXP

DataBase Script

create table activities
(
    id          int auto_increment
        primary key,
    ageLimit    int          not null,
    price       double       not null,
    participant int          not null,
    instructor  varchar(255) not null,
    name        varchar(255) null,
    date        varchar(255) null,
    max         int          not null,
    min         int          not null
);

create table bookings
(
    id           int auto_increment,
    activityId   int          not null,
    date         varchar(255) null,
    participants int          null,
    bookingtype  int          null,
    name         varchar(255) null,
    constraint bookings_id_uindex
        unique (id),
    constraint bookings_activities_id_fk
        foreign key (activityId) references activities (id)
);

alter table bookings
    add primary key (id);

create table users
(
    username varchar(50)  not null
        primary key,
    password varchar(120) not null,
    enabled  tinyint(1)   not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint authorities_ibfk_1
        foreign key (username) references users (username)
);

create index username
    on authorities (username);
-----------------------------------------------------------------------------------

SQL SCRIPT

-- Opret en ny skema kaldet 'saltyfirm' --
CREATE SCHEMA IF NOT EXISTS saltyfirm DEFAULT CHARACTER SET UTF8MB4;

-- Vælg saltyfirm skema til at bruge --
USE saltyfirm;

-- Opret en ny tabel kaldet 'Privileges' --
CREATE TABLE IF NOT EXISTS `privileges`
(
    privileges_id       INT              UNSIGNED    NOT NULL    AUTO_INCREMENT     PRIMARY KEY,
    access_level        VARCHAR(15)                  NOT NULL
)
    ENGINE = InnoDB;

-- Opret en ny tabel kaldet 'User' --
CREATE TABLE IF NOT EXISTS `user`
(
    user_id             INT              UNSIGNED    NOT NULL    AUTO_INCREMENT     PRIMARY KEY,
    username            VARCHAR(45)                  NOT NULL    UNIQUE,
    `password`          VARCHAR(300)                 NOT NULL,
    firstname           VARCHAR(45)                  NOT NULL,
    lastname            VARCHAR(75)                  NOT NULL,
    phone_number        INT                          NOT NULL    UNIQUE,
    gender              VARCHAR(15),
    birthdate           VARCHAR(10)                  NOT NULL,
    education           VARCHAR(45),
    mail                VARCHAR(100)                 NOT NULL    UNIQUE,
    nationality         VARCHAR(45),
    privileges_fk_id    INT              UNSIGNED    NOT NULL,
    FOREIGN KEY (privileges_fk_id)
        REFERENCES `privileges` (privileges_id)
)
    ENGINE = InnoDB;

-- Opret en ny tabel kaldet 'Firm' --
CREATE TABLE IF NOT EXISTS firm
(
    firm_id             INT              UNSIGNED    NOT NULL    AUTO_INCREMENT     PRIMARY KEY,
    firm_name           VARCHAR(100)                 NOT NULL,
    firm_type           VARCHAR(45),
    overall_score       DOUBLE(3,1),
    `description`       VARCHAR(500),
    logo_url            VARCHAR(200)
)
    ENGINE = InnoDB;

-- Opret en ny tabel kaldet 'Department' --
CREATE TABLE IF NOT EXISTS department
(
    department_id       INT              UNSIGNED    NOT NULL    AUTO_INCREMENT     PRIMARY KEY,
    department_name     VARCHAR(65)                  NOT NULL,
    department_address  VARCHAR(200),
    department_score    DOUBLE(3,1),
    firm_fk_id          INT              UNSIGNED    NOT NULL,
    FOREIGN KEY (firm_fk_id)
        REFERENCES firm (firm_id)
        ON DELETE CASCADE
)
    ENGINE = InnoDB;

-- Opret en ny tabel kaldet 'Review' --
CREATE TABLE IF NOT EXISTS review
(
    review_id           INT              UNSIGNED    NOT NULL    AUTO_INCREMENT     PRIMARY KEY,
    post                VARCHAR(600),
    salary              INT,
    position            VARCHAR(100),
    pension_scheme      DOUBLE(3,1),
    benefits            DOUBLE(3,1),
    management          DOUBLE(3,1),
    work_environment    DOUBLE(3,1),
    flexibility         DOUBLE(3,1),
    employment_time     INT,
    user_fk_id          INT              UNSIGNED    NOT NULL,
    department_fk_id    INT              UNSIGNED    NOT NULL,
    FOREIGN KEY (user_fk_id)
        REFERENCES `user` (user_id)
        ON DELETE CASCADE,
    FOREIGN KEY (department_fk_id)
        REFERENCES department (department_id)
        ON DELETE CASCADE
)
    ENGINE = InnoDB;

-- Opret en ny tabel kaldet 'Vote' --
CREATE TABLE IF NOT EXISTS vote
(
    vote_id             INT              UNSIGNED    NOT NULL    AUTO_INCREMENT      PRIMARY KEY,
    vote                BOOLEAN,
    user_fk_id          INT              UNSIGNED    NOT NULL,
    review_fk_id        INT              UNSIGNED    NOT NULL,
    FOREIGN KEY (review_fk_id)
        REFERENCES review (review_id)
        ON DELETE CASCADE,
    FOREIGN KEY (user_fk_id)
        REFERENCES `user` (user_id)
        ON DELETE CASCADE
)
    ENGINE = InnoDB;

-- Indsæt en række data i databasen --

INSERT INTO saltyfirm.privileges
(access_level)
    VALUE  ('Administrator'),
    ('Bruger');

INSERT INTO saltyfirm.user
(username, password, firstname, lastname, phone_number, gender, birthdate, education, mail, nationality, privileges_fk_id)
VALUES ('test1', '75fb58dec00bf83c8d7f1edcd6060ebf87a5e9a2212f0f44cdc5ea8e55db5dd2', 'Nicholas', 'Tureczek', 64037621, 'm', '04-02-1986', 'Tjener', 'test1@kea.dk', 'Sverige', 1),
       ('test2', 'a2bee2000c9354030f8e2bc6cca9b4928f33c5280f9aa6637294c95d3719f930', 'Martin', 'Holmqvist', 12345678, 'f', '23-07-1988', 'Datamatiker', 'test2@kea.dk', 'Danmark', 1),
       ('test3', 'f9f32713fe6dbc9a83fe70bed0e8b91f6fa6a6bfdbba7e06e5ea7ed86918f47a', 'Patrick', 'Jønnson', 98765432, 'm', '17-11-1986', 'Skraldemand', 'test3@kea.dk', 'Tyskland', 1),
       ('test4', 'cf47be80cb975d2ed78fd49e853995f9ddce199de7535a93ee865e4619fb37cf', 'Victor', 'Petersen', 56453535, 'm', '11-02-1991', 'Skraldemand', 'test4@kea.dk', 'Holland', 1)

INSERT INTO saltyfirm.firm
(firm_name, firm_type, `description`, logo_url)
VALUES ('Bone´s', 'Restaurant','Stor virksomhed med mange restauranter i hele landet.','https://www.whyorange.dk/wp-content/uploads/2017/11/whyorange-julekalender-3-bones.png'),
       ('McDonalds', 'Restaurant','Stor virksomhed med mange restauranter i hele verdenen.','https://www.pngkey.com/png/full/217-2178380_mcdonalds-logo-png-mcdonalds-logo-png.png'),
       ('Meny', 'Supermarked','Stor supermarkedskæde med mange butikker i hele landet.','https://ekstrabladet.dk/incoming/b472fa/6858578/IMAGE_ALTERNATES/relationBig/desktop-20191123103620'),
       ('Sunset Boulevard', 'Restaurant','Restaurant som laver fastfood i form af sandwiches og andet tilbehør.','https://xpleo.org/images/com_xpleo/Sunset.jpg'),
       ('DSB', 'Togtransport', 'Selvstændig offentlig virksomhed som har monopol på de danske stats baner. Derudover operere de også i Sverige og Tyskland.', 'https://seeklogo.com/images/D/dsb-2014-logo-1EA8C51FC2-seeklogo.com.png');

INSERT INTO saltyfirm.department
(department_name, department_address, firm_fk_id)
VALUES ('Valby', 'Valby Tingsted 4C, 2500 København', '1'),
       ('Amager', 'Amagerbrogade 132, 2300 København', '1'),
       ('Valby', 'Gammel Køge Landevej 103, 2500 København', '2'),
       ('Gentofte', 'Nybrovej 2, 2820 Gentofte', '2'),
       ('Mimersgade', 'Mimersgade 124, 2200 København', '3'),
       ('Lyngbyvej', 'Lyngbyvej 11, 2100 København', '3'),
       ('Hovedbanegården', 'Københavns Hovedbanegård, 1570 København V', '4'),
       ('Fisketorvet', 'Fisketorvet, Kalvebod Brygge 59, 1560 København', '4'),
       ('Kundeservice', 'Telegade 2, 2630 Taastrup', '5'),
       ('Personale', 'Telegade 2, 2630 Taastrup', '5');

INSERT INTO saltyfirm.review
(post, salary, position, pension_scheme, benefits, management, work_environment, flexibility, employment_time, user_fk_id, department_fk_id)
VALUES ('Ganske fint arbejde med masser af søde mennesker, og en rigtig god leder som er god til at lytte til sine medarbejdere', 2, 'Tjener', 7, 8, 10, 9, 7, 4, 1, 1),
       ('Fint arbejde med masser af gode mennesker, og en fin leder som er god til at lytte til sine medarbejdere, dog dårlige arbejdstider og generelt hårdt arbejdspres', 4, 'Kok', 10, 9, 10, 6, 9, 6, 2, 1),
       ('Generelt et fint arbejde, men lønnen er ikke særlig god, og der er mange udskiftninger i personalet', 3, 'Leder', 4, 5, 3, 4, 6, 5, 3, 2),
       ('Hårdt arbejdspres og en leder som generelt er meget uforstående overfor hvilke problemer der er.', 2, 'Tjener', 9, 8, 9, 6, 5, 10, 1, 2),
       ('Skide irriterende kunder som altid skal brokke sig over det mindste.. Til gengæld er det nogle fede julefrokoster!', 2, 'Tjener', 2, 3, 1, 2, 4, 4, 2, 3),
       ('Lav morale blandt medarbejderne som gør at man altid skal være efter dem.. Men der er nogle flotte tøser blandt dem', 3, 'Leder', 4, 1, 3, 1, 2, 4, 3, 3),
       ('Dejligt arbejdsmiljø, men en rigtig dårlig løn', 2, 'Leder', 5, 1, 5, 3, 5, 2, 1, 4),
       ('Ikke særlig god arbejdsmorale blandt medarbejderne, men dejligt med gratis frokost ordning.. Jeg tog 12 kilo på!', 3, 'Medarbejder', 4, 4, 5, 2, 1, 4, 2, 4),
       ('Rigtig stor føtex som kræver mange måneders ansættelse før man lærer at finde rundt i de forskellige afdelinger', 3, 'Afdelingsleder', 6, 4, 6, 6, 4, 5, 3, 5),
       ('Nogle virkelig dårlige arbejdsforhold, der lugter helt ekstremt grimt i flaskerummet!', 1, 'Flaskedreng', 3, 2, 5, 5, 3, 2, 1, 5),
       ('Nogle rigtig dejlige arbejdskollegaer, som gør arbejdet til en leg. Og så er der gode personalegoder i form af gratis mad og drikke fra bageren og slagteren.', 3, 'Slagter', 5, 6, 6, 5, 7, 8, 2, 6),
       ('Ganske fint arbejde generelt, med nogle gode arbejdstider og en fleksibel og lyttende chef.', 3, 'Bagerjomfru', 7, 8, 6, 9, 7, 6, 3, 6),
       ('Udemærket arbejde, dog ikke de store muligheder for at få ændret sit skema.', 2, 'Ekspedient', 5, 3, 8, 9, 4, 16, 1, 7),
       ('Horrible arbejdstider, og generelt nogle sure og utilfredse kunder.. Kan dog godt forstå dem til tider - maden er ikke særlig god.', 3, 'Leder', 7, 8, 6, 9, 7, 6, 2, 7),
       ('Udemærket med gratis frokost ordning, men til gengæld er ledelsen ikke særlig god. De ansætter uudannede folk til at lede.', 2, 'Ekspedient', 7, 4, 2, 9, 7, 6, 3, 8),
       ('Generelt nogle ubehøvlede ekspedienter de får ansat sig, de er sløve og dovne, og gør aldrig hvad der bliver sagt.', 3, 'Sou Chef', 1, 2, 8, 5, 3, 6, 1, 8),
       ('En helt udemærket arbejdsplads, dog er der nærmest ikke andet end sure kunder i røret dagen lang. De brokker sig konstant over forsinkede tog og forlanger at få refundering på deres billetter.', 3, 'Telefondame', 3, 9, 8, 4, 7, 25, 2, 9),
       ('Har været sygemeldt med stress af flere omgange pga. den negative omtale som får tonsvis af kunder til at ringe ind dagligt og nedgøre virksomheden - det tærer hårdt på psyken.', 2, 'Telefonist', 5, 3, 4, 1, 2, 35, 1, 9),
       ('Et meget stille og roligt job, hvor man får set en masse dansk natur. Dog er der alt for ofte nogle idioter der falder ud på skinnerne, fordi de har hovedet begravet i deres telefon.', 5, 'Togfører', 7, 5, 8, 3, 1, 75, 2, 10),
       ('Et til tider meget ensomt job, da man ofte er alene i togene, når man cruiser rundt på de danske spor. Men man får set en masse flotte omgivelser.', 5, 'Togfører', 8, 3, 6, 4, 3, 45, 3, 10);

INSERT INTO saltyfirm.vote
(vote, user_fk_id, review_fk_id)
VALUES (true, 1, 1),
       (false, 2, 1),
       (true, 3, 2),
       (true, 1, 2),
       (false, 2, 3),
       (false, 3, 3),
       (true, 1, 4),
       (false, 2, 4),
       (true, 3, 5),
       (true, 1, 5),
       (false, 2, 6),
       (true, 3, 6),
       (false, 1, 7),
       (false, 2, 7),
       (true, 3, 8),
       (true, 1, 8),
       (true, 2, 9),
       (false, 3, 9),
       (true, 1, 10),
       (true, 2, 10),
       (false, 3, 11),
       (false, 1, 11),
       (false, 1, 12),
       (false, 1, 12);

UPDATE saltyfirm.department
SET department_score =
        (SELECT
                 (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS avg_score) /
                 (SELECT COUNT(benefits)) AS total_avg_score
         FROM review
         WHERE department_fk_id = department_id)
WHERE department_id > 0;

UPDATE saltyfirm.firm
SET overall_score =
        (SELECT AVG(department_score)
         FROM department
         WHERE firm_fk_id = firm_id)
WHERE firm_id > 0;
