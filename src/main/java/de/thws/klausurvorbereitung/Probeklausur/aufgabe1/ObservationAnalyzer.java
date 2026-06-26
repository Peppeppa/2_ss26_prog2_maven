package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

import java.util.List;

public class ObservationAnalyzer {

    public static double maxSpecialCalibration(List<SpecialCalibration> instrumente){
        return instrumente.stream()
                .mapToDouble(s -> s.calibrationValue())
                .max()
                .orElse(0.0);
    }
}
