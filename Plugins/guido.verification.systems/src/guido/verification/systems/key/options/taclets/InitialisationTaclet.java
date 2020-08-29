package guido.verification.systems.key.options.taclets;

import guido.core.verifier.OptionableContainer;


public enum InitialisationTaclet implements TacletOptionable{

	DISABLE_STATIC_INITIALISATION("disableStaticInitialisation"), ENABLE_STATIC_INITIALISATION("enableStaticInitialisation");
	
	private final String value;
	
	private InitialisationTaclet(String value) {
		this. value = value;
	}
	
	@Override
	public String getValue() {
		return getType()+":"+value;
	}

	@Override
	public OptionableContainer getOptionableContainer() {
		return KeyTacletOptions.INITIALISATION;
	}

}
