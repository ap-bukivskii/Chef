package ua.training.bukivskii.model.services.sorting;

import java.util.HashMap;
import java.util.Map;

public class SortIngredients {
    private static SortIngredients instance;
    private Map<SortingTypes, Sort> types = new HashMap<>();

    private SortIngredients() {}

    public static SortIngredients getInstance() {
        if (instance == null) {
            instance = new SortIngredients();
        }
        return instance;
    }

    {
        types.put(SortingTypes.BY_NAME, new SortByName());
        types.put(SortingTypes.BY_CALORIES, new SortByCalories());
        types.put(SortingTypes.BY_COST, new SortByCost());
    }

    public Sort getAction(SortingTypes request) {
        return types.get(request);
    }
}


