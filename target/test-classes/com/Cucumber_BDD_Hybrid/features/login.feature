Feature: feature to test login functionality


  Scenario: loginTest to aplication validation
    Given User login to Applictaion
    Then User can able to see the paga title
    And User can able to see the paga element


  Scenario: loginTest to Book a Free Demo page validation
    When User click on the Book a Free Demo button
    Then User can able to see the Book a Free Demo page title
    And User can able to see the Book a Free Demo paga element
    When User close the Applicatin
