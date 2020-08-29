package guido.network;

import java.io.Serializable;
import java.util.List;

import guido.core.databasis.IDataBasisElement;
import guido.core.verifier.IJob;




public class ResultCommunication implements Serializable{

	private static final long serialVersionUID = 6078326954303589087L;
	private final IJob job;
	private final List<IDataBasisElement> results;
	public IJob getJob() {
		return job;
	}
	public List<IDataBasisElement> getResults() {
		return results;
	}
	public ResultCommunication(IJob job, List<IDataBasisElement> intermediate) {
		super();
		this.job = job;
		this.results = intermediate;
	}
	
}
