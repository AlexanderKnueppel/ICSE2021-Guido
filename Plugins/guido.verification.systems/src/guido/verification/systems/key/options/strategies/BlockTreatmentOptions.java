package guido.verification.systems.key.options.strategies;

import guido.core.verifier.OptionableContainer;

public enum BlockTreatmentOptions implements StrategyOptionable{
	INTERNALCONTRACT("Internal Contract"), EXPAND("Expand"), EXTERNALCONTRACT("External Contract");

	private final String value;

	BlockTreatmentOptions(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public OptionableContainer getOptionableContainer() {
		return KeyStrategyOptions.BLOCK_TREATMENT;
	}
}
