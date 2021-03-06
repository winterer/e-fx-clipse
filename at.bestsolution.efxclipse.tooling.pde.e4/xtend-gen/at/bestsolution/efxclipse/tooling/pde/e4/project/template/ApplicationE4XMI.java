package at.bestsolution.efxclipse.tooling.pde.e4.project.template;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ApplicationE4XMI {
  public CharSequence generateContent(final String rootContext) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<application:Application ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmi:version=\"2.0\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xmi=\"http://www.omg.org/XMI\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:advanced=\"http://www.eclipse.org/ui/2010/UIModel/application/ui/advanced\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:application=\"http://www.eclipse.org/ui/2010/UIModel/application\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:basic=\"http://www.eclipse.org/ui/2010/UIModel/application/ui/basic\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:menu=\"http://www.eclipse.org/ui/2010/UIModel/application/ui/menu\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmi:id=\"");
    String _generateUUID = EcoreUtil.generateUUID();
    _builder.append(_generateUUID, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("elementId=\"org.eclipse.e4.application\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bindingContexts=\"");
    _builder.append(rootContext, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<rootContext xmi:id=\"");
    _builder.append(rootContext, "	");
    _builder.append("\" elementId=\"org.eclipse.ui.contexts.dialogAndWindow\" name=\"In Dialog and Windows\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<children xmi:id=\"");
    String _generateUUID_1 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_1, "		");
    _builder.append("\" elementId=\"org.eclipse.ui.contexts.window\" name=\"In Windows\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<children xmi:id=\"");
    String _generateUUID_2 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_2, "		");
    _builder.append("\" elementId=\"org.eclipse.ui.contexts.dialog\" name=\"In Dialogs\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</rootContext>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_3 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_3, "	");
    _builder.append("\" elementId=\"org.eclipse.e4.core.commands.service\" contributionURI=\"bundleclass://org.eclipse.e4.core.commands/org.eclipse.e4.core.commands.CommandServiceAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_4 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_4, "	");
    _builder.append("\" elementId=\"org.eclipse.e4.ui.contexts.service\" contributionURI=\"bundleclass://org.eclipse.e4.ui.services/org.eclipse.e4.ui.services.ContextServiceAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_5 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_5, "	");
    _builder.append("\" elementId=\"at.bestsolution.efxclipse.runtime.bindings.e4.service\" contributionURI=\"bundleclass://at.bestsolution.efxclipse.runtime.bindings.e4/at.bestsolution.efxclipse.runtime.bindings.e4.BindingServiceAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_6 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_6, "	");
    _builder.append("\" elementId=\"org.eclipse.e4.ui.workbench.commands.model\" contributionURI=\"bundleclass://org.eclipse.e4.ui.workbench/org.eclipse.e4.ui.internal.workbench.addons.CommandProcessingAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_7 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_7, "	");
    _builder.append("\" elementId=\"org.eclipse.e4.ui.workbench.contexts.model\" contributionURI=\"bundleclass://org.eclipse.e4.ui.workbench/org.eclipse.e4.ui.internal.workbench.addons.ContextProcessingAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<addons xmi:id=\"");
    String _generateUUID_8 = EcoreUtil.generateUUID();
    _builder.append(_generateUUID_8, "	");
    _builder.append("\" elementId=\"at.bestsolution.efxclipse.runtime.bindings.e4.model\" contributionURI=\"bundleclass://at.bestsolution.efxclipse.runtime.bindings.e4/at.bestsolution.efxclipse.runtime.bindings.e4.BindingProcessingAddon\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</application:Application>");
    _builder.newLine();
    return _builder;
  }
}
