BEGIN;
-- demo data
INSERT INTO sport_type (sport_type) Values
    ('Baseball'),
    ('Football'),
    ('Basketball'),
    ('Volleyball'),
    ('Rugby');

INSERT INTO team (team_name, _sport_type_id)
    SELECT t.team_name, s.id
    FROM (
        VALUES
            ('Giants', 'Baseball'),
            ('Fighters', 'Baseball'),
            ('Kagome', 'Football'),
            ('Kojima', 'Football'),
            ('Jakobs', 'Basketball'),
            ('Buffalo', 'Basketball'),
            ('Flag Star', 'Volleyball'),
            ('Blossom', 'Volleyball'),
            ('Suntory', 'Rugby'),
            ('All Blacks', 'Rugby')
        ) AS t(team_name, sport_type)
        JOIN sport_type s
            ON s.sport_type = t.sport_type;

INSERT INTO country (country_name) VALUES
    ('Poland'),
    ('Japan'),
    ('Germany'),
    ('England');

INSERT INTO city (city_name, _country_id)
    SELECT ci.city_name, c.id
    FROM (
        VALUES
            ('Warsaw', 'Poland'),
            ('Tokyo', 'Japan'),
            ('Berlin', 'Germany'),
            ('London', 'England'),
            ('Scotland', 'England')
        ) AS ci(city_name, country_name)
        JOIN Country c
            ON c.country_name = ci.country_name;


INSERT INTO street (street_name, _city_id)
    SELECT s.street_name, c.id
    FROM (
        VALUES
            ('Księcia Józefa Poniatowskiego', 'Warsaw'),
            ('Chazawa street', 'Tokyo'),
            ('Olympischer Platz', 'Berlin'),
            ('London street', 'London'),
            ('Scotch street', 'Scotland')
         ) AS s(street_name, city_name)
        JOIN City c
            ON c.city_name = s.city_name;

INSERT INTO venue (venue_name, building_number, _street_id)
    SELECT v.venue_name, v.building_number, s.id
    FROM (
        VALUES
            ('PGE Narodowy', 1,'Księcia Józefa Poniatowskiego'),
            ('Tokyo dome', 12, 'Chazawa street'),
            ('Olympia Stadium', 32, 'Olympischer Platz'),
            ('National Stadium', 2, 'London street'),
            ('Hungover Stadium', 99, 'Scotch street')
        ) AS v(venue_name, building_number, street_name)
        JOIN Street s
            ON s.street_name = v.street_name;


INSERT INTO event (event_name, event_date, _first_team_id, _second_team_id, _venue_id)
    SELECT e.event_name, e.event_date, t1.id, t2.id, v.id
    FROM(
        VALUES
            ('Baseball championship','2026-07-12 18:30:00'::timestamp, 'Giants', 'Fighters', 'PGE Narodowy'),
            ('National football league','2026-07-18 15:00:00'::timestamp,'Kagome','Kojima','Tokyo dome'),
            ('Berlin basketball tournament','2026-08-02 17:00:00'::timestamp,'Jakobs','Buffalo','Olympia Stadium'),
            ('World volleyball tour','2026-08-10 18:30:00'::timestamp,'Flag Star','Blossom','National Stadium'),
            ('WRT','2026-09-10 12:30:00'::timestamp,'Suntory','All Blacks','Hungover Stadium')
        ) AS e(event_name,event_date, first_team, second_team, venue_name)
        JOIN Team t1
            ON t1.team_name = e.first_team
        JOIN Team t2
            ON t2.team_name = e.second_team
        JOIN Venue v
            ON v.venue_name = e.venue_name;


COMMIT;