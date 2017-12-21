package net.cloudcentrik.dagenslunch.health;

import com.codahale.metrics.health.HealthCheck;
import net.cloudcentrik.dagenslunch.core.Template;

import java.util.Optional;

public class TemplateHealthCheck extends HealthCheck {
    private final Template template;

    public TemplateHealthCheck(Template template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        template.render(Optional.empty());
        return Result.healthy();
    }
}
