-JDK 17 
-Intelli J 
-Spring Boot 
-Maven 
-JPA

# Pior Filme do Golden Raspberry Awards

## Description

### It is a RESTful API to make it possible to read the list of nominees and winners in the Worst Picture category at the Golden Raspberry Awards

---
## Implemented endpoints:

| Path        | Method | Description        | Example                    |
|-------------|--------|--------------------|----------------------------|
| api/        | GET    | All movie list     | localhost:8080/api/        |
| api/awards  | GET    | Awarded movie list | localhost:8080/api/awards  |
| api/winners | GET    | Winners movie list | localhost:8080/api/winners |
| api/        | POST   | Post by movie      | localhost:8080/api/        |
| api/        | PUT    | Put by movie       | localhost:8080/api/        |
| api/        | DELETE | Delete by movie    | localhost:8080/api/        |
| api/id      | DELETE | Delete by ID       | localhost:8080/api/1       |

---

## Examples Json to use methods

### GET
```http
{
    "id": 1,
    "year": 1980,
    "title": "Can't Stop the Music",
    "studios": "Associated Film Distribution",
    "producer": "Allan Carr",
    "winner": true
},
{
    "id": 2,
    "year": 1980,
    "title": "Cruising",
    "studios": "Lorimar Productions, United Artists",
    "producer": "Jerry Weintraub",
    "winner": false
}
```

### GET - awards
```http
{
    "id": 1,
    "year": 1980,
    "title": "Can't Stop the Music",
    "studios": "Associated Film Distribution",
    "producer": "Allan Carr",
    "winner": true
},
{
    "id": 11,
    "year": 1981,
    "title": "Mommie Dearest",
    "studios": "Paramount Pictures",
    "producer": "Frank Yablans",
    "winner": true
}
```

### GET - winners
```http
{
    "min": [
        {
            "producer": "Joel Silver",
            "interval": 1,
            "previousWin": 1990,
            "followingWin": 1991
        }
    ],
    "max": [
        {
            "producer": "Matthew Vaughn",
            "interval": 13,
            "previousWin": 2002,
            "followingWin": 2015
        }
    ]
}
```

### POST
```http
{
    "year": 2019,
    "title": "Rambo: Last Blood",
    "studios": "Lionsgate",
    "producer": "Avi Lerner, Kevin King Templeton, Yariv Lerner, and Les Weldon",
    "winner": true
}
```

### PUT
```http
{
    "id": 1,
    "year": 2023,
    "title": "Rambo: Last Blood",
    "studios": "Lionsgate",
    "producer": "Avi Lerner",
    "winner": false
}
```

### DELETE
```http
{
    "id": 1,
    "year": 2023,
    "title": "Rambo: Last Blood",
    "studios": "Lionsgate",
    "producer": "Avi Lerner",
    "winner": false
}
```
#### OR - passing only the ID in body

```http
{
    "id": 1
}
```

### DELETE - by ID
```http
Just pass the ID at the end of the url
```


---
## Bugs or improvements

Every project needs improvements, Feel free to report any bugs or improvements. Pull requests are always welcome.
 