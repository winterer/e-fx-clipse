package at.bestsolution.efxclipse.tooling.pde.ui.templates.tycho

class RootPomGenerator {
	def generate(RootPomData data) '''<?xml version="1.0" encoding="UTF-8"?>
<project
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
	xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<modelVersion>4.0.0</modelVersion>
	<name>«data.description»</name>

	<prerequisites>
		<maven>3.0</maven>
	</prerequisites>

	<groupId>«data.groupId»</groupId>
	<artifactId>«data.artifactId»</artifactId>
	<version>«data.version»</version>
	<packaging>pom</packaging>
	<properties>
		<tycho-version>«data.tychoVersion»</tycho-version>
		<junit-version>«data.junitVersion»</junit-version>
		<mockito-version>«data.mockitoVersion»</mockito-version>
		<platform-version>«data.platformVersion»</platform-version>
		<efx-version>«data.efxVersion»</efx-version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<modules>
		«FOR m : data.modulePaths»
			<module>«m»</module>
		«ENDFOR»
	</modules>

	<repositories>
		«FOR r : data.repositories»
			<repository>
				<id>«r.id»</id>
				<layout>p2</layout>
				<url>«r.url»</url>
			</repository>
		«ENDFOR»

	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>tycho</id>
			<url>http://repository.sonatype.org/content/groups/sonatype-public-grid</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>

	<build>

		<!-- build plugins -->
		<plugins>
			<plugin>
				<groupId>org.eclipse.tycho</groupId>
				<artifactId>tycho-maven-plugin</artifactId>
				<version>${tycho-version}</version>
				<extensions>true</extensions>
			</plugin>

			<plugin>
				<groupId>org.eclipse.tycho</groupId>
				<artifactId>target-platform-configuration</artifactId>
				<version>${tycho-version}</version>
				<configuration>
					<resolver>p2</resolver>
					<pomDependencies>consider</pomDependencies>
					<environments>
						«IF data.envLinux32»
						<environment>
							<os>linux</os>
							<ws>gtk</ws>
							<arch>x86</arch>
						</environment>
						«ENDIF»
						«IF data.envLinux64»
						<environment>
							<os>linux</os>
							<ws>gtk</ws>
							<arch>x86_64</arch>
						</environment>
						«ENDIF»
						«IF data.envWin32»
						<environment>
							<os>win32</os>
							<ws>win32</ws>
							<arch>x86</arch>
						</environment>
						«ENDIF»
						«IF data.envWin64»
						<environment>
							<os>win32</os>
							<ws>win32</ws>
							<arch>x86_64</arch>
						</environment>
						«ENDIF»
						«IF data.envMacOS»
						<environment>
							<os>macosx</os>
							<ws>cocoa</ws>
							<arch>x86_64</arch>
						</environment>
						«ENDIF»
					</environments>
				</configuration>
			</plugin>
		</plugins>


		<!-- defines the default settings for the used plugins -->
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.eclipse.tycho</groupId>
					<artifactId>tycho-compiler-plugin</artifactId>
					<version>${tycho-version}</version>
					<configuration>
						<encoding>UTF-8</encoding>
						<source>1.7</source>
						<target>1.7</target>
						<extraClasspathElements>
							<extraClasspathElement>
								<groupId>javafx</groupId>
								<artifactId>javafx.mvn</artifactId>
								<version>«data.javaFXArtifactVersion»</version> 
							</extraClasspathElement>
						</extraClasspathElements>
					</configuration>
				</plugin>
				<plugin>
					<groupId>org.eclipse.tycho</groupId>
					<artifactId>tycho-source-plugin</artifactId>
					<version>${tycho-version}</version>
					<executions>
						<execution>
							<id>plugin-source</id>
							<goals>
								<goal>plugin-source</goal>
							</goals>
						</execution>
					</executions>
				</plugin>
				<plugin>
				<groupId>org.eclipse.tycho</groupId>
				<artifactId>tycho-packaging-plugin</artifactId>
				<version>${tycho-version}</version>
				<configuration>
					<archiveSite>true</archiveSite>
				</configuration>
			</plugin>
			</plugins>
		</pluginManagement>
	</build>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>${junit-version}</version>
				<scope>test</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<version>${mockito-version}</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

</project>'''
}