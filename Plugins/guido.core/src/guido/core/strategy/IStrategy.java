package guido.core.strategy;

import guido.core.verifier.SettingsObject;

public interface IStrategy {
	SettingsObject computeNextConfiguration();
}
