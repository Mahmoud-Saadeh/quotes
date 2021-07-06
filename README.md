# Quotes

## Problem Domain
there are a json data that have an array of quotes, and it is required to read it and output a random quote and to be able to search for a quote by the author name

## Usage

1. you can just run the code with `./gradlew run` and get a random quote 
1. or you can search for a quote by the author name by running this command: `./gradlew run --args 'authorName'` or `"'author name'"` if the author name of two words

## Methods

1. in [App](src/main/java/quotes/App.java) file there are 2 methods:
    - main: to call the required methods and collect user input
    - randomQuote: to give a random number between 0 and the array length
    
1. in [FileToString](src/main/java/quotes/FileToString.java) I implemented [FilesToString](src/main/java/quotes/FilesToString.java) interface to use readFile method and there are 2 methods in this class:
    - readFile: to read the json file and convert it to string
    - getStringFile: is a getter to send the converted file
    
1. in [ParseString](src/main/java/quotes/ParseString.java) I implemented [StringToJSON](src/main/java/quotes/StringToJSON.java) interface to use convertString method and there are 4 methods in this class:
    - convertString: to call the readFile method and then use GSON library to Parse the string
        - Accepts a path string
    - searchByAuthor: loop through the parsed data and return true or false on weather the author exist or not
        - Accepts an author name (String)
    - getQuote & getParsedData: getters to send the data
    
1. in [Quote](src/main/java/quotes/Quote.java) class there are:
    - Quote: Constructor for the author, and the text
    - getAuthor: getter for the author
    - toString: to print the data nicely
    
> [Json file](src/main/resources/recentquotes.json)

## Tests

1. in [AppTest](src/test/java/quotes/AppTest.java) there are tests for every method:
    - FileToStringAndParsTest: test if the data are being converted correctly
    - searchByAuthorTest: test if the search by author is working
> [Json file](src/test/resources/test.json)


## Libraries

1. [Gson](https://github.com/google/gson)