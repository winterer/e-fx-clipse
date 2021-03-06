/*******************************************************************************
 * Copyright (c) 2011 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.efxclipse.tooling.css.ui.contentassist;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class CssDslProposalProvider extends AbstractCssDslProposalProvider {
//	private CssDialectExtensionComponent extension;
//	
//	public CssDslProposalProvider() {
//		BundleContext context = CssDslActivator.getInstance().getBundle().getBundleContext();
//		ServiceReference<CssDialectExtensionComponent> ref = context.getServiceReference(CssDialectExtensionComponent.class);
//		extension = context.getService(ref);
//	}
//	
//	@Override
//	public void complete_css_property(EObject model, RuleCall ruleCall,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		if( model instanceof ruleset ) {
//			for( Property property : extension.getProperties(model.eResource().getURI()) ) {
//				
//				
//				ConfigurableCompletionProposal cp = (ConfigurableCompletionProposal) createCompletionProposal(property.getName(), property.getName(), null, context);
//				cp.setAdditionalProposalInfo(model);
//				cp.setHover(new HoverImpl(property.getDescription()));
//				
//				acceptor.accept(cp);
//			}
//			
//		}
//		super.complete_css_property(model, ruleCall, context, acceptor);
//	}
//	
//	@Override
//	public void complete_expr(EObject model, RuleCall ruleCall,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
////		System.err.println("Expression Proposal: " + model);
////		if( context.getCurrentModel() instanceof css_declaration ) {
////			css_declaration o = (css_declaration) model;
////			Property p = getProperty(extension.getProperties(), o.getProperty());
////			
////			if( p != null ) {
////				for( Proposal proposal : p.getInitialTermProposals() ) {
////					acceptor.accept(createCompletionProposal(proposal.getLabel(), proposal.getLabel(), null, context));
////				}
////			}
////		} else {
////			super.complete_expr(model, ruleCall, context, acceptor);
////		}
//	}
//	
//	@Override
//	public void complete_termGroup(EObject model, RuleCall ruleCall,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
////		System.err.println("TermGroup proposal: " + context.getCurrentModel());
////		if( context.getCurrentModel() instanceof css_declaration ) {
////			css_declaration dec = (css_declaration) context.getCurrentModel();
////			
////		}
////		
//		super.complete_termGroup(model, ruleCall, context, acceptor);
//	}
//	
//	@Override
//	public void complete_term(EObject model, RuleCall ruleCall,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		
////		System.err.println("Term proposal: " + context.getCurrentModel());
//		
//////		System.err.println(ruleCall.eContainer());
//		
//		if( context.getCurrentModel() instanceof css_declaration ) {
//			// We get in here on the 1st value of the first group
//			// We get in here on the 2nd ... value of the first group
//			css_declaration dec = (css_declaration) context.getCurrentModel();
//			if( dec.getExpression() == null || dec.getExpression().getTermGroups().size() == 0) {
////				System.err.println("This is the initial");
//				Property p = getProperty(extension.getProperties(model.eResource().getURI()), dec.getProperty().getName());
//				if( p != null ) {
//					addProposals(p.getInitialTermProposals(), acceptor, context);
//					return;
//				}
//			}
//		} else if( context.getCurrentModel() instanceof termGroup ) {
//			// We get in here on 2nd value of first group
//			// We get in here on 2nd value of 2nd ... group
//			termGroup group = (termGroup) context.getCurrentModel();
//			expr expression = (expr) group.eContainer();
//			css_declaration dec = (css_declaration) expression.eContainer();
//			
//			if( expression.getTermGroups().indexOf(group) == 0 ) {
//				Property p = getProperty(extension.getProperties(model.eResource().getURI()), dec.getProperty().getName());
////				System.err.println("This is the first group");
//				if( p instanceof MultiValuesGroupProperty ) {
//					addProposals(((MultiValuesGroupProperty) p).getNextTermProposal(group.getTerms().size(), group, null), acceptor, context);
////					System.err.println("Property with multi terms in a group");
//				}
//			} else {
////				System.err.println("This is 2nd ... in 2nd group");
//				Property p = getProperty(extension.getProperties(model.eResource().getURI()), dec.getProperty().getName());
//				if( p instanceof MultiTermGroupProperty && p instanceof MultiValuesGroupProperty ) {
////					System.err.println("Property with multi terms in a group");
//					addProposals(((MultiValuesGroupProperty) p).getNextTermProposal(group.getTerms().size(), group, null), acceptor, context);
//				}
//			}
//			
//		} else if( context.getCurrentModel() instanceof expr ) {
//			// We get in here on 1st value if 2nd ... group 
//			// We get in here on 2nd value of 2nd ... group
//			expr expression = (expr) context.getCurrentModel();
//			css_declaration dec = (css_declaration) expression.eContainer();
//			Property p = getProperty(extension.getProperties(model.eResource().getURI()), dec.getProperty().getName());
//			if( p instanceof MultiTermGroupProperty ) {
//				addProposals(((MultiTermGroupProperty) p).getInitialTermProposal(0, dec), acceptor, context);
//			}
//			/*if( expression.getTermGroups().size() == 0 ) {
//				System.err.println("First in 2nd group");
//			}*/
////			System.err.println(expression.getTermGroups().size());
//		} else if( context.getCurrentModel() instanceof term ) {
//			term term = (term) context.getCurrentModel();
//			termGroup group = (termGroup) term.eContainer();
//			expr expression = (expr) group.eContainer();
//			if( expression.eContainer() instanceof css_declaration ) {
//				css_declaration dec = (css_declaration) expression.eContainer();
//				
//				Property p = getProperty(extension.getProperties(model.eResource().getURI()), dec.getProperty().getName());
//				if( p != null ) {
//					int groupIdx = expression.getTermGroups().indexOf(group);
//					if( groupIdx == 0 ) {
//						// We are in the first group
//						int idx = group.getTerms().indexOf(term) + 1;
//						if( idx == 0 ) {
//							// We are in the first term in the group
////							System.err.println("First term");
//							addProposals(p.getInitialTermProposals(), acceptor, context);
//						} else if( p instanceof MultiValuesGroupProperty ) {
////							System.err.println("Second term");
//							MultiValuesGroupProperty tmp = (MultiValuesGroupProperty) p;
//							addProposals(tmp.getNextTermProposal(idx, group, term), acceptor, context);
//						}
//					} else {
//						if( p instanceof MultiTermGroupProperty ) {
//							MultiTermGroupProperty tmp = (MultiTermGroupProperty) p;
//							int idx = group.getTerms().indexOf(term) + 1;
//							if( idx == 0 ) {
////								System.err.println("First term in > 1 group");
//								addProposals(tmp.getInitialTermProposal(groupIdx, dec), acceptor, context);
//							} else if( p instanceof MultiValuesGroupProperty ) {
////								System.err.println("2nd term in > 1 group");
//								MultiValuesGroupProperty tmp2 = (MultiValuesGroupProperty) p;
//								addProposals(tmp2.getNextTermProposal(idx, group, term), acceptor, context);
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		
////		if( model instanceof term ) {
////			term t = (term) model;
////			if( t.eContainer() instanceof termGroup ) {
////				termGroup tgr = (termGroup) t.eContainer();
////				if( tgr.eContainer() instanceof expr ) {
////					expr expression = (expr) tgr.eContainer();
////					if( expression.eContainer() instanceof css_declaration ) {
////						css_declaration dec = (css_declaration) expression.eContainer();
////						if( createExpressionFurtherTermProposals(dec, expression, tgr, t) ) {
////							return;
////						}
////					}
////				}
////			}
////		}
//		super.complete_term(model, ruleCall, context, acceptor);
//	}
//	
//	private void addProposals(List<Proposal> proposals, ICompletionProposalAcceptor acceptor, ContentAssistContext context) {
//		for( Proposal proposal : proposals ) {
//			if( proposal instanceof DialogProposal ) {
//				final DialogProposal dProp = (DialogProposal) proposal;
//				ConfigurableCompletionProposal dialogProposal = (ConfigurableCompletionProposal) createCompletionProposal(proposal.getLabel(),context);
//				if( dialogProposal != null ) {
//					dialogProposal.setTextApplier(new ReplacementTextApplier() {
//						
//						@Override
//						public String getActualReplacementString(
//								ConfigurableCompletionProposal proposal) {
//							return dProp.openProposal();
//						}
//					});
//				}
//				acceptor.accept(dialogProposal); 
//			} else {
//				acceptor.accept(createCompletionProposal(proposal.getLabel(), new StyledString(proposal.getLabel()), null, proposal.getPriority(), context.getPrefix(), context));	
//			}
//		}
//	}
//	
//	private boolean createExpressionFurtherTermProposals(css_declaration dec, expr expression, termGroup tgr, term t) {
//		// This is the >= 2nd group
//		if( expression.getTermGroups().indexOf(tgr) != 0 ) {
//			Property p = getProperty(extension.getProperties(dec.eResource().getURI()), dec.getProperty().getName());
//			if( p instanceof MultiTermGroupProperty ) {
//				if( tgr.getTerms().indexOf(t) == 0 ) {
//					// Show the initial proposals
//					return true;
//				} else if( p instanceof MultiValuesGroupProperty ) {
//					// Show the extended proposals
//				}
//				
//				return true;
//			}
//		} else {
//			Property p = getProperty(extension.getProperties(dec.eResource().getURI()), dec.getProperty().getName());
//			if( p instanceof MultiValuesGroupProperty ) {
//				if( tgr.getTerms().indexOf(t) > 0 ) {
//					// Show the extended proposals
//				}
//			}
//		}
//		
//		return false;
//	}
//	
//	private static Property getProperty(List<Property> properties, String property) {
//		if( property == null || property.trim().length() == 0 ) {
//			return null;
//		}
//		
//		for( Property p : properties ) {
//			if( property.equals(p.getName()) ) {
//				return p;
//			}
//		}
//		
//		return null;
//	}
//	
////	public static List<String> getProposals(String property) {
////		if( property.equals("border-top-style") 
////				|| property.equals("border-right-style") 
////				|| property.equals("border-bottom-style")
////				|| property.equals("border-left-style") ) {
////			return Arrays.asList("none", "hidden", "dotted", "dashed", "solid", "double", "groove", "ridge", "inset", "outset" );
////		}
////		return Collections.emptyList();
////	}
//	
//	public static class HoverImpl implements IEObjectHover {
//		private JavadocHoverWrapper javadocHover = new JavadocHoverWrapper();
//		private String doc;
//
//		public HoverImpl(String doc) {
//			this.doc = doc;
//		}
//
//		@Override
//		public Object getHoverInfo(EObject eObject, ITextViewer textViewer, IRegion hoverRegion) {
//			//javadocHover.setJavaElement(javaElement);
//			return doc; //javadocHover.getHoverInfo2(textViewer, hoverRegion);
//		}
//
////		@Override
////		public IInformationControlCreator getHoverControlCreator() {
////			return javadocHover.getHoverControlCreator();
////		}
//	}
}