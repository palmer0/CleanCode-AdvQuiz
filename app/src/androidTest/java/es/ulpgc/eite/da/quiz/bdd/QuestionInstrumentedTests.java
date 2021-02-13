package es.ulpgc.eite.da.quiz.bdd;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("ALL")
@RunWith(AndroidJUnit4.class)
@LargeTest
public class QuestionInstrumentedTests {

    public QuestionInstrumentedRobot robot = new QuestionInstrumentedRobot();


    @Test
    public void testResponderCorrectAQuestion1() {

        // Given mostrar pantalla Question
        robot.mostrarPantallaQuestion();
        // And mostrar texto Question 1
        robot.mostrarTextoQuestion1();
        // And mostrar mensaje vacio
        robot.mostrarMensajeVacio();
        // And mostrar botón Option activado
        robot.mostrarBotonOptionActivado();
        // And mostrar botón Cheat activado
        robot.mostrarBotonCheatActivado();
        // And mostrar botón Next desactivado
        robot.mostrarBotonNextDesactivado();

        // When pulsar botón Option 3
        robot.pulsarBotonOption3();

        // Then mostrar texto Question 1
        robot.mostrarTextoQuestion1();
        // And mostrar mensaje Correct
        robot.mostrarMensajeCorrect();
        // And mostrar botón Option desactivado
        robot.mostrarBotonOptionDesactivado();
        // And mostrar botón Cheat desactivado
        robot.mostrarBotonCheatDesactivado();
        // And mostrar botón Next activado
        robot.mostrarBotonNextActivado();
    }

    @Test
    public void testResponderIncorrectAQuestion1() {

        // Given mostrar pantalla Question
        robot.mostrarPantallaQuestion();
        // And mostrar texto Question 1
        robot.mostrarTextoQuestion1();
        // And mostrar mensaje vacio
        robot.mostrarMensajeVacio();
        // And mostrar botón Option activado
        robot.mostrarBotonOptionActivado();
        // And mostrar botón Cheat activado
        robot.mostrarBotonCheatActivado();
        // And mostrar botón Next desactivado
        robot.mostrarBotonNextDesactivado();

        // When pulsar botón Option 2
        robot.pulsarBotonOption2();

        // Then mostrar texto Question 1
        robot.mostrarTextoQuestion1();
        // And mostrar mensaje Incorrect
        robot.mostrarMensajeIncorrect();
        // And mostrar botón Option desactivado
        robot.mostrarBotonOptionDesactivado();
        // And mostrar botón Cheat activado
        robot.mostrarBotonCheatActivado();
        // And mostrar botón Next activado
        robot.mostrarBotonNextActivado();
    }
}