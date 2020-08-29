package guido.core.proof.controller;

import guido.core.databasis.IDataBasisElement;
import guido.core.verifier.IJob;

public interface IProofControl {
	public IDataBasisElement performProof(IJob job);
	//public boolean isClosed();
	//public List<IDataBasisElement> getCurrentResults();
}
