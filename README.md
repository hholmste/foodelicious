[![Build Status](https://travis-ci.org/mariusbreivik/foodelicious.png?branch=master)](https://travis-ci.org/mariusbreivik/foodelicious)

foodelicious
============

Prerequisites:
- Java 1.7 or above
- Mongodb installed and running @ localhost:27017. This can be configured in foodelicious.yml

Get Started
-----------

1. git clone https://github.com/mariusbreivik/foodelicious.git
2. mvn package
3. java -jar target/foodelicious.jar server ./foodelicious.yml
4. open http://localhost:8080/index.html  with a prefered browser


Development
-----------

Post data to recipe endpoint:

    curl -H "Content-Type: application/json" -X POST -d '@src/test/resources/fixtures/recipe.json' http://localhost:8080/foodelicious/recipe
