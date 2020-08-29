package guido.core.analysis;

import java.util.List;

public interface IAnalyzer {
	public interface LanguageConstruct {
		String getLanguageConstruct();
	}

	public List<LanguageConstruct> analyze();

	public boolean hasLanguageConstruct(LanguageConstruct lc);
}
