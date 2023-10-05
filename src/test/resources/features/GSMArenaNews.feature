Feature: GSM Arena News testing
  In order to use Cucumber in my project, I want to check how to test GSM Arena News page

  @demo
  Scenario Outline: GSM Arena open page - passing
    Given I am on main page
    When I open 'News' page
    Then page 'News' should be open
    And page 'News' should contains all items
    Examples: |1321313|34rqwer5er|4r4tt3qt
    |dgfafdgdfgdsfg|wregf43wqg|gewgqrgwgqrg
    |gfrwg4rgtqwfg4e|frawegregregerg|egqwrgf3qg3rg
    |fgwergfwqg4erg |fgawgwgwerg    |gaergbregaegrw3gr

  @demo
  Scenario Outline: GSM Arena open page - failed
    Given I am on main page
    When I open 'News' page
    Then page 'News' should be open
    And page 'News' should contains all items
    Examples: |dsafasdfg|rsgrgargf|rsaggga
    |agsfgarsfg|wregf43wqg|gewgqrgrgasgvsrgvragwgqrg
    |gfrwg4rgtqwfg4e|asdgasrgasrgf|egqwrgf3qg3rg
    |fgwergasrgrsagasrgrasgfwqg4erg |fgasargsrafgsgwgwgwerg    |gaesagsagsggsasgggagrgbregaegrw3gr

