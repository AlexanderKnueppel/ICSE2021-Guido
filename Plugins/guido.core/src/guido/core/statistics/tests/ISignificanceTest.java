package guido.core.statistics.tests;

import java.util.Optional;

import guido.core.experiments.AExperiment;

public interface ISignificanceTest {
	public Optional<Double> computeP(final AExperiment experiment);
}
