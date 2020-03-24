package es.ulpgc.eite.da.quiz.bdd;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.da.quiz.R;
import es.ulpgc.eite.da.quiz.question.QuestionActivity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class QuestionRobot {

    private ActivityController<QuestionActivity> testController;

    private String[] quiz;
    private String correct, incorrect, empty, next, cheat;

    public void mostrarPantallaQuestion() {
        testController = Robolectric.buildActivity(QuestionActivity.class);
        Context ctx = testController.get();

        quiz = ctx.getResources().getStringArray(R.array.quiz_array);
        correct = ctx.getString(R.string.correct_reply);
        incorrect = ctx.getString(R.string.incorrect_reply);
        empty = ctx.getString(R.string.empty_reply);
        next = ctx.getString(R.string.next_button);
        cheat = ctx.getString(R.string.cheat_button);

        testController.create().resume().visible();
    }

    public void mostrarTextoQuestion1() {
        QuestionActivity src1 = testController.get();

        TextView tvQuestion = src1.findViewById(R.id.questionTextView);
        assertThat(tvQuestion.getText().toString(), equalTo(quiz[0]));
    }

    public void mostrarMensajeVacio() {
        QuestionActivity src1 = testController.get();

        TextView tvReply = src1.findViewById(R.id.replyTextView);
        assertThat(tvReply.getText().toString(), equalTo(empty));
    }

    public void mostrarBotonOptionActivado() {
        QuestionActivity src1 = testController.get();

        TextView tvOption1 = src1.findViewById(R.id.option1Button);
        TextView tvOption2 = src1.findViewById(R.id.option2Button);
        TextView tvOption3 = src1.findViewById(R.id.option3Button);

        assertThat(tvOption1.getText().toString(), equalTo(quiz[1]));
        assertThat(tvOption2.getText().toString(), equalTo(quiz[2]));
        assertThat(tvOption3.getText().toString(), equalTo(quiz[3]));
        assertThat(tvOption1.isEnabled(), equalTo(true));
        assertThat(tvOption2.isEnabled(), equalTo(true));
        assertThat(tvOption3.isEnabled(), equalTo(true));
    }

    public void mostrarBotonCheatActivado() {
        QuestionActivity src1 = testController.get();

        Button btnCheat = src1.findViewById(R.id.cheatButton);
        assertThat(btnCheat.getText().toString(), equalTo(cheat));
        assertThat(btnCheat.isEnabled(), equalTo(true));
    }

    public void mostrarBotonNextDesactivado() {
        QuestionActivity src1 = testController.get();

        Button btnNext = src1.findViewById(R.id.nextButton);
        assertThat(btnNext.getText().toString(), equalTo(next));
        assertThat(btnNext.isEnabled(), equalTo(false));
    }

    public void pulsarBotonOption2() {
        QuestionActivity src1 = testController.get();

        TextView tvOption2 = src1.findViewById(R.id.option2Button);
        assertThat(tvOption2.getText().toString(), equalTo(quiz[2]));
        tvOption2.performClick();
    }

    public void pulsarBotonOption3() {
        QuestionActivity src1 = testController.get();

        TextView tvOption3 = src1.findViewById(R.id.option3Button);
        assertThat(tvOption3.getText().toString(), equalTo(quiz[3]));
        tvOption3.performClick();
    }

    public void mostrarMensajeIncorrect() {
        QuestionActivity src1 = testController.get();

        TextView tvReply = src1.findViewById(R.id.replyTextView);
        assertThat(tvReply.getText().toString(), equalTo(incorrect));
    }

    public void mostrarMensajeCorrect() {
        QuestionActivity src1 = testController.get();

        TextView tvReply = src1.findViewById(R.id.replyTextView);
        assertThat(tvReply.getText().toString(), equalTo(correct));
    }

    public void mostrarBotonOptionDesactivado() {
        QuestionActivity src1 = testController.get();

        TextView tvOption1 = src1.findViewById(R.id.option1Button);
        TextView tvOption2 = src1.findViewById(R.id.option2Button);
        TextView tvOption3 = src1.findViewById(R.id.option3Button);

        assertThat(tvOption1.getText().toString(), equalTo(quiz[1]));
        assertThat(tvOption2.getText().toString(), equalTo(quiz[2]));
        assertThat(tvOption3.getText().toString(), equalTo(quiz[3]));
        assertThat(tvOption1.isEnabled(), equalTo(false));
        assertThat(tvOption2.isEnabled(), equalTo(false));
        assertThat(tvOption3.isEnabled(), equalTo(false));
    }

    public void mostrarBotonCheatDesactivado() {
        QuestionActivity src1 = testController.get();

        Button btnCheat = src1.findViewById(R.id.cheatButton);
        assertThat(btnCheat.getText().toString(), equalTo(cheat));
        assertThat(btnCheat.isEnabled(), equalTo(false));
    }

    public void mostrarBotonNextActivado() {
        QuestionActivity src1 = testController.get();

        Button btnNext = src1.findViewById(R.id.nextButton);
        assertThat(btnNext.getText().toString(), equalTo(next));
        assertThat(btnNext.isEnabled(), equalTo(true));

    }

}