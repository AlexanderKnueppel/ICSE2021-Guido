package guido.verification.systems.cpachecker.options.strategies;

import guido.core.verifier.OptionableContainer;

 public enum CpaSmgEnableMallocFailOptions implements KonfigurationOptionable{
	FALSE("false"),TRUE("true");
	private final String value;

	CpaSmgEnableMallocFailOptions(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	@Override
	public OptionableContainer getOptionableContainer() {
		return CPACheckerKonfigurationOptions.CPA_SMG_ENABLEMALLOCFAIL;
	}
}
