/*
* generated by Xtext
*/
package at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import at.bestsolution.efxclipse.tooling.css.services.CssDslGrammarAccess;

public class CssDslParser extends AbstractContentAssistParser {
	
	@Inject
	private CssDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr.internal.InternalCssDslParser createParser() {
		at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr.internal.InternalCssDslParser result = new at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr.internal.InternalCssDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStylesheetAccess().getAlternatives(), "rule__Stylesheet__Alternatives");
					put(grammarAccess.getSelectorAccess().getAlternatives_1(), "rule__Selector__Alternatives_1");
					put(grammarAccess.getSimple_selectorAccess().getAlternatives(), "rule__Simple_selector__Alternatives");
					put(grammarAccess.getElement_nameAccess().getAlternatives(), "rule__Element_name__Alternatives");
					put(grammarAccess.getSub_selectorAccess().getAlternatives(), "rule__Sub_selector__Alternatives");
					put(grammarAccess.getCss_attribAccess().getAlternatives_2_0(), "rule__Css_attrib__Alternatives_2_0");
					put(grammarAccess.getCss_attribAccess().getAlternatives_2_1(), "rule__Css_attrib__Alternatives_2_1");
					put(grammarAccess.getCombinatorAccess().getAlternatives_0(), "rule__Combinator__Alternatives_0");
					put(grammarAccess.getOperatorAccess().getAlternatives(), "rule__Operator__Alternatives");
					put(grammarAccess.getUnary_operatorAccess().getAlternatives(), "rule__Unary_operator__Alternatives");
					put(grammarAccess.getTermAccess().getAlternatives(), "rule__Term__Alternatives");
					put(grammarAccess.getNumberTermAccess().getAlternatives_1(), "rule__NumberTerm__Alternatives_1");
					put(grammarAccess.getNumAccess().getAlternatives(), "rule__Num__Alternatives");
					put(grammarAccess.getLENGTHAccess().getAlternatives_1(), "rule__LENGTH__Alternatives_1");
					put(grammarAccess.getANGLEAccess().getAlternatives_1(), "rule__ANGLE__Alternatives_1");
					put(grammarAccess.getTIMEAccess().getAlternatives_1(), "rule__TIME__Alternatives_1");
					put(grammarAccess.getFREQAccess().getAlternatives_1(), "rule__FREQ__Alternatives_1");
					put(grammarAccess.getMediaAccess().getGroup(), "rule__Media__Group__0");
					put(grammarAccess.getMedia_listAccess().getGroup(), "rule__Media_list__Group__0");
					put(grammarAccess.getMedia_listAccess().getGroup_1(), "rule__Media_list__Group_1__0");
					put(grammarAccess.getRulesetAccess().getGroup(), "rule__Ruleset__Group__0");
					put(grammarAccess.getRulesetAccess().getGroup_1(), "rule__Ruleset__Group_1__0");
					put(grammarAccess.getRulesetAccess().getGroup_3(), "rule__Ruleset__Group_3__0");
					put(grammarAccess.getSelectorAccess().getGroup(), "rule__Selector__Group__0");
					put(grammarAccess.getSelectorAccess().getGroup_1_0(), "rule__Selector__Group_1_0__0");
					put(grammarAccess.getSelectorAccess().getGroup_1_1(), "rule__Selector__Group_1_1__0");
					put(grammarAccess.getSelectorAccess().getGroup_1_1_1(), "rule__Selector__Group_1_1_1__0");
					put(grammarAccess.getSimple_selectorAccess().getGroup_0(), "rule__Simple_selector__Group_0__0");
					put(grammarAccess.getCss_classAccess().getGroup(), "rule__Css_class__Group__0");
					put(grammarAccess.getCss_idAccess().getGroup(), "rule__Css_id__Group__0");
					put(grammarAccess.getCss_attribAccess().getGroup(), "rule__Css_attrib__Group__0");
					put(grammarAccess.getCss_attribAccess().getGroup_2(), "rule__Css_attrib__Group_2__0");
					put(grammarAccess.getCss_generic_declarationAccess().getGroup(), "rule__Css_generic_declaration__Group__0");
					put(grammarAccess.getCss_propertyAccess().getGroup(), "rule__Css_property__Group__0");
					put(grammarAccess.getCss_pseudoAccess().getGroup(), "rule__Css_pseudo__Group__0");
					put(grammarAccess.getCombinatorAccess().getGroup(), "rule__Combinator__Group__0");
					put(grammarAccess.getExprAccess().getGroup(), "rule__Expr__Group__0");
					put(grammarAccess.getExprAccess().getGroup_1(), "rule__Expr__Group_1__0");
					put(grammarAccess.getNumberTermAccess().getGroup(), "rule__NumberTerm__Group__0");
					put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
					put(grammarAccess.getHexColorAccess().getGroup(), "rule__HexColor__Group__0");
					put(grammarAccess.getURLTypeAccess().getGroup(), "rule__URLType__Group__0");
					put(grammarAccess.getPERCENTAGEAccess().getGroup(), "rule__PERCENTAGE__Group__0");
					put(grammarAccess.getEMSAccess().getGroup(), "rule__EMS__Group__0");
					put(grammarAccess.getEXSAccess().getGroup(), "rule__EXS__Group__0");
					put(grammarAccess.getLENGTHAccess().getGroup(), "rule__LENGTH__Group__0");
					put(grammarAccess.getANGLEAccess().getGroup(), "rule__ANGLE__Group__0");
					put(grammarAccess.getTIMEAccess().getGroup(), "rule__TIME__Group__0");
					put(grammarAccess.getFREQAccess().getGroup(), "rule__FREQ__Group__0");
					put(grammarAccess.getStylesheetAccess().getRulesetAssignment_0(), "rule__Stylesheet__RulesetAssignment_0");
					put(grammarAccess.getStylesheetAccess().getMediaAssignment_1(), "rule__Stylesheet__MediaAssignment_1");
					put(grammarAccess.getMediaAccess().getMedialistAssignment_1(), "rule__Media__MedialistAssignment_1");
					put(grammarAccess.getMediaAccess().getRulesetsAssignment_3(), "rule__Media__RulesetsAssignment_3");
					put(grammarAccess.getRulesetAccess().getSelectorsAssignment_0(), "rule__Ruleset__SelectorsAssignment_0");
					put(grammarAccess.getRulesetAccess().getSelectorsAssignment_1_1(), "rule__Ruleset__SelectorsAssignment_1_1");
					put(grammarAccess.getRulesetAccess().getDeclarationsAssignment_3_0(), "rule__Ruleset__DeclarationsAssignment_3_0");
					put(grammarAccess.getSelectorAccess().getSimpleselectorsAssignment_0(), "rule__Selector__SimpleselectorsAssignment_0");
					put(grammarAccess.getSelectorAccess().getCombinatorAssignment_1_0_0(), "rule__Selector__CombinatorAssignment_1_0_0");
					put(grammarAccess.getSelectorAccess().getSelectorAssignment_1_0_1(), "rule__Selector__SelectorAssignment_1_0_1");
					put(grammarAccess.getSelectorAccess().getCombinatorAssignment_1_1_1_0(), "rule__Selector__CombinatorAssignment_1_1_1_0");
					put(grammarAccess.getSelectorAccess().getSelectorAssignment_1_1_1_1(), "rule__Selector__SelectorAssignment_1_1_1_1");
					put(grammarAccess.getSimple_selectorAccess().getElementAssignment_0_0(), "rule__Simple_selector__ElementAssignment_0_0");
					put(grammarAccess.getSimple_selectorAccess().getSubSelectorsAssignment_0_1(), "rule__Simple_selector__SubSelectorsAssignment_0_1");
					put(grammarAccess.getSimple_selectorAccess().getSubSelectorsAssignment_1(), "rule__Simple_selector__SubSelectorsAssignment_1");
					put(grammarAccess.getSub_selectorAccess().getIdAssignment_0(), "rule__Sub_selector__IdAssignment_0");
					put(grammarAccess.getSub_selectorAccess().getClassAssignment_1(), "rule__Sub_selector__ClassAssignment_1");
					put(grammarAccess.getSub_selectorAccess().getAttribAssignment_2(), "rule__Sub_selector__AttribAssignment_2");
					put(grammarAccess.getSub_selectorAccess().getPseudoclassAssignment_3(), "rule__Sub_selector__PseudoclassAssignment_3");
					put(grammarAccess.getCss_generic_declarationAccess().getPropertyAssignment_0(), "rule__Css_generic_declaration__PropertyAssignment_0");
					put(grammarAccess.getCss_generic_declarationAccess().getExpressionAssignment_2(), "rule__Css_generic_declaration__ExpressionAssignment_2");
					put(grammarAccess.getExprAccess().getTermGroupsAssignment_0(), "rule__Expr__TermGroupsAssignment_0");
					put(grammarAccess.getExprAccess().getTermGroupsAssignment_1_1(), "rule__Expr__TermGroupsAssignment_1_1");
					put(grammarAccess.getTermGroupAccess().getTermsAssignment(), "rule__TermGroup__TermsAssignment");
					put(grammarAccess.getTermAccess().getNumberAssignment_0(), "rule__Term__NumberAssignment_0");
					put(grammarAccess.getTermAccess().getStringValueAssignment_1(), "rule__Term__StringValueAssignment_1");
					put(grammarAccess.getTermAccess().getIdentifierAssignment_2(), "rule__Term__IdentifierAssignment_2");
					put(grammarAccess.getTermAccess().getUrlAssignment_3(), "rule__Term__UrlAssignment_3");
					put(grammarAccess.getTermAccess().getFunctionAssignment_4(), "rule__Term__FunctionAssignment_4");
					put(grammarAccess.getTermAccess().getHexColorAssignment_5(), "rule__Term__HexColorAssignment_5");
					put(grammarAccess.getFunctionAccess().getNameAssignment_1(), "rule__Function__NameAssignment_1");
					put(grammarAccess.getFunctionAccess().getExpressionAssignment_4(), "rule__Function__ExpressionAssignment_4");
					put(grammarAccess.getURLTypeAccess().getUrlAssignment_2(), "rule__URLType__UrlAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr.internal.InternalCssDslParser typedParser = (at.bestsolution.efxclipse.tooling.css.ui.contentassist.antlr.internal.InternalCssDslParser) parser;
			typedParser.entryRulestylesheet();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT" };
	}
	
	public CssDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CssDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
