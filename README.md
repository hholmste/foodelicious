[![Build Status](https://travis-ci.org/mariusbreivik/foodelicious.png?branch=master)](https://travis-ci.org/mariusbreivik/foodelicious)

# foodelicious


Prerequisites:
- Java 1.7 or above
- Mongodb installed and running @ localhost:27017. This can be configured in foodelicious.yml

## Get Started

1. git clone https://github.com/mariusbreivik/foodelicious.git
2. mvn package
3. java -jar target/foodelicious.jar server ./foodelicious.yml
4. open http://localhost:8080/index.html  with a prefered browser


## Development

### Inserting data

Post data to recipe endpoint:

    curl -H "Content-Type: application/json" -X POST -d '@src/test/resources/fixtures/recipe.json' http://localhost:8080/foodelicious/recipe

### Front end

In order to ease front end development we use grunt. We use grunt to serve our static files so that we easily can reload them without repackaging the dropwizard jar.

Grunt is set up in the src/main/resources/assets-folder, where our static files are.

#### Set up grunt
First you need 'node'. On OS X you can do this with homebrew:

    brew install node
    
Then you need grunt:

    npm install -g grunt-cli
    
Now you have both node and grunt. The next step is to install the project dependencies. In 'src/main/resources/assets', run:

    npm install
    
This should install required dependencies (which are specified in package.json).

Now you can run the configured grunt tasks.

* grunt jshint - this will check our javascript files for any stupid mistakes
* grunt server - this will host our static resources (on port 8090) and a proxy that proxies calls to our dropwizard backend. This assumes a running foodelicious dropwiard service at port 8080.