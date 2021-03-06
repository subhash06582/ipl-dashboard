# IPL Dashboard
Browse your favorite IPL teams and access their past games details, wins and losses ratios - accessible by team and tournament year.
This is a full Stack Development using Spring Boot and React JS.

## Technologies
* Spring Boot
* Spring Batch
* Java Persistence API, Repositories and JPQL
* HSQL DB
* React JS

### API Endpoints

|     API        |     URL          |
| ------------- | ------------- |
| List of All the Teams playing IPL| http://localhost:8080/team |
| Team details| http://localhost:8080/team/{teamName} |
| List of All Match for a team in particular year| http://localhost:8080/team/{teamName}/matches?year={year} |

## Screenshots

### Team Page

![Team Page Page](/README/team-page.png)

### Matches Page

![Matches Page](/README/matches-page.png)

### Home Page

![Home Page](/README/home-page.png)

## Data Set Used
https://www.kaggle.com/patrickb1912/ipl-complete-dataset-20082020?select=IPL+Matches+2008-2020.csv
