package br.eti.kinoshita.restlet.velocity.performance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.velocity.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class VelocityResource extends ServerResource {

    @Get
    public Representation test() {
        TemplateRepresentation target = null;
        try {
            File templateLocation = new File(VelocityResource.class.getResource("/test.vm").getFile());

            List<String> items = new ArrayList<String>();
            items.add("item 1");
            items.add("item 2");
            items.add("item 3");
            getVariants().add(new Variant(MediaType.TEXT_HTML));

            Map<String, Object> map = new TreeMap<String, Object>();
            map.put("items", items);

            target = new TemplateRepresentation("test.vm", map, MediaType.TEXT_HTML);
            target.getEngine().addProperty("file.resource.loader.path", templateLocation.getParent());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            getResponse().setStatus(new Status(Status.SERVER_ERROR_INTERNAL, e));
        }
        return target;
    }

}
