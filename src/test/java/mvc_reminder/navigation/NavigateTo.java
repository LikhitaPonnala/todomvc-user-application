package mvc_reminder.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theMvcToDoLandingPage() {
        return Task.where("{0} opens the MVC ToDo landing page",
                Open.browserOn().the(MvcToDoLandingPage.class));
    }
}
