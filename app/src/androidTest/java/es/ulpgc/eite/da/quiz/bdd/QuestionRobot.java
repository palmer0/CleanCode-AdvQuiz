package es.ulpgc.eite.da.quiz.bdd;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import es.ulpgc.eite.da.quiz.R;
import es.ulpgc.eite.da.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class QuestionRobot {


    private ActivityTestRule<QuestionActivity> testRule = new ActivityTestRule<>(
        QuestionActivity.class, false, false
    );

    private String[] quiz;
    private String correct, incorrect, empty, next, cheat;

    public void mostrarPantallaQuestion() {
        testRule.launchActivity(null);
        Context ctx = testRule.getActivity();

        quiz = ctx.getResources().getStringArray(R.array.quiz_array);
        correct = ctx.getString(R.string.correct_reply);
        incorrect = ctx.getString(R.string.incorrect_reply);
        empty = ctx.getString(R.string.empty_reply);
        next = ctx.getString(R.string.next_button);
        cheat = ctx.getString(R.string.cheat_button);

    }

    public void mostrarTextoQuestion1() {
        onView(withId(R.id.questionTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[0])));
    }

    public void mostrarMensajeVacio() {
        onView(withId(R.id.replyTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(empty)));
    }

    public void mostrarBotonOptionActivado() {
        onView(withId(R.id.option1Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[1])))
            .check(matches(isEnabled()));
        onView(withId(R.id.option2Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[2])))
            .check(matches(isEnabled()));
        onView(withId(R.id.option3Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[3])))
            .check(matches(isEnabled()));
    }

    public void mostrarBotonCheatActivado() {
        onView(withId(R.id.cheatButton))
            .check(matches(isDisplayed()))
            .check(matches(withText(cheat)))
            .check(matches(isEnabled()));
    }

    public void mostrarBotonNextDesactivado() {
        onView(withId(R.id.nextButton))
            .check(matches(isDisplayed()))
            .check(matches(withText(next)))
            .check(matches(not(isEnabled())));
    }

    public void pulsarBotonOption2() {
        onView(withId(R.id.option2Button)).perform(click());
    }

    public void pulsarBotonOption3() {
        onView(withId(R.id.option3Button)).perform(click());
    }

    public void mostrarMensajeIncorrect() {
        onView(withId(R.id.replyTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(incorrect)));
    }

    public void mostrarMensajeCorrect() {
        onView(withId(R.id.replyTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(correct)));
    }

    public void mostrarBotonOptionDesactivado() {
        onView(withId(R.id.option1Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[1])))
            .check(matches(not(isEnabled())));
        onView(withId(R.id.option2Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[2])))
            .check(matches(not(isEnabled())));
        onView(withId(R.id.option3Button))
            .check(matches(isDisplayed()))
            .check(matches(withText(quiz[3])))
            .check(matches(not(isEnabled())));
    }

    public void mostrarBotonCheatDesactivado() {
        onView(withId(R.id.cheatButton))
            .check(matches(isDisplayed()))
            .check(matches(withText(cheat)))
            .check(matches(not(isEnabled())));
    }

    public void mostrarBotonNextActivado() {
        onView(withId(R.id.nextButton))
            .check(matches(isDisplayed()))
            .check(matches(withText(next)))
            .check(matches(isEnabled()));
    }
}