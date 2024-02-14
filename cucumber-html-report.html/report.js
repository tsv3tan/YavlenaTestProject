$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Brokers.feature");
formatter.feature({
  "name": "Search result view",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@brokerSearch"
    }
  ]
});
formatter.scenario({
  "name": "Searched broker is the only one displayed",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@brokerSearch"
    },
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to the brokers page and accept cookies form",
  "keyword": "Given "
});
formatter.match({
  "location": "BrokersSteps.userNavigatesToTheBrokersPageAndAcceptCookiesForm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks to load more brokers button",
  "keyword": "When "
});
formatter.match({
  "location": "BrokersSteps.userClicksToLoadMoreBrokersButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user stores all the brokers names",
  "keyword": "And "
});
formatter.match({
  "location": "BrokersSteps.userStoresAllTheBrokersNames()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});