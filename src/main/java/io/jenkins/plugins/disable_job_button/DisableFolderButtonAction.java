package io.jenkins.plugins.disable_job_button;

import com.cloudbees.hudson.plugins.folder.AbstractFolder;
import hudson.Extension;
import hudson.model.Action;
import hudson.model.InvisibleAction;
import java.util.List;
import jenkins.model.TransientActionFactory;

public class DisableFolderButtonAction extends InvisibleAction {
    private final transient AbstractFolder folder;

    public DisableFolderButtonAction(AbstractFolder folder) {
        this.folder = folder;
    }

    // Jelly
    public AbstractFolder getFolder() {
        return folder;
    }

    @Extension
    public static class DisableFolderButtonActionFactory extends TransientActionFactory<AbstractFolder> {

        @Override
        public Class<AbstractFolder> type() {
            return AbstractFolder.class;
        }

        @Override
        public java.util.Collection<? extends Action> createFor(AbstractFolder target) {
            if (!target.supportsMakeDisabled()) {
                return List.of();
            }
            return List.of(new DisableFolderButtonAction(target));
        }
    }
}
