package de.rdk.gui;

import javax.swing.JPanel;

public class Page {
    private final PageLifecycleCallbacks lifecycleCallbacks;
    
    public Page(PageLifecycleCallbacks lifecycleCallbacks) {
        this.lifecycleCallbacks = lifecycleCallbacks;
    }
    
    public void open(JPanel panel) {
        lifecycleCallbacks.onBuildView(panel);
        lifecycleCallbacks.onInitActionBinding();
        lifecycleCallbacks.onInitDataBinding();
        lifecycleCallbacks.onInitValidation();
    }
    
    public void close() {
        lifecycleCallbacks.onExit();
    }
}
