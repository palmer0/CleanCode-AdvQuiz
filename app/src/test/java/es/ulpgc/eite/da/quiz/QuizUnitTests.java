package es.ulpgc.eite.da.quiz;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import es.ulpgc.eite.da.quiz.cheat.CheatActivity;
import es.ulpgc.eite.da.quiz.question.QuestionActivity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(RobolectricTestRunner.class)
public class QuizUnitTests {

  TextView question, reply, warning,answer;
  Button option1, option2, option3, next, cheat, yes, no;

  String[] quiz;
  String empty_reply, empty_answer, correct, incorrect, sure;

  @Before
  public void setup(){

    QuestionActivity screen1=Robolectric.setupActivity(QuestionActivity.class);
    CheatActivity screen2=Robolectric.setupActivity(CheatActivity.class);

    quiz = screen1.getResources().getStringArray(R.array.quiz_array);

    empty_reply =screen1.getResources().getString(R.string.empty_reply);
    correct=screen1.getResources().getString(R.string.correct_reply);
    incorrect=screen1.getResources().getString(R.string.incorrect_reply);

    sure =screen2.getResources().getString(R.string.warning_message);
    empty_answer =screen2.getResources().getString(R.string.empty_answer);

    question = screen1.findViewById(R.id.questionTextView);
    reply = screen1.findViewById(R.id.replyTextView);
    option1 = screen1.findViewById(R.id.option1Button);
    option2 = screen1.findViewById(R.id.option2Button);
    option3 = screen1.findViewById(R.id.option3Button);
    next = screen1.findViewById(R.id.nextButton);
    cheat = screen1.findViewById(R.id.cheatButton);

    warning = screen2.findViewById(R.id.warningTextView);
    answer = screen2.findViewById(R.id.answerTextView);
    yes = screen2.findViewById(R.id.yesButton);
    no = screen2.findViewById(R.id.noButton);
  }


  @Test
  public void whenQuestion1_thenCorrect() {

    //  GIVEN 
    //  encontrándonos en pantalla Question después
    //  de cargar pregunta del cuestionario
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));

    //  WHEN 
    //  al pulsar botón Option correcto
    option3.performClick();

    //  THEN 
    //  mostraremos mensaje Correct ya que la respuesta
    //  del usuario corresponde con respuesta correcta
    //  mostraremos botones Option y Cheat desactivados
    //  mostraremos botón Next activado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(correct));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(false));
    assertThat(next.isEnabled(), equalTo(true));

  }


  @Test
  public void whenQuestion1_thenIncorrect() {

    //  GIVEN 
    //  encontrándonos en pantalla Question después
    //  de cargar pregunta del cuestionario
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));

    //  WHEN 
    //  al pulsar botón Option incorrecto
    option2.performClick();

    //  THEN 
    //  mostraremos mensaje Incorrect ya que la respuesta
    //  del usuario corresponde con respuesta incorrecta
    //  mostraremos botón Option desactivado
    //  mostraremos botones Next y Cheat activados
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(incorrect));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(true));
  }

  @Test
  public void whenQuestion1Correct_thenNext() {

    //  GIVEN 
    //  encontrándonos en pantalla Question después
    //  de responder a pregunta del cuestionario
    //  mostraremos mensaje Correct según  la respuesta del usuario
    //  mostraremos botones Option y Cheat desactivados
    //  mostraremos botón Next activado
    option3.performClick();
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(correct));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(false));
    assertThat(next.isEnabled(), equalTo(true));

    //  WHEN 
    //  al pulsar botón Next
    next.performClick();

    //  THEN 
    //  mostraremos pantalla Question con siguiente pregunta  ya cargada
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[5]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));

  }

  @Test
  public void whenQuestion1Incorrect_thenNext() {

    //  GIVEN 
    //  encontrándonos en pantalla Question después
    //  de responder a pregunta del cuestionario
    //  mostraremos mensaje Incorrect según  la respuesta del usuario
    //  mostraremos botón Option desactivado
    //  mostraremos botones Next y Cheat activados
    option2.performClick();
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(incorrect));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(true));

    //  WHEN 
    //  al pulsar botón Next
    next.performClick();

    //  THEN 
    //  mostraremos pantalla Question con siguiente pregunta  ya cargada
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[5]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));
  }

  @Test
  public void whenQuestion1_thenCheat() {

    //  GIVEN 
    //  encontrándonos en pantalla Question sin haber respondido
    //  a pregunta del cuestionario
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));

    //  WHEN 
    //  al pulsar botón Cheat
    cheat.performClick();

    //  THEN 
    //  visualizaremos pantalla Cheat donde se nos pedirá confirmación
    //  antes de mostrar respuesta correcta
    //  mostraremos botones Yes y NO activados
    CheatActivity screen=Robolectric.setupActivity(CheatActivity.class);
    TextView warning = screen.findViewById(R.id.warningTextView);
    TextView answer = screen.findViewById(R.id.answerTextView);
    Button yes = screen.findViewById(R.id.yesButton);
    Button no = screen.findViewById(R.id.noButton);
    String sure =screen.getResources().getString(R.string.warning_message);
    String empty =screen.getResources().getString(R.string.empty_answer);
    assertThat(warning.getText().toString(), equalTo(sure));
    assertThat(answer.getText().toString(), equalTo(empty));
    assertThat(yes.isEnabled(), equalTo(true));
    assertThat(no.isEnabled(), equalTo(true));
  }


  @Test
  public void whenQuestion1Incorrect_thenCheat() {

    //  GIVEN 
    //  encontrándonos en pantalla Question después
    //  de responder a pregunta del cuestionario
    //  mostraremos mensaje Incorrect segun la respuesta del usuario
    //  mostraremos botones Next y Cheat activados
    //  mostraremos botón Option desactivado
    option2.performClick();
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(incorrect));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(true));

    //  WHEN 
    //  al pulsar botón Cheat
    cheat.performClick();

    //  THEN 
    //  visualizaremos pantalla Cheat donde se nos pedirá confirmación
    //  antes de mostrar respuesta correcta
    //  mostraremos botones Yes y NO activados
    assertThat(warning.getText().toString(), equalTo(sure));
    assertThat(answer.getText().toString(), equalTo(empty_answer));
    assertThat(yes.isEnabled(), equalTo(true));
    assertThat(no.isEnabled(), equalTo(true));
  }


  @Test
  public void whenQuestion1Cheated_thenNo() {

    //  GIVEN 
    //  encontrándonos en pantalla Cheat sin haber respondido
    //  a  pregunta del cuestionario en pantalla Question
    //  mostraremos botones Yes y NO activados
    cheat.performClick();
    assertThat(warning.getText().toString(), equalTo(sure));
    assertThat(answer.getText().toString(), equalTo(empty_answer));
    assertThat(yes.isEnabled(), equalTo(true));
    assertThat(no.isEnabled(), equalTo(true));

    //  WHEN 
    //  al pulsar botón No
    no.performClick();

    //  THEN 
    //  volveremos a pantalla Question
    //  mostraremos pregunta del cuestionario existente
    //  antes de iniciar pantalla Cheat
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(empty_reply));
    assertThat(option1.isEnabled(), equalTo(true));
    assertThat(option2.isEnabled(), equalTo(true));
    assertThat(option3.isEnabled(), equalTo(true));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(false));
  }


  @Test
  public void whenQuestion1IncorrectCheated_thenNo() {

    //  GIVEN 
    //  encontrándonos en pantalla Cheat después de responder
    //  a pregunta del cuestionario en pantalla Question
    //  mostraremos mensaje Incorrect segun la respuesta del usuario
    //  mostraremos botones Yes y NO activados
    option2.performClick();
    cheat.performClick();
    assertThat(warning.getText().toString(), equalTo(sure));
    assertThat(answer.getText().toString(), equalTo(empty_answer));
    assertThat(yes.isEnabled(), equalTo(true));
    assertThat(no.isEnabled(), equalTo(true));

    //  WHEN 
    //  al pulsar botón No

    //  THEN 
    //  volveremos a pantalla Question donde mostraremos pregunta
    //  del cuestionario existente antes de iniciar pantalla Cheat
    //  mostraremos botones Option y Cheat activados
    //  mostraremos botón Next desactivado
    assertThat(question.getText().toString(), equalTo(quiz[0]));
    assertThat(reply.getText().toString(), equalTo(incorrect));
    assertThat(option1.isEnabled(), equalTo(false));
    assertThat(option2.isEnabled(), equalTo(false));
    assertThat(option3.isEnabled(), equalTo(false));
    assertThat(cheat.isEnabled(), equalTo(true));
    assertThat(next.isEnabled(), equalTo(true));
  }
}
