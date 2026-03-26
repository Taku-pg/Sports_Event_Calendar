ALTER TABLE City
DROP CONSTRAINT City_Country;

ALTER TABLE Event
DROP CONSTRAINT Event_Venue;

ALTER TABLE Event
DROP CONSTRAINT First_Team;

ALTER TABLE Event
DROP CONSTRAINT Second_Team;

ALTER TABLE Street
DROP CONSTRAINT Street_City;

ALTER TABLE Team
DROP CONSTRAINT Team_Sport_Type;

ALTER TABLE Venue
DROP CONSTRAINT Venue_Street;

-- tables
DROP TABLE City;

DROP TABLE Country;

DROP TABLE Event;

DROP TABLE Sport_Type;

DROP TABLE Street;

DROP TABLE Team;

DROP TABLE Venue;

-- End of file.

-- tables
-- Table: City
CREATE TABLE city (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    city_name varchar(50)  NOT NULL,
    _country_id int  NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: Country
CREATE TABLE country (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    country_name varchar(50)  NOT NULL,
    CONSTRAINT country_pk PRIMARY KEY (id)
);

-- Table: Event
CREATE TABLE event (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    event_name varchar(50)  NOT NULL,
    event_date timestamp  NOT NULL,
    _first_team_id int  NOT NULL,
    _second_team_id int  NOT NULL,
    _venue_id int  NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: SportType
CREATE TABLE sport_type (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    sport_type varchar(50)  NOT NULL,
    CONSTRAINT sport_type_pk PRIMARY KEY (id)
);

-- Table: Street
CREATE TABLE street (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    street_name  varchar(50)  NOT NULL,
    _city_id int  NOT NULL,
    CONSTRAINT street_pk PRIMARY KEY (id)
);

-- Table: Team
CREATE TABLE team (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    team_name varchar(50)  NOT NULL,
    _sport_type_id int  NOT NULL,
    CONSTRAINT team_pk PRIMARY KEY (id)
);

-- Table: Venue
CREATE TABLE venue (
    id int  NOT NULL GENERATED ALWAYS AS IDENTITY,
    venue_name varchar(50)  NOT NULL,
    building_number int  NOT NULL,
    _street_id int  NOT NULL,
    CONSTRAINT venue_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: City_Country (table: City)
ALTER TABLE city ADD CONSTRAINT city_country
    FOREIGN KEY (_country_id)
    REFERENCES country (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Event_Venue (table: Event)
ALTER TABLE event ADD CONSTRAINT event_venue
    FOREIGN KEY (_venue_Id)
    REFERENCES venue (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: First_Team (table: Event)
ALTER TABLE event ADD CONSTRAINT first_team
    FOREIGN KEY (_first_team_id)
    REFERENCES team (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Second_Team (table: Event)
ALTER TABLE event ADD CONSTRAINT second_team
    FOREIGN KEY (_second_team_id)
    REFERENCES team (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Street_City (table: Street)
ALTER TABLE street ADD CONSTRAINT street_city
    FOREIGN KEY (_city_id)
    REFERENCES city (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Team_SportType (table: Team)
ALTER TABLE team ADD CONSTRAINT team_sport_type
    FOREIGN KEY (_sport_type_id)
    REFERENCES sport_type (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Venue_Street (table: Venue)
ALTER TABLE venue ADD CONSTRAINT venue_street
    FOREIGN KEY (_street_id)
    REFERENCES street (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- End of file.

