const collectionName = "styles";

const documents = [
    {
        _id: "1A",
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
        },
        commercialExamples: [
        ],
        tags: [
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