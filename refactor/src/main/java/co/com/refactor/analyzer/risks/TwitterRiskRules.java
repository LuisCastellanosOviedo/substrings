package co.com.refactor.analyzer.risks;

import java.util.function.Predicate;

public class TwitterRiskRules {

    public static Predicate<Double> highRisk = x -> x >= -1 && x <= -0.5d;
    public static Predicate<Double> mediumRisk = x -> x > -0.5d && x < 0.7d;
    public static Predicate<Double> lowRisk = x -> x >= 0.7d;
}
