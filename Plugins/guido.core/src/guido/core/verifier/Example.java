package guido.core.verifier;

import java.io.File;
import java.util.List;

import guido.core.databasis.IDataBasisElement;

public abstract  class Example{

	public abstract List<IDataBasisElement> getResultForProof(File source, File classPath,
			String className, String methodName, SettingsObject so);
		

}
