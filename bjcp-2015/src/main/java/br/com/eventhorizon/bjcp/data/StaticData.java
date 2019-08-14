package br.com.eventhorizon.bjcp.data;

import br.com.eventhorizon.bjcp.model.Category;
import br.com.eventhorizon.bjcp.model.Style;
import br.com.eventhorizon.bjcp.model.VitalStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StaticData {

  public static final List<Category> categories;

  public static final List<Style> styles;

  static {
    categories = new ArrayList<>();
    categories.add(Category.Builder.create("1")
        .name("Standard American Beer")
        .description("This category describes everyday American beers that have a wide public"
            + " appeal. Containing both ales and lagers, the beers of this "
            + "category are not typically complex, and have smooth, accessible flavors. The ales "
            + "tend to have lager-like qualities, or are designed to "
            + "appeal to mass-market lager drinkers as crossover beers. Mass-market beers with a "
            + "more international appeal or origin are "
            + "described in the International Lager category.")
        .build()
    );
    categories.add(Category.Builder.create("2")
        .name("International Lager")
        .description("International lagers are the premium mass-market lagers produced in "
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
    categories.add(Category.Builder.create("3")
        .name("Czech Lager")
        .description("Czech lagers are generally divided by gravity class (draft, lager, "
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
    categories.add(Category.Builder.create("4")
        .name("Pale Malty European Lager")
        .description("This style category contains malty, pale, Pilsner malt-driven German "
            + "lagers of vollbier to starkbier strength. While malty, they are "
            + "still well-attenuated, clean lagers, as are most German beers.")
        .build()
    );
    categories.add(Category.Builder.create("5")
        .name("Pale Bitter European Lager")
        .description("This category describes German-origin beers that are pale and have an "
            + "even to bitter balance with a mild to moderately strong hoppy "
            + "character featuring classic German hops. They are generally bottom-fermented or "
            + "are lagered to provide a smooth profile, and are "
            + "well-attenuated as are most German beers.")
        .build()
    );
    categories.add(Category.Builder.create("6")
        .name("Amber Malty European Lager")
        .description("This category groups amber-colored, German-origin, bottom-fermented "
            + "lagerbiers that have a malty balance and are vollbier to "
            + "starkbier in strength.")
        .build()
    );
    categories.add(Category.Builder.create("7")
        .name("Amber Bitter European Beer")
        .description(
            "This category groups amber-colored, evenly balanced to bitter balanced beers of "
                + "German or Austrian origin.")
        .build()
    );
    categories.add(Category.Builder.create("8")
        .name("Dark European Lager")
        .description(
            "This category contains German vollbier lagers darker than amber-brown color.")
        .build()
    );
    categories.add(Category.Builder.create("9")
        .name("String European Beer")
        .description("This category contains more strongly flavored and higher alcohol lagers"
            + " from Germany and the Baltic region. Most are dark, but "
            + "some pale versions are known.")
        .build()
    );
    categories.add(Category.Builder.create("10")
        .name("German Wheat Beer")
        .description(
            "This category contains vollbier- and starkbier-strength German wheat beers without "
                + "sourness, in light and dark colors.")
        .build()
    );
    categories.add(Category.Builder.create("11")
        .name("British Bitter")
        .description("The family of British bitters grew out of English pale ales as a "
            + "draught product in the late 1800s. The use of crystal malts in bitters "
            + "became more widespread after WWI. Traditionally served very fresh under no "
            + "pressure (gravity or hand pump only) at cellar "
            + "temperatures (i.e., “real ale”). Most bottled or kegged versions of UK-produced "
            + "bitters are often higher-alcohol and more highly "
            + "carbonated versions of cask products produced for export, and have a different "
            + "character and balance than their draught "
            + "counterparts in Britain (often being sweeter and less hoppy than the cask "
            + "versions). These guidelines reflect the “real ale” version of "
            + "the style, not the export formulations of commercial products. "
            + "Several regional variations of bitter exist, ranging from darker, sweeter versions"
            + " served with nearly no head to brighter, hoppier, "
            + "paler versions with large foam stands, and everything in between. "
            + "Judges should not over-emphasize the caramel component of these styles. Exported "
            + "bitters can be oxidized, which increases caramellike flavors (as well as more "
            + "negative flavors). Do not assume that oxidation-derived flavors are traditional or"
            + " required for the style.")
        .build()
    );
    categories.add(Category.Builder.create("12")
        .name("Pale Commonwealth Beer")
        .description(
            "This category contains pale, moderately-strong, hop-forward, bitter ales from "
                + "countries within the former British Empire.")
        .build()
    );
    categories.add(Category.Builder.create("13")
        .name("Brown British Beer")
        .description("While Dark Mild, Brown Ale, and English Porter may have long and "
            + "storied histories, these guidelines describe the modern versions. "
            + "They are grouped together for judging purposes only since they often have similar "
            + "flavors and balance, not because of any implied "
            + "common ancestry. The similar characteristics are low to moderate strength, dark "
            + "color, generally malty balance, and British "
            + "ancestry. These styles have no historic relationship to each other; especially, "
            + "none of these styles evolved into any of the others, or was "
            + "ever a component of another. The category name was never used historically to "
            + "describe this grouping of beers; it is our name for the "
            + "judging category. “Brown Beer” was a distinct and important historical product, "
            + "and is not related to this category name")
        .build()
    );
    categories.add(Category.Builder.create("14")
        .name("Scottish Ale")
        .description("The original meaning of ‘schilling’ (/-) ales have been described "
            + "incorrectly for years. A single style of beer was never designated as a "
            + "60/-, 70/- or 80/-. The schillings only referring to the cost of the barrel of "
            + "beer. Meaning there were 54/- Stouts and 86/- IPAs and so "
            + "on. The Scottish Ales in question were termed Light, Heavy and Export which cover "
            + "the spectrum of costs from around 60/- to 90/- "
            + "and simply dark, malt-focused ales. The larger 120/- ales fall outside of this "
            + "purview as well as the strongest Scotch ales (aka Wee "
            + "Heavy).The Scottish Light, Heavy and Export guidelines read nearly the same for "
            + "each style of beers. As the gravity increases, so does "
            + "the character of the beers in question. Historically, the three types of beer were"
            + " parti-gyled to different strengths, and represented an "
            + "adaptation of English pale ales but with reduced strengths and hopping rates, and "
            + "darker colors (often from added caramel). More "
            + "modern versions (post-WWII, at least), tended to use more complex grists.")
        .build()
    );

    styles = new ArrayList<>();
    styles.add(Style.Builder.create("1A")
        .name("American Light Lager")
        .overallImpression("Highly carbonated, very light-bodied, "
            + "nearly flavorless lager designed to be consumed very cold. Very "
            + "refreshing and thirst quenching")
        .aroma("Low to no malt aroma, although it can be perceived as "
            + "grainy, sweet, or corn-like if present. Hop aroma is light to "
            + "none, with a spicy or floral hop character if present. While a "
            + "clean fermentation character is desirable, a light amount of "
            + "yeast character (particularly a light apple fruitiness) is not a "
            + "fault. Light DMS is not a fault.")
        .appearance("Very pale straw to pale yellow color. White, "
            + "frothy head seldom persists. Very clear.")
        .flavor("Relatively neutral palate with a crisp and dry finish "
            + "and a low to very low grainy or corn-like flavor that might be "
            + "perceived as sweetness due to the low bitterness. Hop flavor "
            + "ranges from none to low levels, and can have a floral, spicy, or "
            + "herbal quality (although rarely strong enough to detect). Low "
            + "to very low hop bitterness. Balance may vary from slightly "
            + "malty to slightly bitter, but is relatively close to even. High "
            + "levels of carbonation may accentuate the crispness of the dry "
            + "finish. Clean lager fermentation character.")
        .mouthfeel("Very light (sometimes watery) body. Very highly "
            + "carbonated with slight carbonic bite on the tongue.")
        .comments("Designed to appeal to as broad a range of the "
            + "general public as possible. Strong flavors are a fault.")
        .history("Coors briefly made a light lager in the early 1940s. "
            + "Modern versions were first produced by Rheingold in 1967 to "
            + "appeal to diet-conscious drinkers, but only became popular "
            + "starting in 1973 after Miller Brewing acquired the recipe and "
            + "marketed the beer heavily to sports fans with the “tastes great, "
            + "less filling” campaign. Beers of this genre became the largest "
            + "sellers in the United States in the 1990s.")
        .characteristicIngredients("Two- or six-row barley with "
            + "high percentage (up to 40%) of rice or corn as adjuncts. "
            + "Additional enzymes can further lighten the body and lower "
            + "carbohydrates.")
        .styleComparison("A lighter-bodied, lower-alcohol, lower "
            + "calorie version of an American Lager. Less hop character and "
            + "bitterness than a Leichtbier.")
        .vitalStatistics(new VitalStatistics())
        .commercialExamples(new ArrayList<>())
        .tags(new ArrayList<>())
        .build());
    styles.add(Style.Builder.create("1B")
        .name("American Lager")
        .overallImpression(
                "A very pale, highly-carbonated, light-bodied, well-attenuated lager with a very "
                    + "neutral flavor profile and low bitterness. Served very cold, it can be a "
                    + "very refreshing and thirst quenching drink.")
        .aroma(
            "Low to no malt aroma, although it can be perceived as grainy, sweet or corn-like if "
                + "present. Hop aroma may range from none to a light, spicy or floral hop "
                + "presence. While a clean fermentation character is desirable, a light amount of"
                + " yeast character (particularly a light apple character) is not a fault. Light "
                + "DMS is also not a fault.")
        .appearance(
            "Very pale straw to medium yellow color. White, frothy head seldom persists. Very "
                + "clear.")
        .flavor(
            "Relatively neutral palate with a crisp and dry finish and a moderately-low to low "
                + "grainy or corn-like flavor that might be perceived as sweetness due to the low"
                + " bitterness. Hop flavor ranges from none to moderately-low levels, and can "
                + "have a floral, spicy, or herbal quality (although often not strong enough to "
                + "distinguish). Hop bitterness at low to medium-low level. Balance may vary from"
                + " slightly malty to slightly bitter, but is relatively close to even. High "
                + "levels of carbonation may accentuate the crispness of the dry finish. Clean "
                + "lager fermentation character.")
        .mouthfeel(
            "Low to medium-low body. Very highly carbonated with slight carbonic bite on the "
                + "tongue.")
        .comments(
            "Strong flavors are a fault. Often what non-craft beer drinkers expect to be served "
                + "if they order beer in the United States. May be marketed as Pilsner beers "
                + "outside of Europe, but should not be confused with traditional examples.")
        .history(
            "Although German immigrants had brewed traditional Pilsner-inspired lager beer in the"
                + " United States since the mid-late 1800s, the modern American lager style was "
                + "heavily influenced by Prohibition and World War II. Surviving breweries "
                + "consolidated, expanded distribution, and heavily promoted a beer style that "
                + "was appealing to a broad range of the population. Became the dominant beer "
                + "style for many decades, and spawning many international rivals who would "
                + "develop similarly bland products for the mass market supported by heavy "
                + "advertising.")
        .characteristicIngredients(
            "Two- or six-row barley with high percentage (up to 40%) of rice or corn as adjuncts.")
        .styleComparison(
            "Stronger, more flavor and body than a Light American Lager. Less bitterness and "
                + "flavor than an International Lager. Significantly less flavor, hops, and bitterness than traditional European Pilsners.")
        .vitalStatistics(VitalStatistics.Builder.create()
            .minIbu(8)
            .maxIbu(18)
            .minSrm(2)
            .maxSrm(4)
            .minOg(1.040)
            .maxOg(1.050)
            .minFg(1.004)
            .maxFg(1.010)
            .minAbv(4.2)
            .maxAbv(5.3)
            .build())
        .commercialExamples(
            Stream.of("Budweiser", "Coors Original", "Grain Belt Premium Lager", "Miller High Life",
                "Pabst Blue Ribbon", "Special Export").collect(Collectors.toList()))
        .tags((Stream.of("standard-strength", "pale-color", "bottom-fermented", "lagered",
            "north-america", "traditional-style", "pale-lager-family", "balanced")
            .collect(Collectors.toList())))
        .build());
  }

}
