package guido.verification.systems.key.options.taclets;

import guido.core.verifier.OptionableContainer;


public enum RuntimeExceptionsTaclet implements TacletOptionable{

	BAN, ALLOW, IGNORE;
	
	@Override
	public String getValue() {
		return getType()+":"+name().toLowerCase();
	}

	@Override
	public OptionableContainer getOptionableContainer() {
		return KeyTacletOptions.RUNTIME_EXCEPTIONS;
	}

}
