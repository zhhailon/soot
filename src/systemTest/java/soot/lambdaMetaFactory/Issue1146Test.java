package soot.lambdaMetaFactory;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 2019 Manuel Benz
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import org.junit.Test;

import soot.SootMethod;
import soot.options.Options;
import soot.testing.framework.AbstractTestingFramework;

/**
 * Reproduces issue 1146: https://github.com/Sable/soot/issues/1146
 *
 * @author Manuel Benz at 2019-05-14
 */
public class Issue1146Test extends AbstractTestingFramework {

  @Test
  public void getVertragTest() {
    String testClass = "soot.lambdaMetaFactory.Issue1146";

    final SootMethod target = prepareTarget(
        methodSigFromComponents(testClass, "soot.lambdaMetaFactory.Issue1146$Vertrag", "getVertrag", "java.lang.String"),
        testClass, "java.util.function.Function");
    // if no exception is thrown, everything is working as intended
  }

  @Test
  public void getVertrag2Test() {
    String testClass = "soot.lambdaMetaFactory.Issue1146";

    final SootMethod target = prepareTarget(
        methodSigFromComponents(testClass, "soot.lambdaMetaFactory.Issue1146$Vertrag", "getVertrag2", "java.lang.String"),
        testClass, "java.util.function.Function");
    // if no exception is thrown, everything is working as intended
  }

  @Override
  protected void setupSoot() {
    super.setupSoot();
    // set classpath to something so that the rt.jar is not loaded as it would be when using the default cp
    Options.v().set_soot_classpath(SYSTEMTEST_TARGET_CLASSES_DIR);
  }
}
