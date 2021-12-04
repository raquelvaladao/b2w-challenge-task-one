## What did I do 👇
+ Just did one task (Task 1) of a backend challenge for fun.
Link: https://github.com/b2w-marketplace/challenge-backend

#### How to run
+ This project runs on MySQL although it's not needed since I only did task one for now.
So just remember to check your user, password and port in application.properties.
+ Run ./mvnw spring-boot:run
## Backend Challenge BIT - SP

1) Develop a rest service that uses this Order API [(link)](http://www.mocky.io/v2/5817803a1000007d01cc7fc9) and, based on the result, filters by data according to the parameters sent by HTTP request.
   The service must follow this definition:

#### Request
```
GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```
#### Response
```
[
  {
    "name": "Impressora",
    "code": "5",
    "date": "2016-10-05T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  {
    "name": "Fifa2017",
    "code": "6",
    "date": "2016-10-06T14:30:37.040Z",
    "dimension": {
      "weight": 10.5,
      "height": 10.5,
      "width": 10.5,
      "length": 10.5
    }
  },
  .
  .
  .
]
```

## Criterias for this task:
- Quality and organization of the code;
- Pay attention to the requirements;
- Use Java 6 or newer (or Elixir language)
- The candidate can choose any framework
