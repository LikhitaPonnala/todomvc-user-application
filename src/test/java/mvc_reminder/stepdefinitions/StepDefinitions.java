package mvc_reminder.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mvc_reminder.navigation.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import mvc_reminder.pages.Actions;
import mvc_reminder.pages.AllElements;

import java.util.List;

public class StepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("{actor} has no reminders in his list")
    public void user_has_no_reminders_in_his_list(Actor actor) {
        actor.attemptsTo(
                Ensure.that(AllElements.NEW_TODO_FIELD).isNotDisplayed()
        );
    }

    @Given("{actor} is on create reminder landing page")
    public void is_on_create_reminder_landing_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.theMvcToDoLandingPage());
    }

    @When("{actor} refreshes the reminder landing page")
    public void refreshes_the_reminder_landing_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.theMvcToDoLandingPage());
    }


    @And("{actor} should see a total of {int} reminders added to the list")
    public void should_see_a_total_of_reminders_added_to_the_list(Actor actor, int size) {
        actor.attemptsTo(
                Ensure.thatTheSetOf(AllElements.TODO_LIST)
                        .hasSize(size)
        );
    }


    @When("{actor} creates a reminder {string}")
    public void creates_a_reminder(Actor actor, String newItem) {
        actor.attemptsTo(
                Actions.newReminder(newItem)
        );
    }


    @When("{actor} creates following reminders")
    public void creates_following_reminders(Actor actor, List<String> reminders) {

        for (int i = 0; i < reminders.size(); i++) {
            actor.attemptsTo(
                    Actions.newReminder(reminders.get(i))
            );
        }
    }

    @Then("{actor} should see {string} added to the reminder list")
    public void should_see_added_to_the_reminder_list(Actor actor, String todoItem) {
        actor.attemptsTo(
                Ensure.that(AllElements.TODO_LIST).hasText(todoItem)
        );
    }

    @When("{actor} strikes out {string}")
    public void strikes_out(Actor actor, String reminder) {
        actor.attemptsTo(Click.on(AllElements.COMPLETE_TASK((reminder))));
    }

    @Then("{actor} sees the active count to be {string}")
    public void sees_the_active_count_to_be(Actor actor, String count) {
        actor.attemptsTo(
                Ensure.that(AllElements.TODO_ACTIVE_COUNT).hasText(count)
        );
    }

}
