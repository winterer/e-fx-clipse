/*
 * generated by Xtext
 */
package at.bestsolution.efxclipse.tooling.fxgraph.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.Element
import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import java.util.List
import org.eclipse.core.internal.resources.Workspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jdt.internal.core.JavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.internal.core.ClasspathEntry
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.Import
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.Property
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ListProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ReferenceProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.IncludeProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.SimpleValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ReferenceValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.IncludeValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ListValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.MapValueProperty
import org.eclipse.xtend.typesystem.StaticProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.StaticValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.CopyValueProperty
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.common.types.JvmTypeReference
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ControllerHandledValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ScriptHandlerHandledValueProperty
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.ScriptValueExpression
import at.bestsolution.efxclipse.tooling.fxgraph.fXGraph.Language
import java.io.File
import java.io.FileOutputStream
import java.io.BufferedWriter
import java.io.FileWriter

class FXGraphGenerator implements IGenerator {
	
	def calculateRelativePath(Resource resource) {
		
			if( resource.URI.platformResource ) {
				var uri = resource.URI;
				var root = ResourcesPlugin::workspace.root;
				var project = root.getProject(uri.segment(1));
				var projectRelativePath = "";
				var i = 0;
			
				for( seg : uri.segments ) {
					if( i >= 1 ) {
						projectRelativePath = projectRelativePath + "/" + uri.segment(i);
					}
					i = i + 1;
				}
			
				var file = project.getFile(projectRelativePath);
				var jproject = JavaCore::create(project);
				var prefix = null;
				for( packroot: jproject.rawClasspath ) {
					if( packroot.entryKind == IClasspathEntry::CPE_SOURCE ) {
						if( projectRelativePath.startsWith(packroot.path.toString) ) {
							projectRelativePath = projectRelativePath.substring(packroot.path.toString.length);
						}
					}
				}
				
				return projectRelativePath;		
			} else {
				return null;
			}
		
	}
	
	def doGeneratePreview(Resource resource) {
		try {
			val projectRelativePath = calculateRelativePath(resource);
			if( projectRelativePath != null ) {
				return createContent(resource, projectRelativePath,true).toString;
			}	
		} catch(Exception e) {
			
		}
		
		return null;
	}
		
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		try {
			val projectRelativePath = calculateRelativePath(resource);
		
			if( projectRelativePath != null ) {
				val relativeOutPath = projectRelativePath.replaceFirst(".fxgraph$",".fxml");
				fsa.generateFile(relativeOutPath, createContent(resource, projectRelativePath,false));
			}	
		} catch(Exception e) {
			
		}
		
	}
	
	
	def createContent(Resource resource, String projectRelativePath, boolean forPreview) '''
		�val importManager = new ImportManager(true)�
		<?xml version="1.0" encoding="UTF-8"?>
		<!-- 
			Do not edit this file it is generated by e(fx)clipse from �projectRelativePath�
		-->
		
		�FOR lang : resource.contents.get(0).eContents.filter(typeof(Language))�
			<?language �lang.language�?>
		�ENDFOR�
		
		�FOR rootElement : resource.contents.get(0).eContents.filter(typeof(Element))�
		�val body = elementContent(rootElement, true, importManager, forPreview)�
		<?import java.lang.*?>
		�FOR i:importManager.imports�
			<?import �i�?>
		�ENDFOR�
		
		�body�
		�ENDFOR�
	'''
	
	def elementContent(Element element, boolean root, ImportManager importManager, boolean forPreview) '''
		<�element.type.shortName(importManager)��IF root� xmlns:fx="http://javafx.com/fxml"�ENDIF��fxElementAttributes(element,importManager,forPreview)��IF hasAttributeProperties(element)��elementAttributes(element.properties,forPreview)��ENDIF��IF ! hasNestedProperties(element)�/�ENDIF�> 
		�IF hasNestedProperties(element)�
			�IF element.defines.size > 0�
			<fx:define>
				�FOR define : element.defines�
				�elementContent(define.element,false,importManager,forPreview)�
				�ENDFOR�
			</fx:define>
			�ENDIF�
			�FOR script : element.scripts�
			�IF script.sourcecode != null && ! forPreview�
			<fx:script>�script.sourcecode.substring(2,script.sourcecode.length-2)�
			</fx:script>
			�ELSE�
			<fx:script source="�script.source�"/>
			�ENDIF�
			�ENDFOR�
			�propContents(element.properties,importManager,forPreview)�
			�statPropContent(element.staticProperties,importManager,forPreview)�
		</�element.type.shortName(importManager)�>
		�ENDIF�
	'''
	
	def propContents(List<Property> properties, ImportManager importManager, boolean forPreview) '''
		�FOR prop : properties.filter([Property p|subelementFilter(p)])�
		�propContent(prop,importManager,forPreview)�
		�ENDFOR�
	'''
	
	def propContent(Property prop, ImportManager importManager, boolean forPreview) '''
		�IF prop.value instanceof SimpleValueProperty�
			�IF (prop.value as SimpleValueProperty).stringValue != null�
				<�prop.name�>�(prop.value as SimpleValueProperty).stringValue�</�prop.name�>
			�ENDIF�
		�ELSEIF prop.value instanceof ListValueProperty�
			<�prop.name�>
				�propListContent(prop.value as ListValueProperty,importManager, forPreview)�
			</�prop.name�>
		�ELSEIF prop.value instanceof MapValueProperty�
			<�prop.name�>
				�propContents((prop.value as MapValueProperty).properties,importManager,forPreview)�
			</�prop.name�>
		�ELSEIF prop.value instanceof Element�
			<�prop.name�>
				�elementContent(prop.value as Element,false,importManager,forPreview)�
			</�prop.name�>
		�ELSEIF prop.value instanceof ReferenceValueProperty�
			<�prop.name�>
				<fx:reference source="�(prop.value as ReferenceValueProperty).reference.name�" />
			</�prop.name�>
		�ELSEIF prop.value instanceof IncludeValueProperty�
			<�prop.name�>
				<fx:include source="�(prop.value as IncludeValueProperty).source�" />
			</�prop.name�>
		�ELSEIF prop.value instanceof CopyValueProperty�
			<�prop.name�>
				<fx:copy source="�(prop.value as CopyValueProperty).reference.name�" />
			</�prop.name�>
		�ENDIF�
	'''
	
	def statPropContent(List<StaticValueProperty> properties, ImportManager importManager, boolean forPreview) '''
		�FOR prop : properties�
		�IF prop.value instanceof SimpleValueProperty�
			�IF (prop.value as SimpleValueProperty).stringValue != null�
				<�prop.type.shortName(importManager)�.�prop.name�>�(prop.value as SimpleValueProperty).stringValue�</�prop.type.shortName(importManager)�.�prop.name�>
			�ELSE�
				<�prop.type.shortName(importManager)�.�prop.name�>�simpleAttributeValue(prop.value as SimpleValueProperty)�</�prop.type.shortName(importManager)�.�prop.name�>
			�ENDIF�
		�ELSEIF prop.value instanceof ListValueProperty�
			<�prop.type.shortName(importManager)�.�prop.name�>
				�propListContent(prop.value as ListValueProperty,importManager, forPreview)�
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ELSEIF prop.value instanceof MapValueProperty�
			<�prop.type.shortName(importManager)�.�prop.name�>
				�propContents((prop.value as MapValueProperty).properties,importManager, forPreview)�
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ELSEIF prop.value instanceof Element�
			<�prop.type.shortName(importManager)�.�prop.name�>
				�elementContent(prop.value as Element,false,importManager, forPreview)�
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ELSEIF prop.value instanceof ReferenceValueProperty�
			<�prop.type.shortName(importManager)�.�prop.name�>
				<fx:reference source="�(prop.value as ReferenceValueProperty).reference.name�" />
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ELSEIF prop.value instanceof IncludeValueProperty�
			<�prop.type.shortName(importManager)�.�prop.name�>
				<fx:include source="�(prop.value as IncludeValueProperty).source�" />
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ELSEIF prop.value instanceof CopyValueProperty�
			<�prop.type.shortName(importManager)�.�prop.name�>
				<fx:copy source="�(prop.value as CopyValueProperty).reference.name�" />
			</�prop.type.shortName(importManager)�.�prop.name�>
		�ENDIF�
		�ENDFOR�
	'''
	
	def propListContent(ListValueProperty listProp, ImportManager importManager, boolean forPreview) '''
		�FOR e : listProp.value�
			�IF e instanceof Element�
				�elementContent(e as Element,false,importManager,forPreview)�
			�ELSEIF e instanceof ReferenceValueProperty�
				<fx:reference source="�(e as ReferenceValueProperty).reference.name�" />
			�ELSEIF e instanceof IncludeValueProperty�
				<fx:include source="�(e as IncludeValueProperty).source�" />
			�ENDIF�
		�ENDFOR�
	'''

	def fxElementAttributes(Element element, ImportManager importManager, boolean forPreview) {
		var builder = new StringBuilder();
		
		if(element.name != null) {
			builder.append(" fx:id=\""+element.name+"\"");
		}
		
		if( element.value != null ) {
			builder.append(" fx:value=\""+ simpleAttributeValue(element.value) + "\"");
		} else if( element.factory != null && ! forPreview ) {
			builder.append(" fx:factory=\""+ element.factory + "\"");
		}
		
		if( element.controller != null && ! forPreview ) {
			builder.append(" fx:controller=\""+ element.controller.qualifiedName + "\"");
		}
		
		return builder.toString;
	}
	
	def elementAttributes(List<Property> properties, boolean forPreview) {
		var builder = new StringBuilder();
		
		for( p : properties.filter([Property p|elementAttributeFilter(p)]) ) {
			if( p.value instanceof SimpleValueProperty ) {
				builder.append(" " + p.name + "=\""+simpleAttributeValue(p.value as SimpleValueProperty)+"\"");
			} else if( p.value instanceof ReferenceValueProperty ) {
				builder.append(" " + p.name + "=\"$"+(p.value as ReferenceValueProperty).reference.name+"\"");
			} else if( p.value instanceof ControllerHandledValueProperty ) {
				if( ! forPreview ) {
					builder.append(" " + p.name + "=\"#"+(p.value as ControllerHandledValueProperty).methodname +"\"");
				}
			} else if( p.value instanceof ScriptHandlerHandledValueProperty ) {
				if( ! forPreview ) {
					builder.append(" " + p.name + "=\""+(p.value as ScriptHandlerHandledValueProperty).functionname +"\"");
				}
			} else if( p.value instanceof ScriptValueExpression ) {
				if( ! forPreview ) {
					builder.append(" " + p.name + "=\""+(p.value as ScriptValueExpression).sourcecode.substring(2,(p.value as ScriptValueExpression).sourcecode.length-2).trim() +";\"");	
				}
			}
		}
		
		return builder;
	}
	
	def subelementFilter(Property property) {
		return ! elementAttributeFilter(property);
	}

	def elementAttributeFilter(Property property) {
		if( property.value instanceof SimpleValueProperty ) {
			if( (property.value as SimpleValueProperty).stringValue == null ) {
				return true;
			}
		} else if( property.value instanceof ReferenceValueProperty ) {
			return true;
		} else if( property.value instanceof ControllerHandledValueProperty ) {
			return true;
		} else if( property.value instanceof ScriptHandlerHandledValueProperty ) {
			return true;
		} else if( property.value instanceof ScriptValueExpression ) {
			return true;
		}
		return false;
	}

	def simpleAttributeValue(SimpleValueProperty value) {
		if( value.stringValue != null ) {
			return value.stringValue;
		} else if( value.booleanValue != null ) {
			return value.booleanValue;
		} else if( (value.realValue as int) != 0 ) {
			if( value.negative ) {
				return "-" + value.realValue;
			} else {
				return value.realValue;
			}
		} else {
			if( value.negative ) {
				return "-" + value.intValue;
			} else {
				return value.intValue;
			}
		}
	}
	
	def hasAttributeProperties(Element element) {
		return element.properties.size > 0 && ! element.properties.filter([Property p|elementAttributeFilter(p)]).nullOrEmpty;
	}
	
	def hasNestedProperties(Element element) {
		if( element.staticProperties.size > 0) {
			return true;
		} else if( element.defines.size > 0 ) {
			return true;
		} else if( element.scripts.size > 0 ) {
			return true;
		}
		
		if( element.properties.size > 0 ) {
			return ! element.properties.filter([Property p|subelementFilter(p)]).nullOrEmpty;
		}
		
		return false;
	}
	
	def shortName(JvmTypeReference r, ImportManager importManager) {
		val builder = new StringBuilder()
		importManager.appendTypeRef(r, builder)
		builder.toString
	}
}
