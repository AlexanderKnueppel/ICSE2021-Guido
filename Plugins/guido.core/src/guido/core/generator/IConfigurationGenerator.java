package guido.core.generator;

import guido.core.verifier.SettingsObject;

public interface IConfigurationGenerator {
	public SettingsObject computeNext();

	public boolean hasNext();
}
