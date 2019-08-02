package br.com.eventhorizon.bjcp.data;

import br.com.eventhorizon.bjcp.model.Category;

import java.util.ArrayList;
import java.util.List;

public final class StaticData {

  public static final List<Category> categories;

  static {
    categories = new ArrayList<>();
    categories.add(Category.Builder.create()
        .withId("1")
        .withNumber(1)
        .withName("Standard American Beer")
        .withDescription("This category describes everyday American beers that have a wide public"
            + " appeal. Containing both ales and lagers, the beers of this "
            + "category are not typically complex, and have smooth, accessible flavors. The ales "
            + "tend to have lager-like qualities, or are designed to "
            + "appeal to mass-market lager drinkers as crossover beers. Mass-market beers with a "
            + "more international appeal or origin are "
            + "described in the International Lager category.")
        .build()
    );
    categories.add(Category.Builder.create()
        .withId("2")
        .withNumber(2)
        .withName("International Lager")
        .withDescription("International lagers are the premium mass-market lagers produced in "
            + "most countries in the world. Whether developed from"
            + "American or European styles, they all tend to have a fairly uniform character and "
            + "are heavily marketed. Loosely derived from"
            + "original Pilsner-type lagers, with colored variations having additional malt "
            + "flavors while retaining a broad appeal to most palates."
            + "In many countries, the styles will be referred to by their local country names. "
            + "The use of the term “international” doesn’t mean that "
            + "any beers are actually labeled as such; it is more of a categorization of similar "
            + "beers produced worldwide.")
        .build()
    );
    categories.add(Category.Builder.create()
        .withId("3")
        .withNumber(3)
        .withName("Czech Lager")
        .withDescription("Czech lagers are generally divided by gravity class (draft, lager, "
            + "special) and color (pale, amber, dark). The Czech names for these "
            + "categories are světlé (pale), polotmavé (amber), and tmavé (dark). The gravity "
            + "classes are výčepní (draft, 7–10 °P), ležák (lager, 11–12 "
            + "°P), and speciální (special, 13 °P+). Pivo is of course the Czech word for beer. "
            + "The division into gravity classes is similar to the German "
            + "groupings of schankbier, vollbier, and starkbier, although at different gravity "
            + "ranges. Czech beers within the classes are often simply "
            + "referenced by their gravity. There are often variations within the gravity-color "
            + "groupings, particularly within the speciální class. The "
            + "style guidelines combine some of these classes, while other beers in the Czech "
            + "market are not described (such as the strong Czech "
            + "Porter). This is not to imply that the categories below are the full coverage of "
            + "Czech beers, simply a way of grouping some of the more "
            + "commonly found types for judging purposes. "
            + "Czech lagers in general are differentiated from German and other Western lagers in"
            + " that German lagers are almost always fully "
            + "attenuated, while Czech lagers can have a slight amount of unfermented extract "
            + "remaining in the finished beer. This helps provide a "
            + "slightly higher finishing gravity (and thus slightly lower apparent attenuation), "
            + "slightly fuller body and mouthfeel, and a richer, "
            + "slightly more complex flavor profile in equivalent color and strength beers. "
            + "German lagers tend to have a cleaner fermentation "
            + "profile, while Czech lagers are often fermented cooler (7–10 °C) and for a longer "
            + "time, and can have a light, barely noticeable (near "
            + "threshold) amount of diacetyl that often is perceived more as a rounded body than "
            + "overtly in aroma and flavor [significant buttery "
            + "diacetyl is a flaw]. Czech lager yeast strains are not always as clean and "
            + "attenuative as German strains, which helps achieve the "
            + "higher finishing gravity (along with the mashing methods and cooler fermentation)."
            + " Czech lagers are traditionally made with "
            + "decoction mashes (often double decoction), even with modern malts, while most "
            + "modern German lagers are made with infusion or "
            + "step infusion mashes. These differences characterize the richness, mouthfeel, and "
            + "flavor profile that distinguishes Czech lagers.")
        .build()
    );
    categories.add(Category.Builder.create()
        .withId("4")
        .withNumber(4)
        .withName("Pale Malty European Lager")
        .withDescription("This style category contains malty, pale, Pilsner malt-driven German "
            + "lagers of vollbier to starkbier strength. While malty, they are "
            + "still well-attenuated, clean lagers, as are most German beers.")
        .build()
    );
    categories.add(Category.Builder.create()
        .withId("5")
        .withNumber(5)
        .withName("Pale Bitter European Lager")
        .withDescription("This category describes German-origin beers that are pale and have an "
            + "even to bitter balance with a mild to moderately strong hoppy "
            + "character featuring classic German hops. They are generally bottom-fermented or "
            + "are lagered to provide a smooth profile, and are "
            + "well-attenuated as are most German beers.")
        .build()
    );
  }

}
