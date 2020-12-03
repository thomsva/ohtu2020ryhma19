@run
Feature: As a user I want to be able to search for reading tips

    Scenario: user can search reading tips by existing author
	Given reading tip with title "Leikkiminen kielletty", type "book", and author "Jukka Laajarinne" is created
        And command search is selected
        And search criteria "author" is selected
        When search term "Jukka Laajarinne" is given
        Then system's response contains "Leikkiminen kielletty"