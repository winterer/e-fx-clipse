/*
* generated by Xtext
*/
package at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import at.bestsolution.efxclipse.tooling.css.cssext.services.CssExtDslGrammarAccess;

public class CssExtDslParser extends AbstractContentAssistParser {
	
	@Inject
	private CssExtDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr.internal.InternalCssExtDslParser createParser() {
		at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr.internal.InternalCssExtDslParser result = new at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr.internal.InternalCssExtDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPackageDefinitionAccess().getAlternatives_3(), "rule__PackageDefinition__Alternatives_3");
					put(grammarAccess.getCSSTypeAccess().getAlternatives(), "rule__CSSType__Alternatives");
					put(grammarAccess.getElementDefinitionAccess().getAlternatives_5(), "rule__ElementDefinition__Alternatives_5");
					put(grammarAccess.getCSSRuleDefinitionAccess().getAlternatives_3(), "rule__CSSRuleDefinition__Alternatives_3");
					put(grammarAccess.getCSSRulePostfixAccess().getCardinalityAlternatives_1_1_0(), "rule__CSSRulePostfix__CardinalityAlternatives_1_1_0");
					put(grammarAccess.getCSSRulePrimaryAccess().getAlternatives(), "rule__CSSRulePrimary__Alternatives");
					put(grammarAccess.getCSSRuleSymbolAccess().getSymbolAlternatives_1_0(), "rule__CSSRuleSymbol__SymbolAlternatives_1_0");
					put(grammarAccess.getCSSDefaultValueAccess().getAlternatives(), "rule__CSSDefaultValue__Alternatives");
					put(grammarAccess.getCssExtensionAccess().getGroup(), "rule__CssExtension__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup(), "rule__QualifiedNameWithWildCard__Group__0");
					put(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1(), "rule__QualifiedNameWithWildCard__Group_1__0");
					put(grammarAccess.getPackageDefinitionAccess().getGroup(), "rule__PackageDefinition__Group__0");
					put(grammarAccess.getCSSTypeAccess().getGroup_0(), "rule__CSSType__Group_0__0");
					put(grammarAccess.getCSSTypeAccess().getGroup_1(), "rule__CSSType__Group_1__0");
					put(grammarAccess.getCSSTypeAccess().getGroup_2(), "rule__CSSType__Group_2__0");
					put(grammarAccess.getCSSTypeAccess().getGroup_3(), "rule__CSSType__Group_3__0");
					put(grammarAccess.getElementDefinitionAccess().getGroup(), "rule__ElementDefinition__Group__0");
					put(grammarAccess.getElementDefinitionAccess().getGroup_3(), "rule__ElementDefinition__Group_3__0");
					put(grammarAccess.getElementDefinitionAccess().getGroup_3_2(), "rule__ElementDefinition__Group_3_2__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup(), "rule__PropertyDefinition__Group__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_4(), "rule__PropertyDefinition__Group_4__0");
					put(grammarAccess.getPseudoClassDefinitionAccess().getGroup(), "rule__PseudoClassDefinition__Group__0");
					put(grammarAccess.getCSSRuleRefAccess().getGroup(), "rule__CSSRuleRef__Group__0");
					put(grammarAccess.getCSSRuleDefinitionAccess().getGroup(), "rule__CSSRuleDefinition__Group__0");
					put(grammarAccess.getCSSRuleFuncAccess().getGroup(), "rule__CSSRuleFunc__Group__0");
					put(grammarAccess.getCSSRuleOrAccess().getGroup(), "rule__CSSRuleOr__Group__0");
					put(grammarAccess.getCSSRuleOrAccess().getGroup_1(), "rule__CSSRuleOr__Group_1__0");
					put(grammarAccess.getCSSRuleOrAccess().getGroup_1_1(), "rule__CSSRuleOr__Group_1_1__0");
					put(grammarAccess.getCSSRuleXorAccess().getGroup(), "rule__CSSRuleXor__Group__0");
					put(grammarAccess.getCSSRuleXorAccess().getGroup_1(), "rule__CSSRuleXor__Group_1__0");
					put(grammarAccess.getCSSRuleXorAccess().getGroup_1_1(), "rule__CSSRuleXor__Group_1_1__0");
					put(grammarAccess.getCSSRuleConcatAccess().getGroup(), "rule__CSSRuleConcat__Group__0");
					put(grammarAccess.getCSSRuleConcatAccess().getGroup_1(), "rule__CSSRuleConcat__Group_1__0");
					put(grammarAccess.getCSSRulePostfixAccess().getGroup(), "rule__CSSRulePostfix__Group__0");
					put(grammarAccess.getCSSRulePostfixAccess().getGroup_1(), "rule__CSSRulePostfix__Group_1__0");
					put(grammarAccess.getCSSRuleBracketAccess().getGroup(), "rule__CSSRuleBracket__Group__0");
					put(grammarAccess.getCSSRulePrimaryAccess().getGroup_6(), "rule__CSSRulePrimary__Group_6__0");
					put(grammarAccess.getCSSRuleRegexAccess().getGroup(), "rule__CSSRuleRegex__Group__0");
					put(grammarAccess.getCSSRuleLiteralAccess().getGroup(), "rule__CSSRuleLiteral__Group__0");
					put(grammarAccess.getCSSRuleSymbolAccess().getGroup(), "rule__CSSRuleSymbol__Group__0");
					put(grammarAccess.getCSSDefaultValueAccess().getGroup_0(), "rule__CSSDefaultValue__Group_0__0");
					put(grammarAccess.getCssExtensionAccess().getImportsAssignment_0(), "rule__CssExtension__ImportsAssignment_0");
					put(grammarAccess.getCssExtensionAccess().getPackageDefAssignment_1(), "rule__CssExtension__PackageDefAssignment_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
					put(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1(), "rule__PackageDefinition__NameAssignment_1");
					put(grammarAccess.getPackageDefinitionAccess().getRulesAssignment_3_0(), "rule__PackageDefinition__RulesAssignment_3_0");
					put(grammarAccess.getPackageDefinitionAccess().getSubpackagesAssignment_3_1(), "rule__PackageDefinition__SubpackagesAssignment_3_1");
					put(grammarAccess.getPackageDefinitionAccess().getElementsAssignment_3_2(), "rule__PackageDefinition__ElementsAssignment_3_2");
					put(grammarAccess.getDokuAccess().getContentAssignment(), "rule__Doku__ContentAssignment");
					put(grammarAccess.getCSSTypeAccess().getTypeAssignment_0_1(), "rule__CSSType__TypeAssignment_0_1");
					put(grammarAccess.getCSSTypeAccess().getFromAssignment_0_4(), "rule__CSSType__FromAssignment_0_4");
					put(grammarAccess.getCSSTypeAccess().getToAssignment_0_8(), "rule__CSSType__ToAssignment_0_8");
					put(grammarAccess.getCSSTypeAccess().getTypeAssignment_1_1(), "rule__CSSType__TypeAssignment_1_1");
					put(grammarAccess.getCSSTypeAccess().getFromAssignment_1_4(), "rule__CSSType__FromAssignment_1_4");
					put(grammarAccess.getCSSTypeAccess().getToAssignment_1_8(), "rule__CSSType__ToAssignment_1_8");
					put(grammarAccess.getCSSTypeAccess().getTypeAssignment_2_0(), "rule__CSSType__TypeAssignment_2_0");
					put(grammarAccess.getCSSTypeAccess().getTypeAssignment_3_0(), "rule__CSSType__TypeAssignment_3_0");
					put(grammarAccess.getElementDefinitionAccess().getDokuAssignment_1(), "rule__ElementDefinition__DokuAssignment_1");
					put(grammarAccess.getElementDefinitionAccess().getNameAssignment_2(), "rule__ElementDefinition__NameAssignment_2");
					put(grammarAccess.getElementDefinitionAccess().getSuperAssignment_3_1(), "rule__ElementDefinition__SuperAssignment_3_1");
					put(grammarAccess.getElementDefinitionAccess().getSuperAssignment_3_2_1(), "rule__ElementDefinition__SuperAssignment_3_2_1");
					put(grammarAccess.getElementDefinitionAccess().getPropertiesAssignment_5_0(), "rule__ElementDefinition__PropertiesAssignment_5_0");
					put(grammarAccess.getElementDefinitionAccess().getPseudoClassesAssignment_5_1(), "rule__ElementDefinition__PseudoClassesAssignment_5_1");
					put(grammarAccess.getPropertyDefinitionAccess().getDokuAssignment_1(), "rule__PropertyDefinition__DokuAssignment_1");
					put(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_2(), "rule__PropertyDefinition__NameAssignment_2");
					put(grammarAccess.getPropertyDefinitionAccess().getRuleAssignment_3(), "rule__PropertyDefinition__RuleAssignment_3");
					put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_4_1(), "rule__PropertyDefinition__DefaultAssignment_4_1");
					put(grammarAccess.getPseudoClassDefinitionAccess().getDokuAssignment_1(), "rule__PseudoClassDefinition__DokuAssignment_1");
					put(grammarAccess.getPseudoClassDefinitionAccess().getNameAssignment_2(), "rule__PseudoClassDefinition__NameAssignment_2");
					put(grammarAccess.getCSSRuleIdAccess().getNameAssignment(), "rule__CSSRuleId__NameAssignment");
					put(grammarAccess.getCSSRuleRefAccess().getRefAssignment_1(), "rule__CSSRuleRef__RefAssignment_1");
					put(grammarAccess.getCSSRuleDefinitionAccess().getDokuAssignment_0(), "rule__CSSRuleDefinition__DokuAssignment_0");
					put(grammarAccess.getCSSRuleDefinitionAccess().getNameAssignment_1(), "rule__CSSRuleDefinition__NameAssignment_1");
					put(grammarAccess.getCSSRuleDefinitionAccess().getRuleAssignment_3_0(), "rule__CSSRuleDefinition__RuleAssignment_3_0");
					put(grammarAccess.getCSSRuleDefinitionAccess().getFuncAssignment_3_1(), "rule__CSSRuleDefinition__FuncAssignment_3_1");
					put(grammarAccess.getCSSRuleFuncAccess().getNameAssignment_1(), "rule__CSSRuleFunc__NameAssignment_1");
					put(grammarAccess.getCSSRuleFuncAccess().getParamsAssignment_4(), "rule__CSSRuleFunc__ParamsAssignment_4");
					put(grammarAccess.getCSSRuleOrAccess().getOrsAssignment_1_1_1(), "rule__CSSRuleOr__OrsAssignment_1_1_1");
					put(grammarAccess.getCSSRuleXorAccess().getXorsAssignment_1_1_1(), "rule__CSSRuleXor__XorsAssignment_1_1_1");
					put(grammarAccess.getCSSRuleConcatAccess().getConcAssignment_1_1(), "rule__CSSRuleConcat__ConcAssignment_1_1");
					put(grammarAccess.getCSSRulePostfixAccess().getCardinalityAssignment_1_1(), "rule__CSSRulePostfix__CardinalityAssignment_1_1");
					put(grammarAccess.getCSSRuleBracketAccess().getInnerAssignment_2(), "rule__CSSRuleBracket__InnerAssignment_2");
					put(grammarAccess.getCSSRulePrimaryAccess().getValueAssignment_6_1(), "rule__CSSRulePrimary__ValueAssignment_6_1");
					put(grammarAccess.getCSSRuleRegexAccess().getRegexAssignment_1(), "rule__CSSRuleRegex__RegexAssignment_1");
					put(grammarAccess.getCSSRuleLiteralAccess().getValueAssignment_1(), "rule__CSSRuleLiteral__ValueAssignment_1");
					put(grammarAccess.getCSSRuleSymbolAccess().getSymbolAssignment_1(), "rule__CSSRuleSymbol__SymbolAssignment_1");
					put(grammarAccess.getCSSDefaultValueAccess().getValAssignment_0_1(), "rule__CSSDefaultValue__ValAssignment_0_1");
					put(grammarAccess.getCSSDefaultValueAccess().getIvalAssignment_1(), "rule__CSSDefaultValue__IvalAssignment_1");
					put(grammarAccess.getCSSDefaultValueAccess().getDvalAssignment_2(), "rule__CSSDefaultValue__DvalAssignment_2");
					put(grammarAccess.getCSSDefaultValueAccess().getSvalAssignment_3(), "rule__CSSDefaultValue__SvalAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr.internal.InternalCssExtDslParser typedParser = (at.bestsolution.efxclipse.tooling.css.cssext.ui.contentassist.antlr.internal.InternalCssExtDslParser) parser;
			typedParser.entryRuleCssExtension();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CssExtDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CssExtDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
