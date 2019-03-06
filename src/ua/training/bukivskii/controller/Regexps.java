package ua.training.bukivskii.controller;

import ua.training.bukivskii.model.entities.Salad;

public interface Regexps {
    String SORT_REGEXP = "[1-3]{1}";
    String SALAD_REGEXP = "[1-3]{1}";
    String CALORIES_RANGE_REGEXP = "([0-9]|([1-9]{1}[0-9]*))[ \\-]([0-9]|([1-9]{1}[0-9]*))";
}
