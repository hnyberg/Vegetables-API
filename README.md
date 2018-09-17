# Vegetables-API
Trying out Spring Boot to make an API

## Instructions
To compile and run program as a API-server, runt the "run.sh" script, which will compile the program and then run the resulting jar.

The server runs a CRUD HTTP RESP-API at `http://localhost:8080` .
Data is in the following `JSON` format:

```javascript
  [  
    {  
      id: 1,  
      name: "Tomato",  
      price: 16  
    }  
  ]  
```

* `GET /vegetables` : returns all existing vegetables
* `GET /vegetables/{id}` : returns id-specific vegetable
* `POST /vegetables/` : add a vegetable
* `PUT /vegetables/{id}` : update id-specific vegetable with new data
* `DELETE /vegetables/{id}` : delete id-specific vegetable
