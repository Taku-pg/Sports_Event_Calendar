# Sport event calendar
## Overview of project
This application provide functionalities of 
- Display list of all events
- Display detail of each event
- Create new event



### Entity diagram
<img width="943" height="472" alt="Image" src="https://github.com/user-attachments/assets/a553302c-8d67-4f5a-bf45-5b41b204a4d2" />

### Tech
- Java 25
- Spring Boot 4.0.4
- Thymeleaf
- PostgreSQL
- Gradle

## Setup
1. Clone this repository

`git clone https://github.com/Taku-pg/Sports_Event_Calendar.git`

2. Go to the project folder
   
`cd Sports_Event_Calendar`

3. This application runs on local PostgreSQL database

```
url: jdbc:postgresql://localhost:5432/sports_event_calendar_db
username: sports_event_calendar
password: password
```

4. Login postgreSQL as super user

`psql -U yourSuperUserName`

5. Create user and database on local host

```
CREATE DATABASE sports_event_calendar_db;
CREATE USER sports_event_calendar WITH PASSWORD 'password';
ALTER DATABASE sports_event_calendar_db OWNER TO sports_event_calendar;
```

6. Logout from super user and initialize schema and insert sample data
   You can use schema.sql and data.sql in this project folder
   Password is 'password'
```
psql -U sports_event_calendar -d sports_event_calendar_db -f src/main/resources/data/Sport_event_calendar_schema.sql
psql -U sports_event_calendar -d sports_event_calendar_db -f src/main/resources/data/Sport_event_calendar_data.sql
```

7. Run application
   
`gradle bootrun`

8. Access the URL
   
`http://localhost:8080`
