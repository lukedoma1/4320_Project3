package io.cucumber.skeleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import java.util.*;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {

    private static final int DEFAULT_RANGE = 100;
    private String messageFromSean;
    private Network network = new Network(DEFAULT_RANGE);
    private Map<String, Person> people;

    @Before
    public void createNetwork() {
        people = new HashMap<>();
    }


    @Given("a person named {word}")
    public void a_person_named(String name) throws Throwable {
        people.put(name, new Person(network, 0));
    }

    @When("Sean shouts")
    public void sean_shouts() throws Throwable {
        people.get("Sean").shout("Hello, world");
    }

    @When("Sean shouts {string}")
    public void sean_shouts_message(String message) throws Throwable {
        people.get("Sean").shout(message);
        messageFromSean = message;
    }

    @Then("Lucy should hear Sean's message")
    public void lucy_hears_Sean_s_message() throws Throwable {
        assertEquals(Collections.singletonList(messageFromSean), people.get("Lucy").getMessagesHeard());
    }

    @Then("Lucy should hear a shout")
    public void lucy_should_hear_a_shout() throws Throwable {
        assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }

    @Then("Larry should not hear a shout")
    public void larry_should_not_hear_a_shout() throws Throwable {
        assertEquals(0, people.get("Larry").getMessagesHeard().size());
    }

    @Given("the range is {int}")
    public void the_range_is(int range) throws Throwable {
        network = new Network(range);
    }

//////For the first failed scenario:

        @Given("a person named {word} is located at {int}")
        public void a_person_named_is_located(String name, int location) throws Throwable {
            people.put(name, new Person(network, location));
        }


//    @Given("a person named/called {word} is located/positioned at {int}")
//    public void a_person_named_is_located(String name, int location) throws Throwable {
//        people.put(name, new Person(network, location));
//    }
//
//////For the second failed scenario:
//
//    @When("Sarah shouts")
//    public void sarah_shouts() throws Throwable {
//        people.get("Sarah").shout("Hello, world");
//    }
//
//    @Then("Lauren should not hear a shout")
//    public void lauren_should_not_hear_a_shout() throws Throwable {
//        assertEquals(0, people.get("Lauren").getMessagesHeard().size());
//    }


}