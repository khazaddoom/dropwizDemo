import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.Utilities;

public class DropDemoApplication extends Application<DropDemoConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropDemoApplication().run("server", "config.yml");
    }

    @Override
    public void run(DropDemoConfiguration dropDemoConfiguration, Environment environment) throws Exception {
        int defaultSize = dropDemoConfiguration.getDefaultSize();
        Utilities utilitiesResource = new Utilities(defaultSize);
        environment
                .jersey()
                .register(utilitiesResource);
    }

    @Override
    public void initialize(Bootstrap<DropDemoConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
