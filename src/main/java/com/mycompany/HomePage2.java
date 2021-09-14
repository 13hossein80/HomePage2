package com.mycompany;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class HomePage2 extends WebPage {

    public User user;

    public HomePage2() {

        Form<?> form = new Form("form");

        user = new User("", "", "","","");

        form.add(new TextField<>("firstNameInput",new PropertyModel<>(user,"firstName")));

        form.add(new TextField<>("lastNameInput",new PropertyModel<>(user,"lastName")));

        form.add(new TextField<>("cityInput",new PropertyModel<>(user,"city")));

        form.add(new TextField<>("ageInput",new PropertyModel<>(user,"age")));

        form.add(new TextField<>("countryInput",new PropertyModel<>(user,"country")));

        form.add(new AjaxButton("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                SaveSession.save(user);
                setResponsePage(HomePage2.class);
            }
        });
        add(form);
    }
}