package guido.core.generator;

import guido.core.verifier.AVerificationSystemFactory;
import guido.core.verifier.SettingsObject;

public class DefaultConfigurationGenerator implements IConfigurationGenerator {

	@Override
	public SettingsObject computeNext() {
		return AVerificationSystemFactory.getFactory().createSettingsObject();
	}

	@Override
	public boolean hasNext() {
		return false;
	}

}
