Feature: As a user I want to be able to save a reading tip


    Scenario: Save and find a book tip
        Given command add is selected
        When a reading tip "New Tip" with type "book" is created
        And all reading tips are listed
        Then a reading tip "New Tip" with type "book" is printed

    
    Scenario: Save and find a blog post tip
        Given command add is selected
        When a reading tip "New Tip" with type "blogpost" is created
        And all reading tips are listed
        Then a reading tip "New Tip" with type "blogpost" is printed
        
    
    Scenario: Save and find a video tip
        Given command add is selected
        When a reading tip "New Tip" with type "video" is created
        And all reading tips are listed
        Then a reading tip "New Tip" with type "video" is printed

    
    Scenario: Save and find a podcast tip
        Given command add is selected
        When a reading tip "New Tip" with type "podcast" is created
        When all reading tips are listed
        Then a reading tip "New Tip" with type "podcast" is printed



    Scenario: Save a book tip
        Given a reading tip "New Tip" with type "book" is created
        When all reading tips are listed
        Then a reading tip "New Tip" with type "book" is printed

    Scenario: Save a blog post tip
        Given a reading tip "New Tip" with type "blogpost" is created
        When all reading tips are listed
        Then a reading tip "New Tip" with type "blogpost" is printed

    Scenario: Save a video tip
        Given a reading tip "New Tip" with type "video" is created
        When all reading tips are listed
        Then a reading tip "New Tip" with type "video" is printed

    Scenario: Save a podcast tip
        Given a reading tip "New Tip" with type "podcast" is created
        When all reading tips are listed
        Then a reading tip "New Tip" with type "podcast" is printed