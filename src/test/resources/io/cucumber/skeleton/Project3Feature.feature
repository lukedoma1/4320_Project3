Feature: Hear shout

  Shouty allows users to "hear" other users "shouts" as long as they are close enough to each other.

  Rule: Shouts can be heard by other users

    Scenario: Listener hears a message
      Given a person named Sean
      And a person named Lucy
      When Sean shouts "free bagels at Sean's"
      Then Lucy should hear Sean's message

  Rule: Shouts should only be heard if listener is within range

    Scenario: Listener is within range
      Given the range is 100
      And a person named Sean is located at 0
      And a person named Lucy is located at 50
      When Sean shouts
      Then Lucy should hear a shout

    Scenario: Listener is out of range - larry is 150 units away
      Given the range is 100
      And a person named Sean is located at 0
      And a person named Larry is located at 150
      When Sean shouts
      Then Larry should not hear a shout


#    #scenarios set to fail for demo
#    Scenario: Listener is out of range - larry is 200 units away
#      Given the range is 100
#      And a person called Sean is positioned at 0
#      And a person called Larry is positioned at 200
#      When Sean shouts
#      Then Larry should not hear a shout
##
##    Scenario: Listener is not in range - Lauren is 250 units away
#      Given the range is 150
#      And a person called Sarah is located at 0
#      And a person named Lauren is positioned at 250
#      When Sarah shouts
#      Then Lauren should not hear a shout