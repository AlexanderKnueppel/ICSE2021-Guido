package guido.verification.systems.key.options.taclets;

import guido.core.verifier.OptionableContainer;


public enum IntegerSimplificationRulesTaclet implements TacletOptionable{

	FULL, MINIMAL;
	
	@Override
	public String getValue() {
		return getType()+":"+name().toLowerCase();
	}

	@Override
	public OptionableContainer getOptionableContainer() {
		return KeyTacletOptions.INTEGER_SIMPLIFICATION_RULES;
	}

}
