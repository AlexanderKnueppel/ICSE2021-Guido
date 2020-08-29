package guido.verification.systems.key;

import com.google.gson.Gson;

import guido.core.proof.controller.IProofControl;
import guido.core.verifier.AVerificationSystemFactory;
import guido.core.verifier.BatchXMLHelper;
import guido.core.verifier.IJob;
import guido.core.verifier.OptionableContainer;
import guido.core.verifier.SampleHelper;
import guido.core.verifier.SettingsObject;
import guido.verification.systems.key.options.strategies.KeyStrategyOptions;

public class KeyFactory extends AVerificationSystemFactory {

	public IProofControl createProofControl() {

		return new ExampleBasedKeyControl();

	}

	@Override
	public SampleHelper createSampleHelper() {
		// TODO Auto-generated method stub
		return new KeySampleHelper();
	}

	@Override
	public BatchXMLHelper createBatchXMLHelper() {
		// TODO Auto-generated method stub
		return new KeyBatchXmlHelper();
	}

	public SettingsObject createSettingsObject() {

		return new KeySettingsObject();
	}

	@Override
	public OptionableContainer[] createOptionableContainer() {
		// TODO Auto-generated method stub
		return KeyStrategyOptions.values();
	}

	@Override
	public OptionableContainer createOptionableContainer(String name) {
		// TODO Auto-generated method stub
		return KeyStrategyOptions.getOption(name);
	}

	@Override
	public IJob parseJobWithGson(String line) {
		Gson g = new Gson();
		return g.fromJson(line, KeyJavaJob.class);
	}
}
