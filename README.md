[![Build Status](https://travis-ci.org/mariusbreivik/foodelicious.png?branch=master)](https://travis-ci.org/mariusbreivik/foodelicious)

# foodelicious backend


Prerequisites:
- Java 1.7 or above
- Maven 3.1.1 over above
- Mongodb installed and running @ localhost:27017. This can be configured in foodelicious.yml

## Get Started

1. git clone https://github.com/mariusbreivik/foodelicious.git
2. mvn package
3. java -jar target/foodelicious.jar server ./foodelicious.yml

Foodelicious backend is up and running! Now grab foodelicious-view:

1. Git clone https://github.com/mariusbreivik/foodeliciousv
2. grunt server
3. open http://localhost:8090/index.html  with a prefered browser


## Development

### Inserting data

Post data to recipe endpoint:

    curl -H "Content-Type: application/json" -X POST -d '@src/test/resources/fixtures/recipe.json' http://localhost:8080/foodelicious/recipe