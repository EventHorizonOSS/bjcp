const collectionName = "styles";

const documents = [
    {
        _id: "1A",
        name: "American Light Lager",
        overallImpression: "Highly carbonated, very light-bodied, "
            + "nearly flavorless lager designed to be consumed very cold. Very "
            + "refreshing and thirst quenching",
        aroma: "Low to no malt aroma, although it can be perceived as "
            + "grainy, sweet, or corn-like if present. Hop aroma is light to "
            + "none, with a spicy or floral hop character if present. While a "
            + "clean fermentation character is desirable, a light amount of "
            + "yeast character (particularly a light apple fruitiness) is not a "
            + "fault. Light DMS is not a fault.",
        appearance: "Very pale straw to pale yellow color. White, "
            + "frothy head seldom persists. Very clear.",
        flavor: "Relatively neutral palate with a crisp and dry finish "
            + "and a low to very low grainy or corn-like flavor that might be "
            + "perceived as sweetness due to the low bitterness. Hop flavor "
            + "ranges from none to low levels, and can have a floral, spicy, or "
            + "herbal quality (although rarely strong enough to detect). Low "
            + "to very low hop bitterness. Balance may vary from slightly "
            + "malty to slightly bitter, but is relatively close to even. High "
            + "levels of carbonation may accentuate the crispness of the dry "
            + "finish. Clean lager fermentation character.",
        mouthfeel: "Very light (sometimes watery) body. Very highly "
            + "carbonated with slight carbonic bite on the tongue.",
        comments: "Designed to appeal to as broad a range of the "
            + "general public as possible. Strong flavors are a fault.",
        history: "Coors briefly made a light lager in the early 1940s. "
            + "Modern versions were first produced by Rheingold in 1967 to "
            + "appeal to diet-conscious drinkers, but only became popular "
            + "starting in 1973 after Miller Brewing acquired the recipe and "
            + "marketed the beer heavily to sports fans with the “tastes great, "
            + "less filling” campaign. Beers of this genre became the largest "
            + "sellers in the United States in the 1990s.",
        characteristicIngredients: "Two- or six-row barley with "
            + "high percentage (up to 40%) of rice or corn as adjuncts. "
            + "Additional enzymes can further lighten the body and lower "
            + "carbohydrates.",
        styleComparison: "A lighter-bodied, lower-alcohol, lower "
            + "calorie version of an American Lager. Less hop character and "
            + "bitterness than a Leichtbier.",
        vitalStatistics: {
            minIbu: 8,
            maxIbu: 12,
            minSrm: 2,
            maxSrm: 3,
            minOg: 1.028,
            maxOg: 1.040,
            minFg: 0.998,
            maxFg: 1.008,
            minAbv: 2.8,
            maxAbv: 4.2
        },
        commercialExamples: [
            "Bud Light",
            "Coors Light",
            "Keystone Light",
            "Michelob Light",
            "Miller Lite",
            "Old Milwaukee Light"
        ],
        tags: [
            "session-strength",
            "pale-color",
            "bottom-fermented",
            "lagered",
            "north-america",
            "traditional-style",
            "pale-lager-family",
            "balanced"
        ]
    },
    {
        _id: "1B",
        name: "American Lager",
        overallImpression: "A very pale, highly-carbonated, light-bodied, well-attenuated lager with a very neutral flavor profile and low bitterness. Served very cold, it can be a very refreshing and thirst quenching drink.",
        aroma: "Low to no malt aroma, although it can be perceived as grainy, sweet or corn-like if present. Hop aroma may range from none to a light, spicy or floral hop presence. While a clean fermentation character is desirable, a light amount of yeast character (particularly a light apple character) is not a fault. Light DMS is also not a fault.",
        appearance: "Very pale straw to medium yellow color. White, frothy head seldom persists. Very clear.",
        flavor: "Relatively neutral palate with a crisp and dry finish and a moderately-low to low grainy or corn-like flavor that might be perceived as sweetness due to the low bitterness. Hop flavor ranges from none to moderately-low levels, and can have a floral, spicy, or herbal quality (although often not strong enough to distinguish). Hop bitterness at low to medium-low level. Balance may vary from slightly malty to slightly bitter, but is relatively close to even. High levels of carbonation may accentuate the crispness of the dry finish. Clean lager fermentation character.",
        mouthfeel: "Low to medium-low body. Very highly carbonated with slight carbonic bite on the tongue.",
        comments: "Strong flavors are a fault. Often what non-craft beer drinkers expect to be served if they order beer in the United States. May be marketed as Pilsner beers outside of Europe, but should not be confused with traditional examples.",
        history: "Although German immigrants had brewed traditional Pilsner-inspired lager beer in the United States since the mid-late 1800s, the modern American lager style was heavily influenced by Prohibition and World War II. Surviving breweries consolidated, expanded distribution, and heavily promoted a beer style that was appealing to a broad range of the population. Became the dominant beer style for many decades, and spawning many international rivals who would develop similarly bland products for the mass market supported by heavy advertising.",
        characteristicIngredients: "Two- or six-row barley with high percentage (up to 40%) of rice or corn as adjuncts.",
        styleComparison: "Stronger, more flavor and body than a Light American Lager. Less bitterness and flavor than an International Lager. Significantly less flavor, hops, and bitterness than traditional European Pilsners.",
        vitalStatistics: {
            minIbu: 8,
            maxIbu: 18,
            minSrm: 2,
            maxSrm: 4,
            minOg: 1.040,
            maxOg: 1.050,
            minFg: 1.004,
            maxFg: 1.010,
            minAbv: 4.2,
            maxAbv: 5.3
        },
        commercialExamples: [
            "Budweiser",
            "Coors Original",
            "Grain Belt Premium Lager",
            "Miller High Life",
            "Pabst Blue Ribbon",
            "Special Export"
        ],
        tags: [
            "standard-strength",
            "pale-color",
            "bottom-fermented",
            "lagered",
            "north-america",
            "traditional-style",
            "pale-lager-family",
            "balanced"
        ]
    },
    {
        _id: "1C",
        name: "Cream Ale",
        overallImpression: "A clean, well-attenuated, flavorful American “lawnmower” beer. Easily drinkable and refreshing, with more character than typical American lagers.",
        aroma: "Medium-low to low malt notes, with a sweet, corn-like aroma. Low levels of DMS are allowable, but are not required. Hop aroma medium low to none, and can be of any variety although floral, spicy, or herbal notes are most common. Overall, a subtle aroma with neither hops nor malt dominating. Low fruity esters are optional.",
        appearance: "Pale straw to moderate gold color, although usually on the pale side. Low to medium head with medium to high carbonation. Fair head retention. Brilliant, sparkling clarity.",
        flavor: "Low to medium-low hop bitterness. Low to moderate maltiness and sweetness, varying with gravity and attenuation. Usually well-attenuated. Neither malt nor hops dominate the palate. A low to moderate corny flavor is commonly found, as is light DMS (optional). Finish can vary from somewhat dry to faintly sweet. Low fruity esters are optional. Low to medium-low hop flavor (any variety, but typically floral, spicy, or herbal).",
        mouthfeel: "Generally light and crisp, although body can reach medium. Smooth mouthfeel with medium to high attenuation; higher attenuation levels can lend a “thirst quenching” quality. High carbonation.",
        comments: "Pre-prohibition Cream Ales were slightly stronger, hoppier (including some dry hopping) and more bitter (25-30+ IBUs). These versions should be entered in the historical category. Most commercial examples are in the 1.050–1.053 OG range, and bitterness rarely rises above 20 IBUs.",
        history: "A sparkling or present-use ale that existed in the 1800s and survived prohibition. An ale version of the American lager style. Produced by ale brewers to compete with lager brewers in Canada and the Northeast, Mid-Atlantic, and Midwest states. Originally known as sparkling or present use ales, lager strains were (and sometimes still are) used by some brewers, but were not historically mixed with ale strains. Many examples are kräusened to achieve carbonation. Cold conditioning isn’t traditional, although modern brewers sometimes use it.",
        characteristicIngredients: "American ingredients most commonly used. A grain bill of six-row malt, or a combination of six-row and North American two-row, is common. Adjuncts can include up to 20% maize in the mash, and up to 20% glucose or other sugars in the boil. Any variety of hops can be used for bittering and finishing.",
        styleComparison: "Similar to a Standard American Lager, but with more character.",
        vitalStatistics: {
            minIbu: 8,
            maxIbu: 20,
            minSrm: 2.5,
            maxSrm: 5,
            minOg: 1.042,
            maxOg: 1.055,
            minFg: 1.006,
            maxFg: 1.012,
            minAbv: 4.2,
            maxAbv: 5.6
        },
        commercialExamples: [
            "Genesee Cream Ale",
            "Liebotschaner Cream Ale",
            "Little Kings Cream Ale",
            "New Glarus Spotted Cow",
            "Old Style",
            "Sleeman Cream Ale"
        ],
        tags: [
            "standard-strength",
            "pale-color",
            "any-fermentation",
            "north-america",
            "traditional-style",
            "pale-ale-family",
            "balanced"
        ]
    },
    {
        _id: "1D",
        name: "American Wheat Beer",
        overallImpression: "Refreshing wheat beers that can display more hop character and less yeast character than their German cousins. A clean fermentation character allows bready, doughy, or grainy wheat flavors to be complemented by hop flavor and bitterness rather than yeast qualities.",
        aroma: "Low to moderate grainy, bready, or doughy wheat character. A light to moderate malty sweetness is acceptable. Esters can be moderate to none, although should reflect relatively neutral yeast strains; banana is inappropriate. Hop aroma may be low to moderate, and can have a citrusy, spicy, floral, or fruity character. No clove phenols.",
        appearance: "Usually pale yellow to gold. Clarity may range from brilliant to hazy with yeast approximating the German weissbier style of beer. Big, long-lasting white head.",
        flavor: "Light to moderately-strong bready, doughy, or grainy wheat flavor, which can linger into the finish. May have a moderate malty sweetness or finish quite dry. Low to moderate hop bitterness, which sometimes lasts into the finish. Balance is usually even, but may be slightly bitter. Low to moderate hop flavor (citrusy, spicy, floral, or fruity). Esters can be moderate to none, but should not include banana. No clove phenols. May have a slightly crisp finish.",
        mouthfeel: "Medium-light to medium body. Medium-high to high carbonation. Slight creaminess is optional; wheat beers sometimes have a soft, ‘fluffy’ impression.",
        comments: "Different variations exist, from an easy-drinking fairly sweet beer to a dry, aggressively-hopped beer with a strong wheat flavor. American rye beers should be entered in the Alternative Fermentables specialty category.",
        history: "An American craft beer adaptation of the German weissbier style using a cleaner yeast and more hops, first widely popularized by Widmer in the mid-1980s.",
        characteristicIngredients: "Clean American ale or lager yeast (German weissbier yeast is inappropriate). Large proportion of wheat malt (often 30–50%, which is lower than is typical in German weissbiers). American, German, or New World hops are typical.",
        styleComparison: "More hop character and less yeast character than German weissbier. Never with the banana and clove character of German weissbier. Generally can have the same range and balance as Blonde Ales, but with a wheat character as the primary malt flavor.",
        vitalStatistics: {
            minIbu: 15,
            maxIbu: 30,
            minSrm: 3,
            maxSrm: 6,
            minOg: 1.040,
            maxOg: 1.055,
            minFg: 1.008,
            maxFg: 1.013,
            minAbv: 4.0,
            maxAbv: 5.5
        },
        commercialExamples: [
            "Bell’s Oberon",
            "Boulevard Unfiltered Wheat Beer",
            "Goose Island 312 Urban Wheat Ale",
            "Widmer Hefeweizen"
        ],
        tags: [
            "standard-strength",
            "pale-color",
            "any-fermentation",
            "north-america",
            "craft-style",
            "wheat-beer-family",
            "balanced"
        ]
    }
]

function success(message) {
    printjson({
        "status": "SUCCESS",
        "msg": message
    });
}

function fail(message, data) {
    printjson({
        "status": "FAILED",
        "msg": message,
        "data": data
    });
}

try {
    if (!db.getCollection(collectionName).exists()) {
        db.createCollection(collectionName);
        if (db.getCollection(collectionName).exists()) {
            success("Successfully created collection " + collectionName);
        } else {
            fail("Failed to create collection " + collectionName);
        }

        db.getCollection(collectionName).createIndex({ name: 1 }, { unique: true} );
    }
    let collection = db.getCollection(collectionName);
    documents.forEach(function(document) {
        let now = new Date();
        document.createdAt = now;
        document.updatedAt = now;
        let result = collection.insertOne(document);
        if (result.acknowledged === true) {
            success("Successfully inserted style " + document._id);
        } else {
            fail("Failed to insert style " + document._id);
        }
    });
    success("SUCCESS");
} catch (e) {
    fail("FAILED: " + e);
}