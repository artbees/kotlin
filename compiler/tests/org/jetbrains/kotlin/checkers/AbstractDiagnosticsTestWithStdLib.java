/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.checkers;

import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles;
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment;
import org.jetbrains.kotlin.test.ConfigurationKind;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestJdkKind;

import java.io.File;
import java.util.Arrays;

public abstract class AbstractDiagnosticsTestWithStdLib extends AbstractDiagnosticsTest {
    @Override
    protected KotlinCoreEnvironment createEnvironment() {
        File javaFilesDir = createJavaFilesDir();
        return KotlinCoreEnvironment.createForTests(getTestRootDisposable(),
                                                    KotlinTestUtils.compilerConfigurationForTests(
                                                         ConfigurationKind.ALL,
                                                         TestJdkKind.MOCK_JDK,
                                                         Arrays.asList(KotlinTestUtils.getAnnotationsJar()),
                                                         Arrays.asList(javaFilesDir)
                                                 ),
                                                    EnvironmentConfigFiles.JVM_CONFIG_FILES);
    }
}
