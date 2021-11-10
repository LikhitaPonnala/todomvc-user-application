package mvc_reminder.pages;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Actions {

    public static Performable newReminder(String reminder) {
        return Task.where("{0} type a new pages reminder '" + reminder + "'",
                Enter.theValue(reminder)
                        .into(AllElements.NEW_TODO_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }
}
