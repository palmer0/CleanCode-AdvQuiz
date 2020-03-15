package es.ulpgc.eite.da.quiz.question;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.R;
import es.ulpgc.eite.da.quiz.app.AppMediator;

public class QuestionScreen {

  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    QuestionState state = mediator.getQuestionState();

    String[] quiz = context.get()
        .getResources().getStringArray(R.array.quiz_array);

    QuestionContract.Router router = new QuestionRouter(mediator);
    QuestionContract.Presenter presenter = new QuestionPresenter(state);
    QuestionContract.Model model = new QuestionModel(quiz);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
