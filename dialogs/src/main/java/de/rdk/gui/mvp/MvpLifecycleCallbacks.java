package de.rdk.gui.mvp;

import de.rdk.gui.PageLifecycleCallbacks;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MvpLifecycleCallbacks<V extends View, P extends Presenter> implements PageLifecycleCallbacks {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MvpLifecycleCallbacks.class);
    
    private final V view;
    private final P presenter;

    public MvpLifecycleCallbacks(V view, P presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public void onStart() {
        LOGGER.info("Starting page");
    }

    @Override
    public void onBuildView(JPanel panel) {
        view.onCreate(panel);
    }

    @Override
    public void onInitActionBinding() {
        presenter.initActionBinding();
    }

    @Override
    public void onInitDataBinding() {
        presenter.initDataBinding();
    }

    @Override
    public void onInitValidation() {
        presenter.initValidation();
    }

    @Override
    public void onExit() {
        LOGGER.info("Exiting page");
    }
    
}
