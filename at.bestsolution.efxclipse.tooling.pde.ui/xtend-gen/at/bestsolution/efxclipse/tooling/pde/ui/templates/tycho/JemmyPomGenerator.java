package at.bestsolution.efxclipse.tooling.pde.ui.templates.tycho;

import at.bestsolution.efxclipse.tooling.pde.ui.templates.tycho.JemmyPomData;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JemmyPomGenerator {
  public CharSequence generate(final JemmyPomData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<modelVersion>4.0.0</modelVersion>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    String _description = data.getDescription();
    _builder.append(_description, "	");
    _builder.append("</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<groupId>");
    String _groupId = data.getGroupId();
    _builder.append(_groupId, "	");
    _builder.append("</groupId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<artifactId>");
    String _artifactId = data.getArtifactId();
    _builder.append(_artifactId, "	");
    _builder.append("</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<packaging>eclipse-test-plugin</packaging>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<parent>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<groupId>");
    String _parentGroupId = data.getParentGroupId();
    _builder.append(_parentGroupId, "		");
    _builder.append("</groupId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<artifactId>");
    String _parentArtifactId = data.getParentArtifactId();
    _builder.append(_parentArtifactId, "		");
    _builder.append("</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<relativePath>");
    String _parentPomPath = data.getParentPomPath();
    _builder.append(_parentPomPath, "		");
    _builder.append("/pom.xml</relativePath>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<version>");
    String _parentVersion = data.getParentVersion();
    _builder.append(_parentVersion, "		");
    _builder.append("</version>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</parent>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<build>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<plugins>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.eclipse.tycho</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>tycho-surefire-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>${tycho-version}</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<testSuite>");
    String _testSuiteBundle = data.getTestSuiteBundle();
    _builder.append(_testSuiteBundle, "					");
    _builder.append("</testSuite>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<testClass>");
    String _testSuiteClass = data.getTestSuiteClass();
    _builder.append(_testSuiteClass, "					");
    _builder.append("</testClass>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<useUIHarness>false</useUIHarness>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<useUIThread>false</useUIThread>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<argLine>-Xms40m -Xmx512m -Defxclipse.osgi.hook.debug=true -Dosgi.framework.extensions=at.bestsolution.efxclipse.runtime.osgi -Dtest.jemmy.product=");
    String _testProductId = data.getTestProductId();
    _builder.append(_testProductId, "					");
    _builder.append("</argLine>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<appArgLine>-consoleLog -nosplash -console</appArgLine>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<application>org.eclipse.pde.junit.runtime.coretestapplication</application>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<type>eclipse-feature</type>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<artifactId>");
    String _applicationFeature = data.getApplicationFeature();
    _builder.append(_applicationFeature, "							");
    _builder.append("</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<version>0.0.0</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<frameworkExtensions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<frameworkExtension>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<groupId>at.bestsolution.efxclipse</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<artifactId>at.bestsolution.efxclipse.runtime.osgi</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<version>${efx-version}</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</frameworkExtension>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</frameworkExtensions>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<phase>test</phase>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<goal>test</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</executions>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.eclipse.tycho</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>tycho-maven-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>${tycho-version}</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<extensions>true</extensions>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.eclipse.tycho</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>target-platform-configuration</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>${tycho-version}</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<resolver>p2</resolver>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</plugins>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</build>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>junit</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>junit</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<scope>test</scope>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</project>");
    _builder.newLine();
    return _builder;
  }
}
