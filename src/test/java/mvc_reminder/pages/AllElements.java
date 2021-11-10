package mvc_reminder.pages;

import net.serenitybdd.screenplay.targets.Target;

public class AllElements {

    public static final Target NEW_TODO_FIELD = Target.the("new pages field")
            .locatedBy("//input[@class=\'new-todo\']");

    public static final Target TODO_LIST = Target.the("pages lists")
            .locatedBy("//li[@class=\'todo\']");

    public static final Target TODO_ACTIVE_COUNT = Target.the("pages active count")
            .locatedBy("//span[@class=\'todo-count\']//strong");

    public static Target COMPLETE_TASK(String text){
        return Target.the("complete task")
                .locatedBy("//label[contains(text(), \'" + text + "\')]//preceding-sibling::input");
    }

}
