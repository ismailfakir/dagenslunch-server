package net.cloudcentrik.dagenslunch.views;

import io.dropwizard.views.View;
import net.cloudcentrik.dagenslunch.core.People;

public class PersonView extends View {
    private final People person;

    public PersonView(People person) {
        super("all_restaurant.ftl");
        this.person = person;
    }

    public  People getPerson() {
        return person;
    }
}