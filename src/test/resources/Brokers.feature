@brokerSearch
Feature: Search result view

  Background: Get all brokers
  Given User navigates to the brokers page and accept cookies form
    When user clicks to load more brokers button
    And user stores all the brokers names


  @smoke
  Scenario: Searched broker is the only one displayed
    Then user verifies broker name, address, properties and phone are visible

