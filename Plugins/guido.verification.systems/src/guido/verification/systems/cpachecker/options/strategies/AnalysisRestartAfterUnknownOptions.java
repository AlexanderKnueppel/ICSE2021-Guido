package guido.verification.systems.cpachecker.options.strategies;

import guido.core.verifier.OptionableContainer;

 public enum AnalysisRestartAfterUnknownOptions implements KonfigurationOptionable{
	TRUE("true"),FALSE("false");
	private final String value;

	AnalysisRestartAfterUnknownOptions(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	@Override
	public OptionableContainer getOptionableContainer() {
		return CPACheckerKonfigurationOptions.ANALYSIS_RESTARTAFTERUNKNOWN;
	}
}
