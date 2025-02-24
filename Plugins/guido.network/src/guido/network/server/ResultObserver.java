package guido.network.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import guido.core.databasis.IDataBasisElement;
import guido.core.verifier.IJob;
import guido.key.pooling.WorkingPool;
import guido.network.ProofRunnable;
import guido.network.ResultCommunication;

public class ResultObserver implements Observer {

	private BufferedWriter results;
	private BufferedWriter doneJob;
	private Gson gson = new GsonBuilder().create();
	private final WorkingPool pool;
	private int port;
	private PunishmentTracker pt;

	public ResultObserver(File result, File done, WorkingPool pool, int port, PunishmentTracker pt) throws IOException {
		results = new BufferedWriter(new FileWriter(result, true));
		doneJob = new BufferedWriter(new FileWriter(done, true));
		this.pool = pool;
		this.port = port;
		this.pt = pt;
	}

	public void close() throws IOException {
		results.close();
	}

	@Override
	public void update(Observable o, Object arg) {
		ResultCommunication resCom = (ResultCommunication) arg;
		if (punish(resCom)) {

			IJob j = resCom.getJob();
			try {
				j = pt.punish(j);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ProofRunnable kpr = new ProofRunnable(j, port);
			pool.addJob(kpr);
		} else {
			synchronized (results) {
				try {
					for (IDataBasisElement res : resCom.getResults()) {
						results.write(gson.toJson(res));
						results.newLine();
					}

					doneJob.write(gson.toJson(resCom.getJob()));
					doneJob.newLine();

					results.flush();
					doneJob.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean punish(ResultCommunication resultCom) {
		final double maxSteps = resultCom.getJob().getSo().getMaxEffort();
		for (IDataBasisElement res : resultCom.getResults())
			if (!res.isProvable() && res.getEffort() >= maxSteps)
				return true;
		return false;
	}
}
