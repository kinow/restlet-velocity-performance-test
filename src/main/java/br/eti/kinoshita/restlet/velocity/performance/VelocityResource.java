package br.eti.kinoshita.restlet.velocity.performance;

import java.io.File;
import java.util.HashMap;
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

            Map<String, String> items = new HashMap<String, String>();

            // Add some entries from Clint Eastwood wikipedia
            // Source: https://en.wikipedia.org/wiki/Clint_Eastwood_filmography
            // Script: rows.forEach (function (row) { if (row.children.length > 2) { console.log("items.put(\"",
            // row.children[0].textContent.trim() + "\", \"" + row.children[1].textContent.trim() + "\");" ); } });
            items.put(" Year", "Film");
            items.put(" Director", "Producer");
            items.put(" 1955", "Revenge of the Creature");
            items.put(" 1955", "Francis in the Navy");
            items.put(" 1955", "Lady Godiva of Coventry");
            items.put(" 1955", "Tarantula");
            items.put(" 1956", "Never Say Goodbye");
            items.put(" 1956", "Star in the Dust");
            items.put(" 1956", "Away All Boats");
            items.put(" 1956", "The First Traveling Saleslady");
            items.put(" 1957", "Escapade in Japan");
            items.put(" 1958", "Lafayette Escadrille");
            items.put(" 1958", "Ambush at Cimarron Pass");
            items.put(" 1964", "A Fistful of Dollars");
            items.put(" 1965", "For a Few Dollars More");
            items.put(" 1966", "The Good, the Bad and the Ugly");
            items.put(" 1967", "Le streghe");
            items.put(" 1968", "Hang 'Em High");
            items.put(" 1968", "Coogan's Bluff");
            items.put(" 1968", "Where Eagles Dare");
            items.put(" 1969", "Paint Your Wagon");
            items.put(" 1970", "Two Mules for Sister Sara");
            items.put(" 1970", "Kelly's Heroes");
            items.put(" 1971", "The Beguiled");
            items.put(" 1971", "Dirty Harry");
            items.put(" 1971", "Play Misty for Me");
            items.put(" 1972", "Joe Kidd");
            items.put(" 1973", "High Plains Drifter");
            items.put(" 1973", "Breezy");
            items.put(" 1973", "Magnum Force");
            items.put(" 1974", "Thunderbolt and Lightfoot");
            items.put(" 1975", "The Eiger Sanction");
            items.put(" 1976", "The Outlaw Josey Wales");
            items.put(" 1976", "The Enforcer");
            items.put(" 1977", "The Gauntlet");
            items.put(" 1978", "Every Which Way but Loose");
            items.put(" 1979", "Escape from Alcatraz");
            items.put(" 1980", "Bronco Billy");
            items.put(" 1980", "Any Which Way You Can");
            items.put(" 1982", "Firefox");
            items.put(" 1982", "Honkytonk Man");
            items.put(" 1983", "Sudden Impact");
            items.put(" 1984", "Tightrope");
            items.put(" 1984", "City Heat");
            items.put(" 1985", "Pale Rider");
            items.put(" 1986", "Heartbreak Ridge");
            items.put(" 1988", "The Dead Pool");
            items.put(" 1988", "Bird");
            items.put(" 1989", "Thelonious Monk: Straight, No Chaser");
            items.put(" 1989", "Pink Cadillac");
            items.put(" 1990", "White Hunter Black Heart");
            items.put(" 1990", "The Rookie");
            items.put(" 1992", "Unforgiven");
            items.put(" 1993", "In the Line of Fire");
            items.put(" 1993", "A Perfect World");
            items.put(" 1995", "The Bridges of Madison County");
            items.put(" 1995", "The Stars Fell on Henrietta");
            items.put(" 1995", "Casper");
            items.put(" 1997", "Absolute Power");
            items.put(" 1997", "Midnight in the Garden of Good and Evil");
            items.put(" 1999", "True Crime");
            items.put(" 2000", "Space Cowboys");
            items.put(" 2002", "Blood Work");
            items.put(" 2003", "Mystic River");
            items.put(" 2004", "Million Dollar Baby");
            items.put(" 2006", "Flags of Our Fathers");
            items.put(" 2006", "Letters from Iwo Jima");
            items.put(" 2007", "Grace Is Gone");
            items.put(" 2008", "Changeling");
            items.put(" 2008", "Gran Torino");
            items.put(" 2009", "Invictus");
            items.put(" 2010", "Hereafter");
            items.put(" 2011", "J. Edgar");
            items.put(" 2011", "Kurosawa's Way");
            items.put(" 2012", "Trouble with the Curve");
            items.put(" 2014", "Jersey Boys");
            items.put(" 2014", "American Sniper");
            items.put(" 2016", "Sully");
            items.put(" 2017", "The 15:17 to Paris");
            items.put(" 2018", "A Star Is Born");
            items.put(" Year", "Title");
            items.put(" Series", "Notes");
            items.put(" 1955", "Allen in Movieland");
            items.put(" 1955", "Highway Patrol");
            items.put(" 1956", "Death Valley Days");
            items.put(" 1957", "The West Point Story");
            items.put(" 1958", "Navy Log");
            items.put(" 1959", "Maverick");
            items.put(" 1959-1965", "Rawhide");
            items.put(" 1962", "Mister Ed");
            items.put(" 1985", "Amazing Stories");
            items.put(" 2003", "The Blues");
            items.put(" 2009", "Johnny Mercer: The Dream's On Me[9]");

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
