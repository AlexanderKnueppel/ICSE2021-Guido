package general;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.tubs.isf.guido.core.analysis.AnalysisCombinator;
import de.tubs.isf.guido.core.analysis.IAnalyzer.LanguageConstruct;
import de.tubs.isf.guido.core.analysis.JMLContractAnalyzer;
import de.tubs.isf.guido.core.analysis.JavaSourceCodeAnalyzer;
import de.tubs.isf.guido.core.databasis.DataBasis;
import de.tubs.isf.guido.core.databasis.DefaultDataBasisElement;
import de.tubs.isf.guido.verification.systems.key.KeyDataBasisElement;

public class RepairDatabasis {
	public static void main(String[] args) {
		DataBasis<KeyDataBasisElement> db = DataBasis.readFromFile(new File("./testData/keyproject/results.txt"), KeyDataBasisElement.class);
		DataBasis<KeyDataBasisElement> dbnew = new DataBasis<KeyDataBasisElement>(KeyDataBasisElement.class);
		
		for (KeyDataBasisElement entry : db.getEntries()) {
			
			String pattern = entry.getName();
			
			pattern = pattern.replace("[I", "int##");
			pattern = pattern.split("\\]")[0];
			String[] str = pattern.split("\\[");

			String clazz = str[0];
			String method = str[1].split("::")[1].split("\\(")[0];
			String[] arguments = str[1].split("::")[1].split("\\(")[1].replace(")", "").replace("##","[]").split(",");

			JavaSourceCodeAnalyzer jsca = new JavaSourceCodeAnalyzer(new File("./testData/keyproject/ReduxProblemSolved"),
					clazz, method, arguments);
			jsca.setContractAnalyzer(new JMLContractAnalyzer());
			jsca.analyze();

			JMLContractAnalyzer ca = new JMLContractAnalyzer(jsca.getCommentString());
			ca.analyze();
			
			List<LanguageConstruct> constructs = AnalysisCombinator.and(jsca, ca);

			KeyDataBasisElement n = entry.clone();
			n.getLanguageConstructs().addAll(constructs.stream()
					.map(l -> l.getLanguageConstruct()).collect(Collectors.toList()));
			
			dbnew.addEntry(n);
			
			//System.out.println(n.getLanguageConstructs());
		}
		//db.addEntries(elements.toArray(new KeyDataBasisElement[0]));
		
		dbnew.writeToFile(new File("./testData/keyproject/keyresults.txt"));
//
//		JavaSourceCodeAnalyzer jsca = new JavaSourceCodeAnalyzer(new File("./keyproject/ReduxProblemSolved"),
//				"Examples_from_Chapter_16.Sort", "max", new String[] { "int" });
//		jsca.setContractAnalyzer(new JMLContractAnalyzer());
//		jsca.analyze();
//		System.out.println(jsca);
//
//		JMLContractAnalyzer ca = new JMLContractAnalyzer(jsca.getComment().toString());
//		ca.analyze();
//		System.out.println(ca);
//
//		jsca = new JavaSourceCodeAnalyzer(new File("./testData/Examples_from_Chapter_16"),
//				"Examples_from_Chapter_16.Sort", "sort", new String[] {});
//		jsca.setContractAnalyzer(new JMLContractAnalyzer());
//		jsca.analyze();
//		System.out.println(jsca);
//
//		jsca = new JavaSourceCodeAnalyzer(new File("./testData/Examples_from_Chapter_16"),
//				"Examples_from_Chapter_16.Sort", "m4", new String[] { "String[]", "int", "float" });
//		jsca.setContractAnalyzer(new JMLContractAnalyzer());
//		jsca.analyze();
//		System.out.println(jsca);
////
////		ca = new JMLContractAnalyzer(jsca.getComment().toString());
////		ca.analyze();
////		System.out.println(ca);
////
//		System.out.println(AnalysisCombinator.and(jsca, ca));
	}
}
