package guido.core.statistics.correction;

import guido.core.statistics.Hypotheses;

public class NoCorrection implements IAlphaCorrection {

	@Override
	public double apply(Hypotheses hypotheses, double uncompensatedAlpha) {
		return uncompensatedAlpha;
	}

}
