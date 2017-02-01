package net.floodlightcontroller.randomizer.web;

import net.floodlightcontroller.restserver.RestletRoutable;
import org.restlet.Context;
import org.restlet.routing.Router;

/**
 * Created by geddingsbarrineau on 9/19/16.
 *
 *
 */
public class RandomizerWebRoutable implements RestletRoutable {
    protected static final String STR_OPERATION = "operation";
    protected static final String STR_SCOPE = "scope";

    @Override
    public Router getRestlet(Context context) {
        Router router = new Router(context);
        router.attach("/module/{" + STR_OPERATION + "}/json", ModuleResource.class);
        router.attach("/server/{" + STR_OPERATION + "}/json", ServerResource.class);
        router.attach("/config/json", ConfigResource.class);
        router.attach("/info/json", InfoResource.class);
        router.attach("/connections/json", ConnectionsResource.class);
        router.attach("/prefix/{" + STR_SCOPE + "}/json", PrefixResource.class);    // Only GET
        router.attach("/prefix/{" + STR_OPERATION + "}/json", PrefixResource.class);    // Only PUT and POST
        return router;
    }

    @Override
    public String basePath() {
        return "/wm/randomizer";
    }
}
