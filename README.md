# mcs (Java)

mcs is a Java-based project that allows users to scrape metadata from Metacritic pages and retrieve information about games such as their titles, platforms, release dates, critic scores, and links. 

As this is still a work in progress things are subject to drastic change. Currently only game list links and game webpages are able to properly be scraped.

## Prerequisites

In order to use mcs, you will need to have Java version 1.8 or higher installed on your computer.

mcs depends on the following libraries, which are included in both the pom.xml of the project and the jar file:

* [Jsoup](https://jsoup.org/)

## Getting Started

1. Clone this repository to your local machine or download the jar file under `Releases`.
2. Import the project or jar into your preferred Java development environment.
3. Create a new instance of the `mcsList` or `mcsItem` class to scrape metadata from a Metacritic page or a specific game URL.
4. Use the methods provided by the `mcsList` or `mcsItem` class to retrieve the desired metadata.

## Usage

### mcsList

The `mcsList` class is used to scrape metadata from a Metacritic page containing a list of games. Here is an example of how to use the `mcsList` class:

```java
mcsList list = new mcsList();
list.initializeList("https://www.metacritic.com/browse/games/score/metascore/all/all/filtered");
ArrayList<String> titles = list.getTitles();
```

In this example, a new `mcsList` object is created and initialized with a Metacritic URL. The `getTitles()` method is then used to retrieve an `ArrayList` of game titles.

### mcsItem

The `mcsItem` class is used to scrape metadata from a specific game URL. Here is an example of how to use the `mcsItem` class:

```java
mcsItem item = new mcsItem();
item.initializeItem("https://www.metacritic.com/game/wii/pokepark-2-wonders-beyond");
String title = item.getTitle();
```

In this example, a new `mcsItem` object is created and initialized with a Metacritic URL for a specific game. The `getTitle()` method is then used to retrieve the game title.

## Contributing

Contributions to Metacritic Scraper are welcome! If you would like to contribute, please fork this repository and create a new pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.