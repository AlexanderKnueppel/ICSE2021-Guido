package guido.verification.systems.cpachecker;

import com.google.gson.Gson;

import guido.core.proof.controller.IProofControl;
import guido.core.verifier.AVerificationSystemFactory;
import guido.core.verifier.BatchXMLHelper;
import guido.core.verifier.IJob;
import guido.core.verifier.OptionableContainer;
import guido.core.verifier.SampleHelper;
import guido.core.verifier.SettingsObject;
import guido.verification.systems.cpachecker.options.strategies.CPACheckerKonfigurationOptions;

public class CPACheckerFactory extends AVerificationSystemFactory{
	public IProofControl createProofControl() {

		return new ExampleBasedCPACheckerControl();
	}

	@Override
	public SampleHelper createSampleHelper() {
		// TODO Auto-generated method stub
		return new CPACheckerSampleHelper();
	}

	@Override
	public BatchXMLHelper createBatchXMLHelper() {
		// TODO Auto-generated method stub
		return new CPACheckerBatchXmlHelper();
	}

	public SettingsObject createSettingsObject() {

		return new CPASettingsObject();
	}

	@Override
	public OptionableContainer[] createOptionableContainer() {
		// TODO Auto-generated method stub
		return CPACheckerKonfigurationOptions.values();
	}

	@Override
	public OptionableContainer createOptionableContainer(String name) {
		// TODO Auto-generated method stub
		return CPACheckerKonfigurationOptions.getOption(name);
	}

	@Override
	public IJob parseJobWithGson(String line) {
		Gson g = new Gson();
		return g.fromJson(line, CPACJob.class);
	}
}
