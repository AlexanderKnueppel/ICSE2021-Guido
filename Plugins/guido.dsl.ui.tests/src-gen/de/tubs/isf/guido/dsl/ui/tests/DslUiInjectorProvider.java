/*
 * generated by Xtext 2.22.0
 */
package de.tubs.isf.guido.dsl.ui.tests;

import com.google.inject.Injector;
import de.tubs.isf.guido.dsl.ui.internal.DslActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class DslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return DslActivator.getInstance().getInjector("de.tubs.isf.guido.dsl.Dsl");
	}

}
