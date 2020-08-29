package guido.verification.systems.key.options.taclets;

import guido.core.verifier.OptionableContainer;


public enum AssertionsTaclet implements TacletOptionable{

	ON, OFF, SAFE;
	
	@Override
	public String getValue() {
		return getType()+":"+name().toLowerCase();
	}

	@Override
	public OptionableContainer getOptionableContainer() {
		return KeyTacletOptions.ASSERTIONS;
	}

}
