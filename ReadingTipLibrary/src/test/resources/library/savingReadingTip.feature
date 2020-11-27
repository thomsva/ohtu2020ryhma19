Feature: As a user I want to be able to save a reading tip

    Scenario: Save a book tip
        Given a reading tip "New Tip" with type "book" is created
        When it is saved to the database
        Then it can be found from the database

    Scenario: Save a blog post tip
        Given a reading tip "New Tip" with type "blogpost" is created
        When it is saved to the database
        Then it can be found from the database

    Scenario: Save a video tip
        Given a reading tip "New Tip" with type "video" is created
        When it is saved to the database
        Then it can be found from the database

    Scenario: Save a podcast tip
        Given a reading tip "New Tip" with type "podcast" is created
        When it is saved to the database
        Then it can be found from the database