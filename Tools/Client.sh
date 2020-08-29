#!/bin/sh
export PATH=$PATH:./CPAchecker-1.9-unix/lib/native
java -cp "guido.core/target/classes/:guido.core/libs/*:guido.network/libs/*:guido.network/bin:guido.verification.systems/libs/*:guido.workingPools/bin:guido.logger/bin:guido.verification.systems/bin:CPAchecker-1.9-unix/lib/*:CPAchecker-1.9-unix/cpachecker.jar:CPAchecker-1.9-unix/lib/java/runtime/*" guido.network.client.Client CPAChecker