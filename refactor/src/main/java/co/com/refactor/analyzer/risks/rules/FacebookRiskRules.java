package co.com.refactor.analyzer.risks.rules;

import java.util.function.Predicate;

public class FacebookRiskRules {

    public static Predicate<Double> highRisk = x -> x == -100d;
    public static Predicate<Double> mediumRisk = x -> x > -100d && x < 50d;
    public static Predicate<Double> lowRisk = x -> x >= 50d;


}
