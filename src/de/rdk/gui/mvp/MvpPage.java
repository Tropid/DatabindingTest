package de.rdk.gui.mvp;

import de.rdk.gui.Page;

public class MvpPage extends Page {

    public MvpPage(Presenter presenter) {
        super(new MvpLifecycleCallbacks(presenter.getView(), presenter));
    }
}
