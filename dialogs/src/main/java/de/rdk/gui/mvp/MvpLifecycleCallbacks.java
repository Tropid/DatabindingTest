package de.rdk.gui.mvp;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.rdk.gui.PageLifecycleCallbacks;

public class MvpLifecycleCallbacks implements PageLifecycleCallbacks {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MvpLifecycleCallbacks.class);
    
    private final View view;
    private final Presenter presenter;

    public MvpLifecycleCallbacks(View view, Presenter presenter) {
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
