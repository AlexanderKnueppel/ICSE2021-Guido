package guido.core.proof;

import java.util.concurrent.Callable;

import guido.core.databasis.IDataBasisElement;
import guido.core.proof.controller.IProofControl;
import guido.core.verifier.IJob;

public class ProverTask implements Callable<IDataBasisElement> {
	IProofControl pc;
	IJob job;

	public ProverTask(IProofControl pc, IJob job) {
		this.pc = pc;
		this.job = job;
	}

	@Override
	public IDataBasisElement call() throws Exception {	
		return pc.performProof(job);
	}
}
