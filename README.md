# ohtu2020ryhma19

![Java CI with Gradle](https://github.com/Muisku/ohtu2020ryhma19/workflows/Java%20CI%20with%20Gradle/badge.svg)

## Backlogit

[Sprint Backlog](https://github.com/Muisku/ohtu2020ryhma19/projects/1)

[Product Backlog](https://github.com/Muisku/ohtu2020ryhma19/projects/2)


## Doukumentaatio

[Tuntilista](https://github.com/Muisku/ohtu2020ryhma19/blob/main/Dokumentaatio/Tunnit.md)

[Sovellusarkkitehtuuri](Dokumentaatio/Sovellusarkkitehtuuri.md)

## Definition of Done

* User storien hyväksymiskriteerit täyttyvät eli Cucumber-testit menevät läpi
* Jacocolla mitattu JUnit-testikattavuus vähintään 70 %
* Koodin tyyli vastaa checkstyle-määrittelyjä
* Luokat ja metodit dokumentoitu JavaDocilla
* Käännös ja testit suoritettu virheettä GitHub Actionsissa

## Asennus- ja käynnistysohje

Lataa ohjelmakoodi GitHubista ja avaa asennuskansio terminaalilla. Kirjoita seuraavat komennot:
* cd ReadingTipLibrary
* ./gradlew shadowJar
* java -jar build/libs/ReadingTipLibrary-all.jar
