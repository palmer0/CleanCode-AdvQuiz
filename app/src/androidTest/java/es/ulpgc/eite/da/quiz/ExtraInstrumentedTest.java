package es.ulpgc.eite.da.quiz;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExtraInstrumentedTest {

  @Rule
  public ActivityTestRule<QuestionActivity> activityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);



  private void rotate() {

    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = activityTestRule.getActivity();

    if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
  }


  @Test
  public void instrumentedTest() throws Exception {


    // GIVEN

    ViewInteraction button = onView(withId(R.id.cheatButton));
    button.perform(click());

    //Thread.sleep(700);

    ViewInteraction button2 = onView(withId(R.id.yesButton));
    button2.perform(click());


    pressBack();

    //Thread.sleep(700);


    ViewInteraction button5 = onView(withId(R.id.cheatButton));
    button5.perform(click());


    // WHEN


    //Thread.sleep(700);

    rotate();

    //Thread.sleep(700);

    rotate();

    //Thread.sleep(700);


    ViewInteraction button6 = onView(withId(R.id.yesButton));
    button6.perform(click());


    // THEN

    ViewInteraction textView71 = onView(withId(R.id.answerTextView));
    textView71.check(matches(withText("Canadá"))); // error = ""

    // WHEN

    rotate();

    //Thread.sleep(700);


    rotate();

    //Thread.sleep(700);


    // THEN

    ViewInteraction textView7 = onView(withId(R.id.answerTextView));
    textView7.check(matches(withText("Canadá"))); // error = "???"


    // WHEN

    pressBack();

    //Thread.sleep(700);

    // THEN

    ViewInteraction textView3 = onView(withId(R.id.questionTextView));
    textView3.check(matches(
        withText("¿Cómo se llama la tercera isla más grande del mundo?")
    ));
    ViewInteraction textView4 = onView(withId(R.id.replyTextView));
    textView4.check(matches(withText("???")));


  }



  /*
  @Test
  public void instrumentedTest() throws Exception {

    // WHEN

    // Question Screen
    // Question: ¿En qué continente se encuentran los Andes?
    // Reply: ???
    ViewInteraction button = onView(withId(R.id.cheatButton));
    button.perform(click());

    //Thread.sleep(700);

    // Cheat Screen
    // Answer: ???
    ViewInteraction button2 = onView(withId(R.id.yesButton));
    button2.perform(click());


    // THEN

    ViewInteraction textView42 = onView(withId(R.id.answerTextView));
    textView42.check(matches(withText("América del Sur")));


    // Cheat Screen
    // Answer: ???
    pressBack();

    //Thread.sleep(700);

    // Question Screen
    // Question: ¿Qué país es el segundo más grande del mundo?
    // Reply: ???
    ViewInteraction button3 = onView(withId(R.id.cheatButton));
    button3.perform(click());


    //Thread.sleep(700);

    // Cheat Screen
    // Answer: ???
    ViewInteraction button4 = onView(withId(R.id.yesButton));
    button4.perform(click());


    // THEN


    // Cheat Screen
    // Answer: Canadá
    ViewInteraction textView2 = onView(withId(R.id.answerTextView));
    textView2.check(matches(withText("Canadá")));


    // WHEN

    rotate();

    //Thread.sleep(700);

    rotate();

    //Thread.sleep(700);


    // THEN

    // Cheat Screen
    // Answer: Canadá
    ViewInteraction textView23 = onView(withId(R.id.warningTextView));
    textView23.check(matches(withText("Are you sure?")));
    ViewInteraction textView24 = onView(withId(R.id.answerTextView));
    textView24.check(matches(withText("Canadá")));


    // WHEN

    pressBack();

    //Thread.sleep(700);

    // THEN

    // Question Screen
    // Question: ¿Cómo se llama la tercera isla más grande del mundo?
    // Reply: ???
    ViewInteraction textView3 = onView(withId(R.id.questionTextView));
    textView3.check(matches(
        withText("¿Cómo se llama la tercera isla más grande del mundo?")
    ));
    ViewInteraction textView4 = onView(withId(R.id.replyTextView));
    textView4.check(matches(withText("???")));



    // WHEN

    ViewInteraction button5 = onView(withId(R.id.cheatButton));
    button5.perform(click());

    //Thread.sleep(700);

    rotate();

    //Thread.sleep(700);

    rotate();

    //Thread.sleep(700);

    // Cheat Screen
    // Answer: ???
    ViewInteraction button6 = onView(withId(R.id.yesButton));
    button6.perform(click());


    // THEN

    // Cheat Screen
    // Answer: Borneo
    ViewInteraction textView5 = onView(withId(R.id.warningTextView));
    textView5.check(matches(withText("Are you sure?")));
    ViewInteraction textView71 = onView(withId(R.id.answerTextView));
    textView71.check(matches(withText("Borneo"))); // error !

    // WHEN

    rotate();

    //Thread.sleep(700);

    // THEN

    // Cheat Screen
    // Answer: Borneo
    ViewInteraction textView6 = onView(withId(R.id.warningTextView));
    textView6.check(matches(withText("Are you sure?")));
    ViewInteraction textView7 = onView(withId(R.id.answerTextView));
    textView7.check(matches(withText("Borneo")));


    // WHEN

    pressBack();

    //Thread.sleep(700);

    // THEN

    // Question Screen
    // Question: ¿Qué porcentaje de la superficie de la Tierra no es agua?
    // Reply: ???
    ViewInteraction textView33 = onView(withId(R.id.questionTextView));
    textView33.check(matches(
        withText("¿Qué porcentaje de la superficie de la Tierra no es agua?")
    ));
    ViewInteraction textView34 = onView(withId(R.id.replyTextView));
    textView34.check(matches(withText("???")));

  }
  */

}
