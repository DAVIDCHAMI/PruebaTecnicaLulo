
## Run the all the tests
- mvn clean verify

## Run tests by tag
- mvn clean verify -Dcucumber.filter.tags="@signup"
- mvn clean verify -Dcucumber.filter.tags="@update"

## Run tests in a specific environment
- mvn verify -Pdev -Dcucumber.filter.tags="@signup"
- mvn verify -Pprod -Dcucumber.filter.tags="@update"




