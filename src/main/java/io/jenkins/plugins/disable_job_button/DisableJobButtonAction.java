package io.jenkins.plugins.disable_job_button;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.Action;
import hudson.model.InvisibleAction;
import hudson.model.Job;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.model.TransientActionFactory;

public class DisableJobButtonAction extends InvisibleAction {
    @Extension
    public static class DisableJobButtonActionFactory extends TransientActionFactory<Job> {

        @Override
        public Class<Job> type() {
            return Job.class;
        }

        @NonNull
        @Override
        public Collection<? extends Action> createFor(@NonNull Job target) {
            Logger.getLogger(DisableJobButtonActionFactory.class.getName())
                    .log(Level.FINE, "Creating DisableJobButtonAction for " + target);
            return List.of(new DisableJobButtonAction());
        }
    }
}
