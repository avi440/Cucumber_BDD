Feature: Submit Automation demo - Login page

  Background: 
    Given User login to Automation demo aplication Applictaion

  Scenario: Automation demo aplication element verifycation
    Then User can able to see the Automation demo paga title
      | Register |
    And User can able to see the Automation demo paga header element
      | Home          |
      | Register      |
      | WebTable      |
      | SwitchTo      |
      | Widgets       |
      | Interactions  |
      | Video         |
      | WYSIWYG       |
      | More          |
      | Practice Site |
    And User can able to see the Automation demo paga submition field element
      | Full Name*       |
      | Address          |
      | Email address*   |
      | Phone*           |
      | Gender*          |
      | Hobbies          |
      | Languages        |
      | Skills           |
      | Country*         |
      | Select Country : |
      | Date Of Birth    |
      | Password         |
      | Confirm Password |
    And User can able to see the Automation demo paga submition button
      | Submit  |
      | Refresh |
    When close the Applicaton

  Scenario Outline: Automation demo page click on the refresh button
    Then User can able to see the Automation demo paga title
      | Register |
    When User send the data into First Name field
      | FirstName | Aviinash |
    And User send the data into last Name field
      | LastName | Bandaru |
    And User send the data into Adress field
      | Adress | 1-70, mallaparajugudem ,utukuru rode, near ramalayam |
    And User send the data into Email address field
      | EmailAdress | avi123@cars.com |
    And User send the data into Phone field
      | Phone | 7731901595 |
    And User select the Gender
      | Gender | Male |
    And User select the Select Country
      | Select Country | India |
    And User select the Hobbies
      | Hobbies | Cricket,Movies |
    And User select the Languages
      | Languages | Lithuanian,Icelandic |
    And User select the Skills
      | Skills | Client Support |
    #And User select the Select Country
    #| Select Country | India |
    And User select the Date Of Birth
      | Year-Month-Day | 1997-May-25 |
    And User send the Password
      | Password | Avi$570 |
    And User send the Confirm Password
      | Confirm Password | Avi$570 |
    And User upload the file
    And Click on button "Refresh"
    Then User Can able to <Allfields> are empty
    When close the Applicaton

    Examples: 
      | Allfields                                                                                                                                    |
      | FirstName,LastName,Adress,EmailAdress,Phone,Gender,Hobbies,Skill,Languages,country,Select Country,yearbox,monthbox,daybox,Password,CPassword |

  Scenario: Automation demo page Submit the data
    Then User can able to see the Automation demo paga title
      | Register |
    When User send the data into First Name field
      | FirstName | Aviinash |
    And User send the data into last Name field
      | LastName | Bandaru |
    And User send the data into Adress field
      | Adress | 1-70, mallaparajugudem ,utukuru rode, near ramalayam |
    And User send the data into Email address field
      | EmailAdress | avi123@cars.com |
    And User send the data into Phone field
      | Phone | 7731901595 |
    And User select the Gender
      | Gender | Male |
    And User select the Select Country
      | Select Country | India |
    And User select the Hobbies
      | Hobbies | Cricket,Movies |
    And User select the Languages
      | Languages | Lithuanian,Icelandic |
    And User select the Skills
      | Skills | Client Support |
    #And User select the Select Country
    #| Select Country | India |
    And User select the Date Of Birth
      | Year-Month-Day | 1997-May-25 |
    And User send the Password
      | Password | Avi$570 |
    And User send the Confirm Password
      | Confirm Password | Avi$570 |
    And User upload the file
    And Click on button "Submit"
    When close the Applicaton
