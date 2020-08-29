package guido.core.statistics.correction;

import guido.core.statistics.Hypotheses;

public interface IAlphaCorrection {
	double apply(final Hypotheses hypotheses, final double uncompensatedAlpha);
}
