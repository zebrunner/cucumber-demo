@FeatureGSMArena
Feature: GSM Arena News testing
  In order to use Cucumber in my project, I want to check how to test GSM Arena News page

  @FeatureFullGSMArena
  Scenario Outline: GSM Arena open page - passing
    Given I am on main page
    When I open 'News' page
    Then page 'News' should be open
    And page 'News' should contains all items
Then run test with "<id>", "<Name>", "<DATA>"
    Examples:
    |id|Name|DATA
    |1 |Example Name1|Example Data1
    |2 |Example Name2|Example Data2
    |3 |Example Name3|Example Data3
    |4 |Example Name4|Example Data4
    |5 |Example Name5|Example Data5
    |6 |Example Name6|Example Data6
    |7 |Example Name7|Example Data7
    |8 |Example Name8|Example Data8
    |9 |Example Name9|Example Data9
    |10 |Example Name10|Example Data10
    |11 |Example Name11|Example Data11

