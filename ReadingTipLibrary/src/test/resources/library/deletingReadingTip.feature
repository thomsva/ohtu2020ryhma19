@run
Feature: As a user, I want to be able to delete a reading tip

    Scenario: user can delete an existing reading tip
	Given reading tip with title "Kaiken käsikirja" and type "book" is created
	And command delete is selected
	When reading tip id "1" is given
	Then system will respond with "Reading tip is deleted."

    Scenario: user cannot delete nonexisting reading tip
        Given reading tip with title "Kaiken käsikirja" and type "book" is created
        And command delete is selected
        When reading tip id "2" is given
        Then system will respond with "Reading tip doesn't exist."