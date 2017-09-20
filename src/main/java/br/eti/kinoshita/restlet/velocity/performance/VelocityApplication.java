package br.eti.kinoshita.restlet.velocity.performance;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;
import org.restlet.routing.VirtualHost;

public class VelocityApplication extends Application {

    public VelocityApplication(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Velocity Application";
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attachDefault(new Directory(getContext(), "war:///"));
        router.attach("/test", VelocityResource.class);
        return router;
    }

    public static void main(String[] args) throws Exception {
        final Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8888);
        Application app = new VelocityApplication(component.getContext().createChildContext());
        VirtualHost host = new VirtualHost();
        host.attach(app);
        component.getHosts().add(host);
        component.start();
    }
}
