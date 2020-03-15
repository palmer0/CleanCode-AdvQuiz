package es.ulpgc.eite.da.quiz.cheat;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.AppMediator;

public class CheatScreen {

  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CheatState state = mediator.getCheatState();

    CheatContract.Router router = new CheatRouter(mediator);
    CheatContract.Presenter presenter = new CheatPresenter(state);
    CheatContract.Model model = new CheatModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
