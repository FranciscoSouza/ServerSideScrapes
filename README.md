# ServerSideScrapes project

Console java application to scrapes the Sainsbury’s grocery site 
- Berries, Cherries, Currants page and returns a JSON array of all the products on the page.


## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them
Java 1.7 or high
Apache Maven 3.5.3

### Maven Dependencies

jsoup - parse HTML
gson - to generate JSON format output
junit - for test code

```
		<dependency>
			<!-- jsoup HTML parser library @ https://jsoup.org/ -->
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.11.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.2</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

```

### Build
To Install dependencies, compile, and test:
```
	$ mvn install
```

### Test
Test scenarios:
-testShouldReturnTheRightJSON
	Checked if the JSON is returning properly 
-testJSONIsEmpty
	Checked if the return for a wrong URL is fine
-testgetProducts
	Checked if one product was returned properly

Run only the tests:
```
	$ mvn test
```

Output
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.serversidescrape.ScrapTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.829 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

Output JSON
```
{
  "results": [
    {
      "title": "Sainsbury's Strawberries 400g",
      "description": "by Sainsbury's strawberries",
      "kcal_per_100g": 33,
      "unit_price": 1.75
    },
    {
      "title": "Sainsbury's Blueberries 200g",
      "description": "by Sainsbury's blueberries",
      "kcal_per_100g": 45,
      "unit_price": 1.75
    },
    {
      "title": "Sainsbury's Raspberries 225g",
      "description": "by Sainsbury's raspberries",
      "kcal_per_100g": 32,
      "unit_price": 1.75
    },
    {
      "title": "Sainsbury's Blackberries, Sweet 150g",
      "description": "by Sainsbury's blackberries",
      "kcal_per_100g": 32,
      "unit_price": 1.5
    },
    {
      "title": "Sainsbury's Blueberries 400g",
      "description": "by Sainsbury's blueberries",
      "kcal_per_100g": 45,
      "unit_price": 3.25
    },
    {
      "title": "Sainsbury's Blueberries, SO Organic 150g",
      "description": "So Organic blueberries Plump and Refreshing",
      "kcal_per_100g": 45,
      "unit_price": 2
    },
    {
      "title": "Sainsbury's Raspberries, Taste the Difference 150g",
      "description": "Ttd raspberries",
      "kcal_per_100g": 32,
      "unit_price": 2.5
    },
    {
      "title": "Sainsbury's Cherries 400g",
      "description": "by Sainsbury's Family Cherry Punnet",
      "kcal_per_100g": 52,
      "unit_price": 2.5
    },
    {
      "title": "Sainsbury's Blackberries, Tangy 150g",
      "description": "by Sainsbury's blackberries",
      "kcal_per_100g": 32,
      "unit_price": 1.5
    },
    {
      "title": "Sainsbury's Strawberries, Taste the Difference 300g",
      "description": "Ttd strawberries",
      "kcal_per_100g": 33,
      "unit_price": 2.5
    },
    {
      "title": "Sainsbury's Cherry Punnet 200g",
      "description": "Description Cherries Succulent and sweet 1 of 5 a-day 10 cherries Class I",
      "kcal_per_100g": 0,
      "unit_price": 1.5
    },
    {
      "title": "Sainsbury's Mixed Berries 300g",
      "description": "by Sainsbury's mixed berries",
      "kcal_per_100g": 0,
      "unit_price": 3.5
    },
    {
      "title": "Sainsbury's Mixed Berry Twin Pack 200g",
      "description": "Description Mixed Berries 1 of 5 a-day 80g serving Class I Raspberries grown in Morocco Blueberries grown in Peru",
      "kcal_per_100g": 0,
      "unit_price": 2.75
    },
    {
      "title": "Sainsbury's Redcurrants 150g",
      "description": "by Sainsbury's redcurrants",
      "kcal_per_100g": 71,
      "unit_price": 2.5
    },
    {
      "title": "Sainsbury's Cherry Punnet, Taste the Difference 200g",
      "description": "Cherry Punnet",
      "kcal_per_100g": 48,
      "unit_price": 2.5
    },
    {
      "title": "Sainsbury's Blackcurrants 150g",
      "description": "Description Union Flag",
      "kcal_per_100g": 0,
      "unit_price": 1.75
    },
    {
      "title": "Sainsbury's British Cherry & Strawberry Pack 600g",
      "description": "Description British Cherry & Strawberry Mixed Pack 1 of 5 a-day - 80g serving Class I Union Flag",
      "kcal_per_100g": 0,
      "unit_price": 4
    }
  ],
  "total": 39.5
}
```
