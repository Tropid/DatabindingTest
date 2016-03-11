package de.rdk.gui;

import javax.swing.JPanel;

public interface PageLifecycleCallbacks {
    void onStart();
    void onBuildView(JPanel panel);
    void onInitActionBinding();
    void onInitDataBinding();
    void onInitValidation();
    void onExit();
}
